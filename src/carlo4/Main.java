package carlo4;

public class Main {
    public static void main(String[] args) {
        Namornik1D n1d = new Namornik1D(1000, 100000);
        System.out.printf("%f, %f\n", n1d.vykonajSimulaciu(), Math.sqrt(2*1000 / Math.PI));
        Namornik2D n2d = new Namornik2D(1000, 100000);
        System.out.printf("%f, %f\n", n2d.vykonajSimulaciu(), Math.sqrt(4*1000 / Math.PI));
        Namornik3D n3d = new Namornik3D(1000, 100000);
        System.out.printf("%f %f\n", n3d.vykonajSimulaciu(), Math.sqrt(6*1000 / Math.PI));
    }
}
