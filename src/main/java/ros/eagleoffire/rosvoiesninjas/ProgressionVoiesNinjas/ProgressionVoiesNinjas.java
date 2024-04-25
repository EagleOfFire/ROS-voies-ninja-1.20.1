package ros.eagleoffire.rosvoiesninjas.ProgressionVoiesNinjas;

import net.minecraft.nbt.CompoundTag;
import net.minecraftforge.common.capabilities.Capability;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityToken;
import net.minecraftforge.common.capabilities.RegisterCapabilitiesEvent;

import java.util.Objects;

public class ProgressionVoiesNinjas {
    private int NombreDeVoiesMaitrise = 0;

    private VoiesNinjas Fuinjutsu = new VoiesNinjas("Fuinjutsu");
    private VoiesNinjas Sensorialite = new VoiesNinjas("Sensorialite");
    private VoiesNinjas Infiltration = new VoiesNinjas("Infiltration");
    private VoiesNinjas Invocation = new VoiesNinjas("Invocation");
    private VoiesNinjas KekkeiBarriere = new VoiesNinjas("Kekkei Barriere");

    public static final Capability<ProgressionVoiesNinjasInterface> INSTANCE = CapabilityManager.get(new CapabilityToken<>() {});

    public static void register(RegisterCapabilitiesEvent event) {
        event.register(ProgressionVoiesNinjasInterface.class);
    }

    ProgressionVoiesNinjas() {
    }

    public int getXP(VoiesNinjas voiesninjas){
        checkNewLVL(Fuinjutsu);
        checkNewLVL(Sensorialite);
        checkNewLVL(Infiltration);
        checkNewLVL(Invocation);
        checkNewLVL(KekkeiBarriere);
        return voiesninjas.getXP();
    }
    public void addXP(VoiesNinjas voiesninjas, int XpPoint){
        if (voiesninjas.getXP()==0){
            ++this.NombreDeVoiesMaitrise;
        }
        voiesninjas.setXP(voiesninjas.getXP() + XpPoint);
        checkNewLVL(voiesninjas);
    }
    public void subXP(VoiesNinjas voiesninjas, int XpPoint){
        voiesninjas.setXP(Math.max(voiesninjas.getXP() - XpPoint, 0));
        checkNewLVL(voiesninjas);
        if (voiesninjas.getXP() == 0){
            --this.NombreDeVoiesMaitrise;
        }
    }
    public int getLVL(VoiesNinjas voiesninjas){
        return voiesninjas.getLVL();
    }
    public int getLVLmax(VoiesNinjas voiesninjas){
        return voiesninjas.getLVLmax();
    }

    public void saveNBTData(CompoundTag nbt){
        nbt.putInt("FuinjutsuXP", Fuinjutsu.getXP());
        nbt.putInt("SensorialiteXP", Sensorialite.getXP());
        nbt.putInt("InfiltrationXP", Infiltration.getXP());

        nbt.putInt("FuinjutsuLVL", Fuinjutsu.getLVL());
        nbt.putInt("SensorialiteLVL", Sensorialite.getLVL());
        nbt.putInt("InfiltrationLVL", Infiltration.getLVL());

        nbt.putInt("FuinjutsuLVLmax", Fuinjutsu.getLVLmax());
        nbt.putInt("SensorialiteLVLmax", Sensorialite.getLVLmax());
        nbt.putInt("InfiltrationLVLmax", Infiltration.getLVLmax());
    }
    public void loadNBTData(CompoundTag nbt){
        System.out.println("Seems to work idk at this point");
        Fuinjutsu.setXP(nbt.getInt("FuinjutsuXP"));
        Sensorialite.setXP(nbt.getInt("SensorialiteXP"));
        Infiltration.setXP(nbt.getInt("InfiltrationXP"));

        Fuinjutsu.setLVL(nbt.getInt("FuinjutsuLVL"));
        Sensorialite.setLVL(nbt.getInt("SensorialiteLVL"));
        Infiltration.setLVL(nbt.getInt("InfiltrationLVL"));
    }
    public void copyFrom(ProgressionVoiesNinjas source) {
        this.Fuinjutsu = source.Fuinjutsu;
        this.Sensorialite = source.Sensorialite;
        this.Infiltration = source.Infiltration;
    }

    private void checkNewLVL(VoiesNinjas VoieNinja){
        int XP = VoieNinja.getXP();
        int LVL = VoieNinja.getLVL();
        int maxLVL = VoieNinja.getLVLmax();
        if (XP >= 1651 && maxLVL == 5){
            if(NombreDeVoiesMaitrise == 1) {
                VoieNinja.setLVL(5);
            }
        }else if (XP >= 951 && maxLVL >= 4){
            if (NombreDeVoiesMaitrise <= 2){
                VoieNinja.setLVL(4);
            }
        }else if (XP >= 451 && maxLVL >= 3){
            if (NombreDeVoiesMaitrise <= 3) {
                VoieNinja.setLVL(3);
            }
        } else if (XP >= 151 && maxLVL >= 2){
            if (NombreDeVoiesMaitrise <= 4) {
                VoieNinja.setLVL(2);
            }
        }else if (XP >= 1 && maxLVL >= 1){
            if(NombreDeVoiesMaitrise<=5){
                VoieNinja.setLVL(1);
            }
        } else {VoieNinja.setLVL(0);}
    }

    public VoiesNinjas getByName(String name){
        if (Objects.equals(name, Fuinjutsu.getNAME())){
            return Fuinjutsu;
        }
        if (Objects.equals(name, Sensorialite.getNAME())){
            return Sensorialite;
        }
        if (Objects.equals(name, Infiltration.getNAME())){
            return Infiltration;
        }
        if (Objects.equals(name, Invocation.getNAME())){
            return Invocation;
        }
        if (Objects.equals(name, KekkeiBarriere.getNAME())){
            return KekkeiBarriere;
        }
        return null;
    }

    public void RPK(){
        this.Fuinjutsu = new VoiesNinjas("Fuinjutsu");
        this.Sensorialite = new VoiesNinjas("Sensorialite");
        this.Infiltration = new VoiesNinjas("Infiltration");
        this.Invocation = new VoiesNinjas("Invocation");
        this.KekkeiBarriere = new VoiesNinjas("Kekkei Barriere");
    }
}