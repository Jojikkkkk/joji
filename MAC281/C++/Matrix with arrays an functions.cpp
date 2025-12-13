#include <iostream>
#include <iomanip>

using std::cout;
using std::endl;
using std::ostream;

const int M = 3;
const int N = 3;

typedef double MATRIX[M][N];

MATRIX A = {
	         {1, 0, -1},
			 {2, 2, -3},
	         {1, 4,  3}
           };


MATRIX B = {
			 {3, 4, -1},
			 {1, -3, 0},
			 {-1, 1, 2}
           };

MATRIX  C;

ostream& operator<<(ostream& out, const MATRIX A) {
	for (int i = 0; i < M; i++)
	{
		for (int j = 0; j < N; j++)
			out <<A[i][j] << ' ';
		out << endl;
	}

	return out;
}

void zeroMAT(MATRIX A)
{
  for (int i = 0; i < M; i++)
	for (int j = 0; j < N; j++)
	  A[i][j] = 0.0;
}

// sum = A + B
void addMAT(MATRIX sum, MATRIX A, MATRIX B) {
	zeroMAT(sum);
	for (int i = 0; i < M; i++)
		for (int j = 0; j < N; j++)
			sum[i][j] = A[i][j] + B[i][j];
}


int main()
{
	cout << A << endl;
	cout << B << endl;
	zeroMAT(C);
	cout << C << endl;
	addMAT(C, A, B);          // C = A + B
	cout << C << endl;
	return 0;
}
