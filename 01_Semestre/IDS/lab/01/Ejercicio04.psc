Algoritmo Ejercicio04
	Definir hijos como Entero
	Definir sueldoi, sueldof Como Real
	Escribir "Digite su sueldo:"
	Leer sueldoi
	Escribir "Digite la cantidad de hijos que tiene"
	Leer hijos
	
	sueldof = sueldoi + sueldoi*0.02*hijos
	sueldof = sueldof - sueldof*0.01*hijos
	
	Escribir "Su sueldo neto es de ", sueldof
FinAlgoritmo
