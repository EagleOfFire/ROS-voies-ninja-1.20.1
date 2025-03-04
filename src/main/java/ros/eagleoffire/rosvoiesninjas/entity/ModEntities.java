package ros.eagleoffire.rosvoiesninjas.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauChakra.*;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauExplosif.*;

public class ModEntities{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ROSVoiesNinjas.MODID);

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

    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
