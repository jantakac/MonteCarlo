package carlo1;

import OSPRNG.TriangularRNG;
import OSPRNG.UniformContinuousRNG;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map.Entry;

public class Tlac {
    private static final double PLATI_TLACIARNAM = 0.15;
    private static final double DOBA_MEDZI_PREDAJOM = 2.7;
    private static final double KOEFICIENT_VYKUPU = 0.65;
    private static final int POCET_KUSOV_BALIK = 10;
    private final TriangularRNG triangularRNG;
    private final UniformContinuousRNG uniformContinuousRNG;
    HashMap<Integer, Double> balickyZarobky;


    public Tlac(int pocetReplikacii, int maxPocetBalikov) {
        this.triangularRNG = new TriangularRNG(0.25, 0.6, 0.95);
        this.uniformContinuousRNG = new UniformContinuousRNG(250.0, 420.0);
        this.balickyZarobky = new HashMap<>();
        for (int i = 1; i < maxPocetBalikov + 1; i++) {
            this.balickyZarobky.put(i, vykonajIteraciu(i, pocetReplikacii));
        }
    }

    public BalikyZarobok getNajlepsiPocetBalickov() {
        Entry<Integer, Double> maxEntry = Collections.max(this.balickyZarobky.entrySet(), Entry.comparingByValue());
        return new BalikyZarobok(maxEntry.getKey(), maxEntry.getValue());
    }

    public double vykonajIteraciu(int pocetBalikov, int pocetReplikacii) {
        double zarobkySpocitaneVIteracii = 0.0;
        for (int i = 0; i < pocetReplikacii; i++) {
            zarobkySpocitaneVIteracii += vykonajReplikaciu(pocetBalikov * POCET_KUSOV_BALIK);
        }
        return zarobkySpocitaneVIteracii / pocetReplikacii;
    }

    public double vykonajReplikaciu(int pocetKupenychNovin) {
        double cenaNovin = triangularRNG.sample();
        double casPredaja = uniformContinuousRNG.sample();
        double zaplateneTlaciarnam = PLATI_TLACIARNAM * pocetKupenychNovin;
        int pocetPredanychNovin = (int) (1 + casPredaja / DOBA_MEDZI_PREDAJOM);
        pocetPredanychNovin = Math.min(pocetPredanychNovin, pocetKupenychNovin);
        double trzbyZPredaja = pocetPredanychNovin * cenaNovin;
        double trzbyZVykupu = (pocetKupenychNovin - pocetPredanychNovin) * PLATI_TLACIARNAM * KOEFICIENT_VYKUPU;
        return trzbyZPredaja + trzbyZVykupu - zaplateneTlaciarnam;
    }
}
