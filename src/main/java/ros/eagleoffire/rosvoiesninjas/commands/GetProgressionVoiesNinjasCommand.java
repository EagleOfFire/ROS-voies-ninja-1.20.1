package ros.eagleoffire.rosvoiesninjas.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.Commands;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.players.PlayerList;
import org.jetbrains.annotations.NotNull;
import ros.eagleoffire.rosvoiesninjas.ProgressionVoiesNinjas.ProgressionVoiesNinjasProvider;
import ros.eagleoffire.rosvoiesninjas.networking.ModMessages;
import ros.eagleoffire.rosvoiesninjas.networking.packet.*;

import java.util.Objects;

public class GetProgressionVoiesNinjasCommand {

    public GetProgressionVoiesNinjasCommand(CommandDispatcher<CommandSourceStack> Dispatcher){
        Dispatcher.register(Commands.literal("getxp")
                .then(Commands.argument("target", StringArgumentType.string())
                .executes(commandContext ->
                GetProgressionVoiesNinjas(commandContext.getSource(),
                        StringArgumentType.getString(commandContext, "target")))
        ));
    }

    private int GetProgressionVoiesNinjas(CommandSourceStack source, String target) throws CommandSyntaxException {
        PlayerList OnlinePlayer = source.getServer().getPlayerList();
        @NotNull
        ServerPlayer TargetedPlayer = Objects.requireNonNull(OnlinePlayer.getPlayerByName(target));

        TargetedPlayer.getCapability(ProgressionVoiesNinjasProvider.PROGRESSION_VOIES_NINJAS).ifPresent(progression -> {
           source.sendSuccess(() -> {
            return Component.literal("Player " + target + " have :\n" + progression.getXP(progression.getByName("Fuinjutsu")) + " XP in Fuinjutsu which correspond to level "
                    + progression.getLVL(progression.getByName("Fuinjutsu")) + " (max " + progression.getLVLmax(progression.getByName("Fuinjutsu")) +")\n"
            +progression.getXP(progression.getByName("Sensorialite")) + " XP in Sensorialite which correspond to level "
                    + progression.getLVL(progression.getByName("Sensorialite")) + " (max " + progression.getLVLmax(progression.getByName("Sensorialite")) +")\n"
            +progression.getXP(progression.getByName("Infiltration")) + " XP in Infiltration which correspond to level "
                    + progression.getLVL(progression.getByName("Infiltration")) + " (max " + progression.getLVLmax(progression.getByName("Infiltration")) +")\n"
            +progression.getXP(progression.getByName("Invocation")) + " XP in Fuinjutsu which correspond to level "
                    + progression.getLVL(progression.getByName("Invocation")) + " (max " + progression.getLVLmax(progression.getByName("Invocation")) +")\n"
            +progression.getXP(progression.getByName("Kekkei Barriere")) + " XP in Kekkei Barriere which correspond to level "
                    + progression.getLVL(progression.getByName("Kekkei Barriere")) + " (max " + progression.getLVLmax(progression.getByName("Kekkei Barriere")) +")");
        }, true);
           ModMessages.sendToPlayer(new FuinjutsuDataSyncS2CPacket(progression.getByName("Fuinjutsu")), TargetedPlayer);
        });
        return 1;
    }

}
