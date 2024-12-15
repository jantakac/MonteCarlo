package carlo5;

public class Main {
    public static void main(String[] args) {
        Vestice vestice = new Vestice(10_000_000);
        System.out.println(vestice.testDveRovnake());
        System.out.println(vestice.testTriRovnake());
    }
}
