package ros.eagleoffire.rosvoiesninjas.client;

import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauExplosif.SceauExplosifNiv0Entity;
import ros.eagleoffire.rosvoiesninjas.screen.*;

public class ClientHooks {
    public static void openSceauViergeScreen(Player Player) {
        Minecraft.getInstance().setScreen(new SceauViergeScreen(Player));
    }

    public static void openSceauExplosifScreen(Player player, SceauExplosifNiv0Entity sceauentity) {
        Minecraft.getInstance().setScreen(new SceauExplosifScreen(player, sceauentity));
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
