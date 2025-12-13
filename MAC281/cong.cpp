#include <iostream>
using namespace std;

void generator(int x[],int m,int c,int a){
  int i=1;
    x[i] = (a*x[0]+c)% m;
    cout << x[0] << " ";
    while(i<9)
  {
    x[i+1] = ((a*x[i]+c)% m);
    i++;
  }
}

int main()
{
    int x[10]; // Seed value
    x[0] = 2;
    int m = 11; // Modulus parameter
    int a = 3; // Multiplier term
    int c = 0; // Increment term
    generator(x,m,c,a);
    // Print the generated random numbers
    for (int i = 1; i < 10; i++) {
        cout << x[i] << " ";
    }

    return 0;
}
