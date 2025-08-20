import java.util.*;

public class Ex02a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite el multiplicador máximo: ");
        int max = sc.nextInt();
        System.out.print("Digite el multiplicando: ");
        int tabla = sc.nextInt();

        for (int i = 0; i <= max; i++) {
            System.out.println(tabla + " x " + i + " = " + (tabla*i));
        }

        sc.close();
    }
}
