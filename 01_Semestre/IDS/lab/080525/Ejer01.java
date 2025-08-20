import java.util.Scanner;

public class Ejer01{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		float nota1, nota2, promedio;
		
		System.out.print("Ingrese la nota 1: ");
		nota1 = sc.nextFloat();
		System.out.print("Ingrese la nota 2: ");
		nota2 = sc.nextFloat();

		promedio = (nota1 + nota2)/2;

		System.out.print("El promedio es " + promedio);
	}
}
