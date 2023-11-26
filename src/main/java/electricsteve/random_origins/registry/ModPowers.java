package electricsteve.random_origins.registry;

import electricsteve.random_origins.RandomOrigins;
import electricsteve.random_origins.power.ShootArrowEntity;
import io.github.apace100.apoli.data.ApoliDataTypes;
import io.github.apace100.apoli.power.Active;
import io.github.apace100.apoli.power.factory.PowerFactory;
import io.github.apace100.apoli.registry.ApoliRegistries;
import io.github.apace100.apoli.util.HudRender;
import io.github.apace100.calio.data.SerializableData;
import io.github.apace100.calio.data.SerializableDataTypes;
import net.minecraft.registry.Registry;

public class ModPowers {
    public static void register() {
        register(new PowerFactory<>(RandomOrigins.identifier("shoot_arrow_entity"),
                new SerializableData()
                        .add("cooldown", SerializableDataTypes.INT)
                        .add("hud_render", ApoliDataTypes.HUD_RENDER)
                        .add("key", ApoliDataTypes.BACKWARDS_COMPATIBLE_KEY)
                        .add("velocity_multiplier", SerializableDataTypes.INT),
                (data) -> (type, player) -> {
                    ShootArrowEntity shootArrowEntity = new ShootArrowEntity(type, player, data.getInt("cooldown"), (HudRender) data.get("hud_render"), data.getInt("velocity_multiplier"));
                    shootArrowEntity.setKey((Active.Key) data.get("key"));
                    return shootArrowEntity;
                }));
    }

    private static void register(PowerFactory serializer) {
        Registry.register(ApoliRegistries.POWER_FACTORY, serializer.getSerializerId(), serializer);
    }
}
