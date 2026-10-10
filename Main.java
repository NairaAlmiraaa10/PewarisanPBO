public class Main {
    public static void main(String[] args) {
        BujurSangkar bujur = new BujurSangkar(2, "Merah");
        System.out.println("Sisi bujur sangkar: " + bujur.getSisi());
        bujur.printInfo();

        Lingkaran lingkaran = new Lingkaran(7, "Biru");
        System.out.println("Radius lingkaran: " + lingkaran.getRadius());
        lingkaran.printInfo();

        Silinder silinder = new Silinder(2, 7, "Hijau");
        System.out.println("Tinggi silinder: " + silinder.getTinggi());
        silinder.printInfo();

        System.out.println();
        System.out.println("=== Demo Polimorfisme ===");
        Bentuk[] daftar = new Bentuk[3];
        daftar[0] = bujur;
        daftar[1] = lingkaran;
        daftar[2] = silinder;

        for (Bentuk b : daftar) {
            b.printInfo();   
        }
    }
}
