package electricsteve.random_origins;

import electricsteve.random_origins.Entities.ThunderArrowEntity;
import electricsteve.random_origins.registry.ModItems;
import electricsteve.random_origins.registry.ModPowers;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.object.builder.v1.entity.FabricEntityTypeBuilder;
import net.minecraft.entity.EntityDimensions;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnGroup;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.util.Identifier;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class RandomOrigins implements ModInitializer {
    public static Logger LOGGER = LogManager.getLogger();
    public static String MOD_ID = "randomorigins";
    public static String VERSION = "";
    @Override
    public void onInitialize() {
        ModPowers.register();
        ModItems.register();
        ModItems.registerItemGroups();
    }

    public static final EntityType<ThunderArrowEntity> THUNDER_ARROW = Registry.register(
            Registries.ENTITY_TYPE,
            new Identifier(MOD_ID, "thunder_arrow"),
            FabricEntityTypeBuilder.create(SpawnGroup.MISC, ThunderArrowEntity::new).dimensions(EntityDimensions.fixed(0.75f, 0.75f)).build()
    );

    public static Identifier identifier(String path) {
        return new Identifier(MOD_ID, path);
    }

}
