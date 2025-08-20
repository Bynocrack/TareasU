import java.util.Scanner;

public class Ex11 {
   public static void main (String[] args) {
      Scanner sc = new Scanner(System.in);
      int edad, antiguedad;

      System.out.print("Digite su edad: ");
      edad = sc.nextInt();
      System.out.print("Digite la antiguedad que tiene en su empleo (en años cumplidos): ");
      antiguedad = sc.nextInt();

      if (edad >= 60) {
	 if (antiguedad >= 25) {
	    System.out.print("Usted pertenece a la jubilación por antiguedad adulta.");
	 } else {
	    System.out.print("Usted pertenece a la jubilación por edad.");
	 }
      } else {
	 if (antiguedad >= 25) {
	    System.out.print("Usted pertenece a la jubilación por antiguedad joven.");
	 } else {
	    System.out.print("Usted no puede acceder a la jubilación.");
	 }
      }
   }
}
