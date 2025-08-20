import java.util.*;

public class Ex07c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite el tope: ");
        int tope = sc.nextInt();
        System.out.print("Digite el minimo: ");
        int min = sc.nextInt();

        System.out.print("Digite un número: ");
        int num = sc.nextInt();
        int i = 1;

        do {
            System.out.print("Digite un número: ");
            num = sc.nextInt();
            i++;
        } while (min > num || num > tope);
        System.out.print("El número de intentos fue: " + i);

        sc.close();
    }
}