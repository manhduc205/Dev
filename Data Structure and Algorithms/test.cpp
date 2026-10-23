#include <iostream>
using namespace std;

int giaithua(int n){
    int gt = 1;
    for(int i = 1; i <= n; i++){
        gt *= i;
    }
    return gt;
}
float TinhEx(int x){
    int sum = 1;
    for(int i = 1; i > 0; i++){
        sum = sum + (pow(x, i) / giaithua(i));
    }
    return sum;
}
int main(){
    int n; cin >> n;
    int *a = new int[n];
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }
    FindMax(a, n);
}


void Xoa(M, L){
    if(L == NULL){
        return;
    }
    if(M == L){
        L = Next(M);
        delete(M);
        return;
    }
    P = L;
    while(Next(P) != M){
        P = Next(P);
    }
    Next(P) = Next(M);
    delete(M);
    return;
}