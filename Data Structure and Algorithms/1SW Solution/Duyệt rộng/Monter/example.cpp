
#include <iostream>
#include <queue>
#include <cstring>
#include <string>
#include <algorithm>
using namespace std;

const int MAXN = 1005;

int N, M;
char a[MAXN][MAXN];

int monsterTime[MAXN][MAXN];
int playerTime[MAXN][MAXN];

int moveX[] = {-1, 1, 0, 0};
int moveY[] = {0, 0, -1, 1};

char direction[] = {'U', 'D', 'L', 'R'};

int startX, startY;

int traceX[MAXN][MAXN];
int traceY[MAXN][MAXN];
char traceDir[MAXN][MAXN];

// BFS đa nguồn từ tất cả quái vật
void bfsMonster() {
    queue<pair<int, int>> q;

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            if (a[i][j] == 'M') {
                q.push({i, j});
                monsterTime[i][j] = 0;
            }
        }
    }

    while (!q.empty()) {
        pair<int, int> u = q.front();
        q.pop();

        int x = u.first;
        int y = u.second;

        for (int k = 0; k < 4; k++) {
            int nx = x + moveX[k];
            int ny = y + moveY[k];

            if (nx < 1 || nx > N || ny < 1 || ny > M)
                continue;

            if (a[nx][ny] == '#')
                continue;

            if (monsterTime[nx][ny] != -1)
                continue;

            monsterTime[nx][ny] = monsterTime[x][y] + 1;
            q.push({nx, ny});
        }
    }
}

// BFS tìm đường cho A
bool bfsPlayer() {
    queue<pair<int, int>> q;

    q.push({startX, startY});
    playerTime[startX][startY] = 0;

    while (!q.empty()) {
        pair<int, int> u = q.front();
        q.pop();

        int x = u.first;
        int y = u.second;

        // Đã đến ô biên
        if (x == 1 || x == N || y == 1 || y == M) {
            return true;
        }

        for (int k = 0; k < 4; k++) {
            int nx = x + moveX[k];
            int ny = y + moveY[k];

            if (nx < 1 || nx > N || ny < 1 || ny > M)
                continue;

            if (a[nx][ny] == '#')
                continue;

            if (playerTime[nx][ny] != -1)
                continue;

            int nextTime = playerTime[x][y] + 1;

            // Phải đến trước quái vật
            if (monsterTime[nx][ny] != -1 && nextTime >= monsterTime[nx][ny])
                continue;

            playerTime[nx][ny] = nextTime;

            // Lưu vị trí trước đó để truy vết đường đi
            traceX[nx][ny] = x;
            traceY[nx][ny] = y;
            traceDir[nx][ny] = direction[k];

            q.push({nx, ny});
        }
    }

    return false;
}

// Truy vết đường đi
string getPath(int x, int y) {
    string path = "";

    while (x != startX || y != startY) {
        path += traceDir[x][y];

        int px = traceX[x][y];
        int py = traceY[x][y];

        x = px;
        y = py;
    }
    reverse(path.begin(), path.end());
    return path;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;

    memset(monsterTime, -1, sizeof(monsterTime));
    memset(playerTime, -1, sizeof(playerTime));

    for (int i = 1; i <= N; i++) {
        for (int j = 1; j <= M; j++) {
            cin >> a[i][j];

            if (a[i][j] == 'A') {
                startX = i;
                startY = j;
            }
        }
    }

    bfsMonster();

    if (bfsPlayer()) {
        string path = "";

        // Tìm ô biên mà A đã đến
        for (int i = 1; i <= N; i++) {
            if (playerTime[i][1] != -1) {
                path = getPath(i, 1);
                break;
            }

            if (playerTime[i][M] != -1) {
                path = getPath(i, M);
                break;
            }
        }

        for (int j = 1; j <= M; j++) {
            if (playerTime[1][j] != -1) {
                path = getPath(1, j);
                break;
            }

            if (playerTime[N][j] != -1) {
                path = getPath(N, j);
                break;
            }
        }

        cout << "YES\n";
        cout << path.length() << "\n";
        cout << path << "\n";
    }
    else {
        cout << "NO\n";
    }

    return 0;
}
