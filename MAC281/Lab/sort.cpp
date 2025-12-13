#include<iostream>
#include<vector>
#include<algorithm>    // sort(), generate()
#include<chrono>
#include<fstream>
using namespace std;

long long int bubblesort(vector<int> &a,int n);
long long int insertionSort(vector<int> &a,int n);
long long int SelectionSort(vector<int> &arr, int n);

int main()
{
    // empty vector
    vector<long long int> data;
    ofstream fout;
    fout.open("data.txt");

    // set of values to test n
    for (auto n : {100000,1000000,10000000,100000000,1000000000})
    {
        data.clear();    // wipe-out vector
        data.resize(n);  // resize

        // anomyous/lambda function used to Generate PRN (rand() is old technique)
        auto random = [&n]() { return rand() % n; };

        // Fill up the vector
        generate(begin(data), end(data), random);

        // start time
        auto time1 = chrono::high_resolution_clock::now();

        // Call your function: bubble Sort
        sort(begin(data), end(data));

        // end time
        auto time2 = chrono::high_resolution_clock::now();

        auto timeMeasure = chrono::duration_cast<chrono::milliseconds>(time2 - time1);

        // send to file an graph with excel
        cout << "Time to sort : " << n << " number was: " << timeMeasure.count() << " milli-sec\n";
        fout << n << "\t" << timeMeasure.count() << "\n";
    }
  }// get next batch to sort.
    /*
        cout << "\n\n\n"<< "BubbleSort" << endl;
        fout << "\n\n\n"<< "BubbleSort" << endl;
    for (auto n : {100,1000,2000,5000,9000,10000,50000,90000,100000})
    {
        data.clear();    // wipe-out vector
        data.resize(n);  // resize

        // anomyous/lambda function used to Generate PRN (rand() is old technique)
        auto random = [&n]() { return rand() % n; };

        // Fill up the vector
        generate(begin(data), end(data), random);

        // start time
        auto time1 = chrono::high_resolution_clock::now();

        // Call your function: bubble Sort
      long long int xs  = bubblesort(data,n);

        // end time
        auto time2 = chrono::high_resolution_clock::now();

        auto timeMeasure = chrono::duration_cast<chrono::milliseconds>(time2 - time1);

        // send to file an graph with excel
        cout << "Time to sort : " << n << " number was: " << timeMeasure.count() << " milli-sec    " << "This is how many times swap " << xs<<"\n";
        fout << n << "\t" << timeMeasure.count() <<"\n";

      } // get next batch to sort.

    cout << "\n\n\n"<< "InsertionSort" << endl;
    fout << "\n\n\n"<< "InsertionSort" << endl;
for (auto n : {100,1000,2000,5000,9000,10000,50000,90000,100000})
{
    data.clear();    // wipe-out vector
    data.resize(n);  // resize

    // anomyous/lambda function used to Generate PRN (rand() is old technique)
    auto random = [&n]() { return rand() % n; };

    // Fill up the vector
    generate(begin(data), end(data), random);

    // start time
    auto time1 = chrono::high_resolution_clock::now();

    // Call your function: bubble Sort
    long long int xs = insertionSort(data,n);

    // end time
    auto time2 = chrono::high_resolution_clock::now();

    auto timeMeasure = chrono::duration_cast<chrono::milliseconds>(time2 - time1);

    // send to file an graph with excel
    cout << "Time to sort : " << n << " number was: " << timeMeasure.count() << " milli-sec    " << "This is how many times swap " << xs<<"\n";
    fout << n << "\t" << timeMeasure.count() << "\n";
}// get next batch to sort.


cout << "\n\n\n"<< "SelectionSort" << endl;
fout << "\n\n\n"<< "SelectionSort" << endl;
for (auto n : {100,1000,2000,5000,9000,10000,50000,90000,100000})
{
data.clear();    // wipe-out vector
data.resize(n);  // resize

// anomyous/lambda function used to Generate PRN (rand() is old technique)
auto random = [&n]() { return rand() % n; };

// Fill up the vector
generate(begin(data), end(data), random);

// start time
auto time1 = chrono::high_resolution_clock::now();

// Call your function: bubble Sort
long long int xs = SelectionSort(data,n);

// end time
auto time2 = chrono::high_resolution_clock::now();

auto timeMeasure = chrono::duration_cast<chrono::milliseconds>(time2 - time1);

// send to file an graph with excel
cout << "Time to sort : " << n << " number was: " << timeMeasure.count() << " milli-sec    " << "This is how many times swap " << xs<<"\n";
fout << n << "\t" << timeMeasure.count() << "\n";
}
    fout.close();
    return 0;
}

long long int bubblesort(vector<int> &a,int n){
  long long int count =0;
  for(int i = 0; i < n;i++){
    for(int j = 0;j<n-i;j++)
      if(a[j+1]< a[j]){
        int b = a[j];
        a[j] = a[j+1];
        a[j+1] = b;
        count++;
      }
  }
  return count;
};

long long int insertionSort(vector<int> &a,int n){
    int j,m;
    long long int count=0;
  for(int i=1; i<n;i++){
      m = a[i];
      j =i-1;
      if(j>=0&&a[j]>m)
        count++;
      while(j>=0&&a[j]>m)
      {
        a[j+1] = a[j];
        j = j-1;
      }
      a[j+1] = m;
  }
  return count;
}

long long int SelectionSort(vector<int>  &a, int n)
{
    int i,j,min;
    long int count=0;
    // One by one move boundary of unsorted subarray
    for (i = 0; i < n-1; i++)
    {
        // Find the minimum element in unsorted array
        min = i;
        for (j = i+1; j < n; j++)
        if (a[j] < a[min]){
            min = j;
            count++;
          }
        // Swap the found minimum element with the first element
        swap(a[min],a[i]);

    }
    return count;
}*/
