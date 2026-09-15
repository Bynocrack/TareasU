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