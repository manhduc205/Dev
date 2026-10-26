#include <iostream>
#include <queue>
#include <tuple>

using namespace std;

int R, C, sr, sc;
char a[26][101];
int dist[26][101][2];
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int bfs() {
    queue<tuple<int, int, int>> q;

    int key = 0;
    q.push({sr, sc, key});
    dist[sr][sc][key] = 0;

    while (!q.empty()) {
        int r, c, key;
        tie(r, c, key) = q.front();
        q.pop();

        if (a[r][c] =='O') {
            return dist[r][c][key];
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if (nr < 0 || nr >= R ||
                nc < 0 || nc >= C) {
                continue;
            }

            if (a[nr][nc] == 'X') {
                continue;
            }

            if (a[nr][nc] == 'A' && key == 0) {
                continue;
            }

            int nextKey = key;

            if (a[nr][nc] == 'a') {
                nextKey = 1;
            }

            if (dist[nr][nc][nextKey] != -1) {
                continue;
            }

            dist[nr][nc][nextKey] =
                dist[r][c][key] + 1;

            q.push({nr, nc, nextKey});
        }
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    for (int tc = 1; tc <= T; tc++) {
        cin >> R >> C;
        cin >> sr >> sc;

        // Chuyen toa do tu 1-based sang 0-based
        --sr;
        --sc;

        // Doc ban do
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                cin >> a[i][j];
            }
        }

        // Khoi tao dist = -1: chua tham
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                for (int k = 0; k < 2; k++) {
                    dist[i][j][k] = -1;
                }
            }
        }

        cout << '#' << tc << ' ' << bfs() << '\n';
    }

    return 0;
}
