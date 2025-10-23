package github.mattzmt.malta.entity.custom;

import github.mattzmt.malta.block.ModBlocks;
import github.mattzmt.malta.entity.ModEntities;
import github.mattzmt.malta.entity.client.ModCracks;
import github.mattzmt.malta.sound.ModSounds;
import github.mattzmt.malta.util.ModTags;
import net.minecraft.block.BlockState;
import net.minecraft.entity.*;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.ai.pathing.PathNodeType;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.entity.data.DataTracker;
import net.minecraft.entity.mob.MobEntity;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.tag.DamageTypeTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundEvent;
import net.minecraft.sound.SoundEvents;
import net.minecraft.storage.ReadView;
import net.minecraft.storage.WriteView;
import net.minecraft.util.ActionResult;
import net.minecraft.util.DyeColor;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.GameRules;
import net.minecraft.world.LocalDifficulty;
import net.minecraft.world.ServerWorldAccess;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;
import org.jetbrains.annotations.Nullable;

import java.util.Objects;

public class SnailEntity extends TameableEntity {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkingAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;

    public SnailEntity(EntityType<? extends TameableEntity> entityType, World world) {
        super(entityType, world);
		this.setTamed(false, false);
		this.setPathfindingPenalty(PathNodeType.POWDER_SNOW, -1.0F);
		this.setPathfindingPenalty(PathNodeType.DANGER_POWDER_SNOW, -1.0F);
    }

    @Override
    protected void initGoals() {
        this.goalSelector.add(1, new SwimGoal(this));
        this.goalSelector.add(1, new EscapeDangerGoal(this, 2D));
		this.goalSelector.add(2, new FollowOwnerGoal(this, 1.0, 10.0F, 2.0F));
        this.goalSelector.add(3, new AnimalMateGoal(this, 1.5D));
        this.goalSelector.add(4, new TemptGoal(this, 1.5D, stack -> stack.isIn(ModTags.Items.SNAIL_FOOD), false));
        this.goalSelector.add(5, new FollowParentGoal(this, 1.5D));
        this.goalSelector.add(6, new WanderAroundFarGoal(this, 1D));
        this.goalSelector.add(7, new LookAtEntityGoal(this, PlayerEntity.class, 6.0F));
        this.goalSelector.add(7, new LookAroundGoal(this));}

    public static DefaultAttributeContainer.Builder createAttributes() {
        return MobEntity.createMobAttributes()
                .add(EntityAttributes.MAX_HEALTH, 12)
                .add(EntityAttributes.MOVEMENT_SPEED, 0.1f)
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
        return stack.isIn(ModTags.Items.SNAIL_FOOD);}

    @Nullable
    @Override
    public PassiveEntity createChild(ServerWorld world, PassiveEntity entity) {
        SnailEntity snailEntity = ModEntities.SNAIL.create(world, SpawnReason.BREEDING);
		if (this.isTamed()) {
			snailEntity.setOwner(this.getOwnerReference());
			snailEntity.setTamed(true, true);
		}
		return snailEntity;
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

    @Nullable
    @Override
    protected SoundEvent getHurtSound(DamageSource source) {
        return ModSounds.SNAIL_HIT;}

    @Nullable
    @Override
    protected SoundEvent getDeathSound() {
        return ModSounds.SNAIL_DEATH;}

    @Override
    protected void playStepSound(BlockPos pos, BlockState state) {}

    @Override
    protected void mobTick(ServerWorld world) {
        super.mobTick(world);}

    @Override
    public void tickMovement() {
        super.tickMovement();

        if (!(this.getWorld() instanceof ServerWorld serverWorld)) return;
        if (!serverWorld.getGameRules().getBoolean(GameRules.DO_MOB_GRIEFING)) return;

        BlockState blockState = ModBlocks.SLIME_TRAIL.getDefaultState();

		for (int i = 0; i < 4; i++) {
			int j = MathHelper.floor(this.getX() + (i % 2 * 2 - 1) * 0.25F);
			int k = MathHelper.floor(this.getY());
			int l = MathHelper.floor(this.getZ() + (i / 2 % 2 * 2 - 1) * 0.25F);
			BlockPos blockPos = new BlockPos(j, k, l);
			if (this.getWorld().getBlockState(blockPos).isAir() && blockState.canPlaceAt(this.getWorld(), blockPos)) {
				this.getWorld().setBlockState(blockPos, blockState);
				this.getWorld().emitGameEvent(GameEvent.BLOCK_PLACE, blockPos, GameEvent.Emitter.of(this, blockState));}}}

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
        } else if (!this.isTamed() && !this.getWorld().isClient && itemStack.isOf(Items.MOSS_BLOCK)) {
			itemStack.decrementUnlessCreative(1, player);
			this.tryTame(player);
			return ActionResult.SUCCESS_SERVER;
		}

		return super.interactMob(player, hand);}

    @Override
    public boolean damage(ServerWorld world, DamageSource source, float amount) {
        Cracks.CrackLevel crackLevel = this.getCrackLevel();
        boolean bl = super.damage(world, source, amount);
        if (bl && this.getCrackLevel() != crackLevel) {
            this.playSound(ModSounds.SNAIL_SHELL_CRACK, 1.0F, 1.0F);
        }

        return bl;}

    public Cracks.CrackLevel getCrackLevel() {
        return ModCracks.SNAIL_CRACKS.getCrackLevel(this.getHealth() / this.getMaxHealth());}

	@Override
	public void setTamed(boolean tamed, boolean updateAttributes) {
		super.setTamed(tamed, updateAttributes);
		if (tamed) {
			Objects.requireNonNull(getAttributeInstance(EntityAttributes.MAX_HEALTH)).setBaseValue(24);
			Objects.requireNonNull(getAttributeInstance(EntityAttributes.MOVEMENT_SPEED)).setBaseValue(0.2f);
			Objects.requireNonNull(getAttributeInstance(EntityAttributes.SAFE_FALL_DISTANCE)).setBaseValue(2);
		} else {
			Objects.requireNonNull(getAttributeInstance(EntityAttributes.MAX_HEALTH)).setBaseValue(12);
			Objects.requireNonNull(getAttributeInstance(EntityAttributes.MOVEMENT_SPEED)).setBaseValue(0.1f);
			Objects.requireNonNull(getAttributeInstance(EntityAttributes.SAFE_FALL_DISTANCE)).setBaseValue(1);}}

	@Override
	protected void updateAttributesForTamed() {
		if (this.isTamed()) {
			Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.MAX_HEALTH)).setBaseValue(24.0);
			Objects.requireNonNull(getAttributeInstance(EntityAttributes.MOVEMENT_SPEED)).setBaseValue(0.2f);
			Objects.requireNonNull(getAttributeInstance(EntityAttributes.SAFE_FALL_DISTANCE)).setBaseValue(2);
			this.setHealth(24.0F);
		} else {
			Objects.requireNonNull(this.getAttributeInstance(EntityAttributes.MAX_HEALTH)).setBaseValue(12.0);
			Objects.requireNonNull(getAttributeInstance(EntityAttributes.MOVEMENT_SPEED)).setBaseValue(0.1f);
			Objects.requireNonNull(getAttributeInstance(EntityAttributes.SAFE_FALL_DISTANCE)).setBaseValue(1);}}

	private void tryTame(PlayerEntity player) {
		if (this.random.nextInt(3) == 0) {
			this.setTamedBy(player);
			this.navigation.stop();
			this.setTarget(null);
			this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_POSITIVE_PLAYER_REACTION_PARTICLES);
		} else
			this.getWorld().sendEntityStatus(this, EntityStatuses.ADD_NEGATIVE_PLAYER_REACTION_PARTICLES);}

	@Override
	public boolean canBreedWith(AnimalEntity other) {
		if (other == this)
			return false;
		else if (!this.isTamed())
			return false;
		else if (!(other instanceof SnailEntity snailEntity))
			return false;
		else if (!snailEntity.isTamed())
			return false;
		else
			return this.isInLove() && snailEntity.isInLove();
	}
}