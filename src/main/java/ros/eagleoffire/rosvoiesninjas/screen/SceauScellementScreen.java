package ros.eagleoffire.rosvoiesninjas.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;
import ros.eagleoffire.rosvoiesninjas.client.ProgressionVoiesNinjasData.ClientFuinjutsuData;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauScellement.SceauScellementNiv0Entity;
import ros.eagleoffire.rosvoiesninjas.networking.ModMessages;
import ros.eagleoffire.rosvoiesninjas.networking.packet.GiveSceauC2SPacket;

public class SceauScellementScreen extends Screen {
    private static final Component TITLE =
            Component.translatable("gui." + ROSVoiesNinjas.MODID + ".example_block_screen");


    private static final ResourceLocation TEXTURE_NIV1 =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/verrouillage/screen_choix_niveau_sceau_scellement_niv1.png");
    private static final ResourceLocation TEXTURE_NIV2 =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/verrouillage/screen_choix_niveau_sceau_scellement_niv2.png");
    private static final ResourceLocation TEXTURE_NIV3 =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/verrouillage/screen_choix_niveau_sceau_scellement_niv3.png");
    private static final ResourceLocation TEXTURE_NIV4 =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/verrouillage/screen_choix_niveau_sceau_scellement_niv4.png");
    private static final ResourceLocation TEXTURE_NIV5 =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/verrouillage/screen_choix_niveau_sceau_scellement_niv5.png");
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
    private final SceauScellementNiv0Entity SE0E;

    private int leftPos, topPos;

    private Button button;

    public SceauScellementScreen(Player player, SceauScellementNiv0Entity SceauEntity) {
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
                graphics.blit(SELECT_NIV1, (int)(1.9*this.width)/3, ((this.height)/3)+2, 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
            }
        } else if (ClientFuinjutsuData.get_LVL() == 2) {
            graphics.blit(TEXTURE_NIV2, 0, 0, 0, 0, this.imageWidth, this.imageHeight,this.width, this.height);
            switch(posCursor) {
                case 2:
                    graphics.blit(SELECT_NIV1, (int)(1.9*this.width)/3, ((this.height)/3)+2, 0, 0, this.imageWidth, this.imageHeight,this.width, this.height);
                    break;
                case 3:
                    graphics.blit(SELECT_NIV2, (int)(1.67*this.width)/3, (int)(1.97*(this.height)/3), 0, 0, this.imageWidth, this.imageHeight,this.width, this.height);
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
                    graphics.blit(SELECT_NIV1, (int)(1.9*this.width)/3, ((this.height)/3)+2, 0, 0, this.imageWidth, this.imageHeight,this.width, this.height);
                    break;
                case 3:
                    graphics.blit(SELECT_NIV2, (int)(1.67*this.width)/3, (int)(1.97*(this.height)/3), 0, 0, this.imageWidth, this.imageHeight,this.width, this.height);
                    break;
                case 4:
                    graphics.blit(SELECT_NIV3, (int)(0.885*this.width)/3, (int)(1.97*(this.height)/3), 0, 0, this.imageWidth, this.imageHeight,this.width, this.height);
                    break;
                case 5:
                    graphics.blit(SELECT_NIV4, 0, 0, 0, 0, this.imageWidth, this.imageHeight,this.width, this.height);
                    break;
            }
        } else if (ClientFuinjutsuData.get_LVL() == 5) {
            graphics.blit(TEXTURE_NIV5, 0, 0, 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
            switch(posCursor) {
                case 1:
                    graphics.blit(SELECT_NIV5, (int)(this.width/2.1), (this.height)/10, 0, 0, this.imageWidth, this.imageHeight,this.width, this.height);
                    break;
                case 2:
                    graphics.blit(SELECT_NIV1, (int)(1.9*this.width)/3, ((this.height)/3)+2, 0, 0, this.imageWidth, this.imageHeight,this.width, this.height);
                    break;
                case 3:
                    graphics.blit(SELECT_NIV2, (int)(1.67*this.width)/3, (int)(1.97*(this.height)/3), 0, 0, this.imageWidth, this.imageHeight,this.width, this.height);
                    break;
                case 4:
                    graphics.blit(SELECT_NIV3, (int)(0.885*this.width)/3, (int)(1.97*(this.height)/3), 0, 0, this.imageWidth, this.imageHeight,this.width, this.height);
                    break;
                case 5:
                    graphics.blit(SELECT_NIV4, 0, 0, 0, 0, this.imageWidth, this.imageHeight,this.width, this.height);
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
            ModMessages.sendToServer(new GiveSceauC2SPacket("Scellement", 5));
            this.SE0E.kill();
        } else if (posCursor==2 && (ClientFuinjutsuData.get_LVL()>=1)) {
            ModMessages.sendToServer(new GiveSceauC2SPacket("Scellement", 1));
            this.SE0E.kill();
        } else if (posCursor==3 && (ClientFuinjutsuData.get_LVL()>=2)) {
            ModMessages.sendToServer(new GiveSceauC2SPacket("Scellement", 2));
            this.SE0E.kill();
        } else if (posCursor==4 && (ClientFuinjutsuData.get_LVL()>=3)) {
            ModMessages.sendToServer(new GiveSceauC2SPacket("Scellement", 3));
            this.SE0E.kill();
        } else if (posCursor==5 && ClientFuinjutsuData.get_LVL()>=4) {
            ModMessages.sendToServer(new GiveSceauC2SPacket("Scellement", 4));
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
}