package carlo2;

import OSPRNG.TriangularRNG;
import OSPRNG.UniformDiscreteRNG;

public class Remeselnik {
    private static final int MAX_VYROBKOV_A = 70;
    private static final int MAX_VYROBKOV_B = 90;
    private static final int CENA_A = 3;
    private static final int CENA_B = 2;
    private final TriangularRNG triangularRNGA;
    private final TriangularRNG triangularRNGB;
    private final UniformDiscreteRNG uniformDiscreteRNGA;
    private final UniformDiscreteRNG uniformDiscreteRNGB;
    private final int pocetReplikacii;
    public Remeselnik(int pocetReplikacii) {
        this.pocetReplikacii = pocetReplikacii;
        this.triangularRNGA = new TriangularRNG(1.0, 1.75, 2.5);
        this.triangularRNGB = new TriangularRNG(0.7, 1.2, 1.7);
        this.uniformDiscreteRNGA = new UniformDiscreteRNG(40, 79);
        this.uniformDiscreteRNGB = new UniformDiscreteRNG(66, 154);
    }

    public Vysledky vykonajIteracieAB() {
        double nascitaneTrzbyA = 0;
        double nascitaneTrzbyB = 0;
        for (int i = 0; i < this.pocetReplikacii; i++) {
            nascitaneTrzbyA += this.vykonajReplikaciuA(this.triangularRNGA.sample(), this.uniformDiscreteRNGA.sample());
        }
        for (int i = 0; i < this.pocetReplikacii; i++) {
            nascitaneTrzbyB += this.vykonajReplikaciuB(this.triangularRNGB.sample(), this.uniformDiscreteRNGB.sample());
        }
        return new Vysledky(nascitaneTrzbyA / this.pocetReplikacii, nascitaneTrzbyB / this.pocetReplikacii);
    }

    public double vykonajReplikaciuA(double cenaNakladyNaJeden, int dopyt) {
        return dopyt < MAX_VYROBKOV_A ? dopyt * CENA_A - cenaNakladyNaJeden * MAX_VYROBKOV_A : MAX_VYROBKOV_A * CENA_A - cenaNakladyNaJeden * MAX_VYROBKOV_A;
    }

    public double vykonajReplikaciuB(double cenaNakladyNaJeden, int dopyt) {
        return dopyt < MAX_VYROBKOV_B ? dopyt * CENA_B - cenaNakladyNaJeden * MAX_VYROBKOV_B : MAX_VYROBKOV_B * CENA_B - cenaNakladyNaJeden * MAX_VYROBKOV_B;
    }

}
