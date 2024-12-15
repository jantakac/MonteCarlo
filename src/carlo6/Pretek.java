package carlo6;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

public class Pretek {
    private static final int POCET_AUT = 10;
    private final Auto[] trat;
    public Pretek() {
        this.trat = new Auto[POCET_AUT];
        for (int i = 0; i < POCET_AUT / 2; i++) {
            this.trat[i] = new Fast();
        }
        for (int i = POCET_AUT / 2; i < POCET_AUT; i++) {
            this.trat[i] = new Furious();
        }
    }

    private void vyhodnotPretek() {
        Arrays.sort(this.trat, Comparator.comparingDouble(Auto::getCas));
    }

    public HashMap<String, Integer> bodyZaPretek() {
        this.vyhodnotPretek();
        HashMap<String, Integer> tabulkaBodov = new HashMap<>();
        int bodyFast = 0;
        int bodyFurious = 0;
        for (int i = 0 ; i < POCET_AUT; i++) {
            if (this.trat[i].toString().equals("Fast")) {
                bodyFast += POCET_AUT - i;
            } else {
                bodyFurious += POCET_AUT - i;
            }
        }
        tabulkaBodov.put("Fast", bodyFast);
        tabulkaBodov.put("Furious", bodyFurious);
        return tabulkaBodov;
    }

    public boolean suPrveDveFast() {
        this.vyhodnotPretek();
        return Arrays.stream(this.trat).limit(2).filter(auto -> auto instanceof Fast).count() == 2;
    }
}
