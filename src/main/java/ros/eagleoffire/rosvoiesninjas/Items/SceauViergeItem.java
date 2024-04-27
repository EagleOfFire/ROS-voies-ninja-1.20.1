package ros.eagleoffire.rosvoiesninjas.Items;

import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.*;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import org.jetbrains.annotations.Nullable;
import net.minecraftforge.network.NetworkHooks;
import ros.eagleoffire.rosvoiesninjas.client.ClientHooks;

import static ros.eagleoffire.rosvoiesninjas.client.ClientHooks.openSceauViergeScreen;

public class SceauViergeItem extends Item {

    public SceauViergeItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        InteractionHand hand = pContext.getHand();
        if(hand != InteractionHand.MAIN_HAND) return InteractionResult.PASS;
        if(!level.isClientSide()) return InteractionResult.SUCCESS;
        BlockEntity be = level.getBlockEntity(pContext.getClickedPos());
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ClientHooks.openSceauViergeScreen(pContext.getClickedPos()));
        return InteractionResult.SUCCESS;
    }
}
