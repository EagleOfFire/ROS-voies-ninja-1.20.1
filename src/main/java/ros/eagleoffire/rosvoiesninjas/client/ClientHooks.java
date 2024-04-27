package ros.eagleoffire.rosvoiesninjas.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.OptionInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraftforge.network.NetworkHooks;
import ros.eagleoffire.rosvoiesninjas.screen.SceauViergeScreen;

public class ClientHooks {
    public static void openSceauViergeScreen(BlockPos position) {
        Minecraft.getInstance().setScreen(new SceauViergeScreen(position));
    }
}
