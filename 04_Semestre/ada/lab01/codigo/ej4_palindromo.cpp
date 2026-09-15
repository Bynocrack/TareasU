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

int main() {
  int nums[] = { 12321, 1221, 1991, 2002, 12345, 100001, 7, 123321 };
  int n = 8;

  cout << "=== Determinar si un numero es palindromo ===" << endl;
  for (int i = 0; i < n; i++) {
    int comp;
    int d = (int)to_string(nums[i]).length();
    bool pal = esPalindromo(nums[i], comp);
    cout << nums[i] << " (" << d << " digitos): "
         << (pal ? "SI es palindromo" : "NO es palindromo")
         << "  comparaciones=" << comp
         << "  limite d/2=" << d / 2 << endl;
  }
  return 0;
}