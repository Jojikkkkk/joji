/* Group 2
   2.Describe an algorithm that takes as input a list of n integers
   and finds the location of the last even integer in the list
   or returns 0 if there are no even integers in the list.*/

#include <iostream>
using namespace std;

int LastEven(int a[],int n){
       int position=0;
        for(int i=0;i<n;i++) // checking even number in the array.
            if(a[i]%2==0){
               position=i;  //if evennumber was found position will store its location
        }
        return position; // return LastEven location and if not found even number it return 0.
    }

int main()
{
    int a[]={-2,-4,5,4,-5,5,7,-9,44,56,-99};
    const int N=sizeof(a)/sizeof(int);
    int location = LastEven(a,N);
    if(location==0)
    cout << "There are no even numvers in the array." <<endl; //if lasteven is 0, no evennubers were in the array.
    else
    cout<<"Lasteven location: "<< location+1<< " in the array." <<endl; // Display the location in the array. I added +1 becuase of remaing conting form
    return 0;
}
