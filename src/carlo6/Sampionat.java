package carlo6;

import java.util.HashMap;

public class Sampionat {
    private static final int POCET_PRETEKOV = 15;
    private final HashMap<String, Integer> bodovaTabulka;

    public Sampionat() {
        Pretek[] preteky = new Pretek[POCET_PRETEKOV];
        this.bodovaTabulka = new HashMap<>();
        this.bodovaTabulka.put("Fast", 0);
        this.bodovaTabulka.put("Furious", 0);
        for (int i = 0; i < POCET_PRETEKOV; i++) {
            preteky[i] = new Pretek();
            this.bodovaTabulka.put("Fast", this.bodovaTabulka.get("Fast") + preteky[i].bodyZaPretek().get("Fast"));
            this.bodovaTabulka.put("Furious", this.bodovaTabulka.get("Furious") + preteky[i].bodyZaPretek().get("Furious"));
        }
    }

    public String vyssiBodovyZisk() {
        return this.bodovaTabulka.get("Fast") > this.bodovaTabulka.get("Furious") ? "Fast" : "Furious";
    }
}
