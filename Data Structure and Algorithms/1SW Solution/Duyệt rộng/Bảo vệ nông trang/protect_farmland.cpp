#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
int N, M;
int a[701][701];
int d[701][701];
bool visited[701][701];
int moveX[] = {-1, 1, 0, 0};
int moveY[] = {0, 0, -1, 1};
void bfs(int sr, int sc){
    queue<pair<int, int>> q;
    q.push({1,1});
    visited[sr][sc] = true;
    int h = a[sr][sc];
    int peak;
    d[sr][sc] = 0;
    while(!q.empty()){
        int r = q.front().first;
        int c = q.front().second;
        q.pop();
        for(int i = 0; i< 4; i++){
            int u = r + moveX[i];
            int v = c + moveY[i];
            if(u < 1 || u > N || v < 1 || v > M){
                continue;
            }
            if(a[u][v] > h){
                peak = 0;
            }
            if(a[u][v] <h){
                continue;
            }
            if(a[u][v] == h&& visited[u][v]){
                visited[u][v] == true;
                q.push({u, v});
            }

        }
    }
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
        memset(visited, false, sizeof(visited));
        memset(d, -1, sizeof(d));
        cout << '#' << t << ' ' << '\n';
    }
}