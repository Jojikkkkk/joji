#include <iostream>
#include <cassert>
#include <algorithm>
using namespace std;


void show(int v[], int N)
{
    for (int i = 0; i < N; i++)
        cout << v[i] << ' ';
    cout << "\n-----\n";
}

void bubbles1(int d[], int N)
{
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N - 1; j++)
            if (d[j] > d[j + 1]) swap(d[j], d[j + 1]);
}

bool myChoicelow(int a, int b) { return a > b; }
bool myChoicehigh(int a, int b) { return a < b; }

void bubbles2(int d[], int N, bool (*fun)(int, int)   )
{
    for (int i = 0; i < N; i++)
        for (int j = 0; j < N - 1; j++)
            if ( fun(d[j], d[j + 1]) ) swap(d[j], d[j + 1]);
}


int main()
{
    int data[] = { 34,55,66,77,200, 88, 99, 1, 4, 6 };
    const int N = sizeof(data) / sizeof(int);

    show(data, N);
    //sort(data, data + N);
    //bubbles1(data, N);
    bubbles2(data, N, myChoicehigh);
    show(data, N);

}
