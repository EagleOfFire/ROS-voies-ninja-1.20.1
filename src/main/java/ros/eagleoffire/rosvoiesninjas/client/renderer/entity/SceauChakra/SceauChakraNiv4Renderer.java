package ros.eagleoffire.rosvoiesninjas.client.renderer.entity.SceauChakra;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.geom.ModelLayers;
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
import ros.eagleoffire.rosvoiesninjas.entity.Model.SceauChakra.SceauChakraNiv4Model;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauChakra.SceauChakraNiv4Entity;

@OnlyIn(Dist.CLIENT)
public class SceauChakraNiv4Renderer extends EntityRenderer<SceauChakraNiv4Entity> {
    private final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(ROSVoiesNinjas.MODID, "textures/block/sceauchakra/sceau_chakra_entity_niv4.png");
    private final Model model;

    public SceauChakraNiv4Renderer(EntityRendererProvider.Context p_174449_) {
        super(p_174449_);
        this.model = new SceauChakraNiv4Model<>(p_174449_.bakeLayer(ModelLayers.BANNER));
    }

    public void render(SceauChakraNiv4Entity SceauChakraNiv4Entity, float pEntityYaw, float pPartialTicks, PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(SceauChakraNiv4Entity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
        pPoseStack.pushPose();
        Direction direction = SceauChakraNiv4Entity.getDirection();
        Vec3 vec3 = this.getRenderOffset(SceauChakraNiv4Entity, pPartialTicks);
        //pPoseStack.translate(vec3.x(), vec3.y()-0.05, vec3.z()+0.32);
        pPoseStack.scale(0.20f, 0.20f, 0.20f);
        pPoseStack.translate(vec3.x(), vec3.y(), vec3.z());
        pPoseStack.translate(0,-0.2,0);
        VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(this.getTextureLocation(SceauChakraNiv4Entity)));
        pPoseStack.mulPose(Axis.XP.rotationDegrees(SceauChakraNiv4Entity.getXRot()));
        pPoseStack.mulPose(Axis.YP.rotationDegrees(180.0F - SceauChakraNiv4Entity.getYRot()));
        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pPoseStack.popPose();
    }

    public ResourceLocation getTextureLocation(SceauChakraNiv4Entity p_116482_) {
        return TEXTURE_LOCATION;
    }
}

