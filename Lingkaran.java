public class Lingkaran extends Bentuk {
    protected  double radius, PI  = 3.1428;
    public Lingkaran (double radius, String warna){
       super(warna);
       this.radius = radius; 
    }
    public double getRaius (){
        return radius;
    }
    public void setRadius(double r){
        radius = r;
    }
    double hitungLuas (){
        return PI * radius * radius;
    }
    public void printInfo(){
        System.out.println ("Lingkaran "+ warna + ", luas = "+ hitungLuas());
    }
}
