public class Rectangulo {
   private double altura;
   private double base;
   private double area;
   private double perimetro;
   private boolean esCuadrado;

   public Rectangulo (double h) { altura = h; }
   public Rectangulo (double h, double b) {
      altura = h;
      base = b;
   }
   public Rectangulo (double h, double b, boolean simetrico) {
      altura = h;
      base = b;
      esCuadrado = simetrico;
   }
   public void calcularArea() { area = altura*base; }
   public void calcularPerimetro() { perimetro = 2*(altura+base); }
   public void verificar() { esCuadrado = (altura == base); }
   public void setBase (double b) { base = b; }
   public void setAltura (double h) { altura = h; }
   public double getBase () { return base; }
   public double getAltura () { return altura; } 
   public double getArea () { return area; }
   public double getPerimetro () { return perimetro; }
   public boolean getEsCuadrado () { return esCuadrado; }
}
