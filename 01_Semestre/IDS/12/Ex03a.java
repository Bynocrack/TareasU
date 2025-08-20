import java.util.*;

public class Ex03a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite el tope: ");
        int tope = sc.nextInt();
        System.out.print("Digite el minimo: ");
        int min = sc.nextInt();

        for (int i = min; i <= tope; i+=2) {
            if (i % 2 == 0)
                i += 1;
            System.out.println(i + " es un número impar en ese rango");
        }

        sc.close();
    }
}