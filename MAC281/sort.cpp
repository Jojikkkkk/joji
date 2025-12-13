#include <iostream>
using namespace std;

int main()
{
  const int N = 6;  //6 variables
  int data[N] = { 100, 99, 88, 87, 5, 66 };

  for (int x : data) cout << x << ' ';
  cout << endl;

  for(int j=0; j<N; j++)
   for (int i = 0; i < N-1; i++)  //N-1 test
    if (data[i] > data[i+1] ) swap(data[i], data[i+1]);     // N-1 tests

  for (int x : data) cout << x << ' ';
  cout << endl;

}
