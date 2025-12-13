#include <iostream> // Joji Kashimura 11/14/2020
using namespace std;

int Assign(bool [], int, int);

int main() {
    	const int NOSPOT = -1;
    	const int N = 31;  //A parking lot with 31 spaces
    	bool lot[N]{ false };
      // 40 licensed cars try to park in my parking lot.
    	for (int  p : { 317, 918, 007, 317, 317, 100, 111, 310, 118, 119,
                    /*314, 982, 006, 344, 387, 102, 113, 357, 142, 199,
                      399, 923, 004, 322, 310, 104, 114, 316, 122, 333,
                      620, 222, 334, 534, 911, 667, 777, 387, 333, 678*/} )
    	{
    		int loc = Assign(lot, N, p);
    		if (loc == NOSPOT)
           cout << "Sorry no parking space any more!\n";
           // Unfortunately, 9 cars can not park in my parking lot.
    		else
    			cout <<  "Your car parks in section " << loc << endl;
          // 31 cars can park in my parking lot.
		}
}

// prototype
int Assign(bool lot[], int N,  int p )
{
    	int spot = p % N,i = 0; // hashing function
    	if (lot[spot])    // someone has parked here
    	{
        while(lot[spot]){ // while someone has parked, keeping to look for free space.
          spot = p%N+i%N; // using a linear probing fincting to find free spacee.
          if(30<spot)     // If there are no free spaces in the entire lot, return -1 that means the lot is full.
            return -1;
        i++;
        }
        lot[spot] = true; // If free sapce is found, your car can park.
    	}
    	else
    		lot[spot] = true;
    	return spot;
}
