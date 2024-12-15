package carlo6;

import OSPRNG.TriangularRNG;

public class Furious implements Auto {
    private final double cas;

    public Furious() {
        this.cas = new TriangularRNG(35.0, 52.0, 80.0).sample();
    }

    @Override
    public String toString() {
        return "Furious";
    }

    @Override
    public double getCas() {
        return this.cas;
    }
}
