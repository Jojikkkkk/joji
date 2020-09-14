// Joji Kashimura 18/5/20
#include <iostream>

using namespace std;
int findmini(int*,int);

int main(){
    int graph,countnumber = 0;
    cout << "How many nodes are in the graph?: ";
    cin>> graph;
    int seqnum = graph - 2;
    cout << "Give the " << seqnum << " values in the sequence: ";
     int tree[graph],seq[graph-2];

    //user input for the sequence.
    for(int i = 0; i< seqnum;i++)
        cin >> seq[i];

    //inisilzing a tree array in which size is same as nodes.
    for (int i = 0; i < graph; i++)
           tree[i] = 0;

    cout << endl;
    // store numbers from user input in a tree array.
    for(int i = 0; i < seqnum; i++)
           tree[seq[i]-1] += 1;

    cout << "The spanning tree has the following links: ";
    //finding minimum number except for the same number in sequence at the graph - 2 times.
        for(int i=0;i<seqnum;i++){
            cout << "{" << findmini(tree,countnumber)<< ", " << seq[i] << "}" << endl;
            tree[seq[i] - 1] -=1;
        }

     //finding the lest of 2 numbers.
        for (int i=0;i<graph;i++) {
                  if (tree[i] == 0 && countnumber == 0) {
                      cout << "{"<<i+1<< ", ";
                      countnumber = 1;
                  }
                  else if(tree[i] == 0 && countnumber == 1)
                      cout << i+1 <<"}";
              }
        cout << endl;
        cout << "Thank you !!!!!";
        cout << endl;
        return 0;
    }
// a reclusion function to find minimum numbers
int findmini(int *arr,int n){
        if(arr[n] == 0){
            arr[n] = -1;
            return n+1;}
        else
            return findmini(arr,n+1);
    }
