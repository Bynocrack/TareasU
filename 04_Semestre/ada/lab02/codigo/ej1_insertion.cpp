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