package ros.eagleoffire.rosvoiesninjas.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import org.jetbrains.annotations.NotNull;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;
import ros.eagleoffire.rosvoiesninjas.client.ProgressionVoiesNinjasData.ClientFuinjutsuData;

public class SceauChakraAutruiScreen extends Screen {
    private static final Component TITLE =
            Component.translatable("gui." + ROSVoiesNinjas.MODID + ".example_block_screen");


    private static final ResourceLocation TEXTURE_NIV1 =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/restriction/screen_choix_niveau_sceau_chakra_autrui_niv1.png");
    private static final ResourceLocation TEXTURE_NIV2 =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/restriction/screen_choix_niveau_sceau_chakra_autrui_niv2.png");
    private static final ResourceLocation TEXTURE_NIV3 =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/restriction/screen_choix_niveau_sceau_chakra_autrui_niv3.png");
    private static final ResourceLocation TEXTURE_NIV4 =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/restriction/screen_choix_niveau_sceau_chakra_autrui_niv4.png");
    private static final ResourceLocation TEXTURE_NIV5 =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/restriction/screen_choix_niveau_sceau_chakra_autrui_niv5.png");


    private final int imageWidth, imageHeight;

    private int leftPos, topPos;

    private Button button;

    public SceauChakraAutruiScreen() {
        super(TITLE);

        this.imageWidth = 1920;
        this.imageHeight = 1920;
    }

    @Override
    protected void init() {
        super.init();

        this.leftPos = (this.width - this.imageWidth) / 2;
        this.topPos = (this.height - this.imageHeight) / 2;

        if(this.minecraft == null) return;
        Level level = this.minecraft.level;
        if(level == null) return;
    }

    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        if (ClientFuinjutsuData.get_LVL() == 1) {
            graphics.blit(TEXTURE_NIV1, 0, 0, 0, 0, this.imageWidth, this.imageHeight,this.minecraft.getWindow().getGuiScaledWidth(), this.minecraft.getWindow().getGuiScaledHeight());
        } else if (ClientFuinjutsuData.get_LVL() == 2) {
            graphics.blit(TEXTURE_NIV2, 0, 0, 0, 0, this.imageWidth, this.imageHeight,this.minecraft.getWindow().getGuiScaledWidth(), this.minecraft.getWindow().getGuiScaledHeight());
        } else if (ClientFuinjutsuData.get_LVL() == 3) {
            graphics.blit(TEXTURE_NIV3, 0, 0, 0, 0, this.imageWidth, this.imageHeight,this.minecraft.getWindow().getGuiScaledWidth(), this.minecraft.getWindow().getGuiScaledHeight());
        } else if (ClientFuinjutsuData.get_LVL() == 4) {
            graphics.blit(TEXTURE_NIV4, 0, 0, 0, 0, this.imageWidth, this.imageHeight,this.minecraft.getWindow().getGuiScaledWidth(), this.minecraft.getWindow().getGuiScaledHeight());
        } else if (ClientFuinjutsuData.get_LVL() == 5) {
            graphics.blit(TEXTURE_NIV5, 0, 0, 0, 0, this.imageWidth, this.imageHeight, this.minecraft.getWindow().getGuiScaledWidth(), this.minecraft.getWindow().getGuiScaledHeight());
        }
        super.render(graphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}