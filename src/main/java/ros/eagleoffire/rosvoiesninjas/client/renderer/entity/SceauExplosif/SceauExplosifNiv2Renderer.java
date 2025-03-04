package ros.eagleoffire.rosvoiesninjas.client.renderer.entity.SceauExplosif;

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
import org.jetbrains.annotations.NotNull;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;
import ros.eagleoffire.rosvoiesninjas.entity.Model.SceauExplosif.SceauExplosifNiv2Model;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauExplosif.SceauExplosifNiv2Entity;

@OnlyIn(Dist.CLIENT)
public class SceauExplosifNiv2Renderer extends EntityRenderer<SceauExplosifNiv2Entity> {
    private final ResourceLocation TEXTURE_LOCATION = new ResourceLocation(ROSVoiesNinjas.MODID, "textures/block/sceauexplosif/sceau_explosif_entity_niv2.png");
    private final Model model;

    public SceauExplosifNiv2Renderer(EntityRendererProvider.Context p_174449_) {
        super(p_174449_);
        this.model = new SceauExplosifNiv2Model<>(p_174449_.bakeLayer(ModelLayers.BANNER));
    }

    public void render(@NotNull SceauExplosifNiv2Entity SceauExplosifNiv2Entity, float pEntityYaw, float pPartialTicks, @NotNull PoseStack pPoseStack, MultiBufferSource pBuffer, int pPackedLight) {
        super.render(SceauExplosifNiv2Entity, pEntityYaw, pPartialTicks, pPoseStack, pBuffer, pPackedLight);
        pPoseStack.pushPose();
        Direction direction = SceauExplosifNiv2Entity.getDirection();
        Vec3 vec3 = this.getRenderOffset(SceauExplosifNiv2Entity, pPartialTicks);
        //pPoseStack.translate(vec3.x(), vec3.y()-0.05, vec3.z()+0.32);
        pPoseStack.scale(0.20f, 0.20f, 0.20f);
        pPoseStack.translate(vec3.x(), vec3.y(), vec3.z());
        pPoseStack.translate(0,-0.2,0);
        VertexConsumer vertexconsumer = pBuffer.getBuffer(this.model.renderType(this.getTextureLocation(SceauExplosifNiv2Entity)));
        pPoseStack.mulPose(Axis.XP.rotationDegrees(SceauExplosifNiv2Entity.getXRot()));
        pPoseStack.mulPose(Axis.YP.rotationDegrees(180.0F - SceauExplosifNiv2Entity.getYRot()));
        this.model.renderToBuffer(pPoseStack, vertexconsumer, pPackedLight, OverlayTexture.NO_OVERLAY, 1.0F, 1.0F, 1.0F, 1.0F);
        pPoseStack.popPose();
    }

    public @NotNull ResourceLocation getTextureLocation(@NotNull SceauExplosifNiv2Entity p_116482_) {
        return TEXTURE_LOCATION;
    }
}

