// Laboratorio Nro 10 - Ejercicio1
// Autor: Josue Alexander Madueño Macedo
// Colaboró: nadie
// Tiempo: 5

import java.util.Scanner;

public class Ex01 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int num;

      System.out.print("Digite un número: ");
      num = sc.nextInt();

      if (num % 2 == 0){
	 System.out.print(num + " es un número par.");
      } else {
	 System.out.print(num + " es un número impar.");
      }
   }
}
