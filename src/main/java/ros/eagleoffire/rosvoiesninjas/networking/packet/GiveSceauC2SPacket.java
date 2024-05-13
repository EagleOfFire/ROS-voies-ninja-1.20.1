package ros.eagleoffire.rosvoiesninjas.networking.packet;

import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.network.NetworkEvent;
import ros.eagleoffire.rosvoiesninjas.Items.ModItems;

import java.util.Objects;
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
            if(Objects.equals(sceauName, "Explosif")) {
                if (nivSceau == 1){
                    player.addItem(new ItemStack(ModItems.SCEAU_EXPLOSIF_NIV1_ITEM.get(), 1));
                } else if (nivSceau == 2) {
                    player.addItem(new ItemStack(ModItems.SCEAU_EXPLOSIF_NIV2_ITEM.get(), 1));
                } else if (nivSceau == 3) {
                    player.addItem(new ItemStack(ModItems.SCEAU_EXPLOSIF_NIV3_ITEM.get(), 1));
                } else if (nivSceau == 4) {
                    player.addItem(new ItemStack(ModItems.SCEAU_EXPLOSIF_NIV4_ITEM.get(), 1));
                }else if (nivSceau == 5){
                    player.addItem(new ItemStack(ModItems.SCEAU_EXPLOSIF_NIV5_ITEM.get(), 1));
                }
            } else if (Objects.equals(sceauName, "Chakra")) {
                if (nivSceau == 1){
                    player.addItem(new ItemStack(ModItems.SCEAU_CHAKRA_NIV1_ITEM.get(), 1));
                } else if (nivSceau == 2) {
                    player.addItem(new ItemStack(ModItems.SCEAU_CHAKRA_NIV2_ITEM.get(), 1));
                } else if (nivSceau == 3) {
                    player.addItem(new ItemStack(ModItems.SCEAU_CHAKRA_NIV3_ITEM.get(), 1));
                } else if (nivSceau == 4) {
                    player.addItem(new ItemStack(ModItems.SCEAU_CHAKRA_NIV4_ITEM.get(), 1));
                }else if (nivSceau == 5){
                    player.addItem(new ItemStack(ModItems.SCEAU_CHAKRA_NIV5_ITEM.get(), 1));
                }
            } else if (Objects.equals(sceauName, "Scellement")) {
                if (nivSceau == 1){
                    player.addItem(new ItemStack(ModItems.SCEAU_SCELLEMENT_NIV1_ITEM.get(), 1));
                } else if (nivSceau == 2) {
                    player.addItem(new ItemStack(ModItems.SCEAU_SCELLEMENT_NIV2_ITEM.get(), 1));
                } else if (nivSceau == 3) {
                    player.addItem(new ItemStack(ModItems.SCEAU_SCELLEMENT_NIV3_ITEM.get(), 1));
                } else if (nivSceau == 4) {
                    player.addItem(new ItemStack(ModItems.SCEAU_SCELLEMENT_NIV4_ITEM.get(), 1));
                }else if (nivSceau == 5){
                    player.addItem(new ItemStack(ModItems.SCEAU_SCELLEMENT_NIV5_ITEM.get(), 1));
                }
            }else if (Objects.equals(sceauName, "ChakraAutrui")){
                if (nivSceau == 1){
                    player.addItem(new ItemStack(ModItems.SCEAU_CHAKRA_AUTRUI_NIV1_ITEM.get(), 1));
                } else if (nivSceau == 2) {
                    player.addItem(new ItemStack(ModItems.SCEAU_CHAKRA_AUTRUI_NIV2_ITEM.get(), 1));
                } else if (nivSceau == 3) {
                    player.addItem(new ItemStack(ModItems.SCEAU_CHAKRA_AUTRUI_NIV3_ITEM.get(), 1));
                } else if (nivSceau == 4) {
                    player.addItem(new ItemStack(ModItems.SCEAU_CHAKRA_AUTRUI_NIV4_ITEM.get(), 1));
                }else if (nivSceau == 5){
                    player.addItem(new ItemStack(ModItems.SCEAU_CHAKRA_AUTRUI_NIV5_ITEM.get(), 1));
                }
            }
        });
    }
}