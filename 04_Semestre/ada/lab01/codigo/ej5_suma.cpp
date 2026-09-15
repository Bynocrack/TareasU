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

int main() {
  cout << "=== Verificacion de resultados (bucle vs formula n(n+1)/2) ===" << endl;
  for (int k : {0, 5, 100, 1000000, 100000000}) {
    cout << "n=" << k << "  bucle=" << sumaBucle(k)
         << "  formula=" << sumaFormula(k) << endl;
  }

  cout << "\n=== Numero de pasos (aproximado) ===" << endl;
  for (int k : {100, 1000000, 1000000000}) {
    cout << "n=" << k << ": bucle = ~" << 3LL * k
         << " operaciones (1 suma + 1 incremento + 1 comparacion por iteracion)"
         << " ; formula = 3 operaciones (1 multiplicacion + 1 suma + 1 division)" << endl;
  }

  cout << "\n=== Comparacion de tiempo de ejecucion ===" << endl;
  int n = 100000000;

  auto t0 = chrono::steady_clock::now();
  long long r1 = sumaBucle(n);
  auto t1 = chrono::steady_clock::now();
  cout << "Bucle   n=" << n << ": " << r1 << " en "
       << chrono::duration<double, milli>(t1 - t0).count() << " ms" << endl;

  auto t2 = chrono::steady_clock::now();
  long long r2 = sumaFormula(n);
  auto t3 = chrono::steady_clock::now();
  cout << "Formula n=" << n << ": " << r2 << " en "
       << chrono::duration<double, milli>(t3 - t2).count() << " ms" << endl;

  return 0;
}