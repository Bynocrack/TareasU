Algoritmo Ejercicio05
	Definir sueldob, sueldon, bono, escolaridad, descuento Como Real
	Definir nombre Como Caracter
	
	Escribir "Ingrese su sueldo base:"
	Leer sueldob
	Escribir "Ingrese su nombre:"
	Leer nombre
	
	bono = 0.25*sueldob
	escolaridad = 0.75*sueldob
	descuento = 0.2*escolaridad
	sueldon = sueldob+bono+escolaridad-descuento
	
	Escribir "Buenas señor ", nombre, " su sueldo neto es de ", sueldon
FinAlgoritmo
