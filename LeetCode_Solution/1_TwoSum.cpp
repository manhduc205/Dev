#include <iostream>
#include <algorithm>
using namespace std;
int n, a[10000001];

void ktao(){
    cin >> n;
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }
}

void sinhHoanVi(int a[], int n){
    int i = n - 2;
    while(i >= 0 && a[i] >= a[i + 1]){
        --i;
    }
    if(i >= 0){
        int j = n - 1;
        while(a[i] >= a[j]){
            --j;
        }
        swap(a[i], a[j]);
    }
    reverse(a + i + 1, a + n);
}

int main(){
    int t; cin >> t;
    while(t--){
        ktao();
            sinhHoanVi(a, n);
            for(int i = 0; i < n; i++){
                cout << a[i] << " ";
            }
            cout << endl;
    }
}