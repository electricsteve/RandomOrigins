package electricsteve.random_origins.power;

import io.github.apace100.apoli.power.ActiveCooldownPower;
import io.github.apace100.apoli.power.PowerType;
import io.github.apace100.apoli.util.HudRender;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.projectile.ArrowEntity;

import java.util.function.Consumer;

public class ShootArrowEntity extends ActiveCooldownPower {

    EntityType<? extends ArrowEntity> arrowEntity;
    int velocityMultiplier;
    public ShootArrowEntity(PowerType<?> type, LivingEntity entity, int cooldownDuration, HudRender hudRender, EntityType<? extends ArrowEntity> entityType, int velocityMultiplier) {
        super(type, entity, cooldownDuration, hudRender, null);
        this.arrowEntity = entityType;
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

    }

}
