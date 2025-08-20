import java.util.*;

public class Ex05c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite el tope: ");
        int tope = sc.nextInt();

	int i = 1;
        do {
            System.out.println(i + "\t x " + i + "\t = " + (i*i));
	    i++;
        } while (i <= tope);

        sc.close();
    }
}
