#include <iostream>
#include <cstring>
#include <queue>
int N, M;
char a[51][51];
int moveX[] = {-1,1,0,0}; 
int moveY[] = {0,0,-1,1};
using namespace std;
int bfs(){
    
}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T; cin >> T;
    for(int t = 1; t <= T; t++){
        cin >> N >> M;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                cin >> a[i][j];
            }
        }

    }
}