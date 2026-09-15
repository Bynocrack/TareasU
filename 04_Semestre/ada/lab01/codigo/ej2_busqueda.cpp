#include <iostream>
#include <string>
#include <chrono>
#include <cstdio>
using namespace std;

// Búsqueda simple: buscar palabra dentro de un texto (la recorre posición por posición).
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

// Contar todas las apariciones de la palabra en el texto.
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

// Contar cuántos son iguales a la palabra (los repetidos quedan juntos en lista ordenada).
int contarEnLista(string lista[], int n, const string &palabra, long long &comp) {
  int pos = buscarEnLista(lista, n, palabra, comp);
  if (pos == -1) return 0;
  int cnt = 1;
  for (int i = pos - 1; i >= 0 && lista[i] == palabra; i--) cnt++;
  for (int i = pos + 1; i < n && lista[i] == palabra; i++) cnt++;
  return cnt;
}

string name(int i) {
  char buf[32];
  snprintf(buf, sizeof(buf), "palabra%09d", i);
  return string(buf);
}

void medirTexto() {
  cout << "\n=== Crecimiento del texto (peor caso: texto de puras 'a', palabra 'aaaaab') ===" << endl;
  string word = "aaaaab";
  for (int N : {100000, 1000000, 10000000}) {
    string texto(N, 'a');
    long long comp;
    auto t0 = chrono::steady_clock::now();
    int pos = buscarEnTexto(texto, word, comp);
    auto t1 = chrono::steady_clock::now();
    double ms = chrono::duration<double, milli>(t1 - t0).count();
    cout << "n=" << N << "  pos=" << pos << "  comparaciones=" << comp
         << "  tiempo=" << ms << " ms" << endl;
  }
}

void medirLista() {
  cout << "\n=== Crecimiento del tamano de la lista (busqueda binaria) ===" << endl;
  for (int M : {1000, 10000, 1000000}) {
    string *lista = new string[M];
    for (int i = 0; i < M; i++) lista[i] = name(i);
    string clave = name(M / 2);
    long long comp;
    auto t0 = chrono::steady_clock::now();
    int pos = buscarEnLista(lista, M, clave, comp);
    auto t1 = chrono::steady_clock::now();
    double ms = chrono::duration<double, milli>(t1 - t0).count();
    cout << "n=" << M << "  pos=" << pos << "  comparaciones=" << comp
         << "  tiempo=" << ms << " ms" << endl;
    delete[] lista;
  }
}

int main() {
  string texto = "la casa de la esquina es grande y la casa de al lado es pequena";
  string palabra = "casa";

  long long comp;
  int pos = buscarEnTexto(texto, palabra, comp);
  cout << "Texto: \"" << texto << "\"" << endl;
  cout << "Buscando \"" << palabra << "\" en el texto..." << endl;
  if (pos != -1)
    cout << "Elemento encontrado en la posicion " << pos << " (" << comp << " comparaciones)" << endl;
  else
    cout << "Elemento no encontrado (" << comp << " comparaciones)" << endl;

  cout << "\nLa palabra se repite " << contarEnTexto(texto, palabra, comp)
       << " veces en el texto (" << comp << " comparaciones para contarlas todas)" << endl;

  string lista[] = { "algoritmo", "casa", "complejidad", "datos", "eficiencia",
                     "lineal", "logaritmo", "ordenamiento", "recursion", "tiempo" };
  int n = 10;

  pos = buscarEnLista(lista, n, "eficiencia", comp);
  cout << "\nLista ordenada: ";
  for (int i = 0; i < n; i++) cout << lista[i] << " ";
  cout << endl;
  cout << "Buscando \"eficiencia\" (binaria): pos=" << pos
       << " (" << comp << " comparaciones)" << endl;

  medirTexto();
  medirLista();
  return 0;
}