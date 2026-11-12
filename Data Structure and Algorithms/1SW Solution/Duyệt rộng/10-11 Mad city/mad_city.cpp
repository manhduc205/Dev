#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;
int N, A, B;
vector<int> a[200001];
int deg[200005];
bool inCycle[200005];
bool visited[200005];
int dA[200005], dB[200005];

void bfsChuTrinh(){
    
    queue<int> q;
    for(int i = 1; i <= N; i++){
        deg[i] = a[i].size();
        if(deg[i] == 1){
            q.push(i);
        }
    }
    while(!q.empty()){
        int u = q.front();
        q.pop();
        inCycle[u] = false;
        for(int v : a[u]){
            deg[v]--;
            if(deg[v] == 1){
                q.push(v);
            }
        }
    }
    for(int i = 1; i <= N; i++){
        if(deg[i] > 1){
            inCycle[i] = true;
        }
    }
}

void bfs(int s, int d[]) {
    for (int i = 1; i <= N; i++) {
        d[i] = -1;
    }

    queue<int> q;
    q.push(s);
    d[s] = 0;

    while (!q.empty()) {
        int u = q.front();
        q.pop();

        for (int v : a[u]) {
            if (d[v] != -1) continue;

            d[v] = d[u] + 1;
            q.push(v);
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    // freopen("mad_city.txt", "r", stdin);
    int T; cin >> T;
    for(int t = 1; t <= T; t++){
        cin >> N >> A >> B;
        memset(visited, false, sizeof(visited));
        memset(inCycle, false, sizeof(inCycle));
        for(int i = 1; i<= N; i++){
            a[i].clear();   
            deg[i] = 0;
        }
        for(int i = 1; i <= N; i++){
            int u, v;
            cin >> u >> v;
            a[u].push_back(v);
            a[v].push_back(u);
        }
        bfsChuTrinh();
        bfs(B, dB);
        bfs(A, dA);

        bool ans = false;

        for (int i = 1; i <= N; i++) {
            if (inCycle[i]) {
                if (dB[i] < dA[i]) {
                    ans = true;
                    break;
                }
            }
        }

        if (ans) cout << "YES\n";
        else cout << "NO\n";
    }
    return 0;
}
