package carlo6;

public class Simulacia {
    private final int pocetReplikacii;
    public Simulacia(int pocetReplikacii) {
        this.pocetReplikacii = pocetReplikacii;
    }

    public double pravdepodobnostPrveDveFast() {
        int pocetSampionatovKdeSuPrveDveFast = 0;
        for (int i = 0; i < this.pocetReplikacii; i++) {
            if (new Pretek().suPrveDveFast()) ++pocetSampionatovKdeSuPrveDveFast;
        }
        return (double)pocetSampionatovKdeSuPrveDveFast / this.pocetReplikacii;
    }

    public ZnackaPravdepodobnost lepsiVSampionatePravdepodobnost() {
        int pocetSampionatovFastVyhra = 0;
        int pocetSampionatovFuriousVyhra = 0;
        for (int i = 0; i < this.pocetReplikacii; i++) {
            if (new Sampionat().vyssiBodovyZisk().equals("Fast")) {
                ++pocetSampionatovFastVyhra;
            } else {
                ++pocetSampionatovFuriousVyhra;
            }
        }
        return new ZnackaPravdepodobnost(pocetSampionatovFastVyhra > pocetSampionatovFuriousVyhra ? "Fast" : "Furious",
                pocetSampionatovFastVyhra > pocetSampionatovFuriousVyhra ? (double)pocetSampionatovFastVyhra / this.pocetReplikacii :
                        (double)pocetSampionatovFuriousVyhra / this.pocetReplikacii);
    }
}
