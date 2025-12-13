// The implementation may need some help in terms of
// >>>>efficiency. <<<<<

#include<iostream> // stdio: cin, cout, cerr, >> extractor, << insertion.
#include<vector>   // can grow using push_back() method.
#include<cmath>    // do we really need?
#include<iomanip>  // align digits of nicer output in general

using namespace std;
// Textbook page 258.
// The Fundamental Theorem of Arithmetic
// returns the address to a vector the holds
// the prime factors of N.
// where N is some positive number.

vector<int> *primeFactors(int n){
       vector<int> *temp = new vector<int>;
       int r, q;           // quotient and reminder.
       const int LAST = n;
       for (int test=2; test <= LAST; test++)
       {
        q = n;
        do {
            q = q/test;   // quotient
            r = n%test;   // remainder
            if ( r==0 )   // in test divides q, then
              {
               temp->push_back(test);  // remember this works
               n = q;                  // use q as divisor for next test
              }
        }while(r==0);
       }
       return temp;
}

      void display(int n, vector<int>* factors){
       cout << "prime factors of " << setw(5)<< n << " are: ";
       for (int f : *factors)
         cout << setw(3) << f << ' ';
       cout << endl;
      }


int main() {
    // list of number to work on are from pages 258 and 272 in the text.
    // (verify solutions using page S-25, manually, and the web)
        int list[] = {100, 999, 641, 1024, 88, 126, 729, 1001, 81, 101, 289, 1111};

        vector<int> *factors;

        for(auto n: list)
        {
       factors = primeFactors(n);  // a new list of factors
       display(n, factors);
       delete factors;  // return the old list to system
        }

        return 0;
  }
