package ros.eagleoffire.rosvoiesninjas.event;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.event.RegisterCommandsEvent;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.fml.LogicalSide;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.server.command.ConfigCommand;
import ros.eagleoffire.rosvoiesninjas.ProgressionVoiesNinjas.ProgressionVoiesNinjas;
import ros.eagleoffire.rosvoiesninjas.ProgressionVoiesNinjas.ProgressionVoiesNinjasProvider;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import ros.eagleoffire.rosvoiesninjas.commands.AddProgressionVoiesNinjasCommand;
import ros.eagleoffire.rosvoiesninjas.commands.GetProgressionVoiesNinjasCommand;
import ros.eagleoffire.rosvoiesninjas.commands.RemoveProgressionVoiesNinjasCommand;
import net.minecraftforge.event.entity.EntityJoinLevelEvent;
import ros.eagleoffire.rosvoiesninjas.networking.ModMessages;
import ros.eagleoffire.rosvoiesninjas.networking.packet.*;

@Mod.EventBusSubscriber(modid = ROSVoiesNinjas.MODID)
public class ModEvents {

    @SubscribeEvent
    public static void onCommandsRegister(RegisterCommandsEvent event){
        new AddProgressionVoiesNinjasCommand(event.getDispatcher());
        new GetProgressionVoiesNinjasCommand(event.getDispatcher());
        new RemoveProgressionVoiesNinjasCommand(event.getDispatcher());

        ConfigCommand.register(event.getDispatcher());
    }

    @SubscribeEvent
    public static void onAttachCapabilitiesPlayer(AttachCapabilitiesEvent<Entity> event) {
        if(event.getObject() instanceof Player) {
            if(!event.getObject().getCapability(ProgressionVoiesNinjasProvider.PROGRESSION_VOIES_NINJAS).isPresent()) {
                event.addCapability(new ResourceLocation(ROSVoiesNinjas.MODID, "properties"), new ProgressionVoiesNinjasProvider());
            }
        }
    }

    @SubscribeEvent
    public static void onPlayerCloned(PlayerEvent.Clone event) {
        if(event.isWasDeath()) {
            event.getOriginal().getCapability(ProgressionVoiesNinjasProvider.PROGRESSION_VOIES_NINJAS).ifPresent(oldStore -> {
                event.getOriginal().getCapability(ProgressionVoiesNinjasProvider.PROGRESSION_VOIES_NINJAS).ifPresent(newStore -> {
                    newStore.copyFrom(oldStore);
                });
            });
        }
    }

    @SubscribeEvent
    public static void onRegisterCapabilities(RegisterCapabilitiesEvent event) {
        event.register(ProgressionVoiesNinjas.class);
    }

    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        if(event.side == LogicalSide.SERVER) {
            event.player.getCapability(ProgressionVoiesNinjasProvider.PROGRESSION_VOIES_NINJAS).ifPresent(progression -> {
                if(event.player.getRandom().nextFloat() < 0.005f) { // Once Every 10 Seconds on Avg
                    //event.player.sendSystemMessage(Component.literal(String.format("Your progression is at %2d XP point", progression.getExperience())));
                }
            });
        }
    }

    @SubscribeEvent
    public static void onPlayerJoinWorld(EntityJoinLevelEvent event) {
        if(!event.getLevel().isClientSide()) {
            if(event.getEntity() instanceof ServerPlayer player) {
                player.getCapability(ProgressionVoiesNinjasProvider.PROGRESSION_VOIES_NINJAS).ifPresent(progression -> {
                   ModMessages.sendToPlayer(new FuinjutsuDataSyncS2CPacket(progression.getByName("Fuinjutsu")), player);
                });
            }
        }
    }
}
