package ros.eagleoffire.rosvoiesninjas.entity.Model.SceauChakra;// Made with Blockbench 4.9.4
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.model.EntityModel;
import net.minecraft.client.model.geom.ModelLayerLocation;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.*;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.decoration.HangingEntity;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;

public class SceauChakraNiv4Model<T extends HangingEntity> extends EntityModel<T> {
public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation(ROSVoiesNinjas.MODID, "sceau_chakra_niv4"), "main");
	private final ModelPart bb_main;
	public SceauChakraNiv4Model(ModelPart root) {
		this.bb_main = root.getChild("flag");
	}
	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition flag = partdefinition.addOrReplaceChild("flag", CubeListBuilder.create()
				.texOffs(0, 0)
				.addBox(-4.0F, 0.0F, -8.0F, 8.0F, 0.0F, 16.0F,
						new CubeDeformation(0.0F)), PartPose.offset(0.0F, -24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 64, 64);
	}
	@Override
	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		bb_main.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}