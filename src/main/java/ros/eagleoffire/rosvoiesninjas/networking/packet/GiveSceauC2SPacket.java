package ros.eagleoffire.rosvoiesninjas.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import ros.eagleoffire.rosvoiesninjas.Items.ModItems;

import java.util.function.Supplier;

public class GiveSceauC2SPacket {
    //private final String playerName;
    private final String sceauName;
    private final int nivSceau;

    public GiveSceauC2SPacket(String sceauName, int nivSceau) {
        //this.playerName = playerName;
        this.sceauName = sceauName;
        this.nivSceau = nivSceau;
    }

    public GiveSceauC2SPacket(FriendlyByteBuf buf) {
        //this.playerName = buf.readUtf();
        this.sceauName = buf.readUtf();
        this.nivSceau = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        //buf.writeUtf(this.playerName);
        buf.writeUtf(this.sceauName);
        buf.writeInt(this.nivSceau);
    }

    public void handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ServerPlayer player = supplier.get().getSender();
            player.addItem(new ItemStack(ModItems.SCEAU_EXPLOSIF_NIV2_ITEM.get(), 1));
        });
    }
}