Algoritmo Ejercicio09
	Definir unidades, decenas, centenas, nOriginal, nInvertido Como entero
	
	Escribir "Digite un número de tres cifras:"
	Leer nOriginal
	
	unidades = nOriginal%10
	decenas = (nOriginal%100 - unidades)/10
	centenas = (nOriginal - decenas*10 - unidades)/100
	
	nInvertido = unidades*100 + decenas*10 + centenas
	
	Escribir "El número invertido es ", nInvertido
FinAlgoritmo
