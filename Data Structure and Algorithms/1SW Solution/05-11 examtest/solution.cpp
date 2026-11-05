
#include <iostream>
#include <queue>
#include <cstring>
using namespace std;

int N, M;
char a[31][31];

bool visited[31][31];
int vX[31][31];
int vY[31][31];

int dem[31][31];
bool visitedP[31][31];

int parentX[31][31];
int parentY[31][31];

int moveX[] = {-1, 1, 0, 0};
int moveY[] = {0, 0, -1, 1};

void bfsDevice(int sr, int sc) {
    visited[sr][sc] = true;

    vX[sr][sc] = sr;
    vY[sr][sc] = sc;

    for (int i = 0; i < 4; i++) {
        int u = sr + moveX[i];
        int v = sc + moveY[i];

        if (u < 1 || u > N || v < 1 || v > M) {
            continue;
        }

        if (!visited[u][v]) {
            visited[u][v] = true;

            vX[u][v] = sr;
            vY[u][v] = sc;
        }
    }
}

int bfsPlayer(int sr, int sc) {
    queue<pair<int, int>> q;

    memset(visitedP, false, sizeof(visitedP));
    memset(dem, -1, sizeof(dem));

    memset(parentX, -1, sizeof(parentX));
    memset(parentY, -1, sizeof(parentY));

    if (!visited[sr][sc]) {
        return -1;
    }

    visitedP[sr][sc] = true;
    q.push({sr, sc});

    int endR = -1;
    int endC = -1; // lưu lại điểm cuối khi đến

    while (!q.empty()) {
        int r = q.front().first;
        int c = q.front().second;
        q.pop();

        if (r == N) {
            endR = r;
            endC = c;
            break;
        }

        for (int i = 0; i < 4; i++) {
            int u = r + moveX[i];
            int v = c + moveY[i];

            if (u < 1 || u > N || v < 1 || v > M) {
                continue;
            }

            // O chua an toan thi khong duoc di
            if (!visited[u][v]) {
                continue;
            }

            if (visitedP[u][v]) {
                continue;
            }

            visitedP[u][v] = true;

            parentX[u][v] = r;
            parentY[u][v] = c;

            q.push({u, v});
        }
    }

    if (endR == -1) {
        return -1;
    }

    // Truy vet duong di va dem thiet bi
    int cnt = 0;

    int r = endR;
    int c = endC;

    while (r != -1 && c != -1) {
        int x = vX[r][c];
        int y = vY[r][c];

        if (x != -1 && y != -1) {
            if (dem[x][y] == -1) {
                cnt++;
                dem[x][y] = 1;
            }
        }

        int pr = parentX[r][c];
        int pc = parentY[r][c];

        r = pr;
        c = pc;
    }

    return cnt;
}

int main() {
    int T;
    cin >> T;

    for (int t = 1; t <= T; t++) {
        cin >> N >> M;

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                cin >> a[i][j];
            }
        }

        memset(visited, false, sizeof(visited));
        memset(vX, -1, sizeof(vX));
        memset(vY, -1, sizeof(vY));

        // Bat tat ca thiet bi
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= M; j++) {
                if (a[i][j] == 'O') {
                    bfsDevice(i, j);
                }
            }
        }

        int minDevice = 10000000;

        // Thu cac vi tri bat dau tren hang dau
        for (int j = 1; j <= M; j++) {
            if (visited[1][j]) {
                int res = bfsPlayer(1, j);

                if (res != -1 && minDevice > res) {
                    minDevice = res;
                }
            }
        }

        if (minDevice == 10000000) {
            minDevice = -1;
        }

        cout << "#" << t << " " << minDevice << endl;
    }

    return 0;
}
