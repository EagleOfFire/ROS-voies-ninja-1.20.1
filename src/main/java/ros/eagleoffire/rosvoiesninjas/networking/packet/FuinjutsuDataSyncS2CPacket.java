package ros.eagleoffire.rosvoiesninjas.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import ros.eagleoffire.rosvoiesninjas.ProgressionVoiesNinjas.VoiesNinjas;
import ros.eagleoffire.rosvoiesninjas.client.ProgressionVoiesNinjasData.ClientFuinjutsuData;

import java.util.function.Supplier;

public class FuinjutsuDataSyncS2CPacket {
    private final String name;
    private final int XP;
    private final int LVL;
    private final int LVLmax;

    public FuinjutsuDataSyncS2CPacket(VoiesNinjas Fuinjutsu) {
        this.name = Fuinjutsu.getNAME();
        this.XP = Fuinjutsu.getXP();
        this.LVL = Fuinjutsu.getLVL();
        this.LVLmax = Fuinjutsu.getLVLmax();
    }

    public FuinjutsuDataSyncS2CPacket(FriendlyByteBuf buf) {
        this.name = buf.readUtf();
        this.XP = buf.readInt();
        this.LVL = buf.readInt();
        this.LVLmax = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeUtf(this.name);
        buf.writeInt(this.XP);
        buf.writeInt(this.LVL);
        buf.writeInt(this.LVLmax);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ClientFuinjutsuData.set(name,XP,LVL,LVLmax);
        });
        return true;
    }
}