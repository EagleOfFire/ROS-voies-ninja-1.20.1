package ros.eagleoffire.rosvoiesninjas.client.ProgressionVoiesNinjasData;

import ros.eagleoffire.rosvoiesninjas.ProgressionVoiesNinjas.VoiesNinjas;

public class ClientInvocationData {
    private static VoiesNinjas Invocation;

    public static void set(String name, int XP, int LVL, int LVLmax){
        ClientInvocationData.Invocation = new VoiesNinjas(name);
        ClientInvocationData.Invocation.setXP(XP);
        ClientInvocationData.Invocation.setLVL(LVL);
        ClientInvocationData.Invocation.setLVLmax(LVLmax);
    }

    public static void set_Invocation(VoiesNinjas Invocation){
        ClientInvocationData.Invocation = Invocation;
    }
}
