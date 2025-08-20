Algoritmo Ex04
	Definir dias, horas, minutos, seg como entero
	
	Escribir "Digite un número de días:"
	Leer dias
	Escribir "Digite un número de horas:"
	Leer horas
	Escribir "Digite un número de minutos:"
	Leer minutos
	Escribir "Digite un número de segundos:"
	Leer seg
	
	seg = ((dias*24 + horas)*60 + minutos)*60 + seg
	
	Escribir "Ese tiempo en segundos es: ", seg
FinAlgoritmo
