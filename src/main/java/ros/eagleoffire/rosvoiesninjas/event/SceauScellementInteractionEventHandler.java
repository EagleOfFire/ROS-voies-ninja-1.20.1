package ros.eagleoffire.rosvoiesninjas.event;

import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.phys.AABB;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;
import net.minecraft.world.entity.Entity;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauScellement.*;

import java.util.List;
import java.util.Arrays;

@Mod.EventBusSubscriber(modid = ROSVoiesNinjas.MODID)
public class SceauScellementInteractionEventHandler {

    private static final List<Class<? extends Entity>> entityClasses = Arrays.asList(
        SceauScellementNiv1Entity.class,
        SceauScellementNiv2Entity.class,
        SceauScellementNiv3Entity.class,
        SceauScellementNiv4Entity.class,
        SceauScellementNiv5Entity.class
    );

    @SubscribeEvent
    public static void onBlockRightClick(PlayerInteractEvent.RightClickBlock event){
        BlockPos pos = event.getPos();
        AABB boundingBox = new AABB(pos.offset(-1, -1, -1), pos.offset(2, 2, 2)); // Cover a larger area around the block

        List<Entity> entities = event.getLevel().getEntities((Entity) null, boundingBox);

        boolean hasHangingEntity = entities.stream().anyMatch(entity ->
                entityClasses.stream().anyMatch(clazz -> clazz.isInstance(entity)));

        if (hasHangingEntity) {
            event.setCanceled(true);
            event.getEntity().displayClientMessage(Component.nullToEmpty("RATIO !"), true);
        } else {
            for (Entity entity : entities) {
                System.out.println(" - " + entity.getType().getDescription() + " at position " + entity.blockPosition());
            }        }
    }
}
