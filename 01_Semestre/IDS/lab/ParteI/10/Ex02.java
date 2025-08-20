// Laboratorio Nro 10 - Ejercicio2
// Autor: Josue Alexander Madueño Macedo
// Colaboró: nadie
// Tiempo: 5

import java.util.Scanner;

public class Ex02 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      double peso, altura;

      System.out.print("Digite su peso en Kg: ");
      peso = sc.nextDouble();
      System.out.print("Digite su altura en metros: ");
      altura = sc.nextDouble();

      if (25 > (peso/(altura*altura))) {
	 System.out.print("Usted no tiene sobrepeso.");
      } else {
	 System.out.print("Usted tiene sobrepeso.");
      }
   }
}
