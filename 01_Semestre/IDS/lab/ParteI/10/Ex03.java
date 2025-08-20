// Laboratorio Nro 10 - Ejercicio3
// Autor: Josue Alexander Madueño Macedo
// Colaboró: nadie
// Tiempo: 5

import java.util.Scanner;

public class Ex03 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      float lab, teoria;

      System.out.print("Digite su nota de teoria: ");
      teoria = sc.nextFloat();
      System.out.print("Digite su nota de laboratorio: ");
      lab = sc.nextFloat();

      if (10.5 > (teoria*0.75 + lab*0.25)) {
	 System.out.print("Usted esta reprobado.");
      } else {
	 System.out.print("Usted esta aprobado.");
      }
   }
}
