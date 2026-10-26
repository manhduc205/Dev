#include <iostream>
#include <queue>
using namespace std;
int R, C, sr, sc;
char a[101][101];
int d[101][101];
bool visited[101][101];
int moveX[] = {-1,1,0, 0};
int moveY[] = {0,0,-1,1};
int bfs(){
    queue<pair<int,int>> q;
    q.push({sr,sc});
    visited[sr][sc]=true;
    d[sr][sc] = 0;
    while(!q.empty()){
        int x = q.front().first;
        int y = q.front().second;
        q.pop();
        if(a[x][y] == 'B'){
            return d[x][y];
        }
        for(int i = 0; i < 4; i++){
            int u = x + moveX[i];
            int v = y + moveY[i];
            if(u < 1 || u > R){
                continue;
            }
            if(v <1 || v > C){
                continue;
            }
            if(a[u][v] == '*'){
                continue;
            }
            if (visited[u][v]) continue;
            visited[u][v] = true;
            d[u][v] = d[x][y] + 1;
            q.push({u, v});
        }
    }
    return -1;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    cin >> R >> C;
    for(int i = 1; i <= R; i++){
        for(int j = 1; j <= C; j++){
            cin >> a[i][j];
            visited[i][j] = false;
        }
    }
    for(int i = 1; i <= R; i++){
        for(int j = 1; j <= C; j++){
            if(a[i][j] == 'C'){
                sr = i;
                sc = j;
            }
        }
    }
    cout << bfs() << "\n";

    
}