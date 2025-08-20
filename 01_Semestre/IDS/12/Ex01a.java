import java.util.*;

public class Ex01a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite un número: ");
        int num = sc.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.println("El " + (i+1) + " número entero no negativo es: " + i);
        }

        sc.close();
    }
}