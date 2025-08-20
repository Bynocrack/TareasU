import java.util.*;

public class Ex08b {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nota = 0, total = 0;
	double suma = 0;

        while (true) {
           System.out.print("Digite una nota (-1 cierra el programa): ");
	   nota = sc.nextInt();
	   if (nota == -1) 
	      break;
	   suma += nota;
	   total++;
        }
	double prom = 0;

	if (total != 0)
	   prom = suma/total;

	System.out.print("El promedio es: " + prom);

        sc.close();
    }
}
