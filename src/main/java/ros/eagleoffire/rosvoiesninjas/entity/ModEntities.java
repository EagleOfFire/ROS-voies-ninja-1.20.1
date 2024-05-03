package ros.eagleoffire.rosvoiesninjas.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauChakra.*;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauChakraAutrui.*;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauExplosif.*;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauScellement.*;

public class ModEntities{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ROSVoiesNinjas.MODID);

    public static final RegistryObject<EntityType<SceauExplosifNiv0Entity>> SCEAU_EXPLOSIF_NIV0 = ENTITY_TYPES.register("sceau_explosif_niv0", () ->
            EntityType.Builder.<SceauExplosifNiv0Entity>of(SceauExplosifNiv0Entity::new, MobCategory.MISC)
                    .sized(1F, 1F).build("sceau_explosif_niv0"));
    public static final RegistryObject<EntityType<SceauExplosifNiv1Entity>> SCEAU_EXPLOSIF_NIV1 = ENTITY_TYPES.register("sceau_explosif_niv1", () ->
            EntityType.Builder.<SceauExplosifNiv1Entity>of(SceauExplosifNiv1Entity::new, MobCategory.MISC)
                    .sized(1F, 1F).build("sceau_explosif_niv1"));
    public static final RegistryObject<EntityType<SceauExplosifNiv2Entity>> SCEAU_EXPLOSIF_NIV2= ENTITY_TYPES.register("sceau_explosif_niv2", () ->
            EntityType.Builder.<SceauExplosifNiv2Entity>of(SceauExplosifNiv2Entity::new, MobCategory.MISC)
                    .sized(1F, 1F).build("sceau_explosif_niv2"));
    public static final RegistryObject<EntityType<SceauExplosifNiv3Entity>> SCEAU_EXPLOSIF_NIV3 = ENTITY_TYPES.register("sceau_explosif_niv3", () ->
            EntityType.Builder.<SceauExplosifNiv3Entity>of(SceauExplosifNiv3Entity::new, MobCategory.MISC)
                    .sized(1F, 1F).build("sceau_explosif_niv3"));
    public static final RegistryObject<EntityType<SceauExplosifNiv4Entity>> SCEAU_EXPLOSIF_NIV4 = ENTITY_TYPES.register("sceau_explosif_niv4", () ->
            EntityType.Builder.<SceauExplosifNiv4Entity>of(SceauExplosifNiv4Entity::new, MobCategory.MISC)
                    .sized(1F, 1F).build("sceau_explosif_niv4"));
    public static final RegistryObject<EntityType<SceauExplosifNiv5Entity>> SCEAU_EXPLOSIF_NIV5 = ENTITY_TYPES.register("sceau_explosif_niv5", () ->
            EntityType.Builder.<SceauExplosifNiv5Entity>of(SceauExplosifNiv5Entity::new, MobCategory.MISC)
                    .sized(1F, 1F).build("sceau_explosif_niv5"));

    public static final RegistryObject<EntityType<SceauChakraNiv0Entity>> SCEAU_CHAKRA_NIV0 = ENTITY_TYPES.register("sceau_chakra_niv0", () ->
            EntityType.Builder.<SceauChakraNiv0Entity>of(SceauChakraNiv0Entity::new, MobCategory.MISC)
                    .sized(1F, 1F).build("sceau_chakra_niv0"));
    public static final RegistryObject<EntityType<SceauChakraNiv1Entity>> SCEAU_CHAKRA_NIV1 = ENTITY_TYPES.register("sceau_chakra_niv1", () ->
            EntityType.Builder.<SceauChakraNiv1Entity>of(SceauChakraNiv1Entity::new, MobCategory.MISC)
                    .sized(1F, 1F).build("sceau_chakra_niv1"));
    public static final RegistryObject<EntityType<SceauChakraNiv2Entity>> SCEAU_CHAKRA_NIV2 = ENTITY_TYPES.register("sceau_chakra_niv2", () ->
            EntityType.Builder.<SceauChakraNiv2Entity>of(SceauChakraNiv2Entity::new, MobCategory.MISC)
                    .sized(1F, 1F).build("sceau_chakra_niv2"));
    public static final RegistryObject<EntityType<SceauChakraNiv3Entity>> SCEAU_CHAKRA_NIV3 = ENTITY_TYPES.register("sceau_chakra_niv3", () ->
            EntityType.Builder.<SceauChakraNiv3Entity>of(SceauChakraNiv3Entity::new, MobCategory.MISC)
                    .sized(1F, 1F).build("sceau_chakra_niv3"));
    public static final RegistryObject<EntityType<SceauChakraNiv4Entity>> SCEAU_CHAKRA_NIV4 = ENTITY_TYPES.register("sceau_chakra_niv4", () ->
            EntityType.Builder.<SceauChakraNiv4Entity>of(SceauChakraNiv4Entity::new, MobCategory.MISC)
                    .sized(1F, 1F).build("sceau_chakra_niv4"));
    public static final RegistryObject<EntityType<SceauChakraNiv5Entity>> SCEAU_CHAKRA_NIV5 = ENTITY_TYPES.register("sceau_chakra_niv5", () ->
            EntityType.Builder.<SceauChakraNiv5Entity>of(SceauChakraNiv5Entity::new, MobCategory.MISC)
                    .sized(1F, 1F).build("sceau_chakra_niv5"));

    public static final RegistryObject<EntityType<SceauScellementNiv0Entity>> SCEAU_SCELLEMENT_NIV0 = ENTITY_TYPES.register("sceau_scellement_niv0", () ->
        EntityType.Builder.<SceauScellementNiv0Entity>of(SceauScellementNiv0Entity::new, MobCategory.MISC)
                .sized(1F, 1F).build("sceau_scellement_niv0"));
    public static final RegistryObject<EntityType<SceauScellementNiv1Entity>> SCEAU_SCELLEMENT_NIV1 = ENTITY_TYPES.register("sceau_scellement_niv1", () ->
        EntityType.Builder.<SceauScellementNiv1Entity>of(SceauScellementNiv1Entity::new, MobCategory.MISC)
                .sized(1F, 1F).build("sceau_scellement_niv1"));
    public static final RegistryObject<EntityType<SceauScellementNiv2Entity>> SCEAU_SCELLEMENT_NIV2 = ENTITY_TYPES.register("sceau_scellement_niv2", () ->
        EntityType.Builder.<SceauScellementNiv2Entity>of(SceauScellementNiv2Entity::new, MobCategory.MISC)
                .sized(1F, 1F).build("sceau_scellement_niv2"));
    public static final RegistryObject<EntityType<SceauScellementNiv3Entity>> SCEAU_SCELLEMENT_NIV3 = ENTITY_TYPES.register("sceau_scellement_niv3", () ->
        EntityType.Builder.<SceauScellementNiv3Entity>of(SceauScellementNiv3Entity::new, MobCategory.MISC)
                .sized(1F, 1F).build("sceau_scellement_niv3"));
    public static final RegistryObject<EntityType<SceauScellementNiv4Entity>> SCEAU_SCELLEMENT_NIV4 = ENTITY_TYPES.register("sceau_scellement_niv4", () ->
        EntityType.Builder.<SceauScellementNiv4Entity>of(SceauScellementNiv4Entity::new, MobCategory.MISC)
                .sized(1F, 1F).build("sceau_scellement_niv4"));
    public static final RegistryObject<EntityType<SceauScellementNiv5Entity>> SCEAU_SCELLEMENT_NIV5 = ENTITY_TYPES.register("sceau_scellement_niv5", () ->
        EntityType.Builder.<SceauScellementNiv5Entity>of(SceauScellementNiv5Entity::new, MobCategory.MISC)
                .sized(1F, 1F).build("sceau_scellement_niv5"));

    public static final RegistryObject<EntityType<SceauChakraAutruiNiv0Entity>> SCEAU_CHAKRA_AUTRUI_NIV0 = ENTITY_TYPES.register("sceau_chakra_autrui_niv0", () ->
        EntityType.Builder.<SceauChakraAutruiNiv0Entity>of(SceauChakraAutruiNiv0Entity::new, MobCategory.MISC)
                .sized(1F, 1F).build("sceau_chakra_autrui_niv0"));
    public static final RegistryObject<EntityType<SceauChakraAutruiNiv1Entity>> SCEAU_CHAKRA_AUTRUI_NIV1 = ENTITY_TYPES.register("sceau_chakra_autrui_niv1", () ->
        EntityType.Builder.<SceauChakraAutruiNiv1Entity>of(SceauChakraAutruiNiv1Entity::new, MobCategory.MISC)
                .sized(1F, 1F).build("sceau_chakra_autrui_niv1"));
    public static final RegistryObject<EntityType<SceauChakraAutruiNiv2Entity>> SCEAU_CHAKRA_AUTRUI_NIV2 = ENTITY_TYPES.register("sceau_chakra_autrui_niv2", () ->
        EntityType.Builder.<SceauChakraAutruiNiv2Entity>of(SceauChakraAutruiNiv2Entity::new, MobCategory.MISC)
                .sized(1F, 1F).build("sceau_chakra_autrui_niv2"));
    public static final RegistryObject<EntityType<SceauChakraAutruiNiv3Entity>> SCEAU_CHAKRA_AUTRUI_NIV3 = ENTITY_TYPES.register("sceau_chakra_autrui_niv3", () ->
        EntityType.Builder.<SceauChakraAutruiNiv3Entity>of(SceauChakraAutruiNiv3Entity::new, MobCategory.MISC)
                .sized(1F, 1F).build("sceau_chakra_autrui_niv3"));
    public static final RegistryObject<EntityType<SceauChakraAutruiNiv4Entity>> SCEAU_CHAKRA_AUTRUI_NIV4 = ENTITY_TYPES.register("sceau_chakra_autrui_niv4", () ->
        EntityType.Builder.<SceauChakraAutruiNiv4Entity>of(SceauChakraAutruiNiv4Entity::new, MobCategory.MISC)
                .sized(1F, 1F).build("sceau_chakra_autrui_niv4"));
    public static final RegistryObject<EntityType<SceauChakraAutruiNiv5Entity>> SCEAU_CHAKRA_AUTRUI_NIV5 = ENTITY_TYPES.register("sceau_chakra_autrui_niv5", () ->
        EntityType.Builder.<SceauChakraAutruiNiv5Entity>of(SceauChakraAutruiNiv5Entity::new, MobCategory.MISC)
                .sized(1F, 1F).build("sceau_chakra_autrui_niv5"));


    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
