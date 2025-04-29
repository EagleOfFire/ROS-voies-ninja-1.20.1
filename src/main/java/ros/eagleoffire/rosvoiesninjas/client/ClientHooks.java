package ros.eagleoffire.rosvoiesninjas.client;

import net.minecraft.client.Minecraft;
import ros.eagleoffire.rosvoiesninjas.screen.FuinjutsuScreen;
import ros.eagleoffire.rosvoiesninjas.screen.VoiesNinjasScreen;

public class ClientHooks {
    public static void openVoiesNinjas(){
        Minecraft.getInstance().setScreen(new VoiesNinjasScreen(Minecraft.getInstance().player));
    }

    public static void openFuinjutsu(){
        Minecraft.getInstance().setScreen(new FuinjutsuScreen(Minecraft.getInstance().player));
    }

    public static void openFuinjutsuStockage() {
    }

    public static void openFuinjutsuMineChakraique() {
    }

    public static void openFuinjutsuBariere() {
    }

    public static void openFuinjutsuFumigene() {
    }

    public static void openFuinjutsuExplosif() {
    }
}