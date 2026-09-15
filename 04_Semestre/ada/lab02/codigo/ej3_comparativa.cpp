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