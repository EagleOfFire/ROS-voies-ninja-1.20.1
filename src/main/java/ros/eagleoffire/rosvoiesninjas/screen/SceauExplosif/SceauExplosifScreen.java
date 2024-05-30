package ros.eagleoffire.rosvoiesninjas.screen.SceauExplosif;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
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
    private final int imageWidth, imageHeight;
    private final Player player;
    private int transition;
    private long oldPlayerTick;
    private double progress;

    public SceauExplosifScreen(Player player, SceauExplosifNiv0Entity SceauEntity) {
        super(TITLE);

        this.player = player;
        this.imageWidth = 1920;
        this.imageHeight = 1920;
        this.transition = 0;
        this.oldPlayerTick = 0;
        this.progress = 0;
    }

    @Override
    protected void init() {
        super.init();

        this.width = this.minecraft.getWindow().getGuiScaledWidth();
        this.height = this.minecraft.getWindow().getGuiScaledHeight();

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

    private void renderProgressBar(@NotNull GuiGraphics graphics, int maxProgress) {
        graphics.blit(ScreenRessourceLocation.PROGRESS_BAR_FULL, (int) (1.04 * (this.width) / 3) - 1, (int) (9.21 * (this.height) / 10), 0, 0, getScaledProgress(maxProgress), 137, this.width, this.height + 2);
    }

    public int getScaledProgress(int maxProgress) {
        progress += 0.1;// Max Progress
        int progressArrowSize = 200;
        return progress != 0 ? (int) progress * progressArrowSize / maxProgress : 0;
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
        switch (posCursor) {
            case 2:
                if (ClientFuinjutsuData.get_LVL() >= 1) {
                    graphics.blit(ScreenRessourceLocation.SELECT_NIV1, (int) (1.9 * this.width) / 3, ((this.height) / 3) + 2, 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
                }
                break;
            case 3:
                if (ClientFuinjutsuData.get_LVL() >= 2) {
                    graphics.blit(ScreenRessourceLocation.SELECT_NIV2, (int) (1.67 * this.width) / 3, (int) (1.97 * (this.height) / 3), 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
                }
                break;
            case 4:
                if (ClientFuinjutsuData.get_LVL() >= 3) {
                    graphics.blit(ScreenRessourceLocation.SELECT_NIV3, (int) (0.885 * this.width) / 3, (int) (1.97 * (this.height) / 3), 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
                }
                break;
            case 5:
                if (ClientFuinjutsuData.get_LVL() >= 4) {
                    graphics.blit(ScreenRessourceLocation.SELECT_NIV4, (int) (this.width / 4.7), ((this.height) / 3) + 3, 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
                }
                break;
            case 1:
                if (ClientFuinjutsuData.get_LVL() == 5) {
                    graphics.blit(ScreenRessourceLocation.SELECT_NIV5, (int) (this.width / 2.35), (this.height) / 40, 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
                }
                break;
        }
    }

    private void renderTransition(GuiGraphics graphics) {
        long actualPlayerTick = player.tickCount;
        oldPlayerTick = oldPlayerTick == 0 ? actualPlayerTick : oldPlayerTick;
        int[] deltas = {40, 160, 240, 320, 400, Integer.MAX_VALUE}; // Integer.MAX_VALUE for case 5
        int[] maxProgresses = {140, 140, 210, 280, 360, 440};

        int index = (transition >= 1 && transition <= 5) ? transition : 0;
        long delta = Math.min(deltas[index], actualPlayerTick - oldPlayerTick);
        int maxProgress = maxProgresses[index];

        if (delta <= 40) {
            graphics.blit(ScreenRessourceLocation.EXPLOSION_PROGRESS_NIV0, 0, 0, 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
            renderProgressBar(graphics, maxProgress);
        }
        if (160 >= delta && delta > 40) {
            graphics.blit(ScreenRessourceLocation.EXPLOSION_PROGRESS_NIV1, 0, 0, 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
            graphics.blit(ScreenRessourceLocation.PROGRESS_BAR_EMPTY, (int) (1.04 * (this.width) / 3) - 1, (int) (9.21 * (this.height) / 10), 0, 0, this.imageWidth, this.imageHeight, this.width, this.height + 2);
            renderProgressBar(graphics, maxProgress);
        }
        if (240 >= delta && delta > 160) {
            graphics.blit(ScreenRessourceLocation.EXPLOSION_PROGRESS_NIV2, 0, 0, 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
            graphics.blit(ScreenRessourceLocation.PROGRESS_BAR_EMPTY, (int) (1.04 * (this.width) / 3) - 1, (int) (9.21 * (this.height) / 10), 0, 0, this.imageWidth, this.imageHeight, this.width, this.height + 2);
            renderProgressBar(graphics, maxProgress);
        }
        if (320 >= delta && delta > 240) {
            graphics.blit(ScreenRessourceLocation.EXPLOSION_PROGRESS_NIV3, 0, 0, 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
            graphics.blit(ScreenRessourceLocation.PROGRESS_BAR_EMPTY, (int) (1.04 * (this.width) / 3) - 1, (int) (9.21 * (this.height) / 10), 0, 0, this.imageWidth, this.imageHeight, this.width, this.height + 2);
            renderProgressBar(graphics, maxProgress);
        }
        if (400 >= delta && delta > 320) {
            graphics.blit(ScreenRessourceLocation.EXPLOSION_PROGRESS_NIV4, 0, 0, 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
            graphics.blit(ScreenRessourceLocation.PROGRESS_BAR_EMPTY, (int) (1.04 * (this.width) / 3) - 1, (int) (9.21 * (this.height) / 10), 0, 0, this.imageWidth, this.imageHeight, this.width, this.height + 2);
            renderProgressBar(graphics, maxProgress);
        }
        if (480 >= delta && delta > 400) {
            graphics.blit(ScreenRessourceLocation.EXPLOSION_PROGRESS_NIV5, 0, 0, 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
            graphics.blit(ScreenRessourceLocation.PROGRESS_BAR_EMPTY, (int) (1.04 * (this.width) / 3) - 1, (int) (9.21 * (this.height) / 10), 0, 0, this.imageWidth, this.imageHeight, this.width, this.height + 2);
            renderProgressBar(graphics, maxProgress);
        }
        if (delta > 480) {
            graphics.blit(ScreenRessourceLocation.EXPLOSION_PROGRESS_NIV6, 0, 0, 0, 0, this.imageWidth, this.imageHeight, this.width, this.height);
            graphics.blit(ScreenRessourceLocation.PROGRESS_BAR_EMPTY, (int) (1.04 * (this.width) / 3) - 1, (int) (9.21 * (this.height) / 10), 0, 0, this.imageWidth, this.imageHeight, this.width, this.height + 2);
            renderProgressBar(graphics, maxProgress);
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
}

//this.SE0E.kill();
//Minecraft.getInstance().setScreen(null);

       /* long actualPlayerTick = player.tickCount;
        if (oldPlayerTick == 0){
            oldPlayerTick = actualPlayerTick;
        }
        long delta = actualPlayerTick - oldPlayerTick;
        if (delta >= 80){
            oldPlayerTick = 0;*/