// Joji kashimura 3/24/20
#include <iostream>
#include <math.h>

using namespace std;

int a,b,c,m,n;
void setmn();
void loop(int[],int);
int closedform(int);

int main(){
    cout <<"Project#1 Joji Kashimura 3/24/20"<< endl << endl;
    setmn();
    cout <<"Give the values for a,b and c: ";
    cin >> a;
    cin >> b;
    cin >> c;
    int m = ::m;
    int n = ::n;
    int sum = 0,loopin = n-m+1;
    int sequence[n-m],sums[n-m];

    for(int i = 0;i<loopin;++i){
        sequence[i] = (a*pow(m+i,2)) + (b*(m+i)) + c;
        sum += sequence[i];
        sums[i] = sum;
    }

    cout << endl <<"The sequence of value is : ";
    loop(sequence,loopin);
    cout << endl<< endl << "The partial sum is : "<< sum <<endl;
    cout << "The closed form solution is: "<< closedform(::n) - closedform(::m-1) <<endl << endl;
    cout << "The sequence of sums is : ";
    loop(sums,loopin);
    cout << endl <<endl;

    return 0;
}

void setmn(){ //Setter for m and n, and checking integer for between -50 and 50
    cout <<"Give the values for m and n: ";
    cin >> m;
    cin >> n;
   if(abs(m) > 50){
        cout << "please maing btween -50 to 50 "<< endl << endl;;
        setmn();}
    if(abs(n) > 50){
        cout << "please maing btween -50 to 50 "<< endl << endl;;
        setmn();}
}

void loop(int x[],int loop){ // showing arrays by loop
    for(int i = 0;i<loop; i++){
        cout << x[i] << " ";}
}

//This is closed form for the equation.
int closedform(int n){
    return (a*((n*(n+1)*(2*n+1))/6))+ (b*(n*(n+1))/2) + (c*n);
}
