#include <iostream>
#include <vector>
#include <queue>
#include <algorithm>

using namespace std;

const int MAXN = 3005;

int N, M, K;

vector<int> adj[MAXN];
vector<int> banned[MAXN][MAXN];

bool visited[MAXN][MAXN];
int parent[MAXN][MAXN];

void bfs() {
    queue<pair<int, int> > q;

    q.push(make_pair(0, 1));
    visited[0][1] = true;

    int endPrev = -1;

    while (!q.empty()) {
        int prev = q.front().first;
        int u = q.front().second;
        q.pop();

        if (u == N) {
            endPrev = prev;
            break;
        }

        for (int i = 0; i < adj[u].size(); i++) {
            int v = adj[u][i];

            // Kiem tra bo ba cam
            if (find(banned[prev][u].begin(),
                     banned[prev][u].end(), v)
                != banned[prev][u].end()) {
                continue;
            }

            if (visited[u][v]) {
                continue;
            }

            visited[u][v] = true;
            parent[u][v] = prev;

            q.push(make_pair(u, v));
        }
    }

    if (endPrev == -1) {
        cout << -1;
        return;
    }

    // Truy vet
    vector<int> path;

    int prev = endPrev;
    int cur = N;

    while (cur != 0) {
        path.push_back(cur);

        int before = parent[prev][cur];

        cur = prev;
        prev = before;
    }

    reverse(path.begin(), path.end());

    cout << path.size() - 1 << "\n";

    for (int i = 0; i < path.size(); i++) {
        cout << path[i] << " ";
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    cin >> N >> M;

    for (int i = 1; i <= M; i++) {
        int u, v;
        cin >> u >> v;

        adj[u].push_back(v);
        adj[v].push_back(u);
    }

    cin >> K;

    for (int i = 1; i <= K; i++) {
        int a, b, c;
        cin >> a >> b >> c;

        banned[a][b].push_back(c);
    }

    bfs();

    return 0;
}