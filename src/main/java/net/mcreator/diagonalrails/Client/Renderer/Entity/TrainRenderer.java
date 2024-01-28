package net.mcreator.diagonalrails.Client.Renderer.Entity;

import net.mcreator.diagonalrails.Client.Model.TrainModel;
import net.mcreator.diagonalrails.entity.TrainEntity;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import net.minecraft.client.renderer.GlStateManager;

@SideOnly(Side.CLIENT)
public class TrainRenderer extends Render<TrainEntity> {

    private static final ResourceLocation TRAIN_TEXTURES = new ResourceLocation("diagonalrails", "textures/entity/traintexture.png");
    protected TrainModel modelTrain = new TrainModel();

    public TrainRenderer(RenderManager renderManager) {
        super(renderManager);
        this.shadowSize = 0.5F;
    }

    @Override
    public void doRender(TrainEntity entity, double x, double y, double z, float entityYaw, float partialTicks) {
        GlStateManager.pushMatrix();
        GlStateManager.translate((float)x, (float)y + 0.5F, (float)z);
        GlStateManager.rotate(entityYaw, 0.0F, 1.0F, 0.0F);
        GlStateManager.scale(-0.1F, -0.1F, 0.1F); // Adjust scale here
        this.bindEntityTexture(entity);
        this.modelTrain.render(entity, 0.0F, 0.0F, -0.1F, 0.0F, 0.0F, 0.0625F);
        GlStateManager.popMatrix();
    }

    @Override
    protected ResourceLocation getEntityTexture(TrainEntity entity) {
        return TRAIN_TEXTURES;
    }

    public static class Factory implements IRenderFactory<TrainEntity> {
        @Override
        public Render<? super TrainEntity> createRenderFor(RenderManager manager) {
            return new TrainRenderer(manager);
        }
    }
}
