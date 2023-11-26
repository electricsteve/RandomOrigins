package electricsteve.random_origins.client.model.entities;

import net.minecraft.client.model.*;
import net.minecraft.client.render.VertexConsumer;
import net.minecraft.client.render.entity.model.EntityModel;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.entity.Entity;

// Made with Blockbench 4.8.3
// Exported for Minecraft version 1.17+ for Yarn
// Paste this class into your mod and generate all required imports
public class ThunderArrowModel extends EntityModel<Entity> {
	private final ModelPart bb_main;

	public ThunderArrowModel(ModelPart root) {
		this.bb_main = root.getChild("bb_main");
	}

	public static TexturedModelData getTexturedModelData() {
		ModelData modelData = new ModelData();
		ModelPartData modelPartData = modelData.getRoot();
		ModelPartData bb_main = modelPartData.addChild("bb_main", ModelPartBuilder.create(), ModelTransform.pivot(0.0F, 24.0F, 0.0F));

		ModelPartData cube_r1 = bb_main.addChild("cube_r1", ModelPartBuilder.create().uv(0, 9).cuboid(-1.5F, -0.5F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.5F, -6.0F, 0.0F, 0.0F, 2.3562F));

		ModelPartData cube_r2 = bb_main.addChild("cube_r2", ModelPartBuilder.create().uv(10, 0).cuboid(-1.5F, -0.5F, -1.0F, 3.0F, 1.0F, 2.0F, new Dilation(0.0F))
		.uv(0, 12).cuboid(1.5F, -0.5F, 13.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(4, 12).cuboid(-2.5F, -0.5F, 13.0F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(10, 3).cuboid(-1.5F, -0.5F, 11.0F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(0, 7).cuboid(-2.5F, -0.5F, 12.0F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(16, 10).cuboid(-0.5F, -0.5F, -2.0F, 1.0F, 1.0F, 16.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.5F, -6.0F, 0.0F, 0.0F, 0.7854F));

		ModelPartData cube_r3 = bb_main.addChild("cube_r3", ModelPartBuilder.create().uv(0, 5).cuboid(-2.5F, -0.5F, -0.5F, 5.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(11, 6).cuboid(-2.5F, -0.5F, 0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(9, 11).cuboid(1.5F, -0.5F, 0.5F, 1.0F, 1.0F, 1.0F, new Dilation(0.0F))
		.uv(8, 9).cuboid(-1.5F, -0.5F, -1.5F, 3.0F, 1.0F, 1.0F, new Dilation(0.0F)), ModelTransform.of(0.0F, -2.5F, 6.5F, 0.0F, 0.0F, -0.7854F));
		return TexturedModelData.of(modelData, 64, 64);
	}
	@Override
	public void setAngles(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}
	@Override
	public void render(MatrixStack matrices, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha) {
		bb_main.render(matrices, vertexConsumer, light, overlay, red, green, blue, alpha);
	}
}