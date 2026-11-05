
#include <iostream>
#include <queue>
#include <string>
#include <cstring>
#include <algorithm>
using namespace std;

int dx[] = {-1, 1, 0, 0};
int dy[] = {0, 0, -1, 1};

int factorial[] = {1, 1, 2, 6, 24, 120};

// Ma hoa mot hoan vi thanh so tu 0 den 719
int getId(string s) {
    int id = 0;

    for (int i = 0; i < 6; i++) {
        int cnt = 0;

        for (int j = i + 1; j < 6; j++) {
            if (s[j] < s[i]) {
                cnt++;
            }
        }

        id += cnt * factorial[5 - i];
    }

    return id;
}

int bfs(string start) {
    string target = "123450";

    bool visited[720];
    memset(visited, false, sizeof(visited));

    queue<pair<string, int> > q;

    q.push({start, 0});
    visited[getId(start)] = true;

    while (!q.empty()) {
        string s = q.front().first;
        int steps = q.front().second;
        q.pop();

        if (s == target) {
            return steps;
        }

        int pos = s.find('0');

        int x = pos / 3;
        int y = pos % 3;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx < 0 || nx >= 2 || ny < 0 || ny >= 3) {
                continue;
            }

            int nextPos = nx * 3 + ny;

            string nextState = s;
            swap(nextState[pos], nextState[nextPos]);

            int id = getId(nextState);

            if (visited[id]) {
                continue;
            }

            visited[id] = true;

            q.push(make_pair(nextState, steps + 1));
        }
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    while (T--) {
        string s = "";

        for (int i = 0; i < 6; i++) {
            int x;
            cin >> x;
            s += char(x + '0');
        }

        cout << bfs(s) << "\n";
    }

    return 0;
}
