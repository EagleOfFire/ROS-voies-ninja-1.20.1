package ros.eagleoffire.rosvoiesninjas.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.chat.Component;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.fml.DistExecutor;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;
import ros.eagleoffire.rosvoiesninjas.client.ClientHooks;

public class FuinjutsuScreen extends Screen {

    private static final Component TITLE =
            Component.translatable("gui." + ROSVoiesNinjas.MODID + ".fuinjutsu_screen");

    private LocalPlayer player;

    public FuinjutsuScreen(LocalPlayer player) {
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
            graphics.blit(ScreensTextures.FUINJUTSU_MENU_STOCKAGE_CHAKRA_SELECTED, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
        } else if (posCursor == 2) {
            graphics.blit(ScreensTextures.FUINJUTSU_MENU_MINE_CHAKRAIQUE_SELECTED, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
        } else if (posCursor == 3) {
            graphics.blit(ScreensTextures.FUINJUTSU_MENU_EXPLOSIF_SELECTED, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
        } else if (posCursor == 4) {
            graphics.blit(ScreensTextures.FUINJUTSU_MENU_FUMIGENE_SELECTED, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
        } else if (posCursor == 5) {
            graphics.blit(ScreensTextures.FUINJUTSU_MENU_BARRIERE_SELECTED, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
        } else {
            graphics.blit(ScreensTextures.FUINJUTSU_MENU, 0, 0, 0, 0, this.width, this.height, this.width, this.height);
        }
        super.render(graphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int pButton) {
        int posCursor = getSectorID(mouseX, this.width);
        if (posCursor == 1) {
            Minecraft.getInstance().setScreen(null);
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientHooks::openFuinjutsuStockage);
        } else if (posCursor == 2) {
            Minecraft.getInstance().setScreen(null);
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientHooks::openFuinjutsuMineChakraique);
        } else if (posCursor == 3) {
            Minecraft.getInstance().setScreen(null);
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientHooks::openFuinjutsuExplosif);
        } else if (posCursor == 4) {
            Minecraft.getInstance().setScreen(null);
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientHooks::openFuinjutsuFumigene);
        } else if (posCursor == 5) {
            Minecraft.getInstance().setScreen(null);
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientHooks::openFuinjutsuBariere);
        } else if (posCursor == 6) {
            Minecraft.getInstance().setScreen(null);
            DistExecutor.unsafeRunWhenOn(Dist.CLIENT, () -> ClientHooks::openFuinjutsuStockage);
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