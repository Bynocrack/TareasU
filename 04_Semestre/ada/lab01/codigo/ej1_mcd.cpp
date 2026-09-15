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

int main() {
  cout << "=== Correctitud (comparacion de resultados) ===" << endl;

  long long cuenta;
  cout << "MCD(48, 36)       Euclides = " << mcdEuclides(48, 36, cuenta)
       << " (" << cuenta << " divisiones)" << endl;
  cout << "MCD(48, 36)       Bucle    = " << mcdBucle(48, 36, cuenta)
       << " (" << cuenta << " iteraciones)" << endl;

  cout << "MCD(100, 75)      Euclides = " << mcdEuclides(100, 75, cuenta)
       << " (" << cuenta << " divisiones)" << endl;
  cout << "MCD(100, 75)      Bucle    = " << mcdBucle(100, 75, cuenta)
       << " (" << cuenta << " iteraciones)" << endl;

  cout << "MCD(17, 5)        Euclides = " << mcdEuclides(17, 5, cuenta)
       << " (" << cuenta << " divisiones)" << endl;
  cout << "MCD(17, 5)        Bucle    = " << mcdBucle(17, 5, cuenta)
       << " (" << cuenta << " iteraciones)" << endl;

  cout << "MCD(1000003, 1000000) Euclides = " << mcdEuclides(1000003, 1000000, cuenta)
       << " (" << cuenta << " divisiones)" << endl;
  cout << "MCD(1000003, 1000000) Bucle    = " << mcdBucle(1000003, 1000000, cuenta)
       << " (" << cuenta << " iteraciones)" << endl;

  cout << "\n=== Peor caso de Euclides: pares de Fibonacci consecutivos ===" << endl;
  cout << "MCD(6765, 4181)   Euclides = " << mcdEuclides(6765, 4181, cuenta)
       << " (" << cuenta << " divisiones)" << endl;
  cout << "MCD(10946, 6765)  Euclides = " << mcdEuclides(10946, 6765, cuenta)
       << " (" << cuenta << " divisiones)" << endl;
  cout << "MCD(2147483647, 1836311903) Euclides = " << mcdEuclides(2147483647, 1836311903, cuenta)
       << " (" << cuenta << " divisiones)" << endl;

  cout << "\n=== Comparacion de tiempo de ejecucion ===" << endl;

  int a = 1000003, b = 1000000;

  long long repsEuclides = 2000000;
  long long suma = 0;
  auto t1 = chrono::steady_clock::now();
  for (long long r = 0; r < repsEuclides; r++) {
    suma += mcdEuclides(a, b, cuenta);
  }
  auto t2 = chrono::steady_clock::now();
  cout << "Euclides (" << repsEuclides << " llamadas): "
       << chrono::duration_cast<chrono::milliseconds>(t2 - t1).count()
       << " ms (suma de resultados = " << suma << ")" << endl;

  long long repsBucle = 100;
  long long suma2 = 0;
  auto t3 = chrono::steady_clock::now();
  for (long long r = 0; r < repsBucle; r++) {
    suma2 += mcdBucle(a, b, cuenta);
  }
  auto t4 = chrono::steady_clock::now();
  cout << "Bucle    (" << repsBucle << " llamadas, cada una con ~1,000,000 de pasos): "
       << chrono::duration_cast<chrono::milliseconds>(t4 - t3).count()
       << " ms (suma de resultados = " << suma2 << ")" << endl;

  return 0;
}