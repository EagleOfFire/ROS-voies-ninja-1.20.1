package ros.eagleoffire.rosvoiesninjas.handler;

import net.minecraft.client.Minecraft;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.client.event.InputEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.DistExecutor;
import net.minecraftforge.fml.common.Mod;
import ros.eagleoffire.rosvoiesninjas.client.ClientHooks;
import ros.eagleoffire.rosvoiesninjas.client.Keybindings;
import net.minecraft.network.chat.Component;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;

@Mod.EventBusSubscriber(modid = ROSVoiesNinjas.MODID, bus = Mod.EventBusSubscriber.Bus.FORGE,value = Dist.CLIENT)
public class ClientForgeHandler {
    private static final Component OPEN_SPELL_SCREEN =
            Component.translatable("message." + ROSVoiesNinjas.MODID + ".open_spell_screen_pressed");

    @SubscribeEvent
    public static void onKeyInput(InputEvent.Key event){
        Minecraft minecraft = Minecraft.getInstance();
        if (Keybindings.INSTANCE.OpenVoiesNinjasScreen.consumeClick() && minecraft.player != null) {
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientHooks::openVoiesNinjas);
        }
        if (Keybindings.INSTANCE.OpenFuinjutsuScreen.consumeClick() && minecraft.player != null) {
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientHooks::openFuinjutsu);
        }
    }
}