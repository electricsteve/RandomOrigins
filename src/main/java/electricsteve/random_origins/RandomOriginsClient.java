package electricsteve.random_origins;

import electricsteve.random_origins.client.model.entities.ThunderArrowEntityModel;
import electricsteve.random_origins.client.render.entities.ThunderArrowEntityRenderer;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.rendering.v1.EntityModelLayerRegistry;
import net.fabricmc.fabric.api.client.rendering.v1.EntityRendererRegistry;
import net.minecraft.client.render.entity.model.EntityModelLayer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class RandomOriginsClient implements ClientModInitializer {
    public static final EntityModelLayer MODEL_THUNDER_ARROW_LAYER = new EntityModelLayer(new Identifier("randomorigins", "thuder_arrow"), "main");
    /**
     * Runs the mod initializer on the client environment.
     */
    @Override
    public void onInitializeClient() {
        EntityRendererRegistry.register(RandomOrigins.THUNDER_ARROW, ThunderArrowEntityRenderer::new);

        EntityModelLayerRegistry.registerModelLayer(MODEL_THUNDER_ARROW_LAYER, ThunderArrowEntityModel::getTexturedModelData);
    }
}
