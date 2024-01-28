// Made with Blockbench 4.9.3
// Exported for Minecraft version 1.7 - 1.12
// Paste this class into your mod and generate all required imports

package net.mcreator.diagonalrails.Client.Model;

import net.minecraft.client.model.ModelBase;
import net.minecraft.client.model.ModelRenderer;
import net.minecraft.entity.Entity;

import net.mcreator.diagonalrails.Client.Renderer.Entity.*;

public class TrainModel extends ModelBase {
	private final ModelRenderer train;
	private final ModelRenderer light2_r1;
	private final ModelRenderer firebox4_r1;

	public TrainModel() {
		textureWidth = 300;
		textureHeight = 300;

		train = new ModelRenderer(this);
		train.setRotationPoint(0.0F, 16.0F, 0.0F);
		train.setTextureOffset(8, 135).addBox(-60, -50, -230, 120, 120, 240);

train.setTextureOffset(129, 54).addBox(-70, 60, 10, 140, 10, 130);
train.setTextureOffset(32, 123).addBox(60, -170, 10, 10, 230, 10);
train.setTextureOffset(35, 154).addBox(-70, -170, 10, 10, 230, 10);
train.setTextureOffset(0, 112).addBox(50, -40, 20, 20, 100, 120);
train.setTextureOffset(0, 112).addBox(-70, -40, 20, 20, 100, 120);
train.setTextureOffset(51, 147).addBox(-70, -170, 130, 10, 130, 10);
train.setTextureOffset(25, 130).addBox(60, -170, 130, 10, 130, 10);
train.setTextureOffset(8, 102).addBox(-70, -180, 10, 140, 10, 130);
train.setTextureOffset(0, 128).addBox(-14, -141, -190, 29, 85, 170);
train.setTextureOffset(0, 128).addBox(-42, -114, -190, 84, 29, 170);
train.setTextureOffset(18, 118).addBox(-14, -60, -190, 30, 10, 170);
train.setTextureOffset(131, 136).addBox(50, -60, -210, 10, 10, 220);
train.setTextureOffset(120, 115).addBox(-60, -60, -210, 10, 10, 220);
train.setTextureOffset(131, 36).addBox(70, 0, 50, 10, 80, 40);
train.setTextureOffset(139, 51).addBox(70, 20, 30, 10, 40, 80);
train.setTextureOffset(173, 48).addBox(70, 10, 40, 10, 60, 60);
train.setTextureOffset(248, 42).addBox(80, 10, 60, 10, 60, 20);
train.setTextureOffset(261, 39).addBox(80, 30, 40, 10, 20, 60);
train.setTextureOffset(136, 22).addBox(60, 0, -80, 10, 80, 40);
train.setTextureOffset(138, 35).addBox(60, 20, -100, 10, 40, 80);
train.setTextureOffset(128, 43).addBox(60, 10, -90, 10, 60, 60);
train.setTextureOffset(267, 38).addBox(70, 10, -70, 10, 60, 20);
train.setTextureOffset(243, 42).addBox(70, 30, -90, 10, 20, 60);
train.setTextureOffset(140, 29).addBox(-80, 0, 50, 10, 80, 40);
train.setTextureOffset(118, 39).addBox(-80, 20, 30, 10, 40, 80);
train.setTextureOffset(126, 38).addBox(-80, 10, 40, 10, 60, 60);
train.setTextureOffset(269, 47).addBox(-90, 10, 60, 10, 60, 20);
train.setTextureOffset(225, 49).addBox(-90, 30, 40, 10, 20, 60);
train.setTextureOffset(130, 22).addBox(-70, 0, -80, 10, 80, 40);
train.setTextureOffset(133, 32).addBox(-70, 20, -100, 10, 40, 80);
train.setTextureOffset(124, 29).addBox(-70, 10, -90, 10, 60, 60);
train.setTextureOffset(280, 59).addBox(-80, 10, -70, 10, 60, 20);
train.setTextureOffset(243, 40).addBox(-80, 30, -90, 10, 20, 60);
train.setTextureOffset(130, 146).addBox(-50, 20, -240, 100, 40, 10);
train.setTextureOffset(237, 30).addBox(-20, -200, -170, 40, 70, 50);
train.setTextureOffset(239, 21).addBox(-30, -210, -180, 60, 20, 70);
train.setTextureOffset(251, 25).addBox(-10, -180, -80, 20, 50, 20);
train.setTextureOffset(142, 36).addBox(60, 50, -200, 10, 30, 30);
train.setTextureOffset(234, 30).addBox(70, 60, -190, 10, 10, 10);
train.setTextureOffset(135, 32).addBox(-70, 50, -200, 10, 30, 30);
train.setTextureOffset(238, 33).addBox(-80, 60, -190, 10, 10, 10);

light2_r1 = new ModelRenderer(this);
light2_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
train.addChild(light2_r1);
setRotationAngle(light2_r1, 0.0F, 0.0F, -0.7854F);

light2_r1.setTextureOffset(1, 14).addBox(60, -80, -210, 20, 20, 10);
light2_r1.setTextureOffset(241, 31).addBox(50, -90, -200, 40, 40, 10);
light2_r1.setTextureOffset(0, 128).addBox(30, -90, -190, 80, 40, 170);

firebox4_r1 = new ModelRenderer(this);
firebox4_r1.setRotationPoint(0.0F, 0.0F, 0.0F);
train.addChild(firebox4_r1);
setRotationAngle(firebox4_r1, 0.0F, 0.0F, 0.7854F);

firebox4_r1.setTextureOffset(0, 128).addBox(-110, -90, -190, 80, 40, 170);
	}

	@Override
	public void render(Entity entity, float f, float f1, float f2, float f3, float f4, float f5) {
		train.render(f5);
	}

	public void setRotationAngle(ModelRenderer modelRenderer, float x, float y, float z) {
		modelRenderer.rotateAngleX = x;
		modelRenderer.rotateAngleY = y;
		modelRenderer.rotateAngleZ = z;
	}
}