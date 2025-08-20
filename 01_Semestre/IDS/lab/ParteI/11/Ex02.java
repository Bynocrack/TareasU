// Laboratorio Nro 11 - Ejercicio2
// Autor: Josue Alexander Madueño Macedo
// Colaboró: nadie
// Tiempo: 5

import java.util.Scanner;

public class Ex02 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      double lado1, lado2, lado3, x1, x2, x3, y1, y2, y3;
      
      System.out.print("Digite el valor \"x\" del primer vértice: ");
      x1 = sc.nextDouble();
      System.out.print("Digite el valor \"y\" del primer vértice: ");
      y1 = sc.nextDouble();
      System.out.print("Digite el valor \"x\" del segundo vértice: ");
      x2 = sc.nextDouble();
      System.out.print("Digite el valor \"y\" del segundo vértice: ");
      y2 = sc.nextDouble();
      System.out.print("Digite el valor \"x\" del tercer vértice: ");
      x3 = sc.nextDouble();
      System.out.print("Digite el valor \"y\" del tercer vértice: ");
      y3 = sc.nextDouble();

      lado1 = Math.sqrt((x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
      lado2 = Math.sqrt((x1-x3)*(x1-x3)+(y1-y3)*(y1-y3));
      lado3 = Math.sqrt((x2-x3)*(x2-x3)+(y2-y3)*(y2-y3));

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
