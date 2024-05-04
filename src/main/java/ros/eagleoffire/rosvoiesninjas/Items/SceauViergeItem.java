package ros.eagleoffire.rosvoiesninjas.Items;

import net.minecraft.world.*;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import ros.eagleoffire.rosvoiesninjas.client.ClientHooks;

public class SceauViergeItem extends Item {

    public SceauViergeItem(Properties pProperties) {
        super(pProperties);
    }

/*    @Override
    public InteractionResult useOn(UseOnContext pContext) {
        Level level = pContext.getLevel();
        InteractionHand hand = pContext.getHand();
        if(hand != InteractionHand.MAIN_HAND) return InteractionResult.PASS;
        if(!level.isClientSide()) return InteractionResult.SUCCESS;
        BlockEntity be = level.getBlockEntity(pContext.getClickedPos());
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ClientHooks.openSceauViergeScreen(pContext.getClickedPos()));
        return InteractionResult.SUCCESS;
    }*/

    @Override
    public InteractionResultHolder<ItemStack> use(Level Level, Player Player, InteractionHand Hand) {
        if(Hand != InteractionHand.MAIN_HAND) return InteractionResultHolder.pass(this.getDefaultInstance());
        if(!Level.isClientSide()) return InteractionResultHolder.success(this.getDefaultInstance());
        DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> () -> ClientHooks.openSceauViergeScreen());
        return InteractionResultHolder.success(this.getDefaultInstance());
    }
}
