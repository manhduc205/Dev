#include <iostream>
#include <cstring>
#include <queue>
int N, M;
char a[51][51];
int moveX[] = {-1,1,0,0}; 
int moveY[] = {0,0,-1,1};
bool visitedWall[51][51];
bool visitedG[51][51];
using namespace std;
bool bfs(int sr, int sc){
    memset(visitedG, false, sizeof(visitedG));
    queue<pair<int, int>> q;
    q.push({sr, sc});
    visitedG[sr][sc] = true;
    while(!q.empty()){
        int r = q.front().first;
        int c = q.front().second;
        q.pop();
        if(visitedG[N][M] == true){

            return true;
        }
        for(int i = 0; i < 4; i++){
            int u = r + moveX[i];
            int v = c + moveY[i];
            if(u < 1 || u > N || v < 1 || v > M){
                continue;
            }
            if(a[u][v] == '#' || visitedWall[u][v]){
                continue;
            }
            if(!visitedG[u][v]){
                visitedG[u][v] = true;
                q.push({u,v});
            }
        }
    }
    return false;
}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T; cin >> T;
    for(int t = 1; t <= T; t++){
        cin >> N >> M;
        
        memset(visitedWall, false, sizeof(visitedWall));
        
        memset(a,0,sizeof(a));
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                cin >> a[i][j];
            }
        }
        
        bool pass = true;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(a[i][j] == 'B'){
                    for(int k = 0; k < 4; k++){
                        int u = i + moveX[k];
                        int v = j + moveY[k];
                        if(u < 1 || u > N || v < 1 || v > M){
                            continue;
                        }
                        if(a[u][v] == 'G'){
                            pass = false;
                        }
                        
                        if(!visitedWall[u][v]){
                            visitedWall[u][v] = true;
                        }
                    }
                }
            }
        }
        // for(int i = 1; i <= N; i++){
        //     for(int j = 1; j <= M; j++){
        //         if(visitedWall[i][j]){
        //             cout << "tuong: " << i << " " << j << endl;
        //         }
        //     }
        // }
        
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){

                if(!visitedG[i][j] && a[i][j] == 'G'){
                    pass = bfs(i,j);
                }
            }
        }
        if(pass == true){
            cout << "#" << t << " YES " << endl; 
        }
        else cout << "#" << t << " NO " << endl;
    }
}

/*
input
6
1 1
.
1 2
G.
2 2
#B
G.
2 3
G.#
B#.
3 3
#B.
#..
GG.
2 2
#B
B.
*/