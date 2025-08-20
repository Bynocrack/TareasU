import java.util.*;

public class Ex05a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite el tope: ");
        int tope = sc.nextInt();

        for (int i = 1; i <= tope; i+=1) {
            System.out.println(i + "\t x " + i + "\t = " + (i*i));
        }

        sc.close();
    }
}
