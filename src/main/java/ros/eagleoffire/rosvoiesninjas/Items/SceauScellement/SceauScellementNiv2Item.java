
package ros.eagleoffire.rosvoiesninjas.Items.SceauScellement;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.HangingEntityItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.gameevent.GameEvent;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauScellement.SceauScellementNiv2Entity;

public class SceauScellementNiv2Item extends HangingEntityItem {
    public SceauScellementNiv2Item(EntityType<? extends HangingEntity> pType, Properties pProperties) {
        super(pType, pProperties);
    }

    public SceauScellementNiv2Item(Properties pProperties) {
        //super(ModEntities.SCEAU_EXPLOSIF.get(), pProperties);
        super(EntityType.ITEM_FRAME, pProperties);
    }


    protected boolean mayPlace(Player pPlayer, Direction pDirection, ItemStack pItemStack, BlockPos pPos) {
        return !pPlayer.level().isOutsideBuildHeight(pPos) && pPlayer.mayUseItemAt(pPos, pDirection, pItemStack);
    }

    @Override
   public InteractionResult useOn(UseOnContext pContext) {
         Level level = pContext.getLevel();
         BlockPos blockpos = pContext.getClickedPos();
         Direction direction = pContext.getClickedFace();
         BlockPos blockpos1 = blockpos.relative(direction);
         SceauScellementNiv2Entity hangingentity = new SceauScellementNiv2Entity(level, blockpos1, direction);
         hangingentity.setDirection(direction);
         Player player = pContext.getPlayer();
         hangingentity.playPlacementSound();
         level.gameEvent(player, GameEvent.ENTITY_PLACE, hangingentity.position());
         level.addFreshEntity(hangingentity);
         return InteractionResult.CONSUME;
   }
}
