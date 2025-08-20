Algoritmo Ejercicio08
	Definir lCuadrado, sAreas, sPerimetros Como Real
	
	Escribir "Digite la longitud del lado del cuadrado:"
	Leer lCuadrado
	
	// - Haciendo pruebas descubrí que pseint viene con la constante pi ya declarada, por lo que la usare para hacer los calculos mas precisos -
	
	// area cuadrado = lCuadrado*lCuadrado
	// area circulo = pi*(lCuadrado/2)*(lCuadrado/2) = pi*lCuadrado*lCuadrado/4
	// suma areas = lCuadrado*lCuadrado + 3.1416*lCuadrado*lCuadrado/4 = lCuadrado*lCuadrado*(1 + pi/4)
	sAreas = lCuadrado*lCuadrado*(1 + pi/4)
	
	// perimetro cuadrado = 4*lCuadrado
	// perimetro circulo = 2*pi*lCuadrado/2 = pi*lCuadrado
	// suma perimetros = 4*lCuadrado + pi*lCuadrado = lCuadrado*(4 + pi)
	sPerimetros = lCuadrado*(4 + pi)
	
	Escribir "La suma de las áreas es ", sAreas
	Escribir "La suma de los perimetros es ", sPerimetros
FinAlgoritmo
