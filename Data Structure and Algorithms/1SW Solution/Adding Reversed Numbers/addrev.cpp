#include <iostream>
using namespace std;

int reverseNum(int n){
    int tmp = 0;
    while ( n > 0){
        tmp = tmp * 10 + n % 10;
        n /= 10;
    }
    return tmp;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int N;
    cin >> N;
    while(N--){
        int a, b;
        cin >> a >> b;
        int sum = reverseNum(a) + reverseNum(b);
        cout << reverseNum(sum) << '\n';
    }
}
