import java.util.*;

public class Ex06a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite el tope: ");
        int tope = sc.nextInt();
	int suma = 0;

        for (int i = 0; i <= tope; i += 2) {
            suma += i;
        }

	System.out.println("La suma de los pares postivios hasta ahi es: " + suma);

        sc.close();
    }
}
