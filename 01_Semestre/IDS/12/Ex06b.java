import java.util.*;

public class Ex06b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite el tope: ");
        int tope = sc.nextInt();
	int suma = 0;

	int i = 0;
        while (i <= tope) {
            suma += i;
	    i += 2;
        }

	System.out.println("La suma de los pares postivios hasta ahi es: " + suma);

        sc.close();
    }
}
