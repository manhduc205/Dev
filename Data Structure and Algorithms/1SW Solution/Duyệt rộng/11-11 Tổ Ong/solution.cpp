
#include <iostream>
#include <queue>
#include <cstring>
#include <algorithm>

using namespace std;

const int MAXN = 1005;

int n, T;
int a[MAXN][MAXN];
int lenRow[MAXN];

bool visited[MAXN][MAXN];
bool checked[MAXN][MAXN];

// Lay 6 o lien ke
void getNeighbors(int x, int y, int nx[], int ny[]) {

    // Hai o cung hang
    nx[0] = x;
    ny[0] = y - 1;

    nx[1] = x;
    ny[1] = y + 1;

    // Hai o hang tren
    nx[2] = x - 1;
    nx[3] = x - 1;

    if (x > 1 && lenRow[x - 1] > lenRow[x]) {
        ny[2] = y;
        ny[3] = y + 1;
    }
    else {
        ny[2] = y - 1;
        ny[3] = y;
    }

    // Hai o hang duoi
    nx[4] = x + 1;
    nx[5] = x + 1;

    if (x < n && lenRow[x + 1] > lenRow[x]) {
        ny[4] = y;
        ny[5] = y + 1;
    }
    else {
        ny[4] = y - 1;
        ny[5] = y;
    }
}

// Mo rong cac o co gia tri k trong mot luot gieo
void bfs(int k) {
    queue<pair<int, int> > q;

    // Chi dua cac o da tham TRUOC luot nay vao queue
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= lenRow[i]; j++) {
            if (visited[i][j]) {
                q.push(make_pair(i, j));
            }
        }
    }

    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        int nx[6], ny[6];
        getNeighbors(x, y, nx, ny);

        for (int i = 0; i < 6; i++) {
            int u = nx[i];
            int v = ny[i];

            if (u < 1 || u > n) continue;
            if (v < 1 || v > lenRow[u]) continue;

            if (!visited[u][v] && a[u][v] == k) {
                visited[u][v] = true;

                // Khong dua o moi vao queue
                // Chi duoc lan tiep o luot xuc xac sau
            }
        }
    }
}

// Dem so o trong mot cum cung gia tri
// Chi tinh diem neu cum co tu 2 o tro len va duoc tham het
int countComponent(int sx, int sy) {
    queue<pair<int, int> > q;

    q.push(make_pair(sx, sy));
    checked[sx][sy] = true;

    int total = 0;
    bool complete = true;

    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        total++;

        if (!visited[x][y]) {
            complete = false;
        }

        int nx[6], ny[6];
        getNeighbors(x, y, nx, ny);

        for (int i = 0; i < 6; i++) {
            int u = nx[i];
            int v = ny[i];

            if (u < 1 || u > n) continue;
            if (v < 1 || v > lenRow[u]) continue;

            if (!checked[u][v] && a[u][v] == a[sx][sy]) {
                checked[u][v] = true;
                q.push(make_pair(u, v));
            }
        }
    }

    // Bo qua cum chi co mot o
    if (total < 2) return 0;

    // Cum chua duoc tham het
    if (!complete) return 0;

    return total;
}

int main() {
    int TC;
    cin >> TC;

    while (TC--) {

        // Doc so lan gieo
        cin >> T;

        int dice[MAXN];

        for (int i = 1; i <= T; i++) {
            cin >> dice[i];
        }

        // Ban co co 7 hang
        n = 7;
        int mid = 4;

        // Tinh so o moi hang
        for (int i = 1; i <= n; i++) {
            lenRow[i] = mid + min(i - 1, n - i);
        }

        // Nhap ban co
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= lenRow[i]; j++) {
                cin >> a[i][j];
            }
        }

        memset(visited, false, sizeof(visited));
        memset(checked, false, sizeof(checked));

        // Bat dau tu o trung tam co gia tri 0
        visited[mid][mid] = true;

        // Gieo xuc xac lan luot
        for (int i = 1; i <= T; i++) {
            bfs(dice[i]);
        }

        // Sau khi gieo het moi tinh diem
        int score = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= lenRow[i]; j++) {

                // Chi xet cum co ket noi voi vung da tham
                if (visited[i][j] &&
                    !checked[i][j] &&
                    a[i][j] != 0) {

                    score += countComponent(i, j);
                }
            }
        }

        cout << score << '\n';
    }

    return 0;
}
