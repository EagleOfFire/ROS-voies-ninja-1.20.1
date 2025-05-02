package ros.eagleoffire.rosvoiesninjas.items;

import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;
import ros.eagleoffire.rosvoiesninjas.items.SceauChakra.*;
import ros.eagleoffire.rosvoiesninjas.items.SceauExplosif.*;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;
import ros.eagleoffire.rosvoiesninjas.items.SceauFumigene.SceauFumigeneRankDItem;

public class ModItems {
    public static final DeferredRegister<Item> ITEMS =
            DeferredRegister.create(ForgeRegistries.ITEMS, ROSVoiesNinjas.MODID);

    public static final RegistryObject<Item> SCEAU_EXPLOSIF_RANK_D_ITEM = ITEMS.register("sceau_explosif_item_rank_d",
            () -> new SceauExplosifRankDItem(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_EXPLOSIF_RANK_C_ITEM = ITEMS.register("sceau_explosif_item_rank_c",
            () -> new SceauExplosifRankCItem(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_EXPLOSIF_RANK_B_ITEM = ITEMS.register("sceau_explosif_item_rank_b",
            () -> new SceauExplosifRankBItem(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_EXPLOSIF_RANK_A_ITEM = ITEMS.register("sceau_explosif_item_rank_a",
            () -> new SceauExplosifRankAItem(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_EXPLOSIF_RANK_S_ITEM = ITEMS.register("sceau_explosif_item_rank_s",
            () -> new SceauExplosifRankSItem(new Item.Properties()));

    public static final RegistryObject<Item> SCEAU_CHAKRA_RANK_D_ITEM = ITEMS.register("sceau_chakra_item_rank_d",
            () -> new SceauChakraRankDItem(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_CHAKRA_RANK_C_ITEM = ITEMS.register("sceau_chakra_item_rank_c",
            () -> new SceauChakraRankCItem(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_CHAKRA_RANK_B_ITEM = ITEMS.register("sceau_chakra_item_rank_b",
            () -> new SceauChakraRankBItem(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_CHAKRA_RANK_A_ITEM = ITEMS.register("sceau_chakra_item_rank_a",
            () -> new SceauChakraRankAItem(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_CHAKRA_RANK_S_ITEM = ITEMS.register("sceau_chakra_item_rank_s",
            () -> new SceauChakraRankSItem(new Item.Properties()));

    public static final RegistryObject<Item> SCEAU_FUMIGENE_RANK_D_ITEM = ITEMS.register("sceau_fumigene_item_rank_d",
            () -> new SceauFumigeneRankDItem(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_FUMIGENE_RANK_C_ITEM = ITEMS.register("sceau_fumigene_item_rank_c",
            () -> new SceauChakraRankCItem(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_FUMIGENE_RANK_B_ITEM = ITEMS.register("sceau_fumigene_item_rank_b",
            () -> new SceauChakraRankBItem(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_FUMIGENE_RANK_A_ITEM = ITEMS.register("sceau_fumigene_item_rank_a",
            () -> new SceauChakraRankAItem(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_FUMIGENE_RANK_S_ITEM = ITEMS.register("sceau_fumigene_item_rank_s",
            () -> new SceauChakraRankSItem(new Item.Properties()));

    public static final RegistryObject<Item> SCEAU_MINE_CHAKRA_RANK_D_ITEM = ITEMS.register("sceau_mine_chakra_item_rank_d",
            () -> new SceauChakraRankDItem(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_MINE_CHAKRA_RANK_C_ITEM = ITEMS.register("sceau_mine_chakra_item_rank_c",
            () -> new SceauChakraRankCItem(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_MINE_CHAKRA_RANK_B_ITEM = ITEMS.register("sceau_mine_chakra_item_rank_b",
            () -> new SceauChakraRankBItem(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_MINE_CHAKRA_RANK_A_ITEM = ITEMS.register("sceau_mine_chakra_item_rank_a",
            () -> new SceauChakraRankAItem(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_MINE_CHAKRA_RANK_S_ITEM = ITEMS.register("sceau_mine_chakra_item_rank_s",
            () -> new SceauChakraRankSItem(new Item.Properties()));

    public static final RegistryObject<Item> SCEAU_BARRIERE_RANK_D_ITEM = ITEMS.register("sceau_barriere_item_rank_d",
            () -> new SceauChakraRankDItem(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_BARRIERE_RANK_C_ITEM = ITEMS.register("sceau_barriere_item_rank_c",
            () -> new SceauChakraRankCItem(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_BARRIERE_RANK_B_ITEM = ITEMS.register("sceau_barriere_item_rank_b",
            () -> new SceauChakraRankBItem(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_BARRIERE_RANK_A_ITEM = ITEMS.register("sceau_barriere_item_rank_a",
            () -> new SceauChakraRankAItem(new Item.Properties()));
    public static final RegistryObject<Item> SCEAU_BARRIERE_RANK_S_ITEM = ITEMS.register("sceau_barriere_item_rank_s",
            () -> new SceauChakraRankSItem(new Item.Properties()));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }

}
