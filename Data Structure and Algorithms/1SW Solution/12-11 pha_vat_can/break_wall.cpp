
#include <iostream>
#include <queue>
#include <cstring>
#include <tuple>

using namespace std;

int N, M, K;
int a[1001][1001];

int visited[1001][1001][11][2];

int dx[4] = {-1, 1, 0, 0};
int dy[4] = {0, 0, -1, 1};

int bfs() {
    memset(visited, 0, sizeof(visited));

    queue<tuple<int, int, int, int>> q;

    q.push(make_tuple(0, 0, 0, 1));
    visited[0][0][0][1] = 1;

    while (!q.empty()) {
        int x, y, k, d;
        tie(x, y, k, d) = q.front();
        q.pop();

        if (x == N - 1 && y == M - 1)
            return d;

        int day = d % 2;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= N || ny < 0 || ny >= M)
                continue;

            int nk = k;

            if (a[nx][ny] == 1) {
                if (k >= K || day == 0)
                    continue;

                nk++;
            }

            int nextDay = 1 - day;

            if (!visited[nx][ny][nk][nextDay]) {
                visited[nx][ny][nk][nextDay] = 1;
                q.push(make_tuple(nx, ny, nk, d + 1));
            }
        }

        // Ban dem: dung yen cho troi sang
        if (day == 0 && !visited[x][y][k][1]) {
            visited[x][y][k][1] = 1;
            q.push(make_tuple(x, y, k, d + 1));
        }
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> N >> M >> K;

    for (int i = 0; i < N; i++) {
        for (int j = 0; j < M; j++) {
            cin >> a[i][j];
        }
    }

    cout << bfs() << '\n';

    return 0;
}
