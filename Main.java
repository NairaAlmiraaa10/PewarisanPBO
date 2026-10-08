public class Main {
    public static void main(String[] args) {
        BujurSangkar bujur = new BujurSangkar(2, "Merah");
        bujur.getSisi();
        bujur.printInfo();

        Lingkaran lingkaran = new Lingkaran(7, "Biru");
        lingkaran.getRaius();
        lingkaran.printInfo();

        Silinder silinder = new Silinder(10, 7, "Hijau");
        silinder.getTinggi();
        silinder.printInfo();
    }

    
}
