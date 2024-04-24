package ros.eagleoffire.rosvoiesninjas.Items;

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
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(ModItems.SCEAU_EXPLOSIF_ITEM.get()))
                    .title(Component.translatable("creativetab.ros_voies_ninjas_tab"))
                    .displayItems((pParameters, pOutput) -> {
                        pOutput.accept(ModItems.SCEAU_VIERGE.get());
                        pOutput.accept(ModItems.SCEAU_EXPLOSIF_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_CHAKRA_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_SCELLEMENT_ITEM.get());
                        pOutput.accept(ModItems.SCEAU_CHAKRA_AUTRUI_ITEM.get());
                    })
                    .build());


    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
