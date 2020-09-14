#include <iostream>
#include <climits>
#include <algorithm>
using namespace std;

void Optimal(int,int,int []);


// nuber of items weight of the knapsack
    int n, W;
// an array of wieigh and value
    int value[300],weight[300];
// an array to store the results
    int V[300][300];



int main() {

    // initialze Knapsack array.
       for (int w = 0; w <= W; ++w) V[0][w] = 0;
    // input of inforamtions
    cout <<endl<< "Joji Kashimura 6/3/2020"<< endl<<endl<<endl;
    cout << "What is the number of the items :";
    cin >> n;
    cout << endl;
    cout << "What is the weight of your Knapsack? :";
    cin >> W;
    cout << endl;

    cout << "Enter your items'value and weight" << endl;

    for (int i = 0; i < n; ++i){
        cout << "  Value :";
        cin >> value[i];
        cout << "  Weight :";
        cin >> weight[i];
        cout << i+1 <<" V(" << value[i] <<", "<< weight[i] <<")" <<endl<<endl<<endl;
    }



    // compare which value is bigger if the vlaue put in the knapsack. It will sum up the result.
    for (int i = 0; i < n; ++i) {
        for (int w = 0; w <= W; ++w) {
            if (w >= weight[i]){
            V[i+1][w] = max(V[i][w-weight[i]] + value[i], V[i][w]);
            }
            else V[i+1][w] = V[i][w];
        }
    }

    int *ans =  new int[n];
    Optimal(n,W,ans);

    // Display of the results
    cout <<endl << "The item value and weight "<< endl << endl;
    for(int i=0;i< n;i++){
        cout<<"     V("<< value[i] << ", "<< weight[i] <<"). ";
        if(ans[i])
           cout  <<"This item is in the Knapsack."<< endl << endl;
        else
            cout <<"This item is not in the Knapsack." <<endl << endl;
    }
    cout <<"The maxmum valuea is :"<< V[n][W] << endl << endl;
    cout <<"Thank you !!!" <<endl<<endl<< endl;

    return 0;
}

     //find out which items is in the Knapsack. if the items is in the knapsack, an array will store 1 otherwise 0.
void Optimal(int i,int w,int ans[n]){
    int y=w,k=i-1;
    for(;k>=0;k--){
        if (y >= weight[k] && max(V[k][y-weight[k]]+value[k], V[k][y])==V[k][y])
        {
            ans[k]=0;
        }
        else if(y >= weight[k] && max(V[k][y-weight[k]] + value[k], V[k][y]) == V[k][y-weight[k]] + value[k])
        {
            ans[k]=1;
            y=y-weight[k];
        }
        else if(y < weight[k])
        {
            ans[k]=0;
        }
    }
}
