package ros.eagleoffire.rosvoiesninjas.client.ProgressionVoiesNinjasData;

import ros.eagleoffire.rosvoiesninjas.ProgressionVoiesNinjas.VoiesNinjas;

public class ClientFuinjutsuData {
    private static VoiesNinjas Fuinjutsu;

    public static void set(String name, int XP, int LVL, int LVLmax){
        ClientFuinjutsuData.Fuinjutsu = new VoiesNinjas(name);
        ClientFuinjutsuData.Fuinjutsu.setXP(XP);
        ClientFuinjutsuData.Fuinjutsu.setLVL(LVL);
        ClientFuinjutsuData.Fuinjutsu.setLVLmax(LVLmax);
    }

    public static void set_fuinjutsu(VoiesNinjas Fuinjutsu){
        ClientFuinjutsuData.Fuinjutsu = Fuinjutsu;
    }

    public static int get_LVL(){
        return Fuinjutsu.getLVL();
    }
}
