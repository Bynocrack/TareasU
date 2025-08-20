// Laboratorio Nro 11 - Ejercicio1
// Autor: Josue Alexander Madueño Macedo
// Colaboró: nadie
// Tiempo: 5

import java.util.Scanner;

public class Ex03 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      double altura, base, x1, x2, y1, y2, radio;
      
      System.out.print("Digite el valor \"x\" de la primera coordenada: ");
      x1 = sc.nextDouble();
      System.out.print("Digite el valor \"y\" de la primera coordenada: ");
      y1 = sc.nextDouble();
      System.out.print("Digite el valor \"x\" de la segunda coordenada: ");
      x2 = sc.nextDouble();
      System.out.print("Digite el valor \"y\" de la segunda coordenada: ");
      y2 = sc.nextDouble();

      base = x1-x2;
      altura = y1-y2;
      if (base < 0) base = -base;
      if (altura < 0) altura = -altura;

      if (base > altura) {
	 System.out.println("Es un rectángulo bajo.");
	 radio = altura/2;
      } else if (base < altura) {
	 System.out.println("Es un rectángulo alto.");
	 radio = base/2;
      } else {
	 System.out.println("Es un rectángulo cuadrado.");
	 radio = base/2;
      }

      System.out.print("El área del círculo que se forma dentro es: " + (Math.PI*radio*radio));
   }
}
