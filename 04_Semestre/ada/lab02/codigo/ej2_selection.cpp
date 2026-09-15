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