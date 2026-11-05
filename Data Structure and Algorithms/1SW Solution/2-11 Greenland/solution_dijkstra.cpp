
#include <iostream>
#include <queue>
#include <tuple>
#include <vector>
#include <cstring>
#include <functional>
#include <algorithm>
using namespace std;

int R, C, K, H;

int a[101][101];
int d[101][101][1001];

int moveX[] = {-1, 1, 0, 0};
int moveY[] = {0, 0, -1, 1};

int dijkstra() {
    priority_queue<
        tuple<int, int, int, int>,
        vector<tuple<int, int, int, int>>,
        greater<tuple<int, int, int, int>>
    > q;

    memset(d, -1, sizeof(d));

    // Dua tat ca mass vao hang doi
    for(int i = 1; i <= R; i++) {
        for(int j = 1; j <= C; j++) {
            if(a[i][j] > 0) {
                int k = a[i][j];

                d[i][j][k] = 0;
                q.push({0, i, j, k});
            }
        }
    }

    while(!q.empty()) {
        int time = get<0>(q.top());
        int r = get<1>(q.top());
        int c = get<2>(q.top());
        int k = get<3>(q.top());

        q.pop();

        // Bo qua trang thai cu
        if(time != d[r][c][k]) {
            continue;
        }

        for(int i = 0; i < 4; i++) {
            int u = r + moveX[i];
            int v = c + moveY[i];

            if(u < 1 || u > R || v < 1 || v > C) {
                continue;
            }

            // Gray Land
            if(a[u][v] == -1) {
                continue;
            }

            int newTime = time + k;

            if(d[u][v][k] != -1 && d[u][v][k] <= newTime) {
                continue;
            }

            d[u][v][k] = newTime;

            q.push({newTime, u, v, k});
        }
    }

    int answer = 0;

    // Tim thoi gian nho nhat de co den tung o
    for(int i = 1; i <= R; i++) {
        for(int j = 1; j <= C; j++) {

            if(a[i][j] == -1) {
                continue;
            }

            int minTime = -1;

            for(int k = 1; k <= 1000; k++) {
                if(d[i][j][k] == -1) {
                    continue;
                }

                if(minTime == -1 || d[i][j][k] < minTime) {
                    minTime = d[i][j][k];
                }
            }

            // Co o khong mass nao den duoc
            if(minTime == -1) {
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

    for(int t = 1; t <= T; t++) {
        cin >> R >> C;
        cin >> K >> H;

        memset(a, 0, sizeof(a));

        for(int i = 1; i <= K; i++) {
            int A, B, D;
            cin >> A >> B >> D;

            a[A][B] = D;
        }

        for(int i = 1; i <= H; i++) {
            int E, F;
            cin >> E >> F;

            a[E][F] = -1;
        }

        cout << "#" << t << " " << dijkstra() << "\n";
    }

    return 0;
}
