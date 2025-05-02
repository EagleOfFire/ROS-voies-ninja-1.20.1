package ros.eagleoffire.rosvoiesninjas.screen;

import com.mojang.blaze3d.platform.GlStateManager;
import com.mojang.blaze3d.systems.RenderSystem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.GameRenderer;
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
        // Set up rendering system for transparency
        RenderSystem.disableDepthTest();
        RenderSystem.depthMask(false);
        RenderSystem.enableBlend();
        RenderSystem.setShader(GameRenderer::getPositionTexShader);
        RenderSystem.blendFuncSeparate(
                GlStateManager.SourceFactor.SRC_ALPHA,
                GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA,
                GlStateManager.SourceFactor.ONE,
                GlStateManager.DestFactor.ZERO
        );
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        int slots = 6;  // always circles+1
        int slotW = this.width / slots;
        int drawY = (this.height * 3) / 4;
        int yellowW = this.width / 15;
        int yellowH = (int) (((double) this.width / 15) * 1.06);
        int token1verticalPos = ((this.width) / 6) - yellowW;
        int token2verticalPos = ((this.width * 2) / 6) - ((3 * yellowW) / 4);
        int token3verticalPos = ((this.width * 3) / 6) - (yellowW / 2);
        int token4verticalPos = ((this.width * 4) / 6) - (yellowW / 4);
        int token5verticalPos = ((this.width * 5) / 6);

        int posCursor = getSectorID(mouseX, this.width);
        if (posCursor == 1) {
            int drawX = ((this.width * posCursor) / 6) - yellowW;
            graphics.blit(ScreensTextures.MAIN_MENU_GENJUTSU_SELECTED, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
            graphics.blit(ScreensTextures.TOKEN, token2verticalPos, drawY, 0, 0, yellowW, yellowH, yellowW, yellowH);
            graphics.blit(ScreensTextures.TOKEN, token3verticalPos, drawY, 0, 0, yellowW, yellowH, yellowW, yellowH);
            graphics.blit(ScreensTextures.TOKEN, token4verticalPos, drawY, 0, 0, yellowW, yellowH, yellowW, yellowH);
            graphics.blit(ScreensTextures.TOKEN, token5verticalPos, drawY, 0, 0, yellowW, yellowH, yellowW, yellowH);
            graphics.blit(
                    ScreensTextures.TOKEN_SELECTED,
                    drawX, drawY,
                    0, 0,
                    yellowW, yellowH,
                    yellowW, yellowH);
        } else if (posCursor == 2) {
            int drawX = ((this.width * posCursor) / 6) - ((3 * yellowW) / 4);
            graphics.blit(ScreensTextures.MAIN_MENU_FUINJUTSU_SELECTED, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
            graphics.blit(ScreensTextures.TOKEN, token1verticalPos, drawY, 0, 0, yellowW, yellowH, yellowW, yellowH);
            graphics.blit(ScreensTextures.TOKEN, token3verticalPos, drawY, 0, 0, yellowW, yellowH, yellowW, yellowH);
            graphics.blit(ScreensTextures.TOKEN, token4verticalPos, drawY, 0, 0, yellowW, yellowH, yellowW, yellowH);
            graphics.blit(ScreensTextures.TOKEN, token5verticalPos, drawY, 0, 0, yellowW, yellowH, yellowW, yellowH);
            graphics.blit(
                    ScreensTextures.TOKEN_SELECTED,
                    drawX, drawY,
                    0, 0,
                    yellowW, yellowH,
                    yellowW, yellowH);
        } else if (posCursor == 3) {
            int drawX = ((this.width * posCursor) / 6) - (yellowW / 2);
            graphics.blit(ScreensTextures.MAIN_MENU_MEDICAL_SELECTED, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
            graphics.blit(ScreensTextures.TOKEN, token1verticalPos, drawY, 0, 0, yellowW, yellowH, yellowW, yellowH);
            graphics.blit(ScreensTextures.TOKEN, token2verticalPos, drawY, 0, 0, yellowW, yellowH, yellowW, yellowH);
            graphics.blit(ScreensTextures.TOKEN, token4verticalPos, drawY, 0, 0, yellowW, yellowH, yellowW, yellowH);
            graphics.blit(ScreensTextures.TOKEN, token5verticalPos, drawY, 0, 0, yellowW, yellowH, yellowW, yellowH);
            graphics.blit(
                    ScreensTextures.TOKEN_SELECTED,
                    drawX, drawY,
                    0, 0,
                    yellowW, yellowH,
                    yellowW, yellowH);
        } else if (posCursor == 4) {
            int drawX = ((this.width * posCursor) / 6) - (yellowW / 4);
            graphics.blit(ScreensTextures.MAIN_MENU_SENSORIEL_SELECTED, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
            graphics.blit(ScreensTextures.TOKEN, token1verticalPos, drawY, 0, 0, yellowW, yellowH, yellowW, yellowH);
            graphics.blit(ScreensTextures.TOKEN, token2verticalPos, drawY, 0, 0, yellowW, yellowH, yellowW, yellowH);
            graphics.blit(ScreensTextures.TOKEN, token3verticalPos, drawY, 0, 0, yellowW, yellowH, yellowW, yellowH);
            graphics.blit(ScreensTextures.TOKEN, token5verticalPos, drawY, 0, 0, yellowW, yellowH, yellowW, yellowH);
            graphics.blit(
                    ScreensTextures.TOKEN_SELECTED,
                    drawX, drawY,
                    0, 0,
                    yellowW, yellowH,
                    yellowW, yellowH);
        } else if (posCursor == 5) {
            int drawX = ((this.width * posCursor) / 6);
            graphics.blit(ScreensTextures.MAIN_MENU_INFILTRATION_SELECTED, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
            graphics.blit(ScreensTextures.TOKEN, token1verticalPos, drawY, 0, 0, yellowW, yellowH, yellowW, yellowH);
            graphics.blit(ScreensTextures.TOKEN, token2verticalPos, drawY, 0, 0, yellowW, yellowH, yellowW, yellowH);
            graphics.blit(ScreensTextures.TOKEN, token3verticalPos, drawY, 0, 0, yellowW, yellowH, yellowW, yellowH);
            graphics.blit(ScreensTextures.TOKEN, token4verticalPos, drawY, 0, 0, yellowW, yellowH, yellowW, yellowH);
            graphics.blit(
                    ScreensTextures.TOKEN_SELECTED,
                    drawX, drawY,
                    0, 0,
                    yellowW, yellowH,
                    yellowW, yellowH);
        } else {
            graphics.blit(ScreensTextures.MAIN_MENU, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
        }
        int numberHeight = yellowH/2;
        int numberWidth = (int)(numberHeight / 1.255);
        int numberX = (int) (((double) (this.width) / 6) - (numberWidth*1.7));
        int numberY = ((this.height * 4) / 6) - (numberHeight/4);

        graphics.blit(ScreensTextures.NUMBER_0, numberX, numberY, 0, 0, numberWidth, numberHeight, numberWidth, numberHeight);
        graphics.blit(ScreensTextures.NUMBER_0, (int) (numberX*2.5), numberY, 0, 0, numberWidth, numberHeight, numberWidth, numberHeight);
        graphics.blit(ScreensTextures.NUMBER_0, (int) (numberX*3.95), numberY, 0, 0, numberWidth, numberHeight, numberWidth, numberHeight);
        graphics.blit(ScreensTextures.NUMBER_0, (int) (numberX*5.45), numberY, 0, 0, numberWidth, numberHeight, numberWidth, numberHeight);
        graphics.blit(ScreensTextures.NUMBER_0, (int) (numberX*6.95), numberY, 0, 0, numberWidth, numberHeight, numberWidth, numberHeight);

        // Reset rendering system to default state
        RenderSystem.depthMask(true);
        RenderSystem.defaultBlendFunc();
        RenderSystem.enableDepthTest();
        RenderSystem.disableBlend();
        RenderSystem.setShaderColor(1.0F, 1.0F, 1.0F, 1.0F);

        super.render(graphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int pButton) {
        int posCursor = getSectorID(mouseX, this.width);
        if (posCursor == 1) {
            // TODO add level handling
        } else if (posCursor == 2) {
            // TODO add level handling
        } else if (posCursor == 3) {
            // TODO add level handling
        } else if (posCursor == 4) {
            // TODO add level handling
        } else if (posCursor == 5) {
            // TODO add level handling
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