#include <iostream>
#include <queue>
#include <cstring>
#include <algorithm>
using namespace std;

int R, C, K, H;
int a[101][101];
int d[101][101][6];

int moveX[] = {-1, 1, 0, 0};
int moveY[] = {0, 0, -1, 1};

void bfs(int k) {
    queue<pair<int, int>> q;

    // Khởi tạo tất cả nguồn có D = k
    for (int i = 1; i <= R; i++) {
        for (int j = 1; j <= C; j++) {
            if (a[i][j] == k) {
                d[i][j][k] = 0;
                q.push({i, j});
            }
        }
    }

    while (!q.empty()) {
        int r = q.front().first;
        int c = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int u = r + moveX[i];
            int v = c + moveY[i];

            if (u < 1 || u > R || v < 1 || v > C) {
                continue;
            }

            if (a[u][v] == -1) {
                continue;
            }

            if (d[u][v][k] != -1) {
                continue;
            }

            d[u][v][k] = d[r][c][k] + k;
            q.push({u, v});
        }
    }
}

int solve() {
    memset(d, -1, sizeof(d));

    // Chạy BFS cho từng giá trị D
    for (int k = 1; k <= 5; k++) {
        bfs(k);
    }

    int answer = 0;

    for (int i = 1; i <= R; i++) {
        for (int j = 1; j <= C; j++) {
            if (a[i][j] == -1) {
                continue;
            }

            int minTime = -1;

            for (int k = 1; k <= 5; k++) {
                if (d[i][j][k] == -1) {
                    continue;
                }

                if (minTime == -1 || d[i][j][k] < minTime) {
                    minTime = d[i][j][k];
                }
            }

            if (minTime == -1) {
                return -1;
            }

            answer = max(answer, minTime);
        }
    }

    return answer;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    for (int t = 1; t <= T; t++) {
        cin >> R >> C;
        cin >> K >> H;

        memset(a, 0, sizeof(a));

        for (int i = 1; i <= K; i++) {
            int A, B, D;
            cin >> A >> B >> D;
            a[A][B] = D;
        }

        for (int i = 1; i <= H; i++) {
            int E, F;
            cin >> E >> F;
            a[E][F] = -1;
        }

        cout << "#" << t << " " << solve() << "\n";
    }

    return 0;
}
/*
2
5 5 3 7
3 4 5
1 1 2
1 4 4
2 2
4 5
2 1
4 4
2 5
5 2
5 5
5 5 3 9
1 5 2
4 1 4
1 1 5
5 2
2 1
4 5
3 4
4 4
5 4
4 2
2 5
5 5
*/