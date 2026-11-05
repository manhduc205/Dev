#include <iostream>
#include <vector>
using namespace std;

int N;
int leftB[12], rightB[12];
int a[12];
bool visited[12];
int ans;

bool check() {
    for (int floor = 1; floor <= N; floor++) {
        int id = 1;

        while (a[id] < floor) {
            id++;
        }

        if (a[id] != leftB[floor]) {
            return false;
        }

        id = N;

        while (a[id] < floor) {
            id--;
        }

        if (a[id] != rightB[floor]) {
            return false;
        }
    }

    return true;
}

void backtrack(int id) {
    if (id > N) {
        if (check()) {
            ans++;
        }
        return;
    }

    for (int i = 1; i <= N; i++) {
        if (!visited[i]) {
            a[id] = i;
            visited[i] = true;

            backtrack(id + 1);

            visited[i] = false;
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    for (int t = 1; t <= T; t++) {
        cin >> N;

        for (int i = 1; i <= N; i++) {
            cin >> leftB[i];
        }

        for (int i = 1; i <= N; i++) {
            cin >> rightB[i];
        }

        ans = 0;

        backtrack(1);

        cout << "#" << t << " " << ans << '\n';
    }

    return 0;
}
/*

4
5
3 3 3 5 5
4 4 4 4 5
6
1 6 6 6 6 6
2 2 5 5 5 6
2
1 2
2 2
8
1 8 8 8 8 8 8 8
4 4 4 4 6 6 7 8

*/