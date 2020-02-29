#include <iostream>
#include <conio.h>
#include <string.h>

using namespace std;

int pass()
{
    int num,i=0;

    Loop:
   char c=' ';
   string pass="";
   cout << "Enter your 4 digits pin number" <<endl;
   while(c != 13)// Enter a password in an asterisk.
   {
       c=getch();// input without showing a screen
       if(c != 13){
        pass+=c;
        cout <<"*";
       }
   }
        num = stoi(pass); //change from string to number
            if(num > 999&&num < 10000){cout << "\nYour pin has been accepted!!" <<endl;// find 4 number digit 1000~9999

            }

            else{cout << "\nYou have entered the incorrect pin number!!...you must enter a four digits pin number."<<endl << endl;

                        if(i <= 1){ ++i; //use increment for count after 3 times putting wrong password terminate this program
                                goto Loop;
                        }else{
                         cout << "\nYou got wrong number 3 times. " <<endl;
                         cout << "This program will end accidentally" << endl;
                         exit(1);}
   }

}

int ATM(){
// 1. A welcome message.
   cout << endl << endl;
   cout << "\t********************************" << endl;
   cout << "\t*                              *" << endl;
   cout << "\t*           WElCOME!!          *" << endl;
   cout << "\t*                              *" << endl;
   cout << "\t*      This is a Joji Bank     *" << endl;
   cout << "\t*                              *" << endl;
   cout << "\t*  Enter your number           *" << endl;
   cout << "\t*      your like to operate    *" << endl;
   cout << "\t*   1.check your Balance       *" << endl;
   cout << "\t*   2.Withdraw your money      *" << endl;
   cout << "\t*   3.Deposit your money       *" << endl;
   cout << "\t*   4.Exit                     *" << endl;
   cout << "\t*                              *" << endl;
   cout << "\t********************************" << endl << endl<< endl ;
   int a,b,balance;

   balance = 8000;

Loop:cout <<endl<< "Enter the number ";
   cin >> a;
   cout << "Your number is " << a <<endl << endl;
   if(a==1){
    cout <<endl<< "Your current balance is " << balance <<endl;
       goto Loop;}

   else if(a==2){
        cout <<endl<< "Enter the amount you want to withdraw: "<<endl;
        cin >> b;
        balance = balance-b;
        cout <<"Your current balance is "<< balance <<endl;
       goto Loop;
   }

   else if(a==3){
       cout <<endl<< "Enter the amount you want to deposit: " <<endl;
        cin >> b;
        balance = balance + b;
        cout <<"Your current balance is: "<< balance <<endl;
       goto Loop;
   }
  // a variable for balance  that will remain while looping.
   else
       {cout << "Thank you for using this bank."<<endl;
        cout << "see you next time!\n" <<endl; }

    return 0;
}



int main(){

    pass();
    ATM();

    return 0;


}

