import java.util.*;

public class Ex04a {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite el tope: ");
        int tope = sc.nextInt();
        System.out.print("Digite el minimo: ");
        int min = sc.nextInt();
        int suma = 0;

        for (int i = min; i <= tope; i+=1) {
            suma += i;
        }

        System.out.print("La suma es " + suma);

        sc.close();
    }
}