package carlo1;

public class Main {
    public static void main(String[] args) {
        Tlac tlac = new Tlac(1000000, 30);
        BalikyZarobok vysledok = tlac.getNajlepsiPocetBalickov();
        System.out.println("Najlepsi pocet balickov bol: " + vysledok.baliky());
        System.out.println("A jeho navacsi zarobok: " + vysledok.zarobok());
    }
}