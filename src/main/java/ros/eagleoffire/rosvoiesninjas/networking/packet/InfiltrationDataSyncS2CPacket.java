package ros.eagleoffire.rosvoiesninjas.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import ros.eagleoffire.rosvoiesninjas.ProgressionVoiesNinjas.VoiesNinjas;
import ros.eagleoffire.rosvoiesninjas.client.ProgressionVoiesNinjasData.ClientInfiltrationData;

import java.util.function.Supplier;

public class InfiltrationDataSyncS2CPacket {
    private final String name;
    private final int XP;
    private final int LVL;
    private final int LVLmax;

    public InfiltrationDataSyncS2CPacket(VoiesNinjas Infiltration) {
        this.name = Infiltration.getNAME();
        this.XP = Infiltration.getXP();
        this.LVL = Infiltration.getLVL();
        this.LVLmax = Infiltration.getLVLmax();
    }

    public InfiltrationDataSyncS2CPacket(FriendlyByteBuf buf) {
        System.out.println(buf);
        this.name = buf.readUtf();
        this.XP = buf.readInt();
        this.LVL = buf.readInt();
        this.LVLmax = buf.readInt();
    }

    public void toBytes(FriendlyByteBuf buf) {
        buf.writeUtf(name);
        buf.writeInt(XP);
        buf.writeInt(LVL);
        buf.writeInt(LVLmax);
    }

    public boolean handle(Supplier<NetworkEvent.Context> supplier) {
        NetworkEvent.Context context = supplier.get();
        context.enqueueWork(() -> {
            ClientInfiltrationData.set(name,XP,LVL,LVLmax);
        });
        return true;
    }
}