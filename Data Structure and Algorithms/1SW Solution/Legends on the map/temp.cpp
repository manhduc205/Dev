#include <iostream>
#include <vector>
#include <stack>
using namespace std;
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T; cin >> T;
    for(int t = 1; t <= T; t++){
        int R,C,r,c;
        cin >> R >> C >> r >> c;
        vector<vector<int>> a(R, vector<int> (C));
        for(int i = 0; i < r; i++){
            for(int j = 0; j < c; j++){
                cin >> a[i][j];
            }
        }
        stack<int> a;
        
        
    }
}