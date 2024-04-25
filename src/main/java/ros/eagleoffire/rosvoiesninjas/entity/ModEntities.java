package ros.eagleoffire.rosvoiesninjas.entity;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.RegistryObject;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauExplosifEntity;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauChakraEntity;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauScellementEntity;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauChakraAutruiEntity;

public class ModEntities{
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(ForgeRegistries.ENTITY_TYPES, ROSVoiesNinjas.MODID);

    public static final RegistryObject<EntityType<SceauExplosifEntity>> SCEAU_EXPLOSIF = ENTITY_TYPES.register("sceau_explosif", () ->
            EntityType.Builder.<SceauExplosifEntity>of(SceauExplosifEntity::new, MobCategory.MISC)
                    .sized(1F, 1F).build("sceau_explosif"));

    public static final RegistryObject<EntityType<SceauChakraEntity>> SCEAU_CHAKRA = ENTITY_TYPES.register("sceau_chakra", () ->
            EntityType.Builder.<SceauChakraEntity>of(SceauChakraEntity::new, MobCategory.MISC)
                    .sized(1F, 1F).build("sceau_chakra"));

    public static final RegistryObject<EntityType<SceauScellementEntity>> SCEAU_SCELLEMENT = ENTITY_TYPES.register("sceau_scellement", () ->
        EntityType.Builder.<SceauScellementEntity>of(SceauScellementEntity::new, MobCategory.MISC)
                .sized(1F, 1F).build("sceau_scellement"));

    public static final RegistryObject<EntityType<SceauChakraAutruiEntity>> SCEAU_CHAKRA_AUTRUI = ENTITY_TYPES.register("sceau_chakra_autrui", () ->
        EntityType.Builder.<SceauChakraAutruiEntity>of(SceauChakraAutruiEntity::new, MobCategory.MISC)
                .sized(1F, 1F).build("sceau_chakra_autrui"));


    public static void register(IEventBus eventBus){
        ENTITY_TYPES.register(eventBus);
    }
}
