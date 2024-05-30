package ros.eagleoffire.rosvoiesninjas.client;

import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.player.Player;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauChakra.SceauChakraNiv0Entity;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauChakraAutrui.SceauChakraAutruiNiv0Entity;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauExplosif.SceauExplosifNiv0Entity;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauScellement.SceauScellementNiv0Entity;
import ros.eagleoffire.rosvoiesninjas.screen.*;
import ros.eagleoffire.rosvoiesninjas.screen.SceauChakra.SceauChakraScreen;
import ros.eagleoffire.rosvoiesninjas.screen.SceauChakraAutrui.SceauChakraAutruiScreen;
import ros.eagleoffire.rosvoiesninjas.screen.SceauExplosif.SceauExplosifScreen;
import ros.eagleoffire.rosvoiesninjas.screen.SceauScellement.SceauScellementScreen;

public class ClientHooks {
    public static void openSceauViergeScreen(Player Player) {
        Minecraft.getInstance().setScreen(new SceauViergeScreen(Player));
    }
    public static void openSceauExplosifScreen(Player player, SceauExplosifNiv0Entity sceauentity) {
        Minecraft.getInstance().setScreen(new SceauExplosifScreen(player, sceauentity));
    }
    public static void openSceauChakraScreen(Player player, SceauChakraNiv0Entity sceauentity) {
        Minecraft.getInstance().setScreen(new SceauChakraScreen(player, sceauentity));
    }
    public static void openSceauScellementScreen(Player player, SceauScellementNiv0Entity sceauentity) {
        Minecraft.getInstance().setScreen(new SceauScellementScreen(player, sceauentity));
    }
    public static void openSceauChakraAutruiScreen(Player player, SceauChakraAutruiNiv0Entity sceauentity) {
        Minecraft.getInstance().setScreen(new SceauChakraAutruiScreen(player, sceauentity));
    }
}
