#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

int N, M;
char a[701][701];

int moveX[] = {-1, 1, 0, 0};
int moveY[] = {0, 0, -1, 1};

int moveChX[] = {-1, -1, 1, 1};
int moveChY[] = {-1, 1, -1, 1};

bool danger[701][701][2];
bool visited[701][701][2];

int bfs(int sr, int sc) {
    queue<pair<int, int>> q;

    q.push({sr, sc});
    visited[sr][sc][0] = true;

    int time = 0;

    while (!q.empty()) {
        int sz = q.size();
        for (int cnt = 0; cnt < sz; cnt++) {
            int r = q.front().first;
            int c = q.front().second;
            q.pop();

            if (a[r][c] == 'E') {
                return time;
            }

            int nextTime = time + 1;
            int parity = nextTime % 2;

            for (int i = 0; i < 4; i++) {
                int u = r + moveX[i];
                int v = c + moveY[i];

                if (u < 1 || u > N || v < 1 || v > M) {
                    continue;
                }

                if (a[u][v] == 'X' || a[u][v] == '+') {
                    continue;
                }

                if (danger[u][v][parity]) {
                    continue;
                }

                if (visited[u][v][parity]) {
                    continue;
                }

                visited[u][v][parity] = true;
                q.push({u, v});
            }
        }

        time++;
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    for (int tc = 1; tc <= T; tc++) {
        cin >> N >> M;

        int sr = -1, sc = -1;

        memset(danger, false, sizeof(danger));
        memset(visited, false, sizeof(visited));

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                cin >> a[i][j];

                if (a[i][j] == 'T') {
                    sr = i;
                    sc = j;
                }
            }
        }

        // Danh dau cac o nguy hiem do X va +
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {

                if (a[i][j] == 'X') {
                    for (int k = 0; k < 4; k++) {
                        int u = i + moveChX[k];
                        int v = j + moveChY[k];

                        if (u >= 1 && u <= N && v >= 1 && v <= M) {
                            danger[u][v][1] = true;
                        }
                    }
                }

                if (a[i][j] == '+') {
                    for (int k = 0; k < 4; k++) {
                        int u = i + moveX[k];
                        int v = j + moveY[k];

                        if (u >= 1 && u <= N &&
                            v >= 1 && v <= M) {
                            danger[u][v][0] = true;
                        }
                    }
                }
            }
        }

        cout << "#" << tc << " " << bfs(sr, sc) << "\n";
    }

    return 0;
}
/*
1
5 5
. . . . .
. . . . E
X . . + .
. . . . .
T . + . .
*/