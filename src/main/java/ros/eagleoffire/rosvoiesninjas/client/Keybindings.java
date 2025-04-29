package ros.eagleoffire.rosvoiesninjas.client;

import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraftforge.client.settings.KeyConflictContext;
import ros.eagleoffire.rosvoiesninjas.ROSVoiesNinjas;

public final class Keybindings {
    public static final Keybindings INSTANCE = new Keybindings();

    private Keybindings(){}

    private static final String CATEGORY = "key.categories." + ROSVoiesNinjas.MODID;

    public final KeyMapping OpenVoiesNinjasScreen = new KeyMapping(
            "key." + ROSVoiesNinjas.MODID + ".open_voies_ninjas_screen",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_M, -1),
            CATEGORY
    );

    public final KeyMapping OpenFuinjutsuScreen = new KeyMapping(
            "key." + ROSVoiesNinjas.MODID + ".open_fuinjutsu_screen",
            KeyConflictContext.IN_GAME,
            InputConstants.getKey(InputConstants.KEY_N, -1),
            CATEGORY
    );
}