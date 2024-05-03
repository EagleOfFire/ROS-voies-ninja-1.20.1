package ros.eagleoffire.rosvoiesninjas.client.ProgressionVoiesNinjasData;

import ros.eagleoffire.rosvoiesninjas.ProgressionVoiesNinjas.VoiesNinjas;

public class ClientInfiltrationData {
    private static VoiesNinjas Infiltration;

    public static void set(String name, int XP, int LVL, int LVLmax){
        ClientInfiltrationData.Infiltration = new VoiesNinjas(name);
        ClientInfiltrationData.Infiltration.setXP(XP);
        ClientInfiltrationData.Infiltration.setLVL(LVL);
        ClientInfiltrationData.Infiltration.setLVLmax(LVLmax);
    }

    public static void set_Infiltration(VoiesNinjas Infiltration){
        ClientInfiltrationData.Infiltration = Infiltration;
    }
}
