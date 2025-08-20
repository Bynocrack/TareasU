import java.util.*;

public class Ex09b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

	double num, numPont;

        while (true) {
           System.out.print("Digite un número: ");
	   num = sc.nextDouble();

	   numPont = num*(Math.random()+1.1);
	   System.out.println("El computador ganó! (" + num + " < " + numPont + ")");
        }
    }
}
