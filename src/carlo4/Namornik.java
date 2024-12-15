package carlo4;

import OSPRNG.UniformDiscreteRNG;

public abstract class Namornik {
    private final int krokovVReplikacii;
    private final int pocetReplikacii;
    private final UniformDiscreteRNG uniformDiscreteRNG;
    public Namornik(int krokovVReplikacii, int pocetReplikacii, UniformDiscreteRNG uniformDiscreteRNG) {
        this.krokovVReplikacii = krokovVReplikacii;
        this.pocetReplikacii = pocetReplikacii;
        this.uniformDiscreteRNG = uniformDiscreteRNG;
    }

    public UniformDiscreteRNG getUniformDiscreteRNG() {
        return uniformDiscreteRNG;
    }

    public int getKrokovVReplikacii() {
        return krokovVReplikacii;
    }

    public int getPocetReplikacii() {
        return pocetReplikacii;
    }

    public abstract double odkrokuj();

    public double vykonajSimulaciu() {
        double kdeSomSkoncilNascitane = 0.0;
        for (int i = 0; i < this.getPocetReplikacii(); i++) {
            kdeSomSkoncilNascitane += this.odkrokuj();
        }
        return kdeSomSkoncilNascitane / this.getPocetReplikacii();
    }
}
