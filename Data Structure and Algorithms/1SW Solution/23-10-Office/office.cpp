#include <iostream>
#include <queue>
#include <tuple>
using namespace std;

int R, C, sr, sc;
char a[27][102];
int d[27][102][2]; // lưu các bước
int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int bfs() {
    queue<tuple<int, int,int>> q;

    int key = 0;

    q.push({sr, sc, key});
    d[sr][sc][key] = 0;

    while (!q.empty()) {
        int r, c, key;
        r = get<0>(q.front());
        c = get<1>(q.front());
        key = get<2>(q.front());
        q.pop();

        if (a[r][c] == 'O') {
            return d[r][c][key];
        }

        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];
            if (nr < 1 || nr > R ||nc < 1 || nc > C) {
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

            if (d[nr][nc][nextKey] != -1) {
                continue;
            }
            d[nr][nc][nextKey] =d[r][c][key] + 1;

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
    for (int t = 1; t <= T; t++) {
        cin >> R >> C;
        cin >> sr >> sc;
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                cin >> a[i][j];
            }
        }
        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                for (int k = 0; k < 2; k++) {
                    d[i][j][k] = -1;
                }
            }
        }
        cout << '#' << t << ' ' << bfs() << '\n';
    }

    return 0;
}
