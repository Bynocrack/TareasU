import java.util.*;

public class Ex01b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite un número: ");
        int num = sc.nextInt();

        int i = 0; 
        while (i < num) {
            System.out.println("El " + (i+1) + " número entero no negativo es: " + i);
            i++;
        }

        sc.close();
    }
}