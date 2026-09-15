#include <iostream>
#include <string>
#include <algorithm>
#include <chrono>
#include <cstdio>
using namespace std;

string gen(int i) {
  char buf[32];
  snprintf(buf, sizeof(buf), "Apellido%08d", i % 100000);
  return string(buf);
}

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

// Versión que cuenta las comparaciones realizadas.
void burbujaConCuenta(string arr[], int n, long long &comp) {
  comp = 0;
  for (int i = 0; i < n - 1; i++) {
    for (int j = 0; j < n - 1 - i; j++) {
      comp++;
      if (arr[j] > arr[j + 1]) {
        string t = arr[j];
        arr[j] = arr[j + 1];
        arr[j + 1] = t;
      }
    }
  }
}

int main() {
  cout << "=== Ordenar nombres en orden alfabetico (Burbuja y sort()) ===" << endl;

  string nombres[] = { "Luis", "Ana", "Carlos", "Maria", "Pedro", "Sofia", "Juan" };
  int n = 7;

  string copia[7];
  for (int i = 0; i < n; i++) copia[i] = nombres[i];

  burbuja(nombres, n);
  cout << "Burbuja : ";
  for (int i = 0; i < n; i++) cout << nombres[i] << " ";
  cout << endl;

  sort(copia, copia + n);
  cout << "sort()  : ";
  for (int i = 0; i < n; i++) cout << copia[i] << " ";
  cout << endl;

  cout << "\n=== Numero de comparaciones de la burbuja (n(n-1)/2) ===" << endl;
  for (int N : {10, 100, 1000}) {
    string *a = new string[N];
    long long comp;
    for (int i = 0; i < N; i++) a[i] = gen(i);
    burbujaConCuenta(a, N, comp);
    cout << "n=" << N << "  comparaciones=" << comp
         << "  n(n-1)/2=" << ((long long)N * (N - 1) / 2) << endl;
    delete[] a;
  }

  cout << "\n=== Comparacion de tiempo (mismo tamano de entrada) ===" << endl;
  int N = 5000;
  string *a = new string[N];
  for (int i = 0; i < N; i++) a[i] = gen(N - i);

  auto t0 = chrono::steady_clock::now();
  burbuja(a, N);
  auto t1 = chrono::steady_clock::now();
  bool ok1 = is_sorted(a, a + N);
  cout << "Burbuja n=" << N << ": "
       << chrono::duration<double, milli>(t1 - t0).count() << " ms (ordenado="
       << (ok1 ? "si" : "no") << ")" << endl;

  string *b = new string[N];
  for (int i = 0; i < N; i++) b[i] = gen(N - i);
  auto t2 = chrono::steady_clock::now();
  sort(b, b + N);
  auto t3 = chrono::steady_clock::now();
  bool ok2 = is_sorted(b, b + N);
  cout << "sort()  n=" << N << ": "
       << chrono::duration<double, milli>(t3 - t2).count() << " ms (ordenado="
       << (ok2 ? "si" : "no") << ")" << endl;

  cout << "\n=== sort() sigue siendo rapido con listas grandes ===" << endl;
  int M = 500000;
  string *c = new string[M];
  for (int i = 0; i < M; i++) c[i] = gen(M - i);
  auto t4 = chrono::steady_clock::now();
  sort(c, c + M);
  auto t5 = chrono::steady_clock::now();
  bool ok3 = is_sorted(c, c + M);
  cout << "sort()  n=" << M << ": "
       << chrono::duration<double, milli>(t5 - t4).count() << " ms (ordenado="
       << (ok3 ? "si" : "no") << ")" << endl;

  delete[] a;
  delete[] b;
  delete[] c;
  return 0;
}