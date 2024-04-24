package ros.eagleoffire.rosvoiesninjas.client.renderer.entity;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;

import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.renderer.MultiBufferSource;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.core.Direction;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.phys.Vec3;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauScellement;
import ros.eagleoffire.rosvoiesninjas.entity.decoration.SceauScellementEntity;

@OnlyIn(Dist.CLIENT)
public class SceauScellementRenderer extends EntityRenderer<SceauScellementEntity>{
	private final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(ROSVoiesNinjas.MODID,"textures/block/sceau_scellement.png");
	   private final Model model;

	   public SceauScellementRenderer(EntityRendererProvider.Context p_174449_) {
	      super(p_174449_);
	      this.model = new SceauScellement<>(p_174449_.bakeLayer(ModelLayers.BANNER));
	   }

	   public void render(SceauScellementEntity SceauScellementEntity, float p_116485_, float p_116486_, PoseStack poseStack, MultiBufferSource p_116488_, int p_116489_) {
		   super.render(SceauScellementEntity, p_116485_, p_116486_, poseStack, p_116488_, p_116489_);
	      poseStack.pushPose();
	      Direction direction = SceauScellementEntity.getDirection();
	      Vec3 vec3 = this.getRenderOffset(SceauScellementEntity, p_116486_);
	      poseStack.translate(vec3.x(), vec3.y()-0.05, vec3.z()+0.32);
	      poseStack.scale(0.25f, 0.25f, 0.25f);
	      VertexConsumer vertexconsumer = p_116488_.getBuffer(this.model.renderType(this.getTextureLocation(SceauScellementEntity)));
	      poseStack.mulPose(Axis.XP.rotationDegrees(SceauScellementEntity.getXRot()));
	      poseStack.mulPose(Axis.YP.rotationDegrees(180.0F - SceauScellementEntity.getYRot()));
	      this.model.renderToBuffer(poseStack, vertexconsumer, p_116489_, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
	      poseStack.popPose();
	   }
	   
	   public ResourceLocation getTextureLocation(SceauScellementEntity p_116482_) {
	      return TEXTURE_LOCATION;
	   }
}

