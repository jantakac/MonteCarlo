package carlo3;

import OSPRNG.UniformContinuousRNG;

public class OdhadovacPi {
    private static final double POLOMER_KRUHU = 0.5;
    private static final double STRED_X = 0.5;
    private static final double STRED_Y = 0.5;
    private static final double R_NA2 = Math.pow(POLOMER_KRUHU, 2);
    private final UniformContinuousRNG xGen;
    private final UniformContinuousRNG yGen;
    private final double maxChybaOdhadu;
    public OdhadovacPi(double maxChybaOdhadu) {
        this.xGen = new UniformContinuousRNG(0.0, 1.0);
        this.yGen = new UniformContinuousRNG(0.0, 1.0);
        this.maxChybaOdhadu = maxChybaOdhadu;
        System.out.printf("pokusov pre dosiahnutie pi na zadanu presnost %d\n", this.pocetPokusovPiDoPresnosti());
    }

    public int pocetPokusovPiDoPresnosti() {
        int padnutychDoKruhu = 0;
        int i = 0;
        double piZatial;
        do {
            if (hodDoStvorca()) ++padnutychDoKruhu;
            ++i;
            piZatial = (double) padnutychDoKruhu / i / R_NA2;
        } while (!(piZatial < Math.PI + this.maxChybaOdhadu) || !(piZatial > Math.PI - this.maxChybaOdhadu));
        return i;
    }

    public boolean hodDoStvorca() {
        return (Math.pow(this.xGen.sample() - STRED_X, 2) + Math.pow(this.yGen.sample() - STRED_Y, 2)) <= R_NA2;
    }
}
