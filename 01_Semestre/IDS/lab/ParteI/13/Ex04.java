// Laboratorio Nro 13 - Ejercicio4
// Autor: Josue Alexander Madueño Macedo
// Colaboró: nadie
// Tiempo: 5

import java.util.Scanner;

public class Ex01 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      double lado1, lado2, lado3;
      
      System.out.print("Digite el valor del primer lado: ");
      lado1 = sc.nextDouble();
      System.out.print("Digite el valor del segundo lado: ");
      lado2 = sc.nextDouble();
      System.out.print("Digite el valor del tercer lado: ");
      lado3 = sc.nextDouble();

      if (lado1+lado2 > lado3 && lado1+lado3 > lado2 && lado2+lado3 > lado1) {
	 if (lado1 == lado2 && lado1 == lado3) {
	    System.out.print("Es un triángulo equilátero.");
	 } else if (lado1 == lado2 || lado1 == lado3 || lado2 == lado3) {
	    System.out.print("Es un triángulo isósceles.");
	 } else {
	    System.out.print("Es un triángulo escaleno.");
	 }
      } else {
	 System.out.print("No es un triángulo válido.");
      }
   }
}
