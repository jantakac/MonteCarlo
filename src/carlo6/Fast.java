package carlo6;

import OSPRNG.TriangularRNG;

public class Fast implements Auto {
    private final double cas;
    public Fast() {
        this.cas = new TriangularRNG(40.0, 50.0, 75.0).sample();
    }

    @Override
    public String toString() {
        return "Fast";
    }

    @Override
    public double getCas() {
        return this.cas;
    }
}
