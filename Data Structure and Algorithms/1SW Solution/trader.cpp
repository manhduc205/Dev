
#include <vector>
#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;

int P[21][21];
int S[21][21];

int moveX[] = {-1, 1, 0, 0};
int moveY[] = {0, 0, -1, 1};

long long ans;
int R, C, sr, sc, D, I;

void dfs(int r, int c, int day, int goods, long long profit) {
    if (day == D) {
        if (ans < profit) {
            ans = profit;
        }
        return;
    }

    // 1. Di chuyển sang ô kề cạnh
    for (int i = 0; i < 4; i++) {
        int x = r + moveX[i];
        int y = c + moveY[i];

        if (x < 1 || x > R || y < 1 || y > C) {
            continue;
        }

        dfs(x, y, day + 1, goods, profit);
    }

    // 2. Sản xuất hàng hóa tại ô hiện tại
    int temp = P[r][c];

    if (temp > 0) {
        goods += temp;
        P[r][c] = temp / 2;

        dfs(r, c, day + 1, goods, profit);

        // Khôi phục trạng thái
        goods -= temp;
        P[r][c] = temp;
    }

    // 3. Bán toàn bộ hàng hóa tại ô hiện tại
    if (goods > 0 && S[r][c] > 0) {
        int tempPrice = S[r][c];

        long long newProfit = profit + 1LL * goods * tempPrice;
        S[r][c] = tempPrice - 1;

        dfs(r, c, day + 1, 0, newProfit);

        // Khôi phục trạng thái
        S[r][c] = tempPrice;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    for (int t = 1; t <= T; t++) {
        cin >> R >> C >> sr >> sc >> D >> I;

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                cin >> P[i][j];
            }
        }

        for (int i = 1; i <= R; i++) {
            for (int j = 1; j <= C; j++) {
                cin >> S[i][j];
            }
        }

        ans = 0;
        dfs(sr, sc, 0, I, 0);

        cout << "#" << t << " " << ans << '\n';
    }

    return 0;
}
