Algoritmo Ex06
	Definir num, numi, u, d, c, m Como Entero
	
	Escribir "Digite un número de 4 cifras:"
	Leer num
	
	u = num%10
	d = num%100 - u
	c = (num%1000 - d - u)/10
	m = (num- 10*c - d - u)/1000
	numi = 1000*u + 10*d + c + m
	
	Escribir "El número invertido es: ", numi
FinAlgoritmo
