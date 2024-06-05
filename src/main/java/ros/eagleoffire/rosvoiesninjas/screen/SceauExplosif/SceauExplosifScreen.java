package ros.eagleoffire.rosvoiesninjas.screen.SceauExplosif;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;
import ros.eagleoffire.rosvoiesninjas.client.ProgressionVoiesNinjasData.ClientFuinjutsuData;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauExplosif.SceauExplosifNiv0Entity;
import ros.eagleoffire.rosvoiesninjas.networking.ModMessages;
import ros.eagleoffire.rosvoiesninjas.networking.packet.GiveSceauC2SPacket;
import ros.eagleoffire.rosvoiesninjas.screen.ScreenRessourceLocation;

public class SceauExplosifScreen extends Screen {
    private static final Component TITLE =
            Component.translatable("gui." + ROSVoiesNinjas.MODID + ".sceau_explosif_screen");
    private int imageWidth;
    private int imageHeight;
    private final Player player;
    private int transition;
    private long oldPlayerTick;
    private double progress;
    private final SceauExplosifNiv0Entity SE0E;
    private double[] subProgresses;

    public SceauExplosifScreen(Player player, SceauExplosifNiv0Entity SceauEntity) {
        super(TITLE);

        this.SE0E = SceauEntity;
        this.player = player;
        this.transition = 0;
        this.oldPlayerTick = 0;
        this.progress = 0;
    }

    @Override
    protected void init() {
        super.init();

        this.width = this.minecraft.getWindow().getGuiScaledWidth();
        this.height = this.minecraft.getWindow().getGuiScaledHeight();
        this.imageWidth = this.width;
        this.imageHeight = this.height;

        if (this.minecraft == null) return;
        Level level = this.minecraft.level;
    }

    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        int posCursor = getSectorID(mouseX, mouseY, this.width, this.height);
        if (this.transition == 0) {
            renderBackGround(graphics);
            renderMousePos(graphics, posCursor);
        } else {
            renderTransition(graphics);
        }
        super.render(graphics, mouseX, mouseY, partialTicks);
    }

    private void renderProgress(@NotNull GuiGraphics graphics, int maxProgress) {
        int actualProgress = getScaledProgress(maxProgress);
        graphics.blit(ScreenRessourceLocation.PROGRESS_BAR_FULL, (int) (1.04 * (this.width) / 3) - 1, (int) (9.21 * (this.height) / 10), 0, 0, actualProgress, 137, this.width, this.height + 2);
    }

    public int getScaledProgress(int maxProgress) {
        progress += 0.1;// Max Progress
        int progressArrowSize = 200;
        if (progress >= (maxProgress + 5)) {
            creationResult();
        }
        return progress != 0 ? (int) progress * progressArrowSize / maxProgress : 0;
    }

    public int getDrawingProgress(int subIndex, int maxProgress, int progressArrowSize) {
        int numSubProgresses = transition+1;
        double subMaxProgress = maxProgress / (double) numSubProgresses;
        subProgresses[subIndex] += 0.2;

        return subProgresses[subIndex] != 0 ? (int) (subProgresses[subIndex] * progressArrowSize / subMaxProgress) : 0;
    }

    private void renderBackGround(GuiGraphics graphics) {
        if (ClientFuinjutsuData.get_LVL() == 1) {
            graphics.blit(ScreenRessourceLocation.EXPLOSION_TEXTURE_NIV1, 0, 0, 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
        } else if (ClientFuinjutsuData.get_LVL() == 2) {
            graphics.blit(ScreenRessourceLocation.EXPLOSION_TEXTURE_NIV2, 0, 0, 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
        } else if (ClientFuinjutsuData.get_LVL() == 3) {
            graphics.blit(ScreenRessourceLocation.EXPLOSION_TEXTURE_NIV3, 0, 0, 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
        } else if (ClientFuinjutsuData.get_LVL() == 4) {
            graphics.blit(ScreenRessourceLocation.EXPLOSION_TEXTURE_NIV4, 0, 0, 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
        } else if (ClientFuinjutsuData.get_LVL() == 5) {
            graphics.blit(ScreenRessourceLocation.EXPLOSION_TEXTURE_NIV5, 0, 0, 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
        }
    }

    private void renderMousePos(GuiGraphics graphics, int posCursor) {
        int level = ClientFuinjutsuData.get_LVL();
        if (posCursor == 2 && level >= 1) {
            renderGraphics(graphics, ScreenRessourceLocation.SELECT_NIV1, 1.9 / 3, (1.0 / 3) + (2.0 / this.height));
        } else if (posCursor == 3 && level >= 2) {
            renderGraphics(graphics, ScreenRessourceLocation.SELECT_NIV2, 1.67 / 3, 1.97 / 3);
        } else if (posCursor == 4 && level >= 3) {
            renderGraphics(graphics, ScreenRessourceLocation.SELECT_NIV3, 0.885 / 3, 1.97 / 3);
        } else if (posCursor == 5 && level >= 4) {
            renderGraphics(graphics, ScreenRessourceLocation.SELECT_NIV4, 1.0 / 4.7, (1.0 / 3) + (3.0 / this.height));
        } else if (posCursor == 1 && level == 5) {
            renderGraphics(graphics, ScreenRessourceLocation.SELECT_NIV5, 1.0 / 2.35, 1.0 / 40);
        }
    }

    private void renderGraphics(GuiGraphics graphics, ResourceLocation resourceLocation, double widthFactor, double heightFactor) {
        graphics.blit(resourceLocation, (int) (widthFactor * this.width), (int) (heightFactor * this.height), 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
    }

    private void renderTransition(GuiGraphics graphics) {
        long actualPlayerTick = player.tickCount;
        oldPlayerTick = oldPlayerTick == 0 ? actualPlayerTick : oldPlayerTick;
        int[] deltas = {0, 200, 300, 400, 500, 600};
        int[] maxProgresses = {0, 150, 225, 300, 375, 450};

        int index = (transition >= 1 && transition <= 5) ? transition : 0;
        long delta =  actualPlayerTick - oldPlayerTick;
        int maxProgress = maxProgresses[index];
        graphics.blit(ScreenRessourceLocation.EXPLOSION_PROGRESS_NIV0, 0, 0, 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
        graphics.blit(ScreenRessourceLocation.PROGRESS_BAR_EMPTY, (int) (1.04 * (this.width) / 3) - 1, (int) (9.21 * (this.height) / 10), 0, 0, this.imageWidth, this.imageHeight, this.width, this.height + 2);
        if (delta>(deltas[index])){
            creationResult();
        }else if (deltas[1]/2 >= delta) {
            graphics.blit(ScreenRessourceLocation.EXPLOSION_SCEAU_NIV1, 0, (int)(0.287*this.imageHeight), 0, (int)(0.287*this.imageHeight), this.imageWidth, getDrawingProgress(0,300,this.imageHeight/2), this.width, this.height);
            renderProgress(graphics, maxProgress);
        }else if (deltas[1] >= delta) {
            graphics.blit(ScreenRessourceLocation.EXPLOSION_SCEAU_NIV1, 0, (int)(0.287*this.imageHeight), 0, (int)(0.287*this.imageHeight), this.imageWidth, this.imageHeight, this.width, this.height);
            graphics.blit(ScreenRessourceLocation.EXPLOSION_SCEAU_NIV2, 0, (int)(0.287*this.imageHeight), 0, (int)(0.287*this.imageHeight), this.imageWidth, getDrawingProgress(1,300,this.imageHeight/2), this.width, this.height);
            renderProgress(graphics, maxProgress);
        }else if (deltas[2] >= delta) {
            graphics.blit(ScreenRessourceLocation.EXPLOSION_SCEAU_NIV2, 0, (int)(0.287*this.imageHeight), 0, (int)(0.287*this.imageHeight), this.imageWidth, this.imageHeight, this.width, this.height);
            graphics.blit(ScreenRessourceLocation.EXPLOSION_SCEAU_NIV3, 0, (int)(0.287*this.imageHeight), 0, (int)(0.287*this.imageHeight), this.imageWidth, getDrawingProgress(2,300,this.imageHeight/3), this.width, this.height);
            renderProgress(graphics, maxProgress);
        }else if (deltas[3] >= delta) {
            graphics.blit(ScreenRessourceLocation.EXPLOSION_SCEAU_NIV3, 0, (int)(0.287*this.imageHeight), 0, (int)(0.287*this.imageHeight), this.imageWidth, this.imageHeight, this.width, this.height);
            graphics.blit(ScreenRessourceLocation.EXPLOSION_SCEAU_NIV4, 0, (int)(0.287*this.imageHeight), 0, (int)(0.287*this.imageHeight), this.imageWidth, getDrawingProgress(3,300,this.imageHeight/3), this.width, this.height);
            renderProgress(graphics, maxProgress);
        }else if (deltas[4] >= delta) {
            graphics.blit(ScreenRessourceLocation.EXPLOSION_SCEAU_NIV4, 0, (int)(0.287*this.imageHeight), 0, (int)(0.287*this.imageHeight), this.imageWidth, this.imageHeight, this.width, this.height);
            graphics.blit(ScreenRessourceLocation.EXPLOSION_SCEAU_NIV5, 0, (int)(0.287*this.imageHeight), 0, (int)(0.287*this.imageHeight), this.imageWidth, getDrawingProgress(4,300,this.imageHeight/3), this.width, this.height);
            renderProgress(graphics, maxProgress);
        }else {
            graphics.blit(ScreenRessourceLocation.EXPLOSION_SCEAU_NIV5, 0, (int)(0.287*this.imageHeight), 0, (int)(0.287*this.imageHeight), this.imageWidth, this.imageHeight, this.width, this.height);
            graphics.blit(ScreenRessourceLocation.EXPLOSION_SCEAU_NIV6, 0, (int)(0.287*this.imageHeight), 0, (int)(0.287*this.imageHeight), this.imageWidth, getDrawingProgress(5,300,this.imageHeight/3), this.width, this.height);
            renderProgress(graphics, maxProgress);
        }
    }


    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int pButton) {
        int posCursor = getSectorID(mouseX, mouseY, this.width, this.height);
        if (posCursor == 1 && (ClientFuinjutsuData.get_LVL() == 5)) {
            this.transition = 5;
        } else if (posCursor == 2 && (ClientFuinjutsuData.get_LVL() >= 1)) {
            this.transition = 1;
        } else if (posCursor == 3 && (ClientFuinjutsuData.get_LVL() >= 2)) {
            this.transition = 2;
        } else if (posCursor == 4 && (ClientFuinjutsuData.get_LVL() >= 3)) {
            this.transition = 3;
        } else if (posCursor == 5 && ClientFuinjutsuData.get_LVL() >= 4) {
            this.transition = 4;
        } else {
            this.player.sendSystemMessage(Component.literal("You do not have the required level to create this seal"));
        }
        this.subProgresses = new double[transition+1];
        return super.mouseClicked(mouseX, mouseY, pButton);
    }

    public static int getSectorID(double mouseX, double mouseY, int width, int height) {
        mouseX -= (double) width / 2;
        mouseY -= (double) height / 2;
        double angle = Math.atan2(mouseY, mouseX);
        angle += Math.PI;
        if ((Math.PI / 4) < angle && angle < (3 * Math.PI / 4)) {
            return 1;
        } else if ((3 * Math.PI / 4) < angle && angle < (7 * Math.PI / 6)) {
            return 2;
        } else if ((7 * Math.PI / 6) < angle && angle < (3 * Math.PI / 2)) {
            return 3;
        } else if ((3 * Math.PI / 2) < angle && angle < (11 * Math.PI / 6)) {
            return 4;
        } else {
            return 5;
        }
    }

    private void creationResult() {
        ModMessages.sendToServer(new GiveSceauC2SPacket("Explosif", this.transition));
        this.SE0E.kill();
        Minecraft.getInstance().setScreen(null);
    }
}