import java.util.*;

public class Ex04b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite el tope: ");
        int tope = sc.nextInt();
        System.out.print("Digite el minimo: ");
        int min = sc.nextInt();
        int suma = 0;

        int i = min;
        while (i <= tope) {
            suma += i;
            i += 1;
        }

        System.out.print("La suma es " + suma);

        sc.close();
    }
}