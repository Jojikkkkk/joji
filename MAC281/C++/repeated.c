#include<stdio.h>

int main(){
  int a[15] = {1,1,2,2,3,3,4,5,6,7,8,8,8,9};

  int n = 9;

  for(int i = 2; i<= n;i++){
      if(a[i] == a[i-1] && a[i] < a[i+1]){
        printf("%d",a[i]);
        printf("\n");}
      }

      return 0;
}
