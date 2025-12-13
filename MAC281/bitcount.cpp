#include <iostream>
#include <vector>
using namespace std;


bool CheckUPC(int upc[], int N)
{
	int sum{ 0 };
	for (int i = 0; i < N; i++)
	{
		int k = (i % 2 == 0) ? 3 : 1;  // coefficients
		sum += k * upc[i];
	}
	return (sum % 10 == 0);   // must be mod 10
}


int bitCount(int n) {
	auto q{ n };
	auto k{ 0 };
	while (q != 0) {
		auto r = q % 2;
		if (r > 0) k++;
		q = q / 2;       // this will reduce to zer0. log N
	}
	return k;
}

// parity bit: {0, 1}
unsigned int DataAndParity(int n) {
	auto pBit{ bitCount(n) % 2 };
	n = n << 1;        // shift left 1 bit
	return  n + pBit;
}

// see page 305, with hardcoded parameters
// linear congruntial pseudorandom generator
// Its cycle is far too small to be useful
class PRNG {   // change a,c,n for each generator
	int a = 7;   // x = (ax + c) mod n
	int c = 4;   // set to zero for pure multiplicative generator
	int n = 9;   // modulo n
	int x;       // will be x0 ... xn, xn+1 ....
public:
	PRNG(int seed) : x(seed) { }  // Contructor to start it all off
	int rand() { return x = (a * x + c) % n; }
};


void foo2() {
	PRNG prng(3);  // see example 3 page 305... x0=3
	vector<int> numbers{};
	for (;;) {
		int r = prng.rand(); // get a number
		bool dupFound = std::find(begin(numbers), end(numbers), r) != end(numbers);
		if (dupFound) break;     // cycle has begun, leave loop
		numbers.push_back(r);    // add new number
	}
	std::cout << " we have " << numbers.size() << " unique number sequence\n";
	std::cout<<"found: ";
	for (auto r : numbers)
		std::cout << r << ' ';
	std::cout << std::endl;

}



int foo1() {

	unsigned short x;
	x = 7;
	int k=  bitCount(x);
	cout << " is " << x << " bit count " << k << endl;
	auto DataParity = DataAndParity(x);   // 5
	cout << " is " << x << " parity version " << DataParity << endl;
	return 0;
}




int main()
{
	//foo1();
	foo2();


	return 0;
}
