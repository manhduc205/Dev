#include <iostream>
#include <algorithm>
using namespace std;
/*
cho một mảng , tìm giá trị nhỏ nhất thuộc mảng a[] lớn hơn a[i] (i = 0, ... n -1)
đưa ra '-' nếu k có phan tu nao lon hơn nó 
*/
int main(){
    int n;
    cin >>n;
    int a[n];
    for(int i = 0; i < n; i++){
        cin >>a[i];
    }
    int b[n];
    for(int i = 0; i < n; i++){
        b[i] =a[i];
    }
    sort(a, a+n);
    for(int i = 0; i < n; i++){
        auto it = upper_bound(a, a + n, b[i]);
        if(it != a + n){
            cout << *it << " ";
        }
        else cout << "_" << " ";
    }
    return 0;
}