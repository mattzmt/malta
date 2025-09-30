package github.mattzmt.malta.entity.custom;

import github.mattzmt.malta.block.ModBlocks;
import github.mattzmt.malta.entity.ModEntities;
import github.mattzmt.malta.entity.client.ModCracks;
import net.minecraft.block.BlockState;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityData;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.AnimalEntity;
import net.minecraft.entity.passive.Cracks;
import net.minecraft.entity.passive.PassiveEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameRules;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

public class SnailEntity extends AnimalEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkingAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public SnailEntity(EntityType<? extends AnimalEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 2D));
        this.goalSelector.add(2, new AnimalMateGoal(this, 1.5D));
        this.goalSelector.add(3, new TemptGoal(this, 1.5D, stack -> stack.isOf(Items.SHORT_GRASS), false));
        this.goalSelector.add(4, new FollowParentGoal(this, 2D));
        this.goalSelector.add(5, new WanderAroundFarGoal(this, 1D));
        this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));}

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 12)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.1f)
                .add(EntityAttributes.ATTACK_DAMAGE, 0.5f)
                .add(EntityAttributes.FOLLOW_RANGE, 10)
                .add(EntityAttributes.TEMPT_RANGE, 10)
                .add(EntityAttributes.KNOCKBACK_RESISTANCE, 1)
                .add(EntityAttributes.SAFE_FALL_DISTANCE, 1);}

    private void setupAnimationStates() {
        if (this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 2000;
            this.idleAnimationState.start(this.age);
        } else {
            --this.idleAnimationTimeout;
        }
    }

    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
        }
    }

    @Override
    public boolean isBreedingItem(ItemStack stack) {
        return stack.isOf(Items.SHORT_GRASS);
    }

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        return ModEntities.SNAIL.create(world, SpawnReason.BREEDING);
    }

    @Override
    protected void initDataTracker(DataTracker.Builder builder) {
        super.initDataTracker(builder);
    }

    @Override
    public void writeData(WriteView view) {
        super.writeData(view);
    }

    @Override
    public void readData(ReadView view) {
        super.readData(view);
    }

    @Override
    public EntityData initialize(ServerWorldAccess world, LocalDifficulty difficulty, SpawnReason spawnReason,
                                 @Nullable EntityData entityData) {
        return super.initialize(world, difficulty, spawnReason, entityData);}

    /* SOUNDS */
    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return SoundEvents.ENTITY_PUFFER_FISH_FLOP;}

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return SoundEvents.ENTITY_TURTLE_EGG_BREAK;}

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {}

    @Override
    protected void mobTick(ServerWorld world) {
        super.mobTick(world);}

    private int prevXPos = Integer.MIN_VALUE;
    private int prevYPos = Integer.MIN_VALUE;
    private int prevZPos = Integer.MIN_VALUE;

    @Override
    public void tickMovement() {
        super.tickMovement();

        if (!(this.getWorld() instanceof ServerWorld serverWorld)) return;
        if (!serverWorld.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) return;

        double currentX = this.getX();
        double currentY = this.getY();
        double currentZ = this.getZ();

        boolean hasMoved = (int)currentX != prevXPos || (int)currentY != prevYPos || (int)currentZ != prevZPos;

        if (hasMoved) {
            BlockState blockState = ModBlocks.SLIME_TRAIL.getDefaultState();

            for (int i = 0; i < 4; i++) {
                int j = MathHelper.floor(currentX + (i % 2 * 2 - 1) * 0.25F);
                int k = MathHelper.floor(currentY);
                int l = MathHelper.floor(currentZ + (i / 2 % 2 * 2 - 1) * 0.25F);
                BlockPos blockPos = new BlockPos(j, k, l);
                if (this.getWorld().getBlockState(blockPos).isAir() && blockState.canPlaceAt(this.getWorld(), blockPos)) {
                    this.getWorld().setBlockState(blockPos, blockState);
                    this.getWorld().emitGameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Emitter.of(this, blockState));}}}

        prevXPos = (int)currentX;
        prevYPos = (int)currentY;
        prevZPos = (int)currentZ;}

    public boolean brushable() {
        if (this.isBaby())
            return false;
        else {
            if (this.getWorld() instanceof ServerWorld serverWorld) {
                this.dropStack(serverWorld, new ItemStack(Items.SLIME_BALL));
                this.emitGameEvent(GameEvent.ENTITY_INTERACT);
                this.playSoundIfNotSilent(SoundEvents.ENTITY_SLIME_HURT);
            }
            return true;}}

    @Override
    public ActionResult interactMob(PlayerEntity player, Hand hand) {
        ItemStack itemStack = player.getStackInHand(hand);
        if (itemStack.isOf(Items.BRUSH) && this.brushable()) {
            itemStack.damage(8, player, getSlotForHand(hand));
            return ActionResult.SUCCESS;
        } else
            return super.interactMob(player, hand);}

    @Override
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        Cracks.CrackLevel crackLevel = this.getCrackLevel();
        boolean bl = super.damage(world, source, amount);
        if (bl && this.getCrackLevel() != crackLevel) {
            this.playSound(SoundEvents.ENTITY_TURTLE_EGG_CRACK, 1.0F, 1.0F);
        }

        return bl;
    }

    public Cracks.CrackLevel getCrackLevel() {
        return ModCracks.SNAIL_CRACKS.getCrackLevel(this.getHealth() / this.getMaxHealth());}
}