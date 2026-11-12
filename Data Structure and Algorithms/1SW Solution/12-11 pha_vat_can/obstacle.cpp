
#include <iostream>
#include <vector>
#include <deque>

using namespace std;

int N, M;

vector<vector<int>> a;
vector<vector<int>> d;

int moveX[] = {-1, 1, 0, 0};
int moveY[] = {0, 0, -1, 1};

void bfs() {
    deque<pair<int, int>> dq;

    d.assign(N + 1, vector<int>(M + 1, 1000000000));

    dq.push_front({1, 1});
    d[1][1] = 0;

    while (!dq.empty()) {
        int r = dq.front().first;
        int c = dq.front().second;
        dq.pop_front();

        for (int i = 0; i < 4; i++) {
            int u = r + moveX[i];
            int v = c + moveY[i];

            if (u < 1 || u > N || v < 1 || v > M)
                continue;

            int w = a[u][v];

            if (d[r][c] + w < d[u][v]) {
                d[u][v] = d[r][c] + w;

                if (w == 0)
                    dq.push_front({u, v});
                else
                    dq.push_back({u, v});
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    for (int t = 1; t <= T; t++) {
        cin >> N >> M;

        a.assign(N + 1, vector<int>(M + 1));

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                cin >> a[i][j];
            }
        }

        bfs();

        cout << "#" << t << " " << d[N][M] << '\n';
    }

    return 0;
}
