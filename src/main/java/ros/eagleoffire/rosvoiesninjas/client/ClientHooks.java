package ros.eagleoffire.rosvoiesninjas.client;

import net.minecraft.client.Minecraft;
import ros.eagleoffire.rosvoiesninjas.screen.*;

public class ClientHooks {
    public static void openVoiesNinjas() {
        Minecraft.getInstance().setScreen(new VoiesNinjasScreen(Minecraft.getInstance().player));
    }

    public static void openFuinjutsu() {
        Minecraft.getInstance().setScreen(new FuinjutsuScreen(Minecraft.getInstance().player));
    }

    public static void openFuinjutsuStockage() {
        Minecraft.getInstance().setScreen(new SceauStockageChakraScreen(Minecraft.getInstance().player));
    }

    public static void openFuinjutsuMineChakraique() {
        Minecraft.getInstance().setScreen(new SceauMineChakraiqueScreen(Minecraft.getInstance().player));
    }

    public static void openFuinjutsuBarriere() {
        Minecraft.getInstance().setScreen(new SceauBarriereScreen(Minecraft.getInstance().player));
    }

    public static void openFuinjutsuFumigene() {
        Minecraft.getInstance().setScreen(new SceauFumigeneScreen(Minecraft.getInstance().player));
    }

    public static void openFuinjutsuExplosif() {
        Minecraft.getInstance().setScreen(new SceauExplosifScreen(Minecraft.getInstance().player));
    }
}