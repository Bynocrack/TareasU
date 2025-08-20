import java.util.Scanner;

public class Ejer02{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		int edad;
		
		System.out.print("Ingrese su edad:");
		edad = sc.nextInt();

		if (edad >= 18){
			System.out.println("Usted es mayor de edad");
			System.out.println("Usted puede emitir su voto");
		} else {
			System.out.print("Usted es menor de edad");
		}
	}
}
