#include<iostream>
using namespace std;

int main(){
    int a[3];
    for(int i=0;i < 3;i++){
        cin >> a[i];}

  for(int i = 0; i<3;i++){
    int min = i;
    for(int j = i+1;j<3;j++){
      if(a[j] < a[min])
        min = j;
      }
    swap(a[i],a[min]);
    }

    for(int i=0;i < 3;i++){ cout << a[i];
        if(i != 2)
        cout << " ";}
        cout <<endl;
    return 0;
}
