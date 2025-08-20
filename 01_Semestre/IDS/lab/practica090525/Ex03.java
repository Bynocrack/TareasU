import java.util.Scanner;

public class Ex03{
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);

		float horas, pHora, extra;

		extra = 0;

		System.out.print("Digite la cantidad de horas que trabajó esta semana: ");
		horas = sc.nextFloat();
		System.out.print("Digite la paga que recibe por hora: ");
		pHora = sc.nextFloat();

		if (horas > 40) {
			horas = horas - 40;
			extra = extra + 2*horas*pHora;
			if (horas > 8) {
				horas = horas - 8;
				extra = extra + horas*pHora;
			}
		}

		System.out.print("El sueldo extra que recibira esta semana por sus horas extra es: " + extra);
	}
}
