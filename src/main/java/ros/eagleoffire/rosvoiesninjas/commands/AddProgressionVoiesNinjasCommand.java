package ros.eagleoffire.rosvoiesninjas.commands;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.arguments.IntegerArgumentType;
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

public class AddProgressionVoiesNinjasCommand {

    public AddProgressionVoiesNinjasCommand(CommandDispatcher<CommandSourceStack> Dispatcher){
        Dispatcher.register(Commands.literal("addxp")
                .then(Commands.argument("target", StringArgumentType.string())
                .then(Commands.argument("voie ninja", StringArgumentType.string())
                .then(Commands.argument("quantité", IntegerArgumentType.integer())
                .executes(commandContext ->
                AddProgressionVoiesNinjas(commandContext.getSource(),
                        StringArgumentType.getString(commandContext, "target"),
                        StringArgumentType.getString(commandContext, "voie ninja"),
                        IntegerArgumentType.getInteger(commandContext, "quantité") ))
        ))));
    }
    private int AddProgressionVoiesNinjas(CommandSourceStack source, String target, String voie, int qts) throws CommandSyntaxException {
        PlayerList OnlinePlayer = source.getServer().getPlayerList();
        @NotNull
        ServerPlayer TargetedPlayer = Objects.requireNonNull(OnlinePlayer.getPlayerByName(target));

        TargetedPlayer.getCapability(ProgressionVoiesNinjasProvider.PROGRESSION_VOIES_NINJAS).ifPresent(progression -> {
            source.sendSuccess(() -> {
            progression.addXP(progression.getByName(voie),qts);
            return Component.literal("Successfully added " + qts + "XP to " + voie + " for player " + target);
        }, true);
           ModMessages.sendToPlayer(new FuinjutsuDataSyncS2CPacket(progression.getByName("Fuinjutsu")), TargetedPlayer);
        });
       return 1;
    }
}
