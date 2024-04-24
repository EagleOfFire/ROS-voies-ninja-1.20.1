//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package ros.eagleoffire.rosvoiesninjas.entity.decoration;

import com.mojang.logging.LogUtils;

import java.util.OptionalInt;
import javax.annotation.Nullable;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.tags.DamageTypeTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MoverType;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.SlotAccess;
import net.minecraft.world.entity.decoration.HangingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.MapItem;
import net.minecraft.world.level.GameRules;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.DiodeBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.apache.commons.lang3.Validate;
import org.slf4j.Logger;
import ros.eagleoffire.rosvoiesninjas.Items.ModItems;
import ros.eagleoffire.rosvoiesninjas.entity.custom.ModEntities;

public class SceauScellementEntity extends HangingEntity {
    private static final Logger LOGGER = LogUtils.getLogger();
    private static final EntityDataAccessor<ItemStack> DATA_ITEM;
    private static final EntityDataAccessor<Integer> DATA_ROTATION;
    public static final int NUM_ROTATIONS = 8;
    private float dropChance;
    private boolean fixed;

    public SceauScellementEntity(EntityType<? extends SceauScellementEntity> pEntityType, Level pLevel) {
        super(pEntityType, pLevel);
        this.dropChance = 1.0F;
        this.direction = Direction.DOWN;
        if (Direction.DOWN.getAxis().isHorizontal()) {
            this.setXRot(0.0F);
            this.setYRot((float) (this.direction.get2DDataValue() * 90));
        } else {
            this.setXRot((float) (-90 * Direction.DOWN.getAxisDirection().getStep()));
            this.setYRot(0.0F);
        }
        this.xRotO = this.getXRot();
        this.yRotO = this.getYRot();
        this.recalculateBoundingBox();
    }

    public SceauScellementEntity(Level pLevel, BlockPos pPos, Direction pFacingDirection) {
        this(ModEntities.SCEAU_SCELLEMENT.get(), pLevel, pPos, pFacingDirection);
    }

    public SceauScellementEntity(EntityType<? extends SceauScellementEntity> pEntityType, Level pLevel, BlockPos pPos, Direction pDirection) {
        super(pEntityType, pLevel, pPos);
        this.dropChance = 1.0F;
        this.direction = pDirection;
        if (pDirection.getAxis().isHorizontal()) {
            this.setXRot(0.0F);
            this.setYRot((float) (this.direction.get2DDataValue() * 90));
        } else {
            this.setXRot((float) (-90 * pDirection.getAxisDirection().getStep()));
            this.setYRot(0.0F);
        }
        this.xRotO = this.getXRot();
        this.yRotO = this.getYRot();
        this.recalculateBoundingBox();
    }

    protected float getEyeHeight(Pose pPose, EntityDimensions pSize) {
        return 0.0F;
    }

    protected void defineSynchedData() {
        this.getEntityData().define(DATA_ITEM, ItemStack.EMPTY);
        this.getEntityData().define(DATA_ROTATION, 0);
    }

    @Override
    public void setDirection(Direction pFacingDirection) {
        Validate.notNull(pFacingDirection);
        this.direction = pFacingDirection;
        System.out.println("direction : " + direction);
        if (pFacingDirection.getAxis().isHorizontal()) {
            this.setXRot(0.0F);
            this.setYRot((float) (this.direction.get2DDataValue() * 90));
        } else {
            this.setXRot((float) (-90 * pFacingDirection.getAxisDirection().getStep()));
            this.setYRot(0.0F);
        }

        this.xRotO = this.getXRot();
        this.yRotO = this.getYRot();
        this.recalculateBoundingBox();
    }

    protected void recalculateBoundingBox() {
        this.direction = Direction.UP;
        double $$0 = 0.46875;
        double $$1 = (double) this.pos.getX() + 0.5 - (double) this.direction.getStepX() * 0.46875;
        double $$2 = (double) this.pos.getY() + 0.5 - (double) this.direction.getStepY() * 0.46875;
        double $$3 = (double) this.pos.getZ() + 0.5 - (double) this.direction.getStepZ() * 0.46875;
        this.setPosRaw($$1, $$2, $$3);
        double $$4 = (double) this.getWidth();
        double $$5 = (double) this.getHeight();
        double $$6 = (double) this.getWidth();
        Direction.Axis $$7 = this.direction.getAxis();
        switch ($$7) {
            case X -> $$4 = 1.0;
            case Y -> $$5 = 1.0;
            case Z -> $$6 = 1.0;
        }

        $$4 /= 32.0;
        $$5 /= 32.0;
        $$6 /= 32.0;
        this.setBoundingBox(new AABB($$1 - $$4, $$2 - $$5, $$3 - $$6, $$1 + $$4, $$2 + $$5, $$3 + $$6));
    }

    public boolean survives() {
        if (this.fixed) {
            return true;
        } else if (!this.level().noCollision(this)) {
            return false;
        } else {
            BlockState $$0 = this.level().getBlockState(this.pos.relative(this.direction.getOpposite()));
            return $$0.isSolid() || this.direction.getAxis().isHorizontal() && DiodeBlock.isDiode($$0) ? this.level().getEntities(this, this.getBoundingBox(), HANGING_ENTITY).isEmpty() : false;
        }
    }

    public void move(MoverType pType, Vec3 pPos) {
        if (!this.fixed) {
            super.move(pType, pPos);
        }

    }

    public void push(double pX, double pY, double pZ) {
        if (!this.fixed) {
            super.push(pX, pY, pZ);
        }

    }

    public float getPickRadius() {
        return 0.0F;
    }

    public void kill() {
        this.removeFramedMap(this.getItem());
        super.kill();
    }

    public boolean hurt(DamageSource pSource, float pAmount) {
        if (this.fixed) {
            return !pSource.is(DamageTypeTags.BYPASSES_INVULNERABILITY) && !pSource.isCreativePlayer() ? false : super.hurt(pSource, pAmount);
        } else if (this.isInvulnerableTo(pSource)) {
            return false;
        } else if (!pSource.is(DamageTypeTags.IS_EXPLOSION) && !this.getItem().isEmpty()) {
            if (!this.level().isClientSide) {
                this.dropItem(pSource.getEntity(), false);
                this.gameEvent(GameEvent.BLOCK_CHANGE, pSource.getEntity());
                this.playSound(this.getRemoveItemSound(), 1.0F, 1.0F);
            }

            return true;
        } else {
            return super.hurt(pSource, pAmount);
        }
    }

    public SoundEvent getRemoveItemSound() {
        return SoundEvents.ITEM_FRAME_REMOVE_ITEM;
    }

    public int getWidth() {
        return 12;
    }

    public int getHeight() {
        return 12;
    }

    public boolean shouldRenderAtSqrDistance(double pDistance) {
        double $$1 = 16.0;
        $$1 *= 64.0 * getViewScale();
        return pDistance < $$1 * $$1;
    }

    public void dropItem(@Nullable Entity pBrokenEntity) {
        this.playSound(this.getBreakSound(), 1.0F, 1.0F);
        this.dropItem(pBrokenEntity, true);
        this.gameEvent(GameEvent.BLOCK_CHANGE, pBrokenEntity);
    }

    public SoundEvent getBreakSound() {
        return SoundEvents.ITEM_FRAME_BREAK;
    }

    public void playPlacementSound() {
        this.playSound(this.getPlaceSound(), 1.0F, 1.0F);
    }

    public SoundEvent getPlaceSound() {
        return SoundEvents.ITEM_FRAME_PLACE;
    }

    private void dropItem(@Nullable Entity pEntity, boolean pDropSelf) {
        if (!this.fixed) {
            ItemStack $$2 = this.getItem();
            this.setItem(ItemStack.EMPTY);
            if (!this.level().getGameRules().getBoolean(GameRules.RULE_DOENTITYDROPS)) {
                if (pEntity == null) {
                    this.removeFramedMap($$2);
                }

            } else {
                if (pEntity instanceof Player) {
                    Player $$3 = (Player) pEntity;
                    if ($$3.getAbilities().instabuild) {
                        this.removeFramedMap($$2);
                        return;
                    }
                }

                if (pDropSelf) {
                    this.spawnAtLocation(this.getFrameItemStack());
                }

                if (!$$2.isEmpty()) {
                    $$2 = $$2.copy();
                    this.removeFramedMap($$2);
                    if (this.random.nextFloat() < this.dropChance) {
                        this.spawnAtLocation($$2);
                    }
                }

            }
        }
    }

    private void removeFramedMap(ItemStack pStack) {
        this.getFramedMapId().ifPresent((p_289456_) -> {
            MapItemSavedData $$1 = MapItem.getSavedData(p_289456_, this.level());
            if ($$1 != null) {
                $$1.removedFromFrame(this.pos, this.getId());
                $$1.setDirty(true);
            }

        });
        pStack.setEntityRepresentation((Entity) null);
    }

    public ItemStack getItem() {
        return (ItemStack) this.getEntityData().get(DATA_ITEM);
    }

    public OptionalInt getFramedMapId() {
        ItemStack $$0 = this.getItem();
        if ($$0.is(Items.FILLED_MAP)) {
            Integer $$1 = MapItem.getMapId($$0);
            if ($$1 != null) {
                return OptionalInt.of($$1);
            }
        }

        return OptionalInt.empty();
    }

    public boolean hasFramedMap() {
        return this.getFramedMapId().isPresent();
    }

    public void setItem(ItemStack pStack) {
        this.setItem(pStack, true);
    }

    public void setItem(ItemStack pStack, boolean pUpdateNeighbours) {
        if (!pStack.isEmpty()) {
            pStack = pStack.copyWithCount(1);
        }

        this.onItemChanged(pStack);
        this.getEntityData().set(DATA_ITEM, pStack);
        if (!pStack.isEmpty()) {
            this.playSound(this.getAddItemSound(), 1.0F, 1.0F);
        }

        if (pUpdateNeighbours && this.pos != null) {
            this.level().updateNeighbourForOutputSignal(this.pos, Blocks.AIR);
        }

    }

    public SoundEvent getAddItemSound() {
        return SoundEvents.ITEM_FRAME_ADD_ITEM;
    }

    public SlotAccess getSlot(int pSlot) {
        return pSlot == 0 ? new SlotAccess() {
            public ItemStack get() {
                return SceauScellementEntity.this.getItem();
            }

            public boolean set(ItemStack p_149635_) {
                SceauScellementEntity.this.setItem(p_149635_);
                return true;
            }
        } : super.getSlot(pSlot);
    }

    public void onSyncedDataUpdated(EntityDataAccessor<?> pKey) {
        if (pKey.equals(DATA_ITEM)) {
            this.onItemChanged(this.getItem());
        }

    }

    private void onItemChanged(ItemStack pItem) {
        if (!pItem.isEmpty()) {
            pItem.setEntityRepresentation(this);
        }

        this.recalculateBoundingBox();
    }

    public int getRotation() {
        return (Integer) this.getEntityData().get(DATA_ROTATION);
    }

    public void setRotation(int pRotation) {
        this.setRotation(pRotation, true);
    }

    private void setRotation(int pRotation, boolean pUpdateNeighbours) {
        this.getEntityData().set(DATA_ROTATION, pRotation % 8);
        if (pUpdateNeighbours && this.pos != null) {
            this.level().updateNeighbourForOutputSignal(this.pos, Blocks.AIR);
        }

    }

    public void addAdditionalSaveData(CompoundTag pCompound) {
        super.addAdditionalSaveData(pCompound);
        if (!this.getItem().isEmpty()) {
            pCompound.put("Item", this.getItem().save(new CompoundTag()));
            pCompound.putByte("ItemRotation", (byte) this.getRotation());
            pCompound.putFloat("ItemDropChance", this.dropChance);
        }

        pCompound.putByte("Facing", (byte) this.direction.get3DDataValue());
        pCompound.putBoolean("Invisible", this.isInvisible());
        pCompound.putBoolean("Fixed", this.fixed);
    }

    public void readAdditionalSaveData(CompoundTag pCompound) {
        super.readAdditionalSaveData(pCompound);
        CompoundTag $$1 = pCompound.getCompound("Item");
        if ($$1 != null && !$$1.isEmpty()) {
            ItemStack $$2 = ItemStack.of($$1);
            if ($$2.isEmpty()) {
                LOGGER.warn("Unable to load item from: {}", $$1);
            }

            ItemStack $$3 = this.getItem();
            if (!$$3.isEmpty() && !ItemStack.matches($$2, $$3)) {
                this.removeFramedMap($$3);
            }

            this.setItem($$2, false);
            this.setRotation(pCompound.getByte("ItemRotation"), false);
            if (pCompound.contains("ItemDropChance", 99)) {
                this.dropChance = pCompound.getFloat("ItemDropChance");
            }
        }

        this.setDirection(Direction.from3DDataValue(pCompound.getByte("Facing")));
        this.setInvisible(pCompound.getBoolean("Invisible"));
        this.fixed = pCompound.getBoolean("Fixed");
    }

    public InteractionResult interact(Player pPlayer, InteractionHand pHand) {
        ItemStack $$2 = pPlayer.getItemInHand(pHand);
        boolean $$3 = !this.getItem().isEmpty();
        boolean $$4 = !$$2.isEmpty();
        if (this.fixed) {
            return InteractionResult.PASS;
        } else if (!this.level().isClientSide) {
            if (!$$3) {
                if ($$4 && !this.isRemoved()) {
                    if ($$2.is(Items.FILLED_MAP)) {
                        MapItemSavedData $$5 = MapItem.getSavedData($$2, this.level());
                        if ($$5 != null && $$5.isTrackedCountOverLimit(256)) {
                            return InteractionResult.FAIL;
                        }
                    }

                    this.setItem($$2);
                    this.gameEvent(GameEvent.BLOCK_CHANGE, pPlayer);
                    if (!pPlayer.getAbilities().instabuild) {
                        $$2.shrink(1);
                    }
                }
            } else {
                this.playSound(this.getRotateItemSound(), 1.0F, 1.0F);
                this.setRotation(this.getRotation() + 1);
                this.gameEvent(GameEvent.BLOCK_CHANGE, pPlayer);
            }

            return InteractionResult.CONSUME;
        } else {
            return !$$3 && !$$4 ? InteractionResult.PASS : InteractionResult.SUCCESS;
        }
    }

    public SoundEvent getRotateItemSound() {
        return SoundEvents.ITEM_FRAME_ROTATE_ITEM;
    }

    public int getAnalogOutput() {
        return this.getItem().isEmpty() ? 0 : this.getRotation() % 8 + 1;
    }

    public Packet<ClientGamePacketListener> getAddEntityPacket() {
        return new ClientboundAddEntityPacket(this, this.direction.get3DDataValue(), this.getPos());
    }

    public void recreateFromPacket(ClientboundAddEntityPacket pPacket) {
        super.recreateFromPacket(pPacket);
        this.setDirection(Direction.from3DDataValue(pPacket.getData()));
    }

    public ItemStack getPickResult() {
        ItemStack $$0 = this.getItem();
        return $$0.isEmpty() ? this.getFrameItemStack() : $$0.copy();
    }

    protected ItemStack getFrameItemStack() {
        return new ItemStack(ModItems.SCEAU_SCELLEMENT_ITEM.get());
    }

    public float getVisualRotationYInDegrees() {
        Direction $$0 = this.getDirection();
        int $$1 = $$0.getAxis().isVertical() ? 90 * $$0.getAxisDirection().getStep() : 0;
        return (float) Mth.wrapDegrees(180 + $$0.get2DDataValue() * 90 + this.getRotation() * 45 + $$1);
    }

    static {
        DATA_ITEM = SynchedEntityData.defineId(SceauScellementEntity.class, EntityDataSerializers.ITEM_STACK);
        DATA_ROTATION = SynchedEntityData.defineId(SceauScellementEntity.class, EntityDataSerializers.INT);
    }
}
