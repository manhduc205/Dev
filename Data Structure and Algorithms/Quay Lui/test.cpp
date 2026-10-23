#include <iostream>
#include <string>
using namespace std;

int a[100][100], n, cnt, check = 0;
string s;

void nhap(){
    cin >> n;
    for(int i = 1; i <= n; i++){
        for(int j = 1; j<= n; j++){
            cin >> a[i][j];
        }
    }
}

void Try(int i, int j){
    if(i == n && j == n){
        check = 1;
        cout << s << " ";
    }
    //thử đi sang phải hoặc xuống dưới
    //xuống dưới trước 
    if(i + 1 <= n && a[i + 1][j] == 1){
        a[i + 1][j] = 0;
        s += "D";
        Try(i + 1, j);
        a[i + 1][j] = 1;
        s.pop_back();
    }
    if(j + 1 <=n && a[i][j + 1] == 1){
        a[i][j + 1] = 0;
        s += "R";
        Try(i, j + 1);
        a[i][j + 1] = 1;
        s.pop_back();
    }
    if(i - 1 >= 1 && a[i - 1][j] == 1){
        a[i - 1][j] = 0;
        s += "U";
        Try(i - 1, j);
        a[i - 1][j] = 1;
        s.pop_back();
    }
    if(j - 1 >= 1 && a[i][j - 1] == 1){
        a[i][j - 1] = 0;
        s += "L";
        Try(i, j - 1);
        a[i][j - 1] = 1;
        s.pop_back();
    }
}

int main(){
    int t; cin >> t;
    while(t--){
        nhap();
        s = "";
        check = 0;
        Try(1, 1);
        if(check == 0){
            cout << "-1" << endl;
        }
        cout << endl;
    }
    
}