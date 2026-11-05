#include<iostream>
#include <queue>
#include <cstring>
using namespace std;

int N, M;
char a[31][31];
bool visited[31][31];
int vX[31][31];
int vY[31][31];
int dem[31][31];
int visitedP[31][31];
int cnt;
int moveX[] = {-1,1,0,0};
int moveY[] = {0,0,-1,1};

void bfsDevice(int sr,int sc){
    visited[sr][sc] = true;
    vX[sr][sc] = sr;
    vY[sr][sc] = sc;
    for(int i = 0; i < 4; i++){
        int u = sr+moveX[i];
        int v = sc + moveY[i];
        if(u < 1 || u > N || v < 1 || v > M){
                continue;
            }
        if(!visited[u][v]){
            visited[u][v] = true;
            vX[u][v] = sr;
            vY[u][v] = sc;
        }
    }
}

int bfsPlayer(int sr,int sc){
    queue<pair<int,int>> q;
    cnt = 0;
    q.push({sr,sc});
    while(!q.empty()){
        int r = q.front().first;
        int c = q.front().second;
        q.pop();
        if(!visited[r][c]){
            continue;
        }
        if(r == N){
            return cnt;
        }
        for(int i =0; i< 4; i++){
            int u = r + moveX[i];
            int v = c + moveY[i];
            if(u < 1 || u > N || v < 1 || v > M){
                continue;
            }
            if(!visited[u][v]){
                continue;
            }
            if(visitedP[u][v]){
                continue;
            }
            int x = vX[u][v];
            int y = vY[u][v];
            if(dem[x][y] < 0){
                cnt++;
                dem[x][y] = 1;
            }
            visitedP[u][v] = true;
            q.push({u,v});

        }
    }
    return -1;
}
int main() {
    int T; cin >> T;
        for(int t = 1; t <= T; t++){
            cin >> N >> M;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                cin >> a[i][j];
            }
        }

        memset(visited, false, sizeof(visited));
        memset(visitedP, false, sizeof(visitedP));

        memset(vX, -1, sizeof(vX));
        memset(vY, -1, sizeof(vY));

        memset(dem, -1, sizeof(dem));

        // Bat tat ca thiet bi
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (a[i][j] == 'O') {
                    bfsDevice(i, j);
                }
            }
        }

        
        int minDevice = 10000000;

        for (int j = 1; j <= M; j++) {
            if (visited[1][j]) {
                int res = bfsPlayer(1, j);

                if(minDevice > res){
                    minDevice = res;
                }
            }
        }

        cout << "#" << t << " " << minDevice << endl;
    }
    

    return 0;
}
/*
1
7 9
#########
O###O####
#O#######
#O###O###
###O###O#
#O#######
#####O###
*/