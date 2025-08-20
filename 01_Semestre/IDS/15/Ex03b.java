import java.util.Scanner;

public class Ex03b {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      double x1, x2, y1, y2, d;

      System.out.print("Digite el valor de la coordenada \"x\" de Starbucks: ");
      x1 = sc.nextDouble();
      System.out.print("Digite el valor de la coordenada \"y\" de Starbucks: ");
      y1 = sc.nextDouble();
      System.out.print("Digite el valor de la coordenada \"x\" del turista: ");
      x2 = sc.nextDouble();
      System.out.print("Digite el valor de la coordenada \"y\" del turista: ");
      y2 = sc.nextDouble();

      System.out.print("La distancia entre los dos es de: " + cDistancia(x1, y1, x2, y2) + " unidades");
   }
   public static double cDistancia(double x1, double y1, double x2, double y2) {
      return Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
   }
}
