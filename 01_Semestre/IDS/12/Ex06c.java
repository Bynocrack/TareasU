import java.util.*;

public class Ex06c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite el tope: ");
        int tope = sc.nextInt();
	int suma = 0;

	int i = 0;
        do {
            suma += i;
	    i += 2;
        } while (i <= tope);

	System.out.println("La suma de los pares postivios hasta ahi es: " + suma);

        sc.close();
    }
}
