#include <iostream>
#include <queue>
using namespace std;
int N, M;
int a[101][101];
int d[101][101];
bool visited[101][101];
int moveX[] = {-1,1,0,0};
int moveY[] = {0,0,-1,1};

void bfs(int sr, int sc){
    queue<pair<int,int>> q;
    q.push({sr,sc});
    visited[sr][sc] = true;
    d[sr][sc] = 0;
    while(!q.empty()){
        int r = q.front().first;
        int c = q.front().second;
        q.pop();
        for(int i = 0; i <4; i++){
            int u =  r+ moveX[i];
            int v =  c + moveY[i];
            if(u < 1 || u > N || v < 1 || v > M){
                continue;
            }
            if(a[u][v] == 0){
                continue;
            }
            if(visited[u][v]){
                continue;
            }
            visited[u][v] = true;
            d[u][v] = d[r][c]+1;
            q.push({u,v});
        }
    }
    
}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T; cin >> T;
    for(int t = 1; t <= T; t++){
        cin >> N >> M;
        int size = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                cin >> a[i][j];
                visited[i][j] = false;
            }
        }
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(visited[i][j] != true && a[i][j] == 1){
                    bfs(i, j);
                    ++size;
                }
            }
        }
        cout << "#" << t << " " << size;
    }
    return 0;
}
