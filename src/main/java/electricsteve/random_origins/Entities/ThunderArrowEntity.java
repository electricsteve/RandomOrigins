package electricsteve.random_origins.Entities;

import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LightningEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.entity.projectile.ProjectileEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.util.hit.HitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;
import net.minecraft.world.event.GameEvent;

public class ThunderArrowEntity extends PersistentProjectileEntity {
    public ThunderArrowEntity(EntityType<? extends PersistentProjectileEntity> entityType, World world) {
        super(entityType, world);
    }

    @Override
    public void tick() {
        super.tick();
        if (this.getWorld().isClient && !this.inGround) {
            this.getWorld().addParticle(ParticleTypes.INSTANT_EFFECT, this.getX(), this.getY(), this.getZ(), 0.0, 0.0, 0.0);
        }
    }

    @Override
    protected void onEntityHit(EntityHitResult entityHitResult) {
        Entity entity = entityHitResult.getEntity();
        Vec3d entityPos = entity.getPos();
        LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, this.getWorld());
        lightning.setPosition(entityPos);
        this.getWorld().spawnEntity(lightning);
        this.remove(RemovalReason.DISCARDED);
    }

    @Override
    protected void onBlockHit(BlockHitResult blockHitResult) {
        BlockState blockState = this.getWorld().getBlockState(blockHitResult.getBlockPos());
        blockState.onProjectileHit(this.getWorld(), blockState, blockHitResult, this);
        Vec3d blockPos = blockHitResult.getBlockPos().toCenterPos().add(0,1,0);
        LightningEntity lightning = new LightningEntity(EntityType.LIGHTNING_BOLT, this.getWorld());
        lightning.setPosition(blockPos);
        this.getWorld().spawnEntity(lightning);
        this.remove(RemovalReason.DISCARDED);
    }

    @Override
    protected ItemStack asItemStack() {
        return null;
    }
}