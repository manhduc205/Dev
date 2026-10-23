#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <tuple>

using namespace std;

int R, C, sr, sc;
vector<string> a;
vector<vector<vector<int>>> dist;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int bfs() {
    queue<tuple<int, int, int>> q;

    int key = (a[sr][sc] == 'a') ? 1 : 0;

    q.push({sr, sc, key});
    dist[sr][sc][key] = 0;

    while (!q.empty()) {
        auto [r, c, key] = q.front();
        q.pop();

        if (a[r][c] == 'O')
            return dist[r][c][key];

        for (int i = 0; i < 4; i++) {
            int nr = r + dx[i];
            int nc = c + dy[i];

            if (nr < 0 || nr >= R || nc < 0 || nc >= C)
                continue;

            if (a[nr][nc] == 'X')
                continue;

            if (a[nr][nc] == 'A' && key == 0)
                continue;

            int nextKey = key;

            if (a[nr][nc] == 'a')
                nextKey = 1;

            if (dist[nr][nc][nextKey] != -1)
                continue;

            dist[nr][nc][nextKey] = dist[r][c][key] + 1;
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

        --sr;
        --sc;

        a.resize(R);
        for (int i = 0; i < R; i++)
            cin >> a[i];

        dist.assign(R, vector<vector<int>>(
            C, vector<int>(2, -1)
        ));

        cout << '#' << tc << ' ' << bfs() << '\n';
    }

    return 0;
}
