package ros.eagleoffire.rosvoiesninjas.handler;

import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import ros.eagleoffire.rosvoiesninjas.client.Keybindings;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;

@Mod.EventBusSubscriber(modid = ROSVoiesNinjas.MODID, bus = Mod.EventBusSubscriber.Bus.MOD,value = Dist.CLIENT)
public class ClientModHandler {
    @SubscribeEvent
    public static void registerKeys(RegisterKeyMappingsEvent event){
        event.register(Keybindings.INSTANCE.OpenVoiesNinjasScreen);
        event.register(Keybindings.INSTANCE.OpenFuinjutsuScreen);
    }
}