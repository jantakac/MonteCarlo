package carlo4;

import OSPRNG.UniformDiscreteRNG;

public class Namornik2D extends Namornik {
    public Namornik2D(int krokovVReplikacii, int pocetReplikacii) {
        super(krokovVReplikacii, pocetReplikacii, new UniformDiscreteRNG(0, 3));
    }

    @Override
    public double odkrokuj() {
        int kdeSomSkoncilX = 0;
        int kdeSomSkoncilY = 0;
        for (int i = 0; i < this.getKrokovVReplikacii(); i++) {
             switch (this.getUniformDiscreteRNG().sample()) {
                 case 0:
                     ++kdeSomSkoncilX;
                     break;
                 case 1:
                     --kdeSomSkoncilX;
                     break;
                 case 2:
                     ++kdeSomSkoncilY;
                     break;
                 default:
                     --kdeSomSkoncilY;
                     break;
             }
        }
        // return Math.sqrt(Math.pow(kdeSomSkoncilX, 2) + Math.pow(kdeSomSkoncilY, 2));  toto nemoze byt pretoze sa nemoze hybat sikmo
        return Math.abs(kdeSomSkoncilX) + Math.abs(kdeSomSkoncilY);
    }
}
