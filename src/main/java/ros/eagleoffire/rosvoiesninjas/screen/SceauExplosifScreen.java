package ros.eagleoffire.rosvoiesninjas.screen;

import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.arguments.item.ItemInput;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraftforge.items.ItemHandlerHelper;
import org.jetbrains.annotations.NotNull;
import ros.eagleoffire.rosvoiesninjas.Items.ModItems;
import ros.eagleoffire.rosvoiesninjas.ProgressionVoiesNinjas.ProgressionVoiesNinjasProvider;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;
import ros.eagleoffire.rosvoiesninjas.client.ProgressionVoiesNinjasData.ClientFuinjutsuData;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauExplosif.SceauExplosifNiv0Entity;
import ros.eagleoffire.rosvoiesninjas.networking.ModMessages;
import ros.eagleoffire.rosvoiesninjas.networking.packet.GiveSceauC2SPacket;

import java.util.Collection;
import java.util.Iterator;

public class SceauExplosifScreen extends Screen {
    private static final Component TITLE =
            Component.translatable("gui." + ROSVoiesNinjas.MODID + ".example_block_screen");


    private static final ResourceLocation TEXTURE_NIV1 =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/explosion/screen_choix_niveau_sceau_explosif_niv1.png");
    private static final ResourceLocation TEXTURE_NIV2 =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/explosion/screen_choix_niveau_sceau_explosif_niv2.png");
    private static final ResourceLocation TEXTURE_NIV3 =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/explosion/screen_choix_niveau_sceau_explosif_niv3.png");
    private static final ResourceLocation TEXTURE_NIV4 =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/explosion/screen_choix_niveau_sceau_explosif_niv4.png");
    private static final ResourceLocation TEXTURE_NIV5 =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/explosion/screen_choix_niveau_sceau_explosif_niv5.png");
    private static final ResourceLocation SELECT_NIV1 =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/menuaddition/1_selected.png");
    private static final ResourceLocation SELECT_NIV2 =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/menuaddition/2_selected.png");
    private static final ResourceLocation SELECT_NIV3 =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/menuaddition/3_selected.png");
    private static final ResourceLocation SELECT_NIV4 =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/menuaddition/4_selected.png");
    private static final ResourceLocation SELECT_NIV5 =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/menuaddition/5_selected.png");


    private final int imageWidth, imageHeight;
    private final Player player;
    private final SceauExplosifNiv0Entity SE0E;

    private int leftPos, topPos;

    private Button button;

    public SceauExplosifScreen(Player player, SceauExplosifNiv0Entity SceauEntity) {
        super(TITLE);

        this.SE0E = SceauEntity;
        this.player = player;
        this.imageWidth = 1920;
        this.imageHeight = 1920;
    }

    @Override
    protected void init() {
        super.init();

        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;
        this.width = this.minecraft.getWindow().getGuiScaledWidth();
        this.height = this.minecraft.getWindow().getGuiScaledHeight();

        if(this.minecraft == null) return;
        Level level = this.minecraft.level;
        if(level == null) return;
    }

    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        int posCursor = getSectorID(mouseX,mouseY,this.width,this.height);
        if (ClientFuinjutsuData.get_LVL() == 1) {
            graphics.blit(TEXTURE_NIV1, 0, 0, 0, 0, this.imageWidth, this.imageHeight,this.width, this.height);
            if (posCursor == 2) {
                graphics.blit(SELECT_NIV1, (int)(1.9*this.width)/3, ((this.height)/3)+2, 0, 0, this.imageWidth, this.imageHeight, this.width/7, this.height/4);
            }
        } else if (ClientFuinjutsuData.get_LVL() == 2) {
            graphics.blit(TEXTURE_NIV2, 0, 0, 0, 0, this.imageWidth, this.imageHeight,this.width, this.height);
            switch(posCursor) {
                case 2:
                    graphics.blit(SELECT_NIV1, (int)(1.9*this.width)/3, ((this.height)/3)+2, 0, 0, this.imageWidth, this.imageHeight,this.width/7, this.height/4);
                    break;
                case 3:
                    graphics.blit(SELECT_NIV2, (int)(1.67*this.width)/3, (int)(1.97*(this.height)/3), 0, 0, this.imageWidth, this.imageHeight,this.width/7, this.height/4);
                    break;
            }
        } else if (ClientFuinjutsuData.get_LVL() == 3) {
            graphics.blit(TEXTURE_NIV3, 0, 0, 0, 0, this.imageWidth, this.imageHeight,this.width, this.height);
            switch(posCursor) {
                case 2:
                    graphics.blit(SELECT_NIV1, (int)(1.9*this.width)/3, ((this.height)/3)+2, 0, 0, this.imageWidth, this.imageHeight,this.width, this.height);
                    break;
                case 3:
                    graphics.blit(SELECT_NIV2, (int)(1.67*this.width)/3, (int)(1.97*(this.height)/3), 0, 0, this.imageWidth, this.imageHeight,this.width, this.height);
                    break;
                case 4:
                    graphics.blit(SELECT_NIV3, (int)(0.885*this.width)/3, (int)(1.97*(this.height)/3), 0, 0, this.imageWidth, this.imageHeight,this.width, this.height);
                    break;
            }
        } else if (ClientFuinjutsuData.get_LVL() == 4) {
            graphics.blit(TEXTURE_NIV4, 0, 0, 0, 0, this.imageWidth, this.imageHeight,this.width, this.height);
            switch(posCursor) {
                case 2:
                    graphics.blit(SELECT_NIV1, (int)(1.9*this.width)/3, ((this.height)/3)+2, 0, 0, this.imageWidth, this.imageHeight,this.width/7, this.height/4);
                    break;
                case 3:
                    graphics.blit(SELECT_NIV2, (int)(1.67*this.width)/3, (int)(1.97*(this.height)/3), 0, 0, this.imageWidth, this.imageHeight,this.width/7, this.height/4);
                    break;
                case 4:
                    graphics.blit(SELECT_NIV3, (int)(0.885*this.width)/3, (int)(1.97*(this.height)/3), 0, 0, this.imageWidth, this.imageHeight,this.width/7, this.height/4);
                    break;
                case 5:
                    graphics.blit(SELECT_NIV4, 0, 0, 0, 0, this.imageWidth, this.imageHeight,this.width/7, this.height/4);
                    break;
            }
        } else if (ClientFuinjutsuData.get_LVL() == 5) {
            graphics.blit(TEXTURE_NIV5, 0, 0, 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
            switch(posCursor) {
                case 1:
                    graphics.blit(SELECT_NIV5, 0, 0, 0, 0, this.imageWidth, this.imageHeight,this.width/7, this.height/4);
                    break;
                case 2:
                    graphics.blit(SELECT_NIV1, (int)(1.9*this.width)/3, ((this.height)/3)+2, 0, 0, this.imageWidth, this.imageHeight,this.width/7, this.height/4);
                    break;
                case 3:
                    graphics.blit(SELECT_NIV2, (int)(1.67*this.width)/3, (int)(1.97*(this.height)/3), 0, 0, this.imageWidth, this.imageHeight,this.width/7, this.height/4);
                    break;
                case 4:
                    graphics.blit(SELECT_NIV3, (int)(0.885*this.width)/3, (int)(1.97*(this.height)/3), 0, 0, this.imageWidth, this.imageHeight,this.width/7, this.height/4);
                    break;
                case 5:
                    graphics.blit(SELECT_NIV4, 0, 0, 0, 0, this.imageWidth, this.imageHeight,this.width/7, this.height/4);
                    break;
            }
        }
        super.render(graphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int pButton) {
        int posCursor = getSectorID(mouseX,mouseY,this.width,this.height);
        if(posCursor==1 && (ClientFuinjutsuData.get_LVL()==5)) {
            this.player.getInventory().add(new ItemStack(ModItems.SCEAU_EXPLOSIF_NIV5_ITEM.get(), 1));
            this.SE0E.kill();
        } else if (posCursor==2 && (ClientFuinjutsuData.get_LVL()>=1)) {
            this.player.getInventory().add(new ItemStack(ModItems.SCEAU_EXPLOSIF_NIV1_ITEM.get(), 1));
            this.SE0E.kill();
        } else if (posCursor==3 && (ClientFuinjutsuData.get_LVL()>=2)) {
            ModMessages.sendToServer(new GiveSceauC2SPacket("Explosif", 2));
            this.SE0E.kill();
        } else if (posCursor==4 && (ClientFuinjutsuData.get_LVL()>=3)) {
            this.player.getInventory().add(new ItemStack(ModItems.SCEAU_EXPLOSIF_NIV3_ITEM.get(), 1));
            this.SE0E.kill();
        } else if (posCursor==5 && ClientFuinjutsuData.get_LVL()>=4) {
            this.player.getInventory().add(new ItemStack(ModItems.SCEAU_EXPLOSIF_NIV4_ITEM.get(), 1));
            this.SE0E.kill();
        } else{
            this.player.sendSystemMessage(Component.literal(String.format("You do not have the required level to create this seal")));
        }
        Minecraft.getInstance().setScreen(null);
        return super.mouseClicked(mouseX, mouseY, pButton);
    }

    public static int getSectorID(double mouseX, double mouseY, int width, int height) {
        mouseX -= (double)width/2;
        mouseY -= (double)height/2;
        double angle = Math.atan2(mouseY, mouseX);
        angle += Math.PI;
        if((Math.PI/4)<angle && angle<(3*Math.PI/4)){
            return 1;
        } else if ((3*Math.PI/4)<angle && angle<(7*Math.PI/6)) {
            return 2;
        } else if ((7*Math.PI/6)<angle && angle<(3*Math.PI/2)) {
            return 3;
        } else if ((3*Math.PI/2)<angle && angle<(11*Math.PI/6)) {
            return 4;
        } else {
            return 5;
        }
    }

    private static int giveItem(ItemInput pItem, Collection<ServerPlayer> pTargets, int pCount) throws CommandSyntaxException {
        int $$4 = pItem.getItem().getMaxStackSize();
        int $$5 = $$4 * 100;
        ItemStack $$6 = pItem.createItemStack(pCount, false);
        if (pCount > $$5) {
            return 0;
        } else {
            Iterator var7 = pTargets.iterator();

            label44:
            while(var7.hasNext()) {
                ServerPlayer $$7 = (ServerPlayer)var7.next();
                int $$8 = pCount;

                while(true) {
                    while(true) {
                        if ($$8 <= 0) {
                            continue label44;
                        }

                        int $$9 = Math.min($$4, $$8);
                        $$8 -= $$9;
                        ItemStack $$10 = pItem.createItemStack($$9, false);
                        boolean $$11 = $$7.getInventory().add($$10);
                        ItemEntity $$12;
                        if ($$11 && $$10.isEmpty()) {
                            $$10.setCount(1);
                            $$12 = $$7.drop($$10, false);
                            if ($$12 != null) {
                                $$12.makeFakeItem();
                            }

                            $$7.level().playSound((Player)null, $$7.getX(), $$7.getY(), $$7.getZ(), SoundEvents.ITEM_PICKUP, SoundSource.PLAYERS, 0.2F, (($$7.getRandom().nextFloat() - $$7.getRandom().nextFloat()) * 0.7F + 1.0F) * 2.0F);
                            $$7.containerMenu.broadcastChanges();
                        } else {
                            $$12 = $$7.drop($$10, false);
                            if ($$12 != null) {
                                $$12.setNoPickUpDelay();
                                $$12.setTarget($$7.getUUID());
                            }
                        }
                    }
                }
            }
            return pTargets.size();
        }
    }
}