package ros.eagleoffire.rosvoiesninjas.event;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;
import net.minecraftforge.client.event.EntityRenderersEvent.RegisterRenderers;
import ros.eagleoffire.rosvoiesninjas.client.renderer.entity.*;
import ros.eagleoffire.rosvoiesninjas.entity.ModEntities;

@OnlyIn(Dist.CLIENT)
@Mod.EventBusSubscriber(modid= ROSVoiesNinjas.MODID, value=Dist.CLIENT, bus= Mod.EventBusSubscriber.Bus.MOD)
public class ClientModBusEvent {
	@SubscribeEvent
	public static void registerRenderersEvent(RegisterRenderers event) {
		event.registerEntityRenderer(ModEntities.SCEAU_EXPLOSIF.get(), SceauExplosifRenderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_CHAKRA.get(), SceauChakraRenderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_SCELLEMENT.get(), SceauScellementRenderer::new);
		event.registerEntityRenderer(ModEntities.SCEAU_CHAKRA_AUTRUI.get(), SceauChakraAutruiRenderer::new);
	}
}
