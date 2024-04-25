package ros.eagleoffire.rosvoiesninjas.Items;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HangingEntityItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import ros.eagleoffire.rosvoiesninjas.entity.ModEntities;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauExplosifEntity;


public class SceauExplosifItem extends HangingEntityItem {
    public SceauExplosifItem(Item.Properties pProperties) {
        //super(ModEntities.SCEAU_EXPLOSIF.get(), pProperties);
        super(EntityType.ITEM_FRAME, pProperties);
    }

    public SceauExplosifItem(EntityType<? extends HangingEntity> pType, Item.Properties pProperties) {
        super(pType, pProperties);
    }

    protected boolean mayPlace(Player pPlayer, Direction pDirection, ItemStack pItemStack, BlockPos pPos) {
        return !pPlayer.level().isOutsideBuildHeight(pPos) && pPlayer.mayUseItemAt(pPos, pDirection, pItemStack);
    }

    @Override
   public InteractionResult useOn(UseOnContext pContext) {
         System.out.println("useOn");
         Level level = pContext.getLevel();
         BlockPos blockpos = pContext.getClickedPos();
         Direction direction = pContext.getClickedFace();
         BlockPos blockpos1 = blockpos.relative(direction);
          System.out.println("useoff");
         SceauExplosifEntity hangingentity = new SceauExplosifEntity(ModEntities.SCEAU_EXPLOSIF.get(), level, blockpos1, direction);
         hangingentity.setDirection(direction);
         Player player = pContext.getPlayer();
         hangingentity.playPlacementSound();
         level.gameEvent(player, GameEvent.ENTITY_PLACE, hangingentity.position());
         level.addFreshEntity(hangingentity);
         return InteractionResult.CONSUME;
   }
}
