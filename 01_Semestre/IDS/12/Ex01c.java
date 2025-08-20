import java.util.*;

public class Ex01c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Digite un número: ");
        int num = sc.nextInt();

        int i = 0; 
        do {
            System.out.println("El " + (i+1) + " número entero no negativo es: " + i);
            i++;
        } while (i<num);

        sc.close();
    }
}