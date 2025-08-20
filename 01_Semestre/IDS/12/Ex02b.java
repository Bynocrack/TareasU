import java.util.*;

public class Ex02b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite el multiplicador máximo: ");
        int max = sc.nextInt();
        System.out.print("Digite el multiplicando: ");
        int tabla = sc.nextInt();

        int i = 0;
        while (i <= max) {
            System.out.println(tabla + " x " + i + " = " + (tabla*i));
            i++;
        }

        sc.close();
    }
}