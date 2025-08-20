import java.util.Scanner;

public class Ex07 {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      double sBase, venta1, venta2, comisiones, sFinal;

      System.out.print("Digite su sueldo base: ");
      sBase = sc.nextDouble();
      System.out.print("Digite el valor de la primera venta: ");
      venta1 = sc.nextDouble();
      System.out.print("Digite el valor de la segunda venta: ");
      venta2 = sc.nextDouble();

      comisiones = (venta1 + venta2)*0.15;
      sFinal = sBase + comisiones;

      System.out.println("Su ganancia en comisiones es de " + comisiones);
      System.out.println("Su sueldo final es de " + sFinal);
   }
}
