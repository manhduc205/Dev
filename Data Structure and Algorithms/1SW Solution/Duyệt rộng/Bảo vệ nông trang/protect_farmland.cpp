#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

int N, M;
int a[701][701];
bool visited[701][701];

int moveX[] = {-1, -1, -1, 0, 0, 1, 1, 1};
int moveY[] = {-1,  0,  1,-1, 1,-1, 0, 1};

bool bfs(int sr, int sc){
    queue<pair<int, int>> q;

    int h = a[sr][sc];
    bool isPeak = true;

    q.push({sr, sc});
    visited[sr][sc] = true;

    while(!q.empty()){
        int r = q.front().first;
        int c = q.front().second;
        q.pop();

        for(int i = 0; i < 8; i++){
            int u = r + moveX[i];
            int v = c + moveY[i];

            // Ngoai bien ban do
            if(u < 1 || u > N || v < 1 || v > M){
                continue;
            }

            // Co o cao hon => khong phai dinh doi
            if(a[u][v] > h){
                isPeak = false;
            }

            // Chi BFS cac o cung do cao
            if(a[u][v] == h && !visited[u][v]){
                visited[u][v] = true;
                q.push({u, v});
            }
        }
    }

    return isPeak;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    for(int t = 1; t <= T; t++){
        cin >> N >> M;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                cin >> a[i][j];
            }
        }

        memset(visited, false, sizeof(visited));

        int ans = 0;

        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(!visited[i][j]){
                    if(bfs(i, j)){
                        ans++;
                    }
                }
            }
        }

        cout << "#" << t << " " << ans << '\n';
    }

    return 0;
}