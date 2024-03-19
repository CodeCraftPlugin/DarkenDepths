package me.codecraft.darkendepths.entity.custom;

import me.codecraft.darkendepths.DarkenDepths;
import net.minecraft.entity.AnimationState;
import net.minecraft.entity.EntityPose;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.ai.control.FlightMoveControl;
import net.minecraft.entity.ai.goal.*;
import net.minecraft.entity.attribute.DefaultAttributeContainer;
import net.minecraft.entity.attribute.EntityAttributes;
import net.minecraft.entity.boss.BossBar;
import net.minecraft.entity.boss.ServerBossBar;
import net.minecraft.entity.mob.HostileEntity;
import net.minecraft.entity.mob.Monster;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.nbt.NbtCompound;
import net.minecraft.util.math.MathHelper;
import net.minecraft.world.World;

public class DarkShadowEntity extends HostileEntity implements Monster  {

    public final static AnimationState idleAnimation = new AnimationState();
    public final static AnimationState  burstAnimation = new AnimationState();
    public final static AnimationState shieldAnimation = new AnimationState();
    public int idleTimeout = 0;
    private final ServerBossBar bossBar;


    public DarkShadowEntity(EntityType<? extends HostileEntity> entityType, World world) {
        super(entityType, world);
        this.bossBar = (ServerBossBar)(new ServerBossBar(this.getDisplayName(), BossBar.Color.PURPLE, BossBar.Style.PROGRESS)).setDarkenSky(true);
        this.moveControl = new FlightMoveControl(this, 20, true);
        this.experiencePoints = 50;


    }
    public void readCustomDataFromNbt(NbtCompound nbt) {
        super.readCustomDataFromNbt(nbt);
        if (this.hasCustomName()) {
            this.bossBar.setName(this.getDisplayName());
        }

    }

    @Override
    protected void initGoals() {

        this.goalSelector.add(0, new SwimGoal(this));
        this.goalSelector.add(1, new AttackGoal(this));
        this.goalSelector.add(2,new FlyGoal(this, this.getAttributeBaseValue(EntityAttributes.GENERIC_FLYING_SPEED)));
		this.goalSelector.add(6, new LookAtEntityGoal(this, PlayerEntity.class, 8.0F));
		this.goalSelector.add(7, new LookAroundGoal(this));
		this.targetSelector.add(1, new RevengeGoal(this));
		this.targetSelector.add(2, new ActiveTargetGoal(this, LivingEntity.class, false));
    }

    public static DefaultAttributeContainer.Builder createDarkShadowAttributes() {
        return HostileEntity.createHostileAttributes()
                .add(EntityAttributes.GENERIC_MAX_HEALTH,120D)
                .add(EntityAttributes.GENERIC_FLYING_SPEED,5)
                .add(EntityAttributes.GENERIC_ATTACK_DAMAGE,10D)
                .add(EntityAttributes.GENERIC_KNOCKBACK_RESISTANCE,5D)
                .add(EntityAttributes.GENERIC_ATTACK_KNOCKBACK,25D)
                .add(EntityAttributes.GENERIC_MOVEMENT_SPEED,5D);
    }


    private void setupAnimationStates() {
        if (this.idleTimeout <= 0) {
            this.idleTimeout = this.random.nextInt(40) + 80;
            this.idleAnimation.start(this.age);
        } else {
            --this.idleTimeout;
        }
    }

    @Override
    public boolean shouldRenderName() {
        return false;
    }

    protected void updateLimbs(float v) {
        float f;
        if (this.getPose() == EntityPose.STANDING) {
            f = Math.min(v * 6.0F, 1.0F);
        } else {
            f = 0.0F;
        }

        this.limbAnimator.updateLimbs(f, 0.2F);
    }
    @Override
    public void tick() {
        super.tick();

        if (this.getWorld().isClient()) {
            this.setupAnimationStates();
            if(this.getHealth()==50f){
                DarkenDepths.logger.info("Health: " + this  .getHealth());
                this.burstAnimation.start(this.age);
            }
            if (this.getHealth()<49){
                this.burstAnimation.stop();
                this.shieldAnimation.start(this.age);
            }
        }

    }


}
