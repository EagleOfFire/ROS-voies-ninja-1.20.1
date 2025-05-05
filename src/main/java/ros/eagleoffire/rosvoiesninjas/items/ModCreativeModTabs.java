package ros.eagleoffire.rosvoiesninjas.items;

import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;

public class ModCreativeModTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ROSVoiesNinjas.MODID);

    public static final RegistryObject<CreativeModeTab> ROS_VOIES_NINJAS_TAB = CREATIVE_MODE_TAB.register("ros_voies_ninjas_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SCEAU_EXPLOSIF_RANK_S_ITEM.get()))
                    .title(Component.translatable("creativetab.ros_voies_ninjas_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SCEAU_EXPLOSIF_RANK_D_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_EXPLOSIF_RANK_C_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_EXPLOSIF_RANK_B_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_EXPLOSIF_RANK_A_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_EXPLOSIF_RANK_S_ITEM.get());

                        pOutput.accept(ModItems.SCEAU_CHAKRA_RANK_D_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_CHAKRA_RANK_C_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_CHAKRA_RANK_B_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_CHAKRA_RANK_A_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_CHAKRA_RANK_S_ITEM.get());

                        pOutput.accept(ModItems.SCEAU_BARRIERE_RANK_D_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_BARRIERE_RANK_C_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_BARRIERE_RANK_B_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_BARRIERE_RANK_A_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_BARRIERE_RANK_S_ITEM.get());
                        
                        pOutput.accept(ModItems.SCEAU_FUMIGENE_RANK_D_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_FUMIGENE_RANK_C_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_FUMIGENE_RANK_B_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_FUMIGENE_RANK_A_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_FUMIGENE_RANK_S_ITEM.get());

                        pOutput.accept(ModItems.SCEAU_MINE_CHAKRA_RANK_D_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_MINE_CHAKRA_RANK_C_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_MINE_CHAKRA_RANK_B_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_MINE_CHAKRA_RANK_A_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_MINE_CHAKRA_RANK_S_ITEM.get());
                    })
                    .build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
