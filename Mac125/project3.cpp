#include<iostream>
#include<string>
#include<cmath>
using namespace std;

 class Polynomial{
    private: double* arr;
    private: double a,b;
    private: int n;

     public :Polynomial(double a,double b, int n){
        this->a = a;
        this->b = b;
        this->n = n;
         arr = new double[n+1];
         function(a,b,n);
    }

     public :Polynomial(){
         this->a = 0;
         this->b = 0;
         this->n = 0;
     }

    public:void setA(double a){
        this->a=a;
    };
    public:void setB(double b){
        this->b=b;
    };
     public:void setN(int n){
         this->n=n;
         arr = new double[n+1];
     };

    public:double getA(){
     return a;
    };

    public:double getB(){
     return b;
    }

    public:int getN(){
     return n;
    }

     public:int fact(int n){
        if(n == 0||n== 1)
            return 1;
        else
            return n * fact(n-1);};

     public:int combination(int n,int i){
        return fact(n)/(fact(i) * fact(n-i));
     };

    public:void function(double a, double b, int n){
        int j = 0;
        for(int i = n; i >= 0;i--){
                arr[i] = combination(n,j)*pow(a,j)*pow(b,i);
                j++;
        }
    };

    public:double getCoeff(int k){return arr[k];};

    public:double calculate(double x){
        double total = 0;
        for(int i = n; i>=0;i--){
            total += arr[i] * pow(x,i);
            if(arr[i] * pow(x,i)<0)
            cout << arr[i] * pow(x,i) << " ";
            else
            cout << "+"<< arr[i] * pow(x,i) << " ";
        }
        cout <<"= ";
        return total;
    };

    public:void display(){
        cout << "(" << a <<" + "<< b<< "x)^"<< n <<" = ";
        for(int i = n;i>=1;i--){
            if(arr[i] > 1 && i!=1)
                cout <<"+"<< arr[i]<< "x^"<<i<<" ";
            else if(arr[i] < 0&& i!=1)
                cout << arr[i]<< "x^"<<i<<" ";
            else if(arr[1] > 1)
                cout <<"+"<<arr[1]<<"x ";
            else if(arr[1] < 0)
                cout << arr[1]<<"x ";

        }
        if(arr[0]>=0)
            cout <<"+"<< arr[0];
        else
             cout << arr[0];
    }

 };


int main(){
    double a,b,x;
    int n,k;
    cout << endl << "Joji Kashimura Project 3"<<endl;
    cout << "Enter value for a: ";
    cin >> a;
    cout << "Enter value for b: ";
    cin >> b;
    cout << "Enter value for n: ";
    cin >> n;
    Polynomial poly;
    poly.setA(a);
    poly.setB(b);
    poly.setN(n);
    poly.function(poly.getA(), poly.getB(), poly.getN());
    cout << endl << "Testing display():" << endl;
    poly.display();

    cout << endl << endl << "Testing calculate(): ";
    cout << endl << "Enter value for x: ";
    cin >> x;
    cout <<"P("<< x <<") = " << poly.calculate(x) << endl;

    cout << endl << "Testing getCoeff(k) :" << endl;
    cout <<"Enter k: ";
    cin >> k;
    cout <<"The cofficient for x^"<< k <<" is : " << poly.getCoeff(k)<< endl<< endl;
    cout <<"Thank you!!!!!!!!"<<endl<<endl<<endl;
    return 0;
}
