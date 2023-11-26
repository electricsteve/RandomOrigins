package electricsteve.random_origins.power;

import electricsteve.random_origins.Entities.ThunderArrowEntity;
import electricsteve.random_origins.RandomOrigins;
import io.github.apace100.apoli.power.ActiveCooldownPower;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.util.HudRender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.projectile.ArrowEntity;
import net.minecraft.entity.projectile.PersistentProjectileEntity;
import net.minecraft.util.math.Vec3d;

import java.util.function.Consumer;

public class ShootArrowEntity extends ActiveCooldownPower {

    int velocityMultiplier;
    public ShootArrowEntity(PowerType<?> type, LivingEntity entity, int cooldownDuration, HudRender hudRender, int velocityMultiplier) {
        super(type, entity, cooldownDuration, hudRender, null);
        this.velocityMultiplier = velocityMultiplier;
    }

    @Override
    public void onUse() {
        if (!entity.getWorld().isClient) {
            if (canUse()) {
                shoot();
                use();
            }
        }
    }

    private void shoot() {
        ThunderArrowEntity thunderArrow = new ThunderArrowEntity(RandomOrigins.THUNDER_ARROW, entity.getWorld());
        thunderArrow.setPos(entity.getX(), entity.getY() + 1.5, entity.getZ());
        thunderArrow.setVelocity(entity, entity.getPitch(), entity.getYaw(), 0.0F, velocityMultiplier * 3.0F, 1.0F);
        thunderArrow.setOwner(entity);
        entity.getWorld().spawnEntity(thunderArrow);
    }

}
