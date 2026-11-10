
#include <iostream>
#include <vector>
#include <queue>
#include <string>
#include <utility>
#include <cstring>

using namespace std;

int H, W;
char a[2001][2001];
vector<pair<int, int> > p[26];

int d[2001][2001];
bool visitedPort[26];
int moveX[] = {-1,1,0,0};
int moveY[] = {0,0,-1,1};
int sx, sy;

int bfs() {
    queue<pair<int, int> > q;

    q.push({sx, sy});
    d[sx][sy] = 0;

    while (!q.empty()) {
        int x = q.front().first;
        int y = q.front().second;
        q.pop();

        if (a[x][y] == 'G') {
            return d[x][y];
        }

        
        for (int i = 0; i < 4; i++) {
            int u = x + moveX[i];
            int v = y + moveY[i];

            if (u < 1 || u > H || v < 1 || v > W)
                continue;

            if (a[u][v] == '#')
                continue;

            if (d[u][v] != -1)
                continue;

            d[u][v] = d[x][y] + 1;
            q.push({u, v});
        }

        if (a[x][y] >= 'a' && a[x][y] <= 'z') {
            int id = a[x][y] - 'a';

            if (!visitedPort[id]) {
                visitedPort[id] = true;

                for (int k = 0; k < p[id].size(); k++) {
                    int nx = p[id][k].first;
                    int ny = p[id][k].second;

                    if (d[nx][ny] == -1) {
                        d[nx][ny] = d[x][y] + 1;
                        q.push({nx, ny});
                    }
                }
            }
        }
    }

    return -1;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T; cin >> T;
    for(int t = 1; t <= T; t++){
        cin >> H >> W;

        memset(d, -1, sizeof(d));
        memset(visitedPort, false, sizeof(visitedPort));
        for (int i = 0; i < 26; i++) {
            p[i].clear();
        }
        for (int i = 1; i <= H; i++) {
            for (int j = 1; j <=W; j++) {
                cin >> a[i][j];
            }
        }
        for (int i = 1; i <= H; i++) {

            for (int j = 1; j <= W; j++) {
                if (a[i][j] == 'S') {
                    sx = i;
                    sy = j;
                }
                
                if (a[i][j] >= 'a' && a[i][j] <= 'z') {
                    int id = a[i][j] -'a';

                    p[id].push_back({i, j});
                }
            }
        }

        cout << "#" << t << " " << bfs() << "\n";
    }
    return 0;
}
/*
2
10 14
S...#....#....
.a..#....#....
....#..b.#....
....#....#....
....#....#....
....#....#....
....#....#....
....#.a..#.b..
....#....#....
....#....#...G
15 20
S.....#......#......
.a....#......#......
......#..b...#......
......#......#......
......#......#...#..
......#......#......
......#......#......
......#...#..#......
......#....#.#......
......#.....##......
.....##......#......
......#......#......
......#.a...##.b....
......#......#......
....#.#...#..#.....G
*/