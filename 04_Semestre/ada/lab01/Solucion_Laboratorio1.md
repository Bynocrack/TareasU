# SOLUCIÓN — GUÍA DE LABORATORIO 1

**Asignatura:** Análisis y Diseño de Algoritmos
**Práctica N.º 1:** Algoritmos: Definición, características, corrección y eficiencia
**Año lectivo:** 2025-B | **Semestre:** IV
**Tipo:** Individual

---

## III. EJERCICIOS PROPUESTOS

> Todos los programas fueron compilados con `g++` y ejecutados para verificar su
> correctitud y medir tiempos reales (`codigo/*.cpp`).

---

### 1. Problema numérico: Cálculo del Máximo Común Divisor (MCD)

Se desea calcular el Máximo Común Divisor de dos números enteros positivos **mediante dos
funciones**: una que usa el **método de Euclides** (divisiones sucesivas) y otra que usa
**bucles** (probar divisores de forma descendente). Luego se comparan los tiempos de
ejecución de ambos métodos.

#### Código en C++

```cpp
#include <iostream>
#include <chrono>
using namespace std;

int mcdEuclides(int a, int b, long long &divisiones) {
  divisiones = 0;
  while (b != 0) {
    int resto = a % b;
    a = b;
    b = resto;
    divisiones++;
  }
  return a;
}

int mcdBucle(int a, int b, long long &iteraciones) {
  int min = (a < b) ? a : b;
  int mcd = 1;
  iteraciones = 0;
  for (int i = min; i >= 1; i--) {
    iteraciones++;
    if (a % i == 0 && b % i == 0) {
      mcd = i;
      break;
    }
  }
  return mcd;
}
```

#### Análisis de eficiencia — Método de Euclides

1. **Mejor caso – Ω grande (Omega) → Límite inferior**
   Cuando el número menor divide exactamente al mayor, basta **una sola división**.
   - Ejemplo: `mcd(48, 36) = 12` → `48 % 12 == 0`, solo 2 divisiones.
   - Mejor caso: **Ω(1)**.

2. **Peor caso – O grande (O) → Límite superior**
   Ocurre cuando los números son **números de Fibonacci consecutivos** (p. ej. `F_k` y `F_{k−1}`).
   En cada división el resto es aproximadamente `0.618` veces el divisor, así que el tamaño se
   reduce con el factor áureo `φ ≈ 1.618`. Para resolver el MCD bastan del orden de
   `log_φ(a)` divisiones.
   - Peor caso: **O(log n)**, donde `n = min(a, b)`.

3. **Caso promedio – Θ grande (Theta) → Ajuste exacto**
   Para números aleatorios se necesita un número de divisiones del mismo orden logarítmico.
   - Caso promedio: **Θ(log n)**.

#### Análisis de eficiencia — Método con bucles

1. **Mejor caso – Ω grande (Omega) → Límite inferior**
   Si el MCD es el propio número menor (un divisor del otro), se encuentra a la primera.
   - Ejemplo: `mcd(100, 75) = 25`, empieza en 100 y baja; encuentra 25.
   - Mejor caso: **Ω(1)**.

2. **Peor caso – O grande (O) → Límite superior**
   Si los números son coprimos (`mcd = 1`), el bucle debe probar **todos** los candidatos
   desde `min(a,b)` hasta `1`.
   - Ejemplo: `mcd(1000003, 1000000) = 1` → recorre 1,000,000 de valores.
   - Peor caso: **O(n)**, con `n = min(a, b)`.

3. **Caso promedio – Θ grande (Theta) → Ajuste exacto**
   En promedio hay que probar una fracción del rango, del mismo orden lineal.
   - Caso promedio: **Θ(n)**.

#### Comparación de los dos métodos

| Criterio                | Euclides                                    | Bucle (fuerza bruta)              |
|-------------------------|---------------------------------------------|-----------------------------------|
| Idea básica             | Divide sucesivamente hasta que el resto es 0 | Prueba divisores de `min` hacia abajo |
| Mejor caso (Ω)          | Ω(1) → un divisor divide al otro            | Ω(1) → el menor es el MCD         |
| Peor caso (O)           | O(log n) → pares de Fibonacci consecutivos  | O(n) → números coprimos           |
| Caso promedio (Θ)       | Θ(log n)                                    | Θ(n)                              |
| Número de pasos (a=10⁶) | Menos de 20 divisiones                      | Hasta 1,000,000 de iteraciones    |
| Máx. divisiones (32 bits)| ≈ 45 (Lema de Lamé)                        | Hasta 2 147 483 647               |
| Ventajas                | Muy rápido, fácil de implementar            | Sencillo de entender              |
| Desventajas             | Requiere entender el algoritmo              | Muy lento para números grandes    |

#### Resultados de la ejecución

```
=== Correctitud (comparacion de resultados) ===
MCD(48, 36)       Euclides = 12 (2 divisiones)
MCD(48, 36)       Bucle    = 12 (25 iteraciones)
MCD(100, 75)      Euclides = 25 (2 divisiones)
MCD(100, 75)      Bucle    = 25 (51 iteraciones)
MCD(1000003, 1000000) Euclides = 1 (3 divisiones)
MCD(1000003, 1000000) Bucle    = 1 (1000000 iteraciones)

=== Peor caso de Euclides: pares de Fibonacci consecutivos ===
MCD(6765, 4181)   Euclides = 1 (18 divisiones)
MCD(10946, 6765)  Euclides = 1 (19 divisiones)
MCD(2147483647, 1836311903) Euclides = 1 (20 divisiones)

=== Comparacion de tiempo de ejecucion ===
Euclides (2000000 llamadas): 7 ms
Bucle    (100 llamadas, cada una con ~1,000,000 de pasos): 129 ms
```

Observación: con 2 millones de llamadas, Euclides tardó **7 ms**; el bucle, con solo
100 llamadas y entradas modestas (~10⁶), tardó **129 ms** (≈ 2000 veces más por MCD resuelto,
y la diferencia crece sin límite con `n`).

#### ¿Cuántas divisiones como máximo realiza el algoritmo de Euclides?

El **peor caso** ocurre cuando los dos números son **números de Fibonacci consecutivos**
(`mcd(F_k, F_{k-1})` requiere `k−2` divisiones), según el **Lema de Lamé**: el número de
divisiones es a lo más `5 × (número de dígitos decimales del número menor)`.

Como `F_k ≈ φ^k / √5`, se tiene que `k ≈ log_φ(min(a,b)) ≈ 1.44 · log₂(min(a,b))`.
Para números de 32 bits (`min ≤ 2 147 483 647`) el máximo teórico es **≈ 45 divisiones**;
para números de 64 bits, **≈ 92**. En la práctica, incluso con el MCD de
`2147483647` y `1836311903` (ambos ≈ 10⁹), solo se necesitaron **20 divisiones**.

---

### 2. Problema de búsqueda: búsqueda de cadenas en un texto y en una lista ordenada

Se desea determinar si una **palabra** se encuentra dentro de un **texto**. Se comparan dos
estrategias: (a) el **método simple** (deslizar la palabra por cada posición del texto y
comparar carácter a carácter) y (b) la **búsqueda binaria** en una **lista ordenada** de
palabras.

#### Código en C++

```cpp
#include <iostream>
#include <string>
#include <chrono>
#include <cstdio>
using namespace std;

// Método simple: recorrer el texto posición por posición.
int buscarEnTexto(const string &texto, const string &palabra, long long &comp) {
  int n = (int)texto.length();
  int m = (int)palabra.length();
  comp = 0;
  if (m > n) return -1;
  for (int i = 0; i <= n - m; i++) {
    int j = 0;
    while (j < m) {
      comp++;
      if (texto[i + j] != palabra[j]) break;
      j++;
    }
    if (j == m) return i;
  }
  return -1;
}

// Contar todas las apariciones (palabra repetida varias veces).
int contarEnTexto(const string &texto, const string &palabra, long long &comp) {
  int n = (int)texto.length();
  int m = (int)palabra.length();
  comp = 0;
  if (m > n) return 0;
  int cnt = 0;
  for (int i = 0; i <= n - m; i++) {
    int j = 0;
    while (j < m) {
      comp++;
      if (texto[i + j] != palabra[j]) break;
      j++;
    }
    if (j == m) cnt++;
  }
  return cnt;
}

// Búsqueda binaria en una lista ordenada de palabras.
int buscarEnLista(string lista[], int n, const string &palabra, long long &comp) {
  int inicio = 0, fin = n - 1;
  comp = 0;
  while (inicio <= fin) {
    int medio = (inicio + fin) / 2;
    comp++;
    if (lista[medio] == palabra) return medio;
    else if (lista[medio] < palabra) inicio = medio + 1;
    else fin = medio - 1;
  }
  return -1;
}
```

#### Análisis de eficiencia — Método simple (texto)

Sea `n` la longitud del texto y `m` la longitud de la palabra.

1. **Mejor caso – Ω grande (Omega) → Límite inferior**
   La palabra está al **inicio** del texto y coincide desde la primera posición. Solo se
   comparan los `m` caracteres de la palabra.
   - Mejor caso: **Ω(m)**.

2. **Peor caso – O grande (O) → Límite superior**
   La palabra **no está** (o está al final) y, además, en cada posición falla recién en el
   último carácter (p. ej. texto de puras `a` y palabra `aaaaab`). Por cada una de las
   `n − m + 1` posiciones se hacen hasta `m` comparaciones.
   - Peor caso: **O(n · m)**.

3. **Caso promedio – Θ grande (Theta) → Ajuste exacto**
   En promedio se compara una fracción de `m` por cada posición, del mismo orden.
   - Caso promedio: **Θ(n · m)**.

#### Análisis de eficiencia — Búsqueda binaria (lista ordenada)

Sea `n` el número de palabras de la lista.

1. **Mejor caso – Ω grande (Omega) → Límite inferior**
   La palabra está **justo en el medio** en la primera comparación.
   - Mejor caso: **Ω(1)**.

2. **Peor caso – O grande (O) → Límite superior**
   Cada paso divide la lista a la mitad:
   Paso 1: `n` → `n/2`; Paso 2: `n/2` → `n/4`; …; Paso k: `n/2^k = 1 ⇒ k = log₂(n)`.
   - Peor caso: **O(log n)**.

3. **Caso promedio – Θ grande (Theta) → Ajuste exacto**
   En promedio se siguen necesitando del orden de `log₂(n)` pasos.
   - Caso promedio: **Θ(log n)**.

#### Comparación de los dos métodos de búsqueda

| Criterio            | Método simple (texto)                              | Búsqueda binaria (lista)        |
|---------------------|----------------------------------------------------|---------------------------------|
| Requisito           | Ninguno (funciona sobre cualquier texto)           | La lista debe estar ordenada    |
| Idea básica         | Desliza la palabra por el texto y compara          | Divide la lista a la mitad en cada paso |
| Mejor caso (Ω)      | Ω(m) → coincide al inicio del texto                | Ω(1) → está justo en el medio   |
| Peor caso (O)       | O(n·m) → no está y falla al final de cada intento  | O(log n) → no está o requiere varias divisiones |
| Caso promedio (Θ)   | Θ(n·m)                                             | Θ(log n)                        |
| Ejemplo con n=10⁶   | Hasta ≈ 6·10⁶ comparaciones                        | ≈ 20 comparaciones              |
| Ventajas            | Implementación inmediata                           | Muy rápido en listas grandes    |
| Desventajas         | Muy lenta si el texto es muy grande                | Exige lista ordenada de antemano|

#### ¿Qué pasa si la palabra se repite varias veces?

- **En el texto (método simple):** si solo se busca la **primera aparición**, el algoritmo
  termina en cuanto la encuentra; es decir, las repeticiones **ayudan** (en promedio
  termina antes). Pero si se quieren **contar todas las apariciones**, hay que recorrer el
  texto completo: se degrada a **Θ(n·m) siempre**. En la ejecución, la palabra `"casa"`
  apareció 2 veces y contarlas todas llevó 66 comparaciones (recorrer todo el texto).

- **En la lista ordenada:** las copias de una misma palabra quedan **adyacentes**. La
  búsqueda binaria encuentra **una** aparición en `O(log n)` y luego basta expandirse a
  izquierda y derecha para contar las `k` repetidas en `O(k)` pasos. Costo total:
  **O(log n + k)**, mucho menor que recorrer toda la lista.

#### Resultados de la ejecución

```
Buscando "casa" en el texto...
Elemento encontrado en la posicion 3 (7 comparaciones)
La palabra se repite 2 veces en el texto (66 comparaciones para contarlas todas)
Buscando "eficiencia" (binaria): pos=4 (1 comparaciones)

=== Crecimiento del texto (peor caso: texto de puras 'a', palabra 'aaaaab') ===
n=100000    comparaciones=599970    tiempo=0.25 ms
n=1000000   comparaciones=5999970   tiempo=2.14 ms
n=10000000  comparaciones=59999970  tiempo=20.5 ms

=== Crecimiento del tamano de la lista (busqueda binaria) ===
n=1000     comparaciones=9    tiempo ~0 ms
n=10000    comparaciones=13   tiempo ~0 ms
n=1000000  comparaciones=19   tiempo ~0 ms
```

#### Respuestas a las preguntas

**¿Cómo crece el tiempo respecto a la longitud del texto?**
Por cada carácter adicional del texto se prueban hasta `m` caracteres de la palabra. En el
peor caso las comparaciones son `≈ m·n`, es decir, crecen **linealmente** en función de `n`
(mantenida fija `m`). En la medición, al multiplicar `n` por 10 el tiempo también se
multiplicó por ≈ 10 (0.25 → 2.14 → 20.5 ms).

**¿Cómo crece respecto al tamaño de la lista?**
La búsqueda binaria crece **logarítmicamente**: `log₂(n)` comparaciones. En la medición,
al pasar de 1000 a 1 000 000 de elementos (×1000) las comparaciones solo pasaron de 9 a 19
(≈ 2×), confirmando **O(log n)**.

---

### 3. Problema de clasificación: ordenar una lista de nombres alfabéticamente

Se desea ordenar una lista de nombres en **orden alfabético** usando un ordenamiento simple
(burbuja) y compararlo con el método `sort()` de la biblioteca estándar de C++.

#### Código en C++

```cpp
#include <iostream>
#include <string>
#include <algorithm>
#include <chrono>
using namespace std;

void burbuja(string arr[], int n) {
  for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - 1 - i; j++) {
      if (arr[j] > arr[j + 1]) {
        string t = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = t;
      }
    }
  }
}
```

#### Análisis de eficiencia — Ordenamiento burbuja

1. **Mejor caso – Ω grande (Omega) → Límite inferior**
   Incluso si la lista ya está ordenada, la versión simple **siempre** recorre todas las
   parejas `(j, j+1)`; el número de comparaciones es siempre el mismo.
   - Mejor caso: **Ω(n²)**.

2. **Peor caso – O grande (O) → Límite superior**
   La lista en orden inverso no cambia el número de comparaciones (solo aumenta los
   intercambios). Comparaciones = `n·(n−1)/2`.
   - Peor caso: **O(n²)**.

3. **Caso promedio – Θ grande (Theta) → Ajuste exacto**
   El número de comparaciones es idéntico para cualquier permutación de entrada.
   - Caso promedio: **Θ(n²)**.

#### Análisis de eficiencia — `sort()` de la biblioteca estándar

`std::sort` implementa *introsort* (quicksort + heapsort de respaldo, `O(n log n)` en el
peor caso).
- Peor, mejor y promedio: **O(n log n)**, **Ω(n log n)**, **Θ(n log n)**.

#### ¿Cómo crece el número de comparaciones si hay n nombres?

La burbuja hace exactamente `n·(n−1)/2` comparaciones, es decir, crece de forma
**cuadrática**:

| n      | Comparaciones = n(n−1)/2 |
|--------|--------------------------|
| 10     | 45                       |
| 100    | 4950                     |
| 1000   | 499 500                  |
| n      | n(n−1)/2 → **O(n²)**     |

Con `sort()` el número de comparaciones es del orden de **`n·log₂(n)`**.

#### Comparación burbuja vs `sort()`

| Criterio          | Burbuja                            | sort() estándar                      |
|-------------------|------------------------------------|--------------------------------------|
| Idea básica       | Compara adyacentes y los intercambia | Introsort (quicksort + heapsort)    |
| Mejor caso (Ω)    | Ω(n²)                              | Ω(n log n)                          |
| Peor caso (O)     | O(n²)                              | O(n log n)                          |
| Caso promedio (Θ) | Θ(n²)                              | Θ(n log n)                          |
| Comparaciones     | n(n−1)/2                           | ≈ n·log₂(n)                         |
| Tiempo (n=5000)   | 198 ms                             | 0.11 ms                             |
| Tiempo (n=500000) | inviable (≈ 33 min)                | 32.4 ms                             |
| Ventajas          | Trivial de escribir                | Muy rápido, probado y optimizado    |
| Desventajas       | Lento para listas grandes          | Es de la librería estándar          |

#### Resultados de la ejecución

```
=== Ordenar nombres en orden alfabetico (Burbuja y sort()) ===
Burbuja : Ana Carlos Juan Luis Maria Pedro Sofia
sort()  : Ana Carlos Juan Luis Maria Pedro Sofia

=== Numero de comparaciones de la burbuja (n(n-1)/2) ===
n=10   comparaciones=45     n(n-1)/2=45
n=100  comparaciones=4950   n(n-1)/2=4950
n=1000 comparaciones=499500 n(n-1)/2=499500

=== Comparacion de tiempo (mismo tamano de entrada) ===
Burbuja n=5000:    198.486 ms (ordenado=si)
sort()  n=5000:    0.107 ms    (ordenado=si)
sort()  n=500000:  32.396 ms   (ordenado=si)
```

Observación: con `n = 5000` la burbuja tardó ~198 ms y `sort()` ~0.1 ms (**≈ 1800 veces
menos**); además, `sort()` ordena 500 000 nombres en el mismo tiempo que la burbuja tarda
con 5000.

---

### 4. Problema de decisión: determinar si un número es palíndromo

Se desea saber si un número entero leído de izquierda a derecha es igual que leído de
derecha a izquierda (salida sí/no).

#### Código en C++

```cpp
#include <iostream>
#include <string>
using namespace std;

bool esPalindromo(int num, int &comparaciones) {
  string s = to_string(num);
  int d = (int)s.length();
  comparaciones = 0;
  for (int i = 0; i < d / 2; i++) {
    comparaciones++;
    if (s[i] != s[d - 1 - i])
      return false;
  }
  return true;
}
```

#### Análisis de eficiencia

Sea `d` el número de dígitos.

1. **Mejor caso – Ω grande (Omega) → Límite inferior**
   Si el **primer y el último dígito difieren**, basta una sola comparación para
   responder NO.
   - Ejemplo: `12345` → 1 comparación.
   - Mejor caso: **Ω(1)**.

2. **Peor caso – O grande (O) → Límite superior**
   Si el número **sí es palíndromo**, hay que comparar todas las parejas simétricas, que
   son `d/2`, es decir `⌊d/2⌋` comparaciones.
   - Ejemplo: `100001` (6 dígitos) → 3 comparaciones; `123321` → 3.
   - Peor caso: **O(d)**.

3. **Caso promedio – Θ grande (Theta) → Ajuste exacto**
   En promedio se requiere una fracción de las `d/2` parejas, del mismo orden lineal.
   - Caso promedio: **Θ(d)**.

#### ¿Cuántas comparaciones hace el algoritmo en función del número de dígitos d?

Como máximo **`⌊d/2⌋`**: se compara el primer dígito con el último, el segundo con el
penúltimo, …, hasta el centro. Si en algún paso los dígitos no coinciden, el algoritmo se
detiene **antes** (mínimo 1). Con `d = 5` dígitos, a lo sumo 2 comparaciones; con
`d = 10`, a lo sumo 5.

#### Resultados de la ejecución

```
12321  (5 digitos): SI es palindromo  comparaciones=2  limite d/2=2
1221   (4 digitos): SI es palindromo  comparaciones=2  limite d/2=2
12345  (5 digitos): NO es palindromo  comparaciones=1  limite d/2=2
100001 (6 digitos): SI es palindromo  comparaciones=3  limite d/2=3
7      (1 digitos): SI es palindromo  comparaciones=0  limite d/2=0
```

Se verifica que el peor caso (es palíndromo) usa exactamente `⌊d/2⌋` comparaciones, y que
cuando deja de serlo termina antes.

---

### 5. Problema de eficiencia: suma de los primeros n números naturales

Se desea calcular `1 + 2 + 3 + … + n` de **dos formas**: (a) con un **bucle** que suma uno
a uno y (b) con la **fórmula cerrada** `n(n+1)/2`. Luego se comparan los pasos de cada una.

#### Código en C++

```cpp
#include <iostream>
#include <chrono>
using namespace std;

long long sumaBucle(int n) {
  long long suma = 0;
  for (int i = 1; i <= n; i++) {
    suma += i;
  }
  return suma;
}

long long sumaFormula(int n) {
  return (long long)n * (n + 1) / 2;
}
```

#### Análisis de eficiencia

1. **Con bucle – Θ(n)**
   El bucle se ejecuta `n` veces; en cada iteración hace ~3 operaciones (una suma, un
   incremento y una comparación). El número total de operaciones es **≈ 3n**, es decir,
   crece linealmente con `n`.
   - Peor = mejor = promedio: **Θ(n)**.

2. **Con la fórmula – Θ(1)**
   Solo se hacen **3 operaciones** (una multiplicación, una suma y una división),
   **independientes de `n`**.
   - Peor = mejor = promedio: **Θ(1) / O(1)**.

#### Comparación de pasos y tiempo

| n          | Bucle (≈ 3n operaciones)     | Fórmula (3 operaciones) |
|------------|------------------------------|--------------------------|
| 100        | ≈ 300 op.                    | 3 op.                    |
| 1 000 000  | ≈ 3 000 000 op.              | 3 op.                    |
| 100 000 000| ≈ 300 000 000 op. → 79.8 ms  | 3 op. → ≈ 0 ms           |
| 10⁹        | ≈ 3·10⁹ op. (≈ 1 s)          | 3 op. (≈ 0 ms)           |

Ambos métodos son **correctos** (resultados idénticos en todas las pruebas), pero la
fórmula es **asintóticamente superior**:   a medida que `n` crece, el bucle hace `Θ(n)`
pasos mientras la fórmula hace siempre un número constante. Además, con `long long` se
evita el desbordamiento incluso para `n` grandes.

#### Resultados de la ejecución

```
n=1000000  bucle=500000500000  formula=500000500000
n=100000000 bucle=5000000050000000  formula=5000000050000000

Bucle   n=100000000: 5000000050000000 en 79.8 ms
Formula n=100000000: 5000000050000000 en ≈ 0 ms
```

---

## IV. CUESTIONARIO

### 1. ¿Qué diferencia existe entre la corrección parcial y total de un algoritmo?

- **Corrección parcial:** establece que **si** el algoritmo termina, entonces el resultado
  es correcto. Es decir, para toda entrada que cumple la precondición, cualquier estado
  final alcanzado satisface la postcondición. Se demuestra típicamente con **invariantes de
  bucle** (la propiedad que se mantiene en cada iteración) y una relación entre la condición
  de salida y la postcondición.

- **Corrección total:** es la corrección parcial **más la garantía de terminación**: el
  algoritmo termina siempre para toda entrada válida. La terminación se demuestra con una
  **función de cota** que decrece en cada iteración y no puede ser negativa (p. ej., en la
  búsqueda binaria la longitud del intervalo `fin − inicio` se reduce a la mitad en cada
  paso).

Resumen: la corrección total = corrección parcial + terminación. Un algoritmo que queda en
un bucle infinito puede ser parcialmente correcto (si termina, lo hace bien) pero no es
totalmente correcto.

### 2. ¿Qué ventajas tiene el análisis con notación asintótica frente a medir el tiempo real de ejecución?

1. **Independiencia de la máquina:** la notación no depende de la CPU, la memoria, el
   lenguaje, el compilador ni el sistema operativo. El tiempo real en segundos cambia de una
   computadora a otra; el orden de crecimiento no.
2. **No requiere ejecutar:** se puede analizar y comparar algoritmos sobre el papel antes de
   implementarlos.
3. **Describe la escalabilidad:** expresa qué ocurre cuando `n` tiende a valores grandes
   (1 000, 1 000 000, 10⁹ datos), no solo un caso puntual de una ejecución concreta.
4. **Comparación justa:** dos algoritmos se comparan por su tasa de crecimiento intrínseca,
   no por una medición puntual contaminada por la carga del sistema o los datos concretos.
5. **Es posible medir tiempos reales solo después de implementar y con datos determinados;**
   el análisis asintótico permite decidir el diseño **antes** de escribir el código.

### 3. Explique con un ejemplo una relación de recurrencia y su solución.

Una recurrencia expresa el costo de un algoritmo recursivo en función de sí mismo con una
entrada más pequeña.

**Ejemplo — Búsqueda binaria.** Cada llamada realiza un trabajo constante `c` (calcular el
medio y comparar) y luego resuelve un subproblema de tamaño `n/2`:

```
T(n) = T(n/2) + c        con T(1) = c
```

**Solución por expansión (método de sustitución):**

```
T(n)     = T(n/2) + c
T(n/2)   = T(n/4) + c   ⇒  T(n) = T(n/4) + 2c
T(n/4)   = T(n/8) + c   ⇒  T(n) = T(n/8) + 3c
   ...
después de k pasos:   T(n) = T(n/2^k) + k·c
```

Cuando `n/2^k = 1`, se tiene `k = log₂(n)`. Sustituyendo:

```
T(n) = T(1) + log₂(n)·c = c + c·log₂(n)
```

Por lo tanto la solución es **T(n) = Θ(log n)**, que coincide con el análisis hecho en la
guía para la búsqueda binaria. Otro ejemplo clásico: `T(n) = T(n−1) + c, T(1) = c` produce
`T(n) = c·n = Θ(n)`, como en un algoritmo lineal iterativo/recursivo.

### 4. ¿Por qué la eficiencia es tan importante en problemas de gran escala?

Porque la diferencia entre órdenes de crecimiento se vuelve **dramática** cuando `n` es
grande: un algoritmo correcto pero ineficiente puede volverse **imposible de usar** en la
práctica. La tabla siguiente muestra las operaciones de distintos algoritmos según `n`:

| n         | O(n)        | O(n log n)      | O(n²)        | O(2ⁿ)           |
|-----------|-------------|-----------------|--------------|-----------------|
| 10        | 10          | 33              | 100          | 1 024           |
| 10⁶       | 10⁶ (~1 ms) | 2·10⁷ (~0.02 s) | 10¹² (~1 h)  | imposible       |
| 10⁹       | 10⁹ (~1 s)  | 3·10¹⁰ (~30 s)  | 10¹⁸ (~30 años)| imposible      |

En aplicaciones reales la entrada es enorme: bases de datos con millones de registros, GPS,
motores de búsqueda, logs de servidores. Un algoritmo O(n²) para 10⁹ datos necesitaría
miles de millones de veces más tiempo que uno O(n log n), y consume proporcionalmente más
energía y recursos. Por ello, además de **correctos**, los algoritmos deben ser
**eficientes**.

### 5. ¿Qué características debe cumplir un buen algoritmo? Mencione al menos tres y justifique con ejemplos.

1. **Finitud:** debe terminar después de un número finito de pasos.
   *Ejemplo:* la búsqueda binaria termina porque el intervalo `[inicio, fin]` se reduce a la
   mitad en cada iteración; siempre se llega a un intervalo vacío o a la clave.

2. **Definición (no ambigüedad):** cada paso debe ser claro y sin doble interpretación.
   *Ejemplo:* la condición `arr[i] == clave` de la búsqueda secuencial es exacta; una
   instrucción como "elige un número cercano a x" no sería un algoritmo.

3. **Generalidad:** debe resolver una **clase** de problemas, no un caso particular.
   *Ejemplo:* `mcdEuclides(a, b)` funciona para cualquier par de enteros positivos y no solo
   para una pareja fija.

4. **Eficiencia:** debe hacer un uso razonable de recursos (tiempo y memoria).
   *Ejemplo:* para sumar `1..n`, la fórmula `n(n+1)/2` es `Θ(1)` mientras que un bucle es
   `Θ(n)`; ambos son correctos, pero uno es mucho más eficiente.

5. **Correctitud:** debe producir el resultado esperado para toda entrada válida.
   *Ejemplo:* el algoritmo de suma con bucle devuelve el valor correcto para cualquier `n`,
   como se verificó contra la fórmula en el ejercicio 5.

### 6. ¿Qué significa que un algoritmo tenga complejidad O(1)? Dé un ejemplo sencillo.

Que su costo (tiempo o memoria) es **constante**: no depende del tamaño `n` de la entrada.
Siempre ejecuta el mismo número de operaciones, sin importar si la entrada tiene 1, 100 o
un millón de elementos.

**Ejemplos sencillos:**
- Acceder a `arr[0]` (el primer elemento de un arreglo): es un salto directo a una dirección,
  O(1).
- Sumar con la fórmula `return n * (n + 1) / 2;`: hace 3 operaciones, O(1), aunque se calcule
  para `n = 10⁹`.
- Intercambiar dos variables con variable temporal.

Nota: recorrer el arreglo completo para hallar el máximo no es O(1), es O(n).

### 7. Si tienes un algoritmo que resuelve un problema correctamente pero tarda demasiado, ¿qué opciones tienes como programador para mejorar su eficiencia?

1. **Cambiar de algoritmo** por uno de menor complejidad asintótica (la mejora más grande).
   *Ejemplo:* burbuja `O(n²)` → `sort()` `O(n log n)`; búsqueda secuencial `O(n)` →
   búsqueda binaria `O(log n)` ordenando la lista previamente.
2. **Usar la estructura de datos adecuada:** tablas hash (O(1) promedio), montículos para
   máximos/mínimos, árboles balanceados, etc.
3. **Memorización / programación dinámica:** evitar recalcular subproblemas repetidos.
   *Ejemplo:* Fibonacci con memoización pasa de `O(2ⁿ)` a `O(n)`.
4. **Preprocesamiento:** si se harán muchas búsquedas, ordenar o construir un índice una sola
   vez.
5. **Recorte (pruning) y casos base:** detectar terminación temprana (p. ej. en el ejercicio
   del palíndromo, salir al primer desajuste).
6. **Explotar la biblioteca estándar y la optimización del compilador:** `std::sort`,
   `std::binary_search`, compilar con `-O2`.
7. **Reducir factores constantes:** evitar copias innecesarias de objetos grandes, pasar
   referencias, mover cálculos fuera de los bucles internos.
8. **Paralelizar o distribuir** la carga si el problema lo permite y el costo lo justifica.

**Orden recomendado:** primero atacar la complejidad asintótica (ítem 1 y 2); solo después
optimizar constantes (ítem 7); al final, paralelismo (ítem 8).

---

## V. REFERENCIAS

- Cormen, T. H., Leiserson, C. E., Rivest, R. L., & Stein, C. (2022). *Introduction to Algorithms*. MIT Press.
- Sedgewick, R., & Wayne, K. (2011). *Algorithms*. Addison-Wesley.
- Brassard, G., & Bratley, P. (1996). *Fundamentals of Algorithmics*. Prentice Hall.