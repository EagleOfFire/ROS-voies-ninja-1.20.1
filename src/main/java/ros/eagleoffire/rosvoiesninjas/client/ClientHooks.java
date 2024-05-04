package ros.eagleoffire.rosvoiesninjas.client;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import ros.eagleoffire.rosvoiesninjas.screen.*;

public class ClientHooks {
    public static void openSceauViergeScreen() {
        Minecraft.getInstance().setScreen(new SceauViergeScreen());
    }
    public static void openSceauExplosifScreen() {
        Minecraft.getInstance().setScreen(new SceauExplosifScreen());
    }
    public static void openSceauChakraScreen() {
        Minecraft.getInstance().setScreen(new SceauChakraScreen());
    }
    public static void openSceauScellementScreen() {
        Minecraft.getInstance().setScreen(new SceauScellementScreen());
    }
    public static void openSceauChakraAutruiScreen() {
        Minecraft.getInstance().setScreen(new SceauChakraAutruiScreen());
    }
}
