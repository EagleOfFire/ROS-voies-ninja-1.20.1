package ros.eagleoffire.rosvoiesninjas.ProgressionVoiesNinjas;

public class VoiesNinjas {
    private String NAME;
    private int XP = 0;
    private int LVL = 0;
    private int LVLmax = 5;

    public VoiesNinjas(String name){
        this.NAME = name;
    }

    public String getNAME(){
        return NAME;
    }
    public int getXP(){
        return XP;
    }
    public int getLVL(){
        return LVL;
    }
    public int getLVLmax(){
        return LVLmax;
    }

    public void setXP(int xp){
        this.XP = xp;
    }
    public void setLVL(int lvl){
        this.LVL = lvl;
    }
    public void setLVLmax(int lvlmax){
        this.LVLmax = lvlmax;
    }
}
