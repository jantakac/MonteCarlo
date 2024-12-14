package carlo2;

public class Main {
    public static void main(String[] args) {
        Remeselnik remeselnik = new Remeselnik(1000000);
        Vysledky vysledky = remeselnik.vykonajIteracieAB();
        System.out.format("A - %f, B - %f\n", vysledky.a(), vysledky.b());
    }
}
