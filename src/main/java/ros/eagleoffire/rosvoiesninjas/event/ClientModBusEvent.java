package ros.eagleoffire.rosvoiesninjas.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers;
import ros.eagleoffire.rosvoiesninjas.client.renderer.entity.SceauChakra.*;
import ros.eagleoffire.rosvoiesninjas.client.renderer.entity.SceauChakraAutrui.*;
import ros.eagleoffire.rosvoiesninjas.client.renderer.entity.SceauExplosif.*;
import ros.eagleoffire.rosvoiesninjas.client.renderer.entity.SceauScellement.*;
import ros.eagleoffire.rosvoiesninjas.entity.ModEntities;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid= ROSVoiesNinjas.MODID, value=Dist.CLIENT, bus= Mod.EventBusSubscriber.Bus.MOD)
public class ClientModBusEvent {
	@SubscribeEvent
	public static void registerRenderersEvent(RegisterRenderers event) {
		event.registerEntityRenderer(ModEntities.SCEAU_EXPLOSIF_NIV0.get(), SceauExplosifNiv0Renderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_EXPLOSIF_NIV1.get(), SceauExplosifNiv1Renderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_EXPLOSIF_NIV2.get(), SceauExplosifNiv2Renderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_EXPLOSIF_NIV3.get(), SceauExplosifNiv3Renderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_EXPLOSIF_NIV4.get(), SceauExplosifNiv4Renderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_EXPLOSIF_NIV5.get(), SceauExplosifNiv5Renderer::new);

		event.registerEntityRenderer(ModEntities.SCEAU_CHAKRA_NIV0.get(), SceauChakraNiv0Renderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_CHAKRA_NIV1.get(), SceauChakraNiv1Renderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_CHAKRA_NIV2.get(), SceauChakraNiv2Renderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_CHAKRA_NIV3.get(), SceauChakraNiv3Renderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_CHAKRA_NIV4.get(), SceauChakraNiv4Renderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_CHAKRA_NIV5.get(), SceauChakraNiv5Renderer::new);

		event.registerEntityRenderer(ModEntities.SCEAU_SCELLEMENT_NIV0.get(), SceauScellementNiv0Renderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_SCELLEMENT_NIV1.get(), SceauScellementNiv1Renderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_SCELLEMENT_NIV2.get(), SceauScellementNiv2Renderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_SCELLEMENT_NIV3.get(), SceauScellementNiv3Renderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_SCELLEMENT_NIV4.get(), SceauScellementNiv4Renderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_SCELLEMENT_NIV5.get(), SceauScellementNiv5Renderer::new);

		event.registerEntityRenderer(ModEntities.SCEAU_CHAKRA_AUTRUI_NIV0.get(), SceauChakraAutruiNiv0Renderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_CHAKRA_AUTRUI_NIV1.get(), SceauChakraAutruiNiv1Renderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_CHAKRA_AUTRUI_NIV2.get(), SceauChakraAutruiNiv2Renderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_CHAKRA_AUTRUI_NIV3.get(), SceauChakraAutruiNiv3Renderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_CHAKRA_AUTRUI_NIV4.get(), SceauChakraAutruiNiv4Renderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_CHAKRA_AUTRUI_NIV5.get(), SceauChakraAutruiNiv5Renderer::new);
	}
}
