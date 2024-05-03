package ros.eagleoffire.rosvoiesninjas.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraftforge.network.NetworkEvent;
import ros.eagleoffire.rosvoiesninjas.ProgressionVoiesNinjas.VoiesNinjas;
import ros.eagleoffire.rosvoiesninjas.client.ProgressionVoiesNinjasData.ClientSensorialiteData;

import java.util.function.Supplier;

public class SensorialiteDataSyncS2CPacket {
    private final String name;
    private final int XP;
    private final int LVL;
    private final int LVLmax;

    public SensorialiteDataSyncS2CPacket(VoiesNinjas Sensorialite) {
        this.name = Sensorialite.getNAME();
        this.XP = Sensorialite.getXP();
        this.LVL = Sensorialite.getLVL();
        this.LVLmax = Sensorialite.getLVLmax();
    }

    public SensorialiteDataSyncS2CPacket(FriendlyByteBuf buf) {
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
            ClientSensorialiteData.set(name,XP,LVL,LVLmax);
        });
        return true;
    }
}