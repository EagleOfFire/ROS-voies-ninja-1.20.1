package ros.eagleoffire.rosvoiesninjas.Items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ros.eagleoffire.rosvoiesninjas.Items.SceauChakra.*;
import ros.eagleoffire.rosvoiesninjas.Items.SceauExplosif.*;
import ros.eagleoffire.rosvoiesninjas.Items.SceauScellement.*;
import ros.eagleoffire.rosvoiesninjas.Items.SceauChakraAutrui.*;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ROSVoiesNinjas.MODID);

    public static final RegistryObject<Item> SCEAU_VIERGE = ITEMS.register("sceau_vierge",
            () -> new SceauViergeItem(new Item.Properties()));

    public static final RegistryObject<Item> SCEAU_EXPLOSIF_NIV0_ITEM = ITEMS.register("sceau_explosif_item_niv0",
            () -> new SceauExplosifNiv0Item(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_EXPLOSIF_NIV1_ITEM = ITEMS.register("sceau_explosif_item_niv1",
            () -> new SceauExplosifNiv1Item(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_EXPLOSIF_NIV2_ITEM = ITEMS.register("sceau_explosif_item_niv2",
            () -> new SceauExplosifNiv2Item(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_EXPLOSIF_NIV3_ITEM = ITEMS.register("sceau_explosif_item_niv3",
            () -> new SceauExplosifNiv3Item(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_EXPLOSIF_NIV4_ITEM = ITEMS.register("sceau_explosif_item_niv4",
            () -> new SceauExplosifNiv4Item(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_EXPLOSIF_NIV5_ITEM = ITEMS.register("sceau_explosif_item_niv5",
            () -> new SceauExplosifNiv5Item(new Item.Properties()));

    public static final RegistryObject<Item> SCEAU_CHAKRA_NIV0_ITEM = ITEMS.register("sceau_chakra_item_niv0",
            () -> new SceauChakraNiv0Item(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_CHAKRA_NIV1_ITEM = ITEMS.register("sceau_chakra_item_niv1",
            () -> new SceauChakraNiv1Item(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_CHAKRA_NIV2_ITEM = ITEMS.register("sceau_chakra_item_niv2",
            () -> new SceauChakraNiv2Item(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_CHAKRA_NIV3_ITEM = ITEMS.register("sceau_chakra_item_niv3",
            () -> new SceauChakraNiv3Item(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_CHAKRA_NIV4_ITEM = ITEMS.register("sceau_chakra_item_niv4",
            () -> new SceauChakraNiv4Item(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_CHAKRA_NIV5_ITEM = ITEMS.register("sceau_chakra_item_niv5",
            () -> new SceauChakraNiv5Item(new Item.Properties()));

    public static final RegistryObject<Item> SCEAU_SCELLEMENT_NIV0_ITEM = ITEMS.register("sceau_scellement_item_niv0",
            () -> new SceauScellementNiv0Item(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_SCELLEMENT_NIV1_ITEM = ITEMS.register("sceau_scellement_item_niv1",
            () -> new SceauScellementNiv1Item(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_SCELLEMENT_NIV2_ITEM = ITEMS.register("sceau_scellement_item_niv2",
            () -> new SceauScellementNiv2Item(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_SCELLEMENT_NIV3_ITEM = ITEMS.register("sceau_scellement_item_niv3",
            () -> new SceauScellementNiv3Item(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_SCELLEMENT_NIV4_ITEM = ITEMS.register("sceau_scellement_item_niv4",
            () -> new SceauScellementNiv4Item(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_SCELLEMENT_NIV5_ITEM = ITEMS.register("sceau_scellement_item_niv5",
            () -> new SceauScellementNiv5Item(new Item.Properties()));

    public static final RegistryObject<Item> SCEAU_CHAKRA_AUTRUI_NIV0_ITEM = ITEMS.register("sceau_chakra_autrui_item_niv0",
            () -> new SceauChakraAutruiNiv0Item(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_CHAKRA_AUTRUI_NIV1_ITEM = ITEMS.register("sceau_chakra_autrui_item_niv1",
            () -> new SceauChakraAutruiNiv1Item(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_CHAKRA_AUTRUI_NIV2_ITEM = ITEMS.register("sceau_chakra_autrui_item_niv2",
            () -> new SceauChakraAutruiNiv2Item(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_CHAKRA_AUTRUI_NIV3_ITEM = ITEMS.register("sceau_chakra_autrui_item_niv3",
            () -> new SceauChakraAutruiNiv3Item(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_CHAKRA_AUTRUI_NIV4_ITEM = ITEMS.register("sceau_chakra_autrui_item_niv4",
            () -> new SceauChakraAutruiNiv4Item(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_CHAKRA_AUTRUI_NIV5_ITEM = ITEMS.register("sceau_chakra_autrui_item_niv5",
            () -> new SceauChakraAutruiNiv5Item(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
