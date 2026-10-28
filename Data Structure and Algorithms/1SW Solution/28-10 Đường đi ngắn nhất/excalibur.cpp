#include <iostream>
#include <queue>
#include <tuple>
#include <cstring>
using namespace std;
int N, M, sr, sc, A, B , C;
char a[101][101];
int d[101][101][2][2][2];
bool visited[101][101][2][2][2];
int moveX[] = {-1,1,0,0};
int moveY[] = {0,0,-1,1};

int bfs(){
    queue<tuple<int, int ,int,int,int >> q;
    int A = 0, B = 0, C = 0;
    q.push({sr, sc, A, B, C});
    visited[sr][sc][A][B][C] = true;
    d[sr][sc][A][B][C] = 0;
    while(!q.empty()){
        int r = get<0>(q.front());
        int c = get<1>(q.front());
        int A = get<2>(q.front());
        int B = get<3>(q.front());
        int C = get<4>(q.front());
        q.pop();
        if(a[r][c] == 'S' && A == 1 && B == 1 && C == 1){
            return d[r][c][A][B][C];
        }
        for(int i = 0; i < 4; i++){
            int u = r + moveX[i];
            int v = c + moveY[i];

            if(u < 1 || u > N || v < 1 || v > M){
                continue;
            }
            if(a[u][v] == 'X'&& (A == 0 || B == 0 || C==0)){
                continue;
            }
        
            int tempA = A, tempB = B, tempC = C;
            if(a[u][v] == 'A'){
                tempA = 1;
            }
            if(a[u][v] == 'B'){
                tempB = 1;
            }
            if(a[u][v] == 'C'){
                tempC = 1;
            }
            if(visited[u][v][tempA][tempB][tempC]){
                continue;
            }
            visited[u][v][tempA][tempB][tempC] = true;
            d[u][v][tempA][tempB][tempC] = d[r][c][A][B][C] + 1;
            q.push({u,v,tempA,tempB,tempC});
        }
    }
    return -1;
}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T; cin >> T;

    for(int t = 1; t <= T; t++){
        cin >> N >> M;
        cin >> sr >> sc;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                cin >> a[i][j];
                
            }
        }
        // for (int i = 1; i <= N; i++) {
        //     for (int j = 1; j <= M; j++) {
        //         for (int k = 1; k <= 2; k++) {
        //             for (int m = 1; m <= 2; m++){
        //                 for (int n = 1; n <= 2; n++){
        //                      visited[i][j][A][B][C] = false;
        //                     d[i][j][A][B][C] = -1;
        //                 }
        //             }
        //         }
        //     }
        // }
        memset(visited, false, sizeof(visited));
        memset(d, -1, sizeof(d));
        cout << '#' << t << ' ' << bfs() << '\n';
    }
    
    return 0;
}
/*
1
6 6 1 4
. . . . . .
. . B . . .
. X X C . .
. X X X X A
. S X X X .
. . . . . .

output : 12
*/