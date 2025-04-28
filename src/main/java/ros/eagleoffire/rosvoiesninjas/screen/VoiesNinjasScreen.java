package ros.eagleoffire.rosvoiesninjas.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;
import ros.eagleoffire.rosvoiesninjas.client.ClientHooks;

import net.minecraftforge.fml.DistExecutor;

public class VoiesNinjasScreen extends Screen {

    private static final Component TITLE =
            Component.translatable("gui." + ROSVoiesNinjas.MODID + ".voies_ninjas_screen");
    
    private LocalPlayer player;

    public VoiesNinjasScreen(LocalPlayer player) {
        super(TITLE);
        this.player = player;
    }

    @Override
    protected void init() {
        super.init();
    }

    @Override
    public void render(GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        super.render(graphics, mouseX, mouseY, partialTicks);
        renderBackground(graphics);
        int posCursor = getSectorID(mouseX, this.width);
        if (posCursor == 1) {
            graphics.blit(ScreensTextures.MAIN_MENU_GENJUTSU_SELECTED, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
        } else if (posCursor == 2) {
            graphics.blit(ScreensTextures.MAIN_MENU_FUINJUTSU_SELECTED, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
        } else if (posCursor == 3) {
            graphics.blit(ScreensTextures.MAIN_MENU_MEDICAL_SELECTED, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
        } else if (posCursor == 4) {
            graphics.blit(ScreensTextures.MAIN_MENU_SENSORIEL_SELECTED, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
        } else if (posCursor == 5) {
            graphics.blit(ScreensTextures.MAIN_MENU_INFILTRATION_SELECTED, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
        } else {
            graphics.blit(ScreensTextures.MAIN_MENU, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
        }

        super.render(graphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int pButton) {
        int posCursor = getSectorID(mouseX, this.width);
        if (posCursor == 1) {
            Minecraft.getInstance().setScreen(null);
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientHooks::openFuinjutsu);
        }
        return super.mouseClicked(mouseX, mouseY, pButton);
    }

    public static int getSectorID(double mouseX, int width) {
        if (mouseX < ((double) width / 5)) {
            return 1;
        } else if (((double) width / 5) < mouseX && mouseX < ((double) width / 5) * 2) {
            return 2;
        } else if (((double) width / 5) * 2 < mouseX && mouseX < ((double) width / 5) * 3) {
            return 3;
        } else if (((double) width / 5) * 3 < mouseX && mouseX < ((double) width / 5) * 4) {
            return 4;
        } else {
            return 5;
        }
    }


    @Override
    public boolean isPauseScreen() {
        return false;
    }
}