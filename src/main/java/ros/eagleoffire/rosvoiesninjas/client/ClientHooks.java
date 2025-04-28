package ros.eagleoffire.rosvoiesninjas.client;

import net.minecraft.client.Minecraft;
import ros.eagleoffire.rosvoiesninjas.screen.FuinjutsuScreen;

public class ClientHooks {
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