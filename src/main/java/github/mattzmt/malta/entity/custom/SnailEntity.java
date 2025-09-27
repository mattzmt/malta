package github.mattzmt.malta.entity.custom;

import com.mojang.serialization.Codec;
import github.mattzmt.malta.entity.ModEntities;
import io.netty.buffer.ByteBuf;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.data.TrackedData;
import net.minecraft.entity.data.TrackedDataHandlerRegistry;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.network.codec.PacketCodec;
import net.minecraft.network.codec.PacketCodecs;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.StringIdentifiable;
import net.minecraft.util.function.ValueLists;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;
import java.util.function.IntFunction;

public class SnailEntity extends AnimalEntity {
    private static final EntityDimensions BABY_BASE_DIMENSIONS = ModEntities.SNAIL.getDimensions().scaled(0.5F);

    public SnailEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 3));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.5));
        this.goalSelector.add(3, new TemptGoal(this, 1.5, stack -> stack.isOf(Items.SHORT_GRASS), false));
        this.goalSelector.add(4, new FollowParentGoal(this, 1.5));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));}

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 4)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.05f)
                .add(EntityAttributes.ATTACK_DAMAGE, 0.5f)
                .add(EntityAttributes.FOLLOW_RANGE, 10)
                .add(EntityAttributes.TEMPT_RANGE, 10)
                .add(EntityAttributes.KNOCKBACK_RESISTANCE, 1)
                .add(EntityAttributes.SAFE_FALL_DISTANCE, 1);}

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.SHORT_GRASS);}

    @Override
    public @Nullable PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.SNAIL.create(world, SpawnReason.BREEDING);}

    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_TURTLE_EGG_CRACK;}

    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_TURTLE_EGG_BREAK;}

    public boolean brushable() {
        if (this.isBaby()) {
            return false;
        } else {
            if (this.getWorld() instanceof ServerWorld serverWorld) {
                this.dropStack(serverWorld, new ItemStack(Items.SLIME_BALL));
                this.emitGameEvent(GameEvent.ENTITY_INTERACT);
                this.playSoundIfNotSilent(SoundEvents.ENTITY_SLIME_HURT);
            }
            return true;
        }
    }

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.BRUSH) && this.brushable()) {
            itemStack.damage(4, player, getSlotForHand(hand));
            return ActionResult.SUCCESS;
        } else {
            return ActionResult.FAIL;
        }
    }

    @Override
    public EntityDimensions getBaseDimensions(EntityPose pose) {
        return this.isBaby() ? BABY_BASE_DIMENSIONS : super.getBaseDimensions(pose);}

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
        builder.add(STATE, SnailEntity.State.IDLE.getIndex());
    }

    public boolean isNotIdle() {
        return getState() != SnailEntity.State.IDLE;
    }

    private long currentStateTicks = 0L;

    private boolean isMoving() {
        return getVelocity().horizontalLengthSquared() > 0.0001;
    }

    @Override
    public void tick() {
        super.tick();

        if (this.isMoving() && this.getState() != State.WALKING) {
            setState(State.WALKING);
        } else if (!this.isMoving() && this.getState() != State.IDLE) {
            setState(State.IDLE);
        }

        if (this.getWorld().isClient()) {
            this.updateAnimationStates();
        }

        if (this.isNotIdle()) {
            this.clampHeadYaw();
        }

        this.currentStateTicks++;
    }

    private static final TrackedData<Integer> STATE = DataTracker.registerData(SnailEntity.class, TrackedDataHandlerRegistry.INTEGER);

    public SnailEntity.State getState() {
        return SnailEntity.State.values()[this.dataTracker.get(STATE)];
    }

    public void setState(SnailEntity.State state) {
        this.dataTracker.set(STATE, state.getIndex());
        this.currentStateTicks = 0;
    }

    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkingAnimationState = new AnimationState();

    private void updateAnimationStates() {
        if(this.getState()==State.WALKING) {
            this.idleAnimationState.stop();
            this.walkingAnimationState.startIfNotRunning((int)this.currentStateTicks);
        }else{
            this.walkingAnimationState.stop();
            this.idleAnimationState.startIfNotRunning((int)this.currentStateTicks);
        }
    }

    public static enum State implements StringIdentifiable {
        IDLE("idle", 0, 0) {},
        WALKING("walking", 30, 1) {};

        static final Codec<SnailEntity.State> CODEC = StringIdentifiable.createCodec(SnailEntity.State::values);
        private static final IntFunction<SnailEntity.State> INDEX_TO_VALUE = ValueLists.createIndexToValueFunction(
                SnailEntity.State::getIndex, values(), ValueLists.OutOfBoundsHandling.ZERO
        );
        public static final PacketCodec<ByteBuf, SnailEntity.State> PACKET_CODEC = PacketCodecs.indexed(INDEX_TO_VALUE, SnailEntity.State::getIndex);
        private final String name;
        private final int lengthInTicks;
        private final int index;

        State(final String name, final int lengthInTicks, final int index) {
            this.name = name;
            this.lengthInTicks = lengthInTicks;
            this.index = index;
        }

        @Override
        public String asString() {
            return this.name;}

        private int getIndex() {
            return this.index;}

        public int getLengthInTicks() {
            return this.lengthInTicks;}
    }
}