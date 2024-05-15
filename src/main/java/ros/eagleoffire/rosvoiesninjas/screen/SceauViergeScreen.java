package ros.eagleoffire.rosvoiesninjas.screen;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.gameevent.GameEvent;
import net.minecraftforge.items.ItemHandlerHelper;
import org.codehaus.plexus.util.dag.DAG;
import org.jetbrains.annotations.NotNull;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauChakra.SceauChakraNiv0Entity;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauChakraAutrui.SceauChakraAutruiNiv0Entity;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauExplosif.SceauExplosifNiv0Entity;
import ros.eagleoffire.rosvoiesninjas.entity.custom.SceauScellement.SceauScellementNiv0Entity;
import ros.eagleoffire.rosvoiesninjas.Items.ModItems;
import ros.eagleoffire.rosvoiesninjas.networking.ModMessages;
import ros.eagleoffire.rosvoiesninjas.networking.packet.GiveSceauC2SPacket;

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
    private final UseOnContext Context;
    private int leftPos, topPos;
    private Player player;


    public SceauViergeScreen(Player Player) {
        super(TITLE);
        this.Context = null;
        this.player = Player;
        this.imageWidth = 1920;
        this.imageHeight = 1920;
    }

    public SceauViergeScreen(UseOnContext pContext) {
        super(TITLE);

        this.Context = pContext;
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
        if (this.Context != null) {
            BlockEntity be = level.getBlockEntity(this.Context.getClickedPos());
        }
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int pButton) {
        if (Context != null){
            useOnBlock(mouseX,mouseY,pButton);
        }else{
            useOnAir(mouseX,mouseY,pButton);
        }
        return super.mouseClicked(mouseX, mouseY, pButton);
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

    public void useOnBlock(double mouseX, double mouseY, int pButton){
        int posCursor = getSectorID(mouseX,mouseY,this.minecraft.getWindow().getGuiScaledWidth(),this.minecraft.getWindow().getGuiScaledHeight());
        Level level = Context.getLevel();
        BlockPos blockpos = Context.getClickedPos();
        Direction direction = Context.getClickedFace();
        BlockPos blockpos1 = blockpos.relative(direction);
        Player player = Context.getPlayer();
        switch(posCursor) {
            case 1:
                SceauExplosifNiv0Entity hangingentityExplosif = new SceauExplosifNiv0Entity(level, blockpos1, direction);
                hangingentityExplosif.setDirection(direction);
                hangingentityExplosif.playPlacementSound();
                level.gameEvent(player, GameEvent.ENTITY_PLACE, hangingentityExplosif.position());
                level.addFreshEntity(hangingentityExplosif);
                break;
            case 2:
                SceauScellementNiv0Entity hangingentityScellement = new SceauScellementNiv0Entity(level, blockpos1, direction);
                hangingentityScellement.setDirection(direction);
                hangingentityScellement.playPlacementSound();
                level.gameEvent(player, GameEvent.ENTITY_PLACE, hangingentityScellement.position());
                level.addFreshEntity(hangingentityScellement);
                break;
            case 3:
                SceauChakraNiv0Entity hangingentityChakra = new SceauChakraNiv0Entity(level, blockpos1, direction);
                hangingentityChakra.setDirection(direction);
                hangingentityChakra.playPlacementSound();
                level.gameEvent(player, GameEvent.ENTITY_PLACE, hangingentityChakra.position());
                level.addFreshEntity(hangingentityChakra);
                break;
            case 4:
                SceauChakraAutruiNiv0Entity hangingentityChakraAutrui = new SceauChakraAutruiNiv0Entity(level, blockpos1, direction);
                hangingentityChakraAutrui.setDirection(direction);
                hangingentityChakraAutrui.playPlacementSound();
                level.gameEvent(player, GameEvent.ENTITY_PLACE, hangingentityChakraAutrui.position());
                level.addFreshEntity(hangingentityChakraAutrui);
                break;
            default:
            }
            player.getMainHandItem().setCount(player.getMainHandItem().getCount()-1);
            Minecraft.getInstance().setScreen(null);
    }

    public void useOnAir(double mouseX, double mouseY, int pButton){
        int posCursor = getSectorID(mouseX,mouseY,this.minecraft.getWindow().getGuiScaledWidth(),this.minecraft.getWindow().getGuiScaledHeight());
        switch(posCursor) {
            case 1:
                ModMessages.sendToServer(new GiveSceauC2SPacket("Explosif", 0));
                break;
            case 2:
                ModMessages.sendToServer(new GiveSceauC2SPacket("Scellement", 0));
                break;
            case 3:
                ModMessages.sendToServer(new GiveSceauC2SPacket("Chakra", 0));
                break;
            case 4:
                ModMessages.sendToServer(new GiveSceauC2SPacket("ChakraAutrui", 0));
                break;
            default:
        }
        player.getMainHandItem().setCount(player.getMainHandItem().getCount()-1);
        Minecraft.getInstance().setScreen(null);
    }
}