
#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

int N, M;
char a[101][101];
int d[101][101];
bool visited[101][101];
int sumTime;

int moveX[] = {-1, 1, 0, 0};
int moveY[] = {0, 0, -1, 1};

void bfs() {
    queue<pair<int, int>> q;

    // Dua tat ca nguon lua vao queue
    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= M; j++) {
            if(a[i][j] == 'F') {
                q.push({i, j});
                d[i][j] = 0;
                visited[i][j] = true;
            }
        }
    }

    // BFS da nguon
    while(!q.empty()) {
        int r = q.front().first;
        int c = q.front().second;
        q.pop();

        for(int i = 0; i < 4; i++) {
            int u = r + moveX[i];
            int v = c + moveY[i];

            if(u < 1 || u > N || v < 1 || v > M) {
                continue;
            }

            if(a[u][v] == '#') {
                continue;
            }

            if(visited[u][v]) {
                continue;
            }

            visited[u][v] = true;
            d[u][v] = d[r][c] + 1;
            q.push({u, v});
        }
    }

    // Tinh thoi gian chay het khu vuc
    sumTime = 0;

    for(int i = 1; i <= N; i++) {
        for(int j = 1; j <= M; j++) {
            if(a[i][j] == '.') {
                if(!visited[i][j]) {
                    sumTime = -1;
                    return;
                }

                if(d[i][j] > sumTime) {
                    sumTime = d[i][j];
                }
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    for(int t = 1; t <= T; t++) {
        cin >> N >> M;

        for(int i = 1; i <= N; i++) {
            for(int j = 1; j <= M; j++) {
                cin >> a[i][j];
            }
        }

        memset(visited, false, sizeof(visited));
        memset(d, -1, sizeof(d));

        sumTime = 0;
        bfs();

        cout << "#" << t << " " << sumTime << "\n";
    }

    return 0;
}


/*
2
5 6
F . . . . .
. . # # . .
. . . # . . 
. # . . . . 
. . F . . .
5 6
F . . . . .
. . # # . .
. . . # . . 
. # . . . # 
. . F . # .

*/