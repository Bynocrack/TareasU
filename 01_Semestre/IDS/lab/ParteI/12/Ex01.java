// Laboratorio Nro 12 - Ejercicio1
// Autor: Josue Alexander Madueño Macedo
// Colaboró: nadie
// Tiempo: 5

import java.util.Scanner;

public class Ex01 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int x1, x2, x3, x4, y1, y2, y3, y4, Ax1, Ay1, Ax2, Ay2, Bx1, By1, Bx2, By2;

      System.out.println("Ingrese los datos del rectángulo 1: ");
      System.out.print("X1: "); x1 = sc.nextInt();
      System.out.print("Y1: "); y1 = sc.nextInt();
      System.out.print("X2: "); x2 = sc.nextInt();
      System.out.print("Y2: "); y2 = sc.nextInt();
      System.out.println("\nIngrese los datos del rectángulo 2: ");
      System.out.print("X1: "); x3 = sc.nextInt();
      System.out.print("Y1: "); y3 = sc.nextInt();
      System.out.print("X2: "); x4 = sc.nextInt();
      System.out.print("Y2: "); y4 = sc.nextInt();

      Ax1 = Math.min(x1, x2);
      Ay1 = Math.min(y1, y2);
      Ax2 = Math.max(x1, x2);
      Ay2 = Math.max(y1, y2);
      Bx1 = Math.min(x3, x4);
      By1 = Math.min(y3, y4);
      Bx2 = Math.max(x3, x4);
      By2 = Math.max(y3, y4);

      if (Ax2 < Bx1 || Bx2 < Ax1 || Ay2 < By1 || By2 < Ay1) {
	 System.out.print("Son disjuntos!");
      } else {
	 System.out.print("Colisionan!");
      }
   }
}
