package carlo5;

import OSPRNG.UniformContinuousRNG;
import OSPRNG.UniformDiscreteRNG;

import java.util.Arrays;

public class Vestice {

    private final int pocetReplikacii;
    private final Vestica[] vesticeArray;


    public Vestice(int pocetReplikacii) {
        this.pocetReplikacii = pocetReplikacii;
        this.vesticeArray = new Vestica[3];
        for (int i = 0; i < vesticeArray.length; i++) {
            vesticeArray[i] = new Vestica();
        }
    }


    public double testDveRovnake() {
        int zhodyDvoch = 0;
        double zodpovedanePravdy = 0.0;
        Boolean[] odpovede = new Boolean[this.vesticeArray.length];
        while (zhodyDvoch < this.pocetReplikacii) {
            for (int j = 0; j < this.vesticeArray.length; j++) {
                odpovede[j] = this.vesticeArray[j].generujOdpoved();
            }
            if (odpovede[0] == odpovede[1]) {
                zodpovedanePravdy += Arrays.stream(odpovede).limit(2).filter(b -> b).count();
                ++zhodyDvoch;
            }
        }
        return zodpovedanePravdy / zhodyDvoch / 2;
    }


    public double testTriRovnake() {
        int zhodyTroch = 0;
        double zodpovedanePravdy = 0.0;
        Boolean[] odpovede = new Boolean[this.vesticeArray.length];
        while (zhodyTroch < this.pocetReplikacii) {
            for (int j = 0; j < this.vesticeArray.length; j++) {
                odpovede[j] = this.vesticeArray[j].generujOdpoved();
            }
            if (odpovede[0] == odpovede[1] && odpovede[0] == odpovede[2]) {
                zodpovedanePravdy += Arrays.stream(odpovede).limit(2).filter(b -> b).count();
                ++zhodyTroch;
            }
        }
        return zodpovedanePravdy / zhodyTroch / 2;
    }
}
