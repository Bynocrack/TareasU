import java.util.*;

public class Ex07a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite el tope: ");
        int tope = sc.nextInt();
        System.out.print("Digite el minimo: ");
        int min = sc.nextInt();

        System.out.print("Digite un número: ");
        int num = sc.nextInt();
        int i;

        for (i = 1; (min > num || num > tope); i++) {
            System.out.print("Digite un número: ");
            num = sc.nextInt();
        }
        System.out.print("El número de intentos fue: " + i);

        sc.close();
    }
}