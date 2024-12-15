package carlo5;

import OSPRNG.TriangularRNG;
import OSPRNG.UniformDiscreteRNG;

public class Vestica {

    private final UniformDiscreteRNG uniformDiscreteRNG;
    private final TriangularRNG triangularRNG;


    public Vestica() {
        this.uniformDiscreteRNG = new UniformDiscreteRNG(0, 99);
        this.triangularRNG = new TriangularRNG(30.0, 80.0, 100.0);

    }


    public boolean generujOdpoved() {
        return this.uniformDiscreteRNG.sample() < this.triangularRNG.sample();
    }
}
