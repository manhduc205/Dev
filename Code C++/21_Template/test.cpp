#include <iostream>
using namespace std;
template <class T> T timmin(T a, T b){
    return (a<b)? a : b;
}
int main(){
    int x = 4, y = 8;
    cout << timmin(x,y);
}