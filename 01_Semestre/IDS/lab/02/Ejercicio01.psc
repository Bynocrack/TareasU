Algoritmo Ejercicio01
	// Calcular el pago semanal neto de un trabajador. Los datos a ingresar son: total de horas trabajadas a la semana y el pago por hora.
	// Si el total de horas trabajadas a la semana es mayor que 40 la diferencia se considera como horas extras y se paga un 50% más que
	// una hora normal, Si el sueldo semanal es mayor a 500, se descuenta 20 soles en caso contrario el descuento es 0
	
	// Entrada:
	// pago por hora -> pHora
	// total de horas trabajadas -> horas
	
	// Salida:
	// pago semanal neto <- sueldo
	
	Definir sueldo, pHora, horas Como Real
	
	Escribir "Digite la cantidad de horas que trabajo esta semana:"
	Leer horas
	Escribir "Digite su pago por hora:"
	Leer pHora
	
	sueldo = pHora*horas
	
	Si horas > 40 Entonces
		sueldo = sueldo + (horas-40)*pHora*1/2
	FinSi
	Si sueldo > 500 Entonces
		sueldo = sueldo - 20
	FinSi
	
	Escribir "Su pago semanal neto es de ", sueldo
	
FinAlgoritmo
