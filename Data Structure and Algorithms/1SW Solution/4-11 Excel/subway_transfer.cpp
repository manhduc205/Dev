#include <iostream>
#include <vector>
#include <cstring>
#include <queue>
using namespace std;

int N, M, S, E;
vector<int> r[10001];
vector<int> mp[10001];
bool visited[10001];
bool visitedStation[10001];
int bfs() {

    queue<int> q;
    

    for (int i = 0; i < mp[S].size(); i++) {
        int route = mp[S][i];

        q.push(route);
        visited[route] = true;
    }

    int bus = 0;

    while (!q.empty()) {
        int sz = q.size();

        for (int i = 0; i < sz; i++) {
            int u = q.front();
            q.pop();

            for (int i = 0; i < r[u].size(); i++) {
                int station = r[u][i];

                if (station == E) {
                    return bus;
                }
                if (visitedStation[station]) {
                    continue;
                }

                visitedStation[station] = true;
                

                for (int j = 0; j < mp[station].size(); j++) {
                    int v = mp[station][j];
                    
                    if (!visited[v]) {
                        visited[v] = true;
                        
                        q.push(v);
                    }
                }
            }
        }

        bus++;
    }

    return -1;
}

int main() {
    // freopen("subway.txt","r",stdin);
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T;
    cin >> T;

    for (int t = 1; t <= T; t++) {
        cin >> N >> M >> S >> E;

        for (int i = 1; i <=M; i++) {

            r[i].clear();
        }

        for (int i = 1; i <= N; i++) {
            mp[i].clear();
        }
        memset(visited, false,sizeof(visited));
        memset(visitedStation, false, sizeof(visitedStation));
        
        int cnt[10001];

        for (int i = 1; i <= M; i++) {
            cin >> cnt[i];
        }

        
        for (int i = 1; i <= M; i++) {
            for (int j = 1; j <= cnt[i]; j++) {
                int x;
                cin >> x;

                r[i].push_back(x);
                mp[x].push_back(i);
            }
        }

        cout << "#"<<t << " " << bfs() << "\n";
    }

    return 0;
}