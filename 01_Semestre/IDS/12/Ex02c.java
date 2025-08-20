import java.util.*;

public class Ex02c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite el multiplicador máximo: ");
        int max = sc.nextInt();
        System.out.print("Digite el multiplicando: ");
        int tabla = sc.nextInt();

        int i = 0;
        do {
            System.out.println(tabla + " x " + i + " = " + (tabla*i));
            i++;
        } while (i <= max);

        sc.close();
    }
}
