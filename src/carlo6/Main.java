package carlo6;

public class Main {
    public static void main(String[] args) {
        Simulacia simulacia = new Simulacia(1_000_000);
        System.out.println(simulacia.pravdepodobnostPrveDveFast());
        System.out.println(simulacia.lepsiVSampionatePravdepodobnost());
    }
}
