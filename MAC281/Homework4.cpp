/* Group 2
4. A palindrome is a string that reads the same forward and backward.
Describe an algorithm for determining whether a string of n characters is a palindrome. */

#include<iostream>
#include<string>
#include <locale>

using namespace std;

bool palindrome(string s){
  locale loc;
  for(int i = 0; i < s.length();i++)
    if(tolower(s[i],loc)!= tolower(s[s.length()-i-1],loc)) // compring the string front index and rear index if not much them, return false;
      return false;                                        // Samll or Captical Latters don't matter

  return true; // otherwise return true as the string is palindrome;
}
void display(string str){ // display whether the string is palindrome or not
  if(palindrome(str))
    cout <<str<< " is a palindrome"<< endl;
  else
    cout <<str<<" is not a palindrome"<< endl;
}

int main(){
  string str = "HelloWorld";
  string strr = "Level";
  string strrr ="taTtArrATtat";

  display(str);
  display(strr);
  display(strrr);

  return 0;
}
