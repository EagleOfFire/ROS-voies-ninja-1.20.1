package ros.eagleoffire.rosvoiesninjas.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.codehaus.plexus.util.dag.DAG;
import org.jetbrains.annotations.NotNull;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;

public class SceauViergeScreen extends Screen {
    private static final Component TITLE =
            Component.translatable("gui." + ROSVoiesNinjas.MODID + ".example_block_screen");

    private static final ResourceLocation NEUTRE =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/back_ground_sceau_neutre.png");
    private static final ResourceLocation LEFT =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/back_ground_sceau_left.png");
    private static final ResourceLocation RIGHT =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/back_ground_sceau_right.png");
    private static final ResourceLocation UP =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/back_ground_sceau_up.png");
    private static final ResourceLocation DOWN =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/back_ground_sceau_down.png");



    private final int imageWidth, imageHeight;

    private int leftPos, topPos;

    private Button button;

    public SceauViergeScreen() {
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
        int posCursor = getSectorID(mouseX,mouseY,this.minecraft.getWindow().getGuiScaledWidth(),this.minecraft.getWindow().getGuiScaledHeight());
        switch(posCursor) {
            case 1:
                graphics.blit(UP, 0, 0, 0, 0, this.imageWidth, this.imageHeight,this.minecraft.getWindow().getGuiScaledWidth(), this.minecraft.getWindow().getGuiScaledHeight());
                break;
            case 2:
                graphics.blit(RIGHT, 0, 0, 0, 0, this.imageWidth, this.imageHeight,this.minecraft.getWindow().getGuiScaledWidth(), this.minecraft.getWindow().getGuiScaledHeight());
                break;
            case 3:
                graphics.blit(DOWN, 0, 0, 0, 0, this.imageWidth, this.imageHeight,this.minecraft.getWindow().getGuiScaledWidth(), this.minecraft.getWindow().getGuiScaledHeight());
                break;
            case 4:
                graphics.blit(LEFT, 0, 0, 0, 0, this.imageWidth, this.imageHeight,this.minecraft.getWindow().getGuiScaledWidth(), this.minecraft.getWindow().getGuiScaledHeight());
                break;
            default:
                graphics.blit(NEUTRE, 0, 0, 0, 0, this.imageWidth, this.imageHeight,this.minecraft.getWindow().getGuiScaledWidth(), this.minecraft.getWindow().getGuiScaledHeight());
            }
        super.render(graphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    public static int getSectorID(double mouseX, double mouseY, int width, int height) {
        mouseX -= (double)width/2;
        mouseY -= (double)height/2;
        double angle = Math.atan2(mouseY, mouseX);
        angle += Math.PI;
        if ((Math.PI / 4) < angle && angle < (3*Math.PI / 4)){
            return 1;
        } else if ((3*Math.PI / 4) < angle && angle < (5*Math.PI / 4)) {
            return 2;
        } else if ((11*Math.PI / 6) > angle && angle > (5*Math.PI / 4)){
            return 3;
        }else{
            return 4;
        }
    }
}