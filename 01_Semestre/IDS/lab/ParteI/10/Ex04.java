// Laboratorio Nro 10 - Ejercicio4
// Autor: Josue Alexander Madueño Macedo
// Colaboró: nadie
// Tiempo: 5

import java.util.Scanner;

public class Ex04 {
   public static void main (String [] args) {
      Scanner sc = new Scanner(System.in);
      int num1, num2;
      double division;

      System.out.print("Digite un número: ");
      num1 = sc.nextInt();
      System.out.print("Digite otro número: ");
      num2 = sc.nextInt();

      if (num1 >= num2) {
	 System.out.print("La suma es: " + (num1+num2) + "\nLa resta es: " + (num1-num2));
      } else {
	 division = (double) num1/num2;
	 System.out.print("La multiplicación es: " + (num1*num2) + "\nLa división es: " + (division) + "\nEl módulo es: " + (num1%num2));
      }
   }
}
