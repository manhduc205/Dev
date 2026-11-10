#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

int N;
int a[501];
vector<int> adj[501];
bool visited[501];

int bfs(int s) {
    queue<int> q;
    q.push(s);
    visited[s] = true;

    int cnt = 1;

    while (!q.empty()) {
        int u = q.front();
        q.pop();

        for (auto v: adj[u]) {

            if (!visited[v]) {
                visited[v] = true;
                cnt++;
                q.push(v);
            }
        }
    }

    return cnt;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T; cin >> T;
    for(int t = 1; t <= T; t++){
        cin >> N;
        for (int i = 1; i <= 501; i++) {
            adj[i].clear();
        }
        memset(visited, false, sizeof(visited));
        for (int i = 1; i <= N; i++) {
            cin >> a[i];
        }

        
        for (int i = 1; i <= N; i++) {
            for (int j = i + 1; j <= N; j++) {
                if (a[i] % a[j] == 0 || a[j] % a[i] == 0) {
                    adj[i].push_back(j);
                    adj[j].push_back(i);
                }
            }
        }

        int ans = 0;

        for (int i = 1; i <= N; i++) {
            if (!visited[i]) {
                int dem = bfs(i);

                if (dem > ans) {
                    ans = dem;
                }
            }
        }

        cout << "#" << t << " " << ans << "\n"; 
    }
    return 0;
}

/*
3
5
7 10 5 8 4
7
3 2 12 6 13 7 15
10
11 12 17 3 30 11 22 2 23 15

out put 
2
5 
8
*/