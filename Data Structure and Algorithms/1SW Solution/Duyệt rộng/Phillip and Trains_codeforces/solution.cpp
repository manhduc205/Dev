
#include <iostream>
#include <queue>
#include <string>
#include <cstring>
#include <utility>
using namespace std;

const int MAXN = 105;

int N, K;
char a[3][MAXN];
bool visited[3][MAXN];

int dx[] = {-1, 0, 1};

bool isTrain(int r, int c) {
    if (c >= N) return false;

    return a[r][c] >= 'A' && a[r][c] <= 'Z';
}

bool bfs(int startRow) {
    queue<pair<int, int> > q;

    memset(visited, false, sizeof(visited));

    q.push({startRow, 0});
    visited[startRow][0] = true;

    while (!q.empty()) {
        int r = q.front().first;
        int c = q.front().second;
        q.pop();

        if (c >= N - 1) {
            return true;
        }

        for (int i = 0; i < 3; i++) {
            int nr = r + dx[i];
            int nc = c + 3;

            if (nr < 0 || nr >= 3) {
                continue;
            }

            if (visited[nr][nc]) {
                continue;
            }

            // Philip di chuyen sang phai,
            // sau do co the doi hang.
            if (isTrain(r, c + 1)) {
                continue;
            }

            if (isTrain(nr, c + 1)) {
                continue;
            }

            if (isTrain(nr, c + 2)) {
                continue;
            }

            if (isTrain(nr, c + 3)) {
                continue;
            }

            visited[nr][nc] = true;
            q.push({nr, nc});
        }
    }

    return false;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    while (T--) {
        cin >> N >> K;

        int startRow = -1;

        for (int i = 0; i < 3; i++) {
            cin >> a[i];

            for (int j = 0; j < N; j++) {
                if (a[i][j] == 's') {
                    startRow = i;
                }
            }
        }

        if (bfs(startRow)) {
            cout << "YES\n";
        } else {
            cout << "NO\n";
        }
    }

    return 0;
}
