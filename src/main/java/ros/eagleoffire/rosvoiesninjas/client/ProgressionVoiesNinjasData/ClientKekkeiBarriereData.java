package ros.eagleoffire.rosvoiesninjas.client.ProgressionVoiesNinjasData;

import ros.eagleoffire.rosvoiesninjas.ProgressionVoiesNinjas.VoiesNinjas;

public class ClientKekkeiBarriereData {
    private static VoiesNinjas KekkeiBarriere;

    public static void set(String name, int XP, int LVL, int LVLmax){
        ClientKekkeiBarriereData.KekkeiBarriere = new VoiesNinjas(name);
        ClientKekkeiBarriereData.KekkeiBarriere.setXP(XP);
        ClientKekkeiBarriereData.KekkeiBarriere.setLVL(LVL);
        ClientKekkeiBarriereData.KekkeiBarriere.setLVLmax(LVLmax);
    }

    public static void set_KekkeiBarriere(VoiesNinjas KekkeiBarriere){
        ClientKekkeiBarriereData.KekkeiBarriere = KekkeiBarriere;
    }
}
