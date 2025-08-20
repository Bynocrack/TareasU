import java.util.*;

public class Ex09c {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

	double num, numPont;

        do {
           System.out.print("Digite un número: ");
	   num = sc.nextDouble();

	   numPont = num*(Math.random()+1.1);
	   System.out.println("El computador ganó! (" + num + " < " + numPont + ")");
        } while (true);
    }
}
