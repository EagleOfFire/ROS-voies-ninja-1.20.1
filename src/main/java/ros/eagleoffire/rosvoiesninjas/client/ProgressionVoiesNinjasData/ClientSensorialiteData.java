package ros.eagleoffire.rosvoiesninjas.client.ProgressionVoiesNinjasData;

import ros.eagleoffire.rosvoiesninjas.ProgressionVoiesNinjas.VoiesNinjas;

public class ClientSensorialiteData {
    private static VoiesNinjas Sensorialite;

    public static void set(String name, int XP, int LVL, int LVLmax){
        ClientSensorialiteData.Sensorialite = new VoiesNinjas(name);
        ClientSensorialiteData.Sensorialite.setXP(XP);
        ClientSensorialiteData.Sensorialite.setLVL(LVL);
        ClientSensorialiteData.Sensorialite.setLVLmax(LVLmax);
    }

    public static void set_Sensorialite(VoiesNinjas Sensorialite){
        ClientSensorialiteData.Sensorialite = Sensorialite;
    }
}
