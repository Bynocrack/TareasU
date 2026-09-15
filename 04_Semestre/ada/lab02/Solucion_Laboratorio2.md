# SOLUCIÓN — GUÍA DE LABORATORIO 2

**Asignatura:** Análisis y Diseño de Algoritmos
**Práctica N.º 2:** Ordenamiento: Insertion Sort, Selection Sort
**Año lectivo:** 2025-B | **Semestre:** IV
**Tipo:** Individual

---

## III. EJERCICIOS PROPUESTOS

> Todos los programas fueron compilados con `g++ -O2` y ejecutados para verificar su
> correctitud y medir tiempos reales (`codigo/*.cpp`).

---

### 1. Insertion Sort: ordenar una lista de `n` nombres ingresados por el usuario

Se desea ordenar alfabéticamente una lista de `n` nombres ingresados por el usuario usando
**Insertion Sort**, y analizar cómo cambia el tiempo de ejecución según la lista esté **ya
ordenada**, en **orden inverso** o sea **aleatoria** (cada nombre es una cadena que se desplaza
hasta su posición correcta).

#### Código en C++

```cpp
#include <iostream>
#include <string>
#include <chrono>
#include <algorithm>
#include <random>
#include <cstdio>
using namespace std;

void insertionSort(string arr[], int n, long long &comp, long long &movs) {
  comp = 0;
  movs = 0;
  for (int i = 1; i < n; i++) {
    string key = arr[i];
    int j = i - 1;
    while (j >= 0) {
      comp++;
      if (arr[j] > key) {
        arr[j + 1] = arr[j];
        movs++;
        j--;
      } else {
        break;
      }
    }
    arr[j + 1] = key;
    movs++;
  }
}

string nombre(int i) {
  char buf[32];
  snprintf(buf, sizeof(buf), "Apellido%08d", i);
  return string(buf);
}

void copiar(string destino[], string origen[], int n) {
  for (int i = 0; i < n; i++) destino[i] = origen[i];
}

int main() {
  cout << "=== Insertion Sort: ordenar nombres ingresados por el usuario ===" << endl;

  int n;
  cout << "Ingrese la cantidad de nombres: ";
  cin >> n;
  cin.ignore();

  string *nombres = new string[n];
  for (int i = 0; i < n; i++) {
    cout << "Nombre " << i + 1 << ": ";
    getline(cin, nombres[i]);
  }

  long long comp, movs;
  insertionSort(nombres, n, comp, movs);

  cout << "Lista ordenada: ";
  for (int i = 0; i < n; i++) cout << nombres[i] << " ";
  cout << endl;
  cout << "Comparaciones = " << comp << "  Movimientos = " << movs << endl;
  delete[] nombres;

  cout << "\n=== Analisis de escenarios (lista ya ordenada, inversa y aleatoria) ===" << endl;
  int N = 10000;
  mt19937 rng(123456);

  for (int esc = 0; esc < 3; esc++) {
    string *arr = new string[N];
    for (int i = 0; i < N; i++) arr[i] = nombre(i);

    if (esc == 1) reverse(arr, arr + N);
    else if (esc == 2) shuffle(arr, arr + N, rng);

    auto t0 = chrono::steady_clock::now();
    insertionSort(arr, N, comp, movs);
    auto t1 = chrono::steady_clock::now();
    double ms = chrono::duration<double, milli>(t1 - t0).count();
    bool ok = is_sorted(arr, arr + N);

    const char *nombreEsc = (esc == 0) ? "Ya ordenada" : (esc == 1) ? "Orden inverso" : "Aleatoria";
    cout << nombreEsc << " (n=" << N << "): " << ms << " ms | comparaciones=" << comp
         << " | movimientos=" << movs << " | ordenado=" << (ok ? "si" : "no") << endl;
    delete[] arr;
  }

  return 0;
}
```

#### Análisis de eficiencia — Insertion Sort

La idea es mantener un **prefijo ordenado**: se toma cada elemento `key` y se inserta en su
posición correcta dentro del prefijo, desplazando hacia la derecha a los elementos mayores.

1. **Mejor caso – Ω grande (Omega) → Límite inferior**
   La lista **ya está ordenada**: en cada inserción `key` ya está bien ubicado, así que solo se
   hace **1 comparación** por elemento (`comp = n−1`) y **0 desplazamientos** en el bucle.
   - Mejor caso: **Ω(n)**.

2. **Peor caso – O grande (O) → Límite superior**
   La lista está en **orden inverso**: insertar el elemento `i` exige compararlo (y desplazarlo)
   con los `i` anteriores. Total de comparaciones = `1 + 2 + … + (n−1) = n(n−1)/2`.
   - Peor caso: **O(n²)**.

3. **Caso promedio – Θ grande (Theta) → Ajuste exacto**
   En promedio, para una lista aleatoria, cada elemento debe retroceder hasta la mitad del
   prefijo: unas `n²/4` comparaciones.
   - Caso promedio: **Θ(n²)**.

#### ¿Cómo cambia el tiempo de ejecución según el escenario?

| Escenario       | Comparaciones          | Movimientos           | Orden esperado |
|-----------------|------------------------|-----------------------|----------------|
| Ya ordenada (Ω) | `n−1`                 | `n−1` (solo la asignación de `key`) | **Ω(n)**   |
| Orden inverso (O)| `n(n−1)/2` = Θ(n²)    | `n(n−1)/2 + (n−1)`    | **O(n²)**    |
| Aleatoria (Θ)   | ≈ `n²/4`              | ≈ `n²/4`              | **Θ(n²)**    |

El tiempo **depende fuertemente del orden inicial**: ordenada es lineal, inversa es cuadrática
y aleatoria queda entre ambas. Es decir, a diferencia de Selection Sort, Insertion Sort
**aprovecha el orden existente**.

#### Resultados de la ejecución

```
=== Insertion Sort: ordenar nombres ingresados por el usuario ===
Ingrese la cantidad de nombres: 5
Nombre 1: Ana
Nombre 2: Luis
Nombre 3: Carlos
Nombre 4: Maria
Nombre 5: Pedro
Lista ordenada: Ana Carlos Luis Maria Pedro
Comparaciones = 5  Movimientos = 5

=== Analisis de escenarios (lista ya ordenada, inversa y aleatoria) ===
Ya ordenada (n=10000): 0.114044 ms | comparaciones=9999 | movimientos=9999 | ordenado=si
Orden inverso (n=10000): 135.521 ms | comparaciones=49995000 | movimientos=50004999 | ordenado=si
Aleatoria (n=10000): 71.1438 ms | comparaciones=24992455 | movimientos=24992458 | ordenado=si
```

Observación: con `n = 10000`, la lista **ordenada** necesitó solo 9999 comparaciones (≈ 0.1 ms),
la **inversa** `10000·9999/2 = 49 995 000` (≈ 135 ms) y la **aleatoria** ≈ 25 millones
(≈ 71 ms), confirmando Ω(n) frente a Θ(n²). Los valores de movimientos coinciden con las
fórmulas esperadas (`n−1`, `n(n−1)/2 + (n−1)` y ≈ `n²/4 + n`).

---

### 2. Selection Sort: ordenar un arreglo de números flotantes

Se desea ordenar un arreglo de números **flotantes** (`double`) en orden ascendente con
**Selection Sort**, mostrando el **número de comparaciones** y el **número de intercambios**
realizados.

#### Código en C++

```cpp
#include <iostream>
#include <chrono>
using namespace std;

void selectionSort(double arr[], int n, long long &comp, long long &intercambios) {
  comp = 0;
  intercambios = 0;
  for (int i = 0; i < n - 1; i++) {
    int minIdx = i;
    for (int j = i + 1; j < n; j++) {
      comp++;
      if (arr[j] < arr[minIdx]) minIdx = j;
    }
    if (minIdx != i) {
      double t = arr[i];
      arr[i] = arr[minIdx];
      arr[minIdx] = t;
      intercambios++;
    }
  }
}

void imprimir(double arr[], int n) {
  for (int i = 0; i < n; i++) cout << arr[i] << " ";
  cout << endl;
}

int main() {
  cout << "=== Selection Sort sobre un arreglo de numeros flotantes ===" << endl;

  double datos[] = { 6.2, 3.8, 9.1, 1.5, 7.7, 4.4, 2.9, 8.3, 5.6, 0.9 };
  int n = 10;

  cout << "Original: ";
  imprimir(datos, n);

  long long comp, intercambios;
  selectionSort(datos, n, comp, intercambios);

  cout << "Ordenado: ";
  imprimir(datos, n);
  cout << "Comparaciones = " << comp << " (formula n(n-1)/2 = "
       << ((long long)n * (n - 1) / 2) << ")" << endl;
  cout << "Intercambios = " << intercambios << " (maximo n-1 = " << n - 1 << ")" << endl;

  cout << "\n=== Confirmacion: las comparaciones no cambian con el orden ===" << endl;
  for (int esc = 0; esc < 3; esc++) {
    double arr[1000];
    for (int i = 0; i < 1000; i++) {
      if (esc == 0) arr[i] = (double)i;
      else if (esc == 1) arr[i] = (double)(999 - i);
      else arr[i] = (double)((i * 37 + 11) % 1000);
    }
    selectionSort(arr, 1000, comp, intercambios);
    const char *nombreEsc = (esc == 0) ? "Ya ordenada" : (esc == 1) ? "Orden inverso" : "Aleatoria";
    cout << nombreEsc << " (n=1000): comparaciones=" << comp
         << "  intercambios=" << intercambios << endl;
  }

  return 0;
}
```

#### Análisis de eficiencia — Selection Sort

La idea es **seleccionar el mínimo** del subarreglo no ordenado (`i..n−1`) e intercambiarlo con
el elemento en la posición `i`, repitiendo hasta el penúltimo elemento.

1. **Mejor caso – Ω grande (Omega) → Límite inferior**
   El bucle interno siempre recorre todo el subarreglo para localizar el mínimo, sin importar el
   orden de los datos. Las comparaciones son siempre `n(n−1)/2`, aunque ya esté ordenado.
   - Mejor caso: **Ω(n²)**.

2. **Peor caso – O grande (O) → Límite superior**
   Idéntico al mejor caso: `n(n−1)/2` comparaciones. Solo cambian los intercambios (de `0` a `n−1`).
   - Peor caso: **O(n²)**.

3. **Caso promedio – Θ grande (Theta) → Ajuste exacto**
   El número de comparaciones es el mismo para cualquier permutación de la entrada.
   - Caso promedio: **Θ(n²)**.

#### ¿Cuántas comparaciones e intercambios hace?

- **Comparaciones:** siempre exactamente `n(n−1)/2`, independiente del orden.
- **Intercambios:** como máximo `n−1`; con la mejora de "no intercambiar si `minIdx == i`", el
  mínimo es `0` (lista ya ordenada). Selection Sort prioriza **pocos movimientos** a costa de
  comparaciones fijas.

#### Resultados de la ejecución

```
=== Selection Sort sobre un arreglo de numeros flotantes ===
Original: 6.2 3.8 9.1 1.5 7.7 4.4 2.9 8.3 5.6 0.9
Ordenado: 0.9 1.5 2.9 3.8 4.4 5.6 6.2 7.7 8.3 9.1
Comparaciones = 45 (formula n(n-1)/2 = 45)
Intercambios = 7 (maximo n-1 = 9)

=== Confirmacion: las comparaciones no cambian con el orden ===
Ya ordenada (n=1000): comparaciones=499500  intercambios=0
Orden inverso (n=1000): comparaciones=499500  intercambios=500
Aleatoria (n=1000): comparaciones=499500  intercambios=987
```

Observación: para `n = 1000` las comparaciones son siempre `499 500 = 1000·999/2` en los tres
escenarios (ordenada, inversa y aleatoria), mientras que los intercambios varían de `0` a `987`,
confirmando que Selection Sort **no aprovecha el orden existente** pero **minimiza los movimientos**.

---

### 3. Función genérica de ordenamiento y comparación de rendimiento

Se desea crear una **función única** que reciba un arreglo y un tipo de ordenamiento
(`"insertion"` o `"selection"`) y aplique el algoritmo correspondiente, para luego **evaluar el
rendimiento** con 1000, 5000 y 10000 elementos aleatorios.

#### Código en C++

```cpp
#include <iostream>
#include <string>
#include <chrono>
#include <ctime>
#include <cstdlib>
#include <algorithm>
using namespace std;

void insertionSort(int arr[], int n, long long &comp, long long &movs) {
  comp = 0;
  movs = 0;
  for (int i = 1; i < n; i++) {
    int key = arr[i];
    int j = i - 1;
    while (j >= 0) {
      comp++;
      if (arr[j] > key) {
        arr[j + 1] = arr[j];
        movs++;
        j--;
      } else {
        break;
      }
    }
    arr[j + 1] = key;
    movs++;
  }
}

void selectionSort(int arr[], int n, long long &comp, long long &intercambios) {
  comp = 0;
  intercambios = 0;
  for (int i = 0; i < n - 1; i++) {
    int minIdx = i;
    for (int j = i + 1; j < n; j++) {
      comp++;
      if (arr[j] < arr[minIdx]) minIdx = j;
    }
    if (minIdx != i) {
      int t = arr[i];
      arr[i] = arr[minIdx];
      arr[minIdx] = t;
      intercambios++;
    }
  }
}

void ordenar(int arr[], int n, string tipo, long long &comp, long long &op) {
  if (tipo == "insertion") insertionSort(arr, n, comp, op);
  else if (tipo == "selection") selectionSort(arr, n, comp, op);
}

int main() {
  srand((unsigned)time(NULL));

  cout << "=== Funcion generica: ordenar segun el tipo ('insertion' o 'selection') ===" << endl;

  int tam = 5;
  int entrada[] = { 9, 2, 7, 1, 5 };

  long long compI, opI, compS, opS;
  int *copia = new int[tam];
  for (int i = 0; i < tam; i++) copia[i] = entrada[i];
  ordenar(copia, tam, "insertion", compI, opI);
  cout << "insertion -> ";
  for (int i = 0; i < tam; i++) cout << copia[i] << " ";
  cout << "(comp=" << compI << " movs=" << opI << ")" << endl;
  delete[] copia;

  copia = new int[tam];
  for (int i = 0; i < tam; i++) copia[i] = entrada[i];
  ordenar(copia, tam, "selection", compS, opS);
  cout << "selection -> ";
  for (int i = 0; i < tam; i++) cout << copia[i] << " ";
  cout << "(comp=" << compS << " swaps=" << opS << ")" << endl;
  delete[] copia;

  cout << "\n=== Rendimiento con datos aleatorios (1000, 5000 y 10000) ===" << endl;
  int tamanos[3] = { 1000, 5000, 10000 };

  for (int k = 0; k < 3; k++) {
    int n = tamanos[k];
    int *base = new int[n];
    for (int i = 0; i < n; i++) base[i] = rand() % 100000;

    int *a = new int[n];
    for (int i = 0; i < n; i++) a[i] = base[i];
    auto t0 = chrono::steady_clock::now();
    ordenar(a, n, "insertion", compI, opI);
    auto t1 = chrono::steady_clock::now();
    bool ok1 = is_sorted(a, a + n);

    int *b = new int[n];
    for (int i = 0; i < n; i++) b[i] = base[i];
    auto t2 = chrono::steady_clock::now();
    ordenar(b, n, "selection", compS, opS);
    auto t3 = chrono::steady_clock::now();
    bool ok2 = is_sorted(b, b + n);

    double msI = chrono::duration<double, milli>(t1 - t0).count();
    double msS = chrono::duration<double, milli>(t3 - t2).count();

    cout << "n=" << n << ":" << endl;
    cout << "  insertion: " << msI << " ms | comp=" << compI
         << " | movs=" << opI << " | ordenado=" << (ok1 ? "si" : "no") << endl;
    cout << "  selection: " << msS << " ms | comp=" << compS
         << " | swaps=" << opS << " | ordenado=" << (ok2 ? "si" : "no") << endl;

    delete[] base;
    delete[] a;
    delete[] b;
  }

  return 0;
}
```

#### Análisis y comparación

Ambos algoritmos son `O(n²)` y `Θ(n²)` en promedio, pero el número de comparaciones difiere:

- **Insertion Sort:** hace **menos** comparaciones en promedio (≈ `n²/4`) y el número varía con el
  orden de entrada. Con `n = 10000` y datos aleatorios: ≈ 25 millones de comparaciones.
- **Selection Sort:** hace **siempre** `n(n−1)/2` (`n = 10000` → `49 995 000`), aproximadamente el
  doble que Insertion en promedio, pero **más movimientos** en Insertion (≈ 2 por comparación contra
  1 swap por elemento en Selection).

#### Resultados de la ejecución

```
=== Funcion generica: ordenar segun el tipo ('insertion' o 'selection') ===
insertion -> 1 2 5 7 9 (comp=9 movs=11)
selection -> 1 2 5 7 9 (comp=10 swaps=3)

=== Rendimiento con datos aleatorios (1000, 5000 y 10000) ===
n=1000:
  insertion: 0.091477 ms | comp=239714 | movs=239720 | ordenado=si
  selection: 0.782907 ms | comp=499500 | swaps=997 | ordenado=si
n=5000:
  insertion: 2.26312 ms | comp=6270535 | movs=6270544 | ordenado=si
  selection: 19.8334 ms | comp=12497500 | swaps=4991 | ordenado=si
n=10000:
  insertion: 11.2326 ms | comp=24957164 | movs=24957173 | ordenado=si
  selection: 64.0041 ms | comp=49995000 | swaps=9988 | ordenado=si
```

Observación: con la **misma entrada aleatoria**, Insertion Sort fue más rápido en los tres tamaños
(hasta ≈ 6× en `n = 10000`) porque en promedio realiza la **mitad de comparaciones** que Selection
(`25·10⁶` vs `50·10⁶`), aunque hace muchos más movimientos; Selection compensa solo cuando los
**intercambios** (no las comparaciones) son la operación costosa. Ambos verifican `is_sorted`.

---

### 4. Aplicación: ordenar una lista de videojuegos por puntaje

Se desarrolla una aplicación en C++ que ordena una **lista de videojuegos** (temática libre) de
**mayor a menor** según su **puntaje**. Cada elemento tiene: **código** (string), **nombre** (string)
y **puntaje** (valor numérico, criterio de ordenamiento). Los datos se cargan
**dinámicamente desde un `.txt`**, se ordena con **Insertion Sort** y **Selection Sort**, con
contadores de comparaciones e intercambios y medición de tiempo, y se exporta el resultado a un
**`.csv`**.

#### Estructura de datos y formato de entrada

```
struct Juego {
  string codigo;    // identificador
  string nombre;    // título del videojuego
  double puntaje;   // criterio de ordenamiento (0-100)
};
```

`videojuegos.txt` (25 registros, formato `codigo|nombre|puntaje`):

```
VG-001|The Legend of Zelda: Breath of the Wild|96
VG-002|Super Mario Odyssey|97
VG-003|God of War|94
...
VG-025|Tales of Arise|87
```

#### Código en C++

```cpp
#include <iostream>
#include <string>
#include <fstream>
#include <sstream>
#include <chrono>
using namespace std;

struct Juego {
  string codigo;
  string nombre;
  double puntaje;
};

int cargarDatos(const string &ruta, Juego *juegos) {
  ifstream archivo(ruta.c_str());
  if (!archivo.is_open()) {
    cout << "No se pudo abrir el archivo " << ruta << endl;
    return 0;
  }
  int n = 0;
  string linea;
  while (getline(archivo, linea)) {
    if (linea.empty()) continue;
    stringstream ss(linea);
    string codigo, nombre, puntajeStr;
    getline(ss, codigo, '|');
    getline(ss, nombre, '|');
    getline(ss, puntajeStr, '|');
    juegos[n].codigo = codigo;
    juegos[n].nombre = nombre;
    juegos[n].puntaje = atof(puntajeStr.c_str());
    n++;
  }
  archivo.close();
  return n;
}

void imprimirJuegos(Juego *juegos, int n, const char *titulo) {
  cout << titulo << endl;
  cout << "  Codigo | Nombre | Puntaje" << endl;
  for (int i = 0; i < n; i++)
    cout << "  " << juegos[i].codigo << " | " << juegos[i].nombre << " | "
         << juegos[i].puntaje << endl;
}

void insertionSortDesc(Juego arr[], int n, long long &comp, long long &movs) {
  comp = 0;
  movs = 0;
  for (int i = 1; i < n; i++) {
    Juego key = arr[i];
    int j = i - 1;
    while (j >= 0) {
      comp++;
      if (arr[j].puntaje < key.puntaje) {
        arr[j + 1] = arr[j];
        movs++;
        j--;
      } else {
        break;
      }
    }
    arr[j + 1] = key;
    movs++;
  }
}

void selectionSortDesc(Juego arr[], int n, long long &comp, long long &intercambios) {
  comp = 0;
  intercambios = 0;
  for (int i = 0; i < n - 1; i++) {
    int maxIdx = i;
    for (int j = i + 1; j < n; j++) {
      comp++;
      if (arr[j].puntaje > arr[maxIdx].puntaje) maxIdx = j;
    }
    if (maxIdx != i) {
      Juego t = arr[i];
      arr[i] = arr[maxIdx];
      arr[maxIdx] = t;
      intercambios++;
    }
  }
}

void exportarCSV(const string &ruta, Juego *juegos, int n) {
  ofstream archivo(ruta.c_str());
  archivo << "codigo,nombre,puntaje\n";
  for (int i = 0; i < n; i++)
    archivo << juegos[i].codigo << "," << juegos[i].nombre << "," << juegos[i].puntaje << "\n";
  archivo.close();
  cout << "Exportado a " << ruta << endl;
}

void copiarJuegos(Juego destino[], Juego origen[], int n) {
  for (int i = 0; i < n; i++) destino[i] = origen[i];
}

int main() {
  const int MAX = 100;
  Juego *original = new Juego[MAX];
  int n = cargarDatos("videojuegos.txt", original);

  if (n == 0) {
    delete[] original;
    return 1;
  }

  cout << "=== Ordenar videojuegos por puntaje (de mayor a menor) ===" << endl;
  imprimirJuegos(original, n, "Lista original (cargada desde videojuegos.txt):");
  cout << "Total de elementos cargados: " << n << endl;

  Juego *a = new Juego[n];
  Juego *b = new Juego[n];
  copiarJuegos(a, original, n);
  copiarJuegos(b, original, n);

  long long comp, op;
  auto t0 = chrono::steady_clock::now();
  insertionSortDesc(a, n, comp, op);
  auto t1 = chrono::steady_clock::now();
  double msI = chrono::duration<double, milli>(t1 - t0).count();
  long long compI = comp, movI = op;

  auto t2 = chrono::steady_clock::now();
  selectionSortDesc(b, n, comp, op);
  auto t3 = chrono::steady_clock::now();
  double msS = chrono::duration<double, milli>(t3 - t2).count();
  long long compS = comp, swapS = op;

  cout << "\n--- Resultado con Insertion Sort (descendente) ---" << endl;
  cout << "Tiempo = " << msI << " ms | comparaciones = " << compI
       << " | movimientos = " << movI << endl;
  imprimirJuegos(a, n, "");

  cout << "\n--- Resultado con Selection Sort (descendente) ---" << endl;
  cout << "Tiempo = " << msS << " ms | comparaciones = " << compS
       << " | intercambios = " << swapS << endl;
  imprimirJuegos(b, n, "");

  cout << "\n--- Exportacion a CSV ---" << endl;
  exportarCSV("videojuegos_ordenado_insertion.csv", a, n);
  exportarCSV("videojuegos_ordenado_selection.csv", b, n);

  cout << "\n=== Comparacion de contadores ===" << endl;
  cout << "Insertion: comparaciones = " << compI << " | movimientos = " << movI << endl;
  cout << "Selection: comparaciones = " << compS << " | intercambios = " << swapS << endl;

  delete[] original;
  delete[] a;
  delete[] b;
  return 0;
}
```

#### Resultados de la ejecución

```
=== Ordenar videojuegos por puntaje (de mayor a menor) ===
Lista original (cargada desde videojuegos.txt):
  Codigo | Nombre | Puntaje
  VG-001 | The Legend of Zelda: Breath of the Wild | 96
  VG-002 | Super Mario Odyssey | 97
  VG-003 | God of War | 94
  ...
  VG-025 | Tales of Arise | 87
Total de elementos cargados: 25

--- Resultado con Insertion Sort (descendente) ---
Tiempo = 0.002314 ms | comparaciones = 115 | movimientos = 116
  VG-002 | Super Mario Odyssey | 97
  VG-004 | Red Dead Redemption 2 | 97
  VG-001 | The Legend of Zelda: Breath of the Wild | 96
  VG-009 | Elden Ring | 96
  VG-022 | Persona 5 | 95
  VG-003 | God of War | 94
  VG-006 | Uncharted 4: A Thief's End | 93
  VG-007 | The Witcher 3: Wild Hunt | 92
  VG-016 | Demon's Souls | 92
  VG-023 | Bloodborne | 92
  VG-008 | Sekiro: Shadows Die Twice | 90
  VG-005 | Horizon Zero Dawn | 89
  VG-012 | Ratchet & Clank: Rift Apart | 88
  VG-021 | Final Fantasy VII Remake | 88
  VG-013 | Gran Turismo 7 | 87
  VG-025 | Tales of Arise | 87
  VG-015 | Returnal | 86
  VG-024 | Ghost of Tsushima: Director's Cut | 86
  VG-011 | Spiderman: Miles Morales | 85
  VG-020 | Resident Evil Village | 84
  VG-017 | Ghost of Tsushima | 83
  VG-018 | Death Stranding | 82
  VG-014 | Sackboy: A Big Adventure | 79
  VG-010 | Detroit: Become Human | 78
  VG-019 | Days Gone | 71

--- Resultado con Selection Sort (descendente) ---
Tiempo = 0.002085 ms | comparaciones = 300 | intercambios = 21
  VG-002 | Super Mario Odyssey | 97
  VG-004 | Red Dead Redemption 2 | 97
  VG-001 | The Legend of Zelda: Breath of the Wild | 96
  VG-009 | Elden Ring | 96
  ... (misma lista ordenada)

--- Exportacion a CSV ---
Exportado a videojuegos_ordenado_insertion.csv
Exportado a videojuegos_ordenado_selection.csv

=== Comparacion de contadores ===
Insertion: comparaciones = 115 | movimientos = 116
Selection: comparaciones = 300 | intercambios = 21
```

Observación: con 25 elementos las comparaciones de Selection son fijas `= 25·24/2 = 300`,
mientras que Insertion hizo solo 115 (aprovecha el orden parcial), confirmando que para listas
**pequeñas o casi ordenadas** Insertion Sort es más eficiente. Ambos CSV exportados contienen las
25 líneas ordenadas de mayor a menor (encabezado `codigo,nombre,puntaje`).

---

## IV. CUESTIONARIO

### 1. ¿Cuál de los dos algoritmos es más eficiente si la lista ya está ordenada? ¿Por qué?

**Insertion Sort**, con complejidad **Ω(n)** en ese caso. Al recorrer cada elemento solo compara una
vez con el anterior (su `key` ya está bien ubicado) y no desplaza ningún elemento. **Selection Sort**,
en cambio, sigue haciendo **siempre** `n(n−1)/2` comparaciones porque debe *buscar* el mínimo del
subarreglo restante aunque no haya intercambios. En la medición con `n = 10000`: la lista ordenada
tardó **≈ 0.11 ms** con Insertion; con Selection serían las mismas `49 995 000` comparaciones de
siempre (≈ 64 ms), sin importar el orden.

### 2. ¿Qué significa que un algoritmo sea "in-place"?

Que ordena los elementos **dentro del propio arreglo**, sin necesidad de arreglos auxiliares
proporcionales a `n`; usa solo una cantidad **constante de memoria extra O(1)** (una variable temporal
para el intercambio). Tanto Insertion como Selection Sort son in-place: desplazan/intercambian
elementos sobre el mismo arreglo. *Contraejemplo:* Merge Sort copia a un arreglo temporal y usa
`O(n)` de memoria extra.

### 3. ¿Por qué se dice que Selection Sort no es estable?

Porque al intercambiar el elemento mínimo con la posición actual puede **saltar por encima de
elementos iguales**, alterando su orden relativo. Ejemplo con `(4a, 4b, 2)` (las `4` llevan subíndice
para distinguirlas): en la primera pasada el mínimo es `2` y se intercambia con `4a`, quedando
`(2, 4b, 4a)`; ahora `4a` quedó **después** de `4b`. Solo hay que desplazar elementos, no "saltarlos",
para conservar la estabilidad (como hace Insertion Sort, que por eso **sí es estable**).

### 4. ¿Cuál es la diferencia clave en el enfoque entre Insertion Sort y Selection Sort?

- **Insertion Sort** *inserta* cada elemento del prefijo desordenado en su **posición correcta
  dentro del prefijo ya ordenado**, creciendo el prefijo ordenado de a un elemento. El trabajo
  depende del **orden inicial** (pocas/muchas comparaciones).
- **Selection Sort** *selecciona* el **mínimo del subarreglo no ordenado** y lo ubica en la próxima
  posición, sin importar el orden: siempre `n(n−1)/2` comparaciones.

En resumen: Insertion **inserta (coloca)** haciendo muchos movimientos; Selection **selecciona** el
mejor candidato haciendo pocos intercambios pero comparaciones fijas.

### 5. ¿Podrías optimizar alguno de los dos algoritmos para mejorar su rendimiento? ¿Cómo?

1. **Insertion Sort + búsqueda binaria (Binary Insertion Sort):** localizar la posición de
   inserción con búsqueda binaria en el prefijo ordenado reduce las **comparaciones** de `O(n²)` a
   `O(n log n)` (aunque los **desplazamientos** siguen siendo `O(n²)`, útil cuando comparar es caro).
2. **Insertion con detección temprana:** llevar la cuenta de intercambios en cada pasada y terminar
   el algoritmo si el arreglo ya quedó ordenado (variante "comoving sensors"), ideal para listas casi
   ordenadas.
3. **Selection Sort por ambos extremos (Double-ended):** buscar simultáneamente el **mínimo y el
   máximo** y ubicarlos al inicio y al final, reduciendo las pasadas a la mitad
   (`n(n−1)/2` → ≈ `n²/4` comparaciones).
4. **Nuevo algoritmo para listas grandes:** usar Insertion para los primeros ~16 elementos y luego
   Merge Sort/Quick Sort (libre de `std::sort`), porque los `O(n²)` no escalan.

En general, para mejorar la eficiencia de un ordenamiento `O(n²)` conviene **cambiar de
paradigma**: Insertion Sort para listas pequeñas/casi ordenadas y un algoritmo `O(n log n)`
(introsort de `std::sort`, mergesort) para listas grandes.

---

## V. REFERENCIAS

- Cormen, T. H., Leiserson, C. E., Rivest, R. L., & Stein, C. (2022). *Introduction to Algorithms*. MIT Press.
- Sedgewick, R., & Wayne, K. (2011). *Algorithms*. Addison-Wesley.
- Brassard, G., & Bratley, P. (1996). *Fundamentals of Algorithmics*. Prentice Hall.