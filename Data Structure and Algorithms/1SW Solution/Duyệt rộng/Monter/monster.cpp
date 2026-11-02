#include <iostream>
#include <queue>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;
int N, M;
const int MAXN = 1001;
char a[1001][1001];
int dM[1001][1001];
int dA[1001][1001];
int moveX[] = {-1,1,0,0};
int moveY[] = {0,0,-1,1};
char direction[] = {'U', 'D', 'L', 'R'};

int startX, startY;

int traceX[MAXN][MAXN];
int traceY[MAXN][MAXN];
char traceDir[MAXN][MAXN];
void bfsMonster(){
    queue<pair<int,int>> q;
    for(int i = 1; i <= N; i++){
        for(int j = 1; j <= M; j++){
            if(a[i][j] == 'M'){
                q.push({i,j});
                // visited[i][j] = true;
                dM[i][j] = 0;
            }
        }
    }
    while(!q.empty()){
    
        int r = q.front().first;
        int c = q.front().second;
        q.pop();
        for(int i =0; i < 4; i++){
            int u = r + moveX[i];
            int v = c + moveY[i];
            if(u < 1 || u > N || v < 1 || v > M){
                continue;
            }
            if(a[u][v] == '#'){
                continue;
            }
            // if(!visited[u][v]){
            //     visited[u][v] = true;
            //     dM[u][v] = dM[r][c] + 1;
            //     q.push({u,v});
            // }
            if(dM[u][v] == -1){
                dM[u][v] = dM[r][c] + 1;
                q.push({u,v});
            }
        }
    }
}
bool bfsA(){
    queue<pair<int,int>> q;
    q.push({startX, startY});
    // visited[startX][startY] = true;
    dA[startX][startY] = 0;
    while(!q.empty()){
        int r = q.front().first;
        int c = q.front().second;
        q.pop();
        if(r == 1 || r == N || c == 1 || c == M){
            return true;
        }
        for(int i = 0; i < 4; i++){
            int u = r + moveX[i];
            int v = c + moveY[i];
            if(u < 1 || u > N || v < 1 || v > M){
                continue;
            }
            if(a[u][v] == '#'){
                continue;
            }
            // if(visited[u][v]){
            //     continue;
            // }
            if(dA[u][v] != -1){
                continue;
            }
            int nextTime = dA[r][c] + 1;
            if(dM[u][v] != -1 && nextTime >= dM[u][v]){
                continue;
            }
            dA[u][v] = nextTime;
            traceX[u][v] = r;
            traceY[u][v] = c;
            traceDir[u][v] = direction[i];
            q.push({u,v});
        }
    }
    return false;
}
string getPath(int x, int y){
    string path = "";
    while(x != startX || y != startY){
        path += traceDir[x][y];
        int lastX = traceX[x][y];
        int lastY = traceY[x][y];
        x = lastX;
        y = lastY;
    }
    reverse(path.begin(), path.end());
    return path;
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
                if(a[i][j] == 'A'){
                    startX = i;
                    startY = j;
                }
            }
        }
        memset(dM, -1, sizeof(dM));
        memset(dA, -1, sizeof(dA));
        memset(traceDir, 0 , sizeof(traceDir));
        memset(traceX, -1, sizeof(traceX));
        memset(traceY, -1, sizeof(traceY));
        bfsMonster();
        if(bfsA()){
            string path = "";
            //cot bien
            for(int i = 1; i <= N; i++){
                if(dA[i][1] != -1){
                    path = getPath(i, 1);
                    break;
                }
                if(dA[i][M] != -1){
                    path = getPath(i, M);
                    break;
                }
            }
            // hang bien
            for(int j = 1; j <= M; j++){
                if(dA[1][j] != -1){
                    path = getPath(1, j);
                    break;
                }
                if(dA[N][j] != -1){
                    path = getPath(N, j);
                    break;
                }
            }

            cout << "YES" << "\n";
            cout << path.length() << "\n";
            cout << path << "\n";
        }
        else {
            cout << "NO";
        }
        
    }
    return 0;

}