import java.util.Scanner;

public class Ex05 {
	public static void main (String[] args) {
		Scanner sc = new Scanner(System.in);
		float tHora, horas, costo;

		System.out.print("Digite la cantidad de horas que se estacionó: ");
		horas = sc.nextFloat();
		System.out.print("Digite la tarifa por hora que se aplica para su vehiculo: ");
		tHora = sc.nextFloat();

		costo = horas*tHora;

		if (horas > 1) {
			horas = horas - 1;
			costo = costo - (horas*tHora)*3/20;
		}

		System.out.print("El costo de su estacionamiento es de: " + costo);
	}
}
