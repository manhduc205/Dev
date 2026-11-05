
#include <iostream>
#include <queue>
#include <string>
#include <cstring>
#include <tuple>
using namespace std;

const int MAXN = 105;
const int MAXT = 210;

int N, K;
string a[3];

bool danger[3][MAXN][MAXT];
bool visitedTrain[3][MAXN][MAXT];
bool visitedUser[3][MAXN];

int dx[] = {-1, 0, 1};

// BFS 1: Tinh thoi diem tau chiem cac o
void bfsTrain() {
    queue<tuple<int, int, int> > q;

    memset(danger, false, sizeof(danger));
    memset(visitedTrain, false, sizeof(visitedTrain));

    // Moi toa tau ban dau la mot trang thai nguon
    for (int r = 0; r < 3; r++) {
        for (int c = 0; c < N; c++) {
            if (a[r][c] != '.' && a[r][c] != 's') {
                q.push({r, c, 0});
                visitedTrain[r][c][0] = true;
                danger[r][c][0] = true;
            }
        }
    }

    while (!q.empty()) {
        int r = get<0>(q.front());
        int c = get<1>(q.front());
        int t = get<2>(q.front());
        q.pop();

        // Tau dich sang trai 1 o moi nua luot
        int nc = c - 1;
        int nt = t + 1;

        if (nc < 0 || nt >= MAXT) {
            continue;
        }

        if (visitedTrain[r][nc][nt]) {
            continue;
        }

        visitedTrain[r][nc][nt] = true;
        danger[r][nc][nt] = true;

        q.push({r, nc, nt});
    }
}

// BFS 2: Philip di chuyen
bool bfsUser(int startRow) {
    queue<tuple<int, int, int> > q;

    memset(visitedUser, false, sizeof(visitedUser));

    q.push({startRow, 0, 0});
    visitedUser[startRow][0] = true;

    while (!q.empty()) {
        int r = get<0>(q.front());
        int c = get<1>(q.front());
        int t = get<2>(q.front());
        q.pop();

        if (c >= N - 1) {
            return true;
        }

        int nc = c + 1;

        // Thoi diem tau truoc khi Philip di chuyen
        int time0 = 2 * t;

        // Philip di sang phai truoc
        // Sau do co the len, xuong hoac dung hang
        for (int i = 0; i < 3; i++) {
            int nr = r + dx[i];

            if (nr < 0 || nr >= 3) {
                continue;
            }

            if (nc >= N) {
                return true;
            }

            if (visitedUser[nr][nc]) {
                continue;
            }

            // Kiem tra o trung gian: Philip di sang phai
            if (danger[r][nc][time0]) {
                continue;
            }

            // Kiem tra o cuoi: Philip doi hang
            if (danger[nr][nc][time0]) {
                continue;
            }

            // Tau dich chuyen lan 1
            int time1 = time0 + 1;

            if (danger[nr][nc][time1]) {
                continue;
            }

            // Tau dich chuyen lan 2
            int time2 = time0 + 2;

            if (danger[nr][nc][time2]) {
                continue;
            }

            visitedUser[nr][nc] = true;
            q.push({nr, nc, t + 1});
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

        bfsTrain();

        if (bfsUser(startRow)) {
            cout << "YES\n";
        } else {
            cout << "NO\n";
        }
    }

    return 0;
}
