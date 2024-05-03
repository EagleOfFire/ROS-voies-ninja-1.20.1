package ros.eagleoffire.rosvoiesninjas.screen;

import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import org.jetbrains.annotations.NotNull;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;

public class SceauViergeScreen extends Screen {
    private static final Component TITLE =
            Component.translatable("gui." + ROSVoiesNinjas.MODID + ".example_block_screen");

    private static final ResourceLocation TEXTURE =
            new ResourceLocation(ROSVoiesNinjas.MODID, "textures/gui/back_ground_sceau_neutre.png");


    private final BlockPos position;
    private final int imageWidth, imageHeight;

    private int leftPos, topPos;

    private Button button;

    public SceauViergeScreen(BlockPos position) {
        super(TITLE);

        this.position = position;
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

        BlockEntity be = level.getBlockEntity(this.position);
    }

    @Override
    public void render(@NotNull GuiGraphics graphics, int mouseX, int mouseY, float partialTicks) {
        int posCursor = getSectorID(mouseX,mouseY);
        System.out.println(posCursor);
        graphics.blit(TEXTURE, 0, 0, 0, 0, this.imageWidth, this.imageHeight,this.minecraft.getWindow().getGuiScaledWidth(), this.minecraft.getWindow().getGuiScaledHeight());
        super.render(graphics, mouseX, mouseY, partialTicks);
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    public static int getSectorID(double mouseX, double mouseY) {
        double angle = Math.atan2(mouseY, mouseX);
        if (angle < 0) {
            angle += 2 * Math.PI;
        }
        double angleDegrees = Math.toDegrees(angle);
        int totalSectors = 8;
        int sectorID = (int) Math.floor(angleDegrees / (360.0 / totalSectors)) + 1;
        if (sectorID > totalSectors) {
            sectorID = 1;
        }
        return sectorID;
    }
}