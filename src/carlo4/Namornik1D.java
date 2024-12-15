package carlo4;

import OSPRNG.UniformDiscreteRNG;

public class Namornik1D extends Namornik {

    public Namornik1D(int krokovVReplikacii, int pocetReplikacii) {
        super(krokovVReplikacii, pocetReplikacii, new UniformDiscreteRNG(0, 1));
    }

    @Override
    public double odkrokuj() {
        int kdeSomSkoncil = 0;
        for (int i = 0; i < this.getKrokovVReplikacii(); i++) {
            kdeSomSkoncil += this.vykonajKrok();
        }
        return Math.abs(kdeSomSkoncil);
    }

    public int vykonajKrok() {
        return this.getUniformDiscreteRNG().sample() == 0 ? 1 : -1;
    }


}
