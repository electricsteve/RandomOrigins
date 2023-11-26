package electricsteve.random_origins.client.render.entities;

import electricsteve.random_origins.Entities.ThunderArrowEntity;
import electricsteve.random_origins.RandomOriginsClient;
import electricsteve.random_origins.client.model.entities.ThunderArrowEntityModel;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.render.entity.EntityRendererFactory;
import net.minecraft.client.render.entity.ProjectileEntityRenderer;
import net.minecraft.util.Identifier;

@Environment(EnvType.CLIENT)
public class ThunderArrowEntityRenderer extends ProjectileEntityRenderer<ThunderArrowEntity> {
    public static final Identifier TEXTURE = new Identifier("randomorigins", "textures/entity/thunder_arrow.png");
    protected ThunderArrowEntityModel model;

    public ThunderArrowEntityRenderer(EntityRendererFactory.Context ctx) {
        super(ctx);
        this.model = new ThunderArrowEntityModel(ctx.getPart(RandomOriginsClient.MODEL_THUNDER_ARROW_LAYER));
    }

    @Override
    public Identifier getTexture(ThunderArrowEntity entity) {
        return TEXTURE;
    }
}
