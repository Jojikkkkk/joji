/* Group 2
   1. Describe an algorithm that takes as input a list of n
   integers and finds the number of negative integers in the list.*/

#include <iostream>
using namespace std;

 int Negative(int a[],int n){
     int tally=0;
    for(int i=0;i<n;i++)
        if(a[i]<0) // if a[i] is less than 0, tally will increment as finding negative number.
            tally++;
       return tally; // return the total nuber for finding negative numvers.

    }

int main()
{
    int a[]={-2,-4,5,4,-5,5,7,-9,44,56,-99};
    const int N= sizeof(a)/sizeof(int);
    int counting = Negative(a,N);
    if(counting == 0) // if counting is 0, that means negative nuber did not exsist in the array
      cout << "There is no negative number in the array" << endl;
    else
      cout<< "Negative numbers counting : "<< counting << endl;
    return 0;
}
