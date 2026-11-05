#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
int N, M, sr, sc;
const int MAXN = 15;
vector<int> a[MAXN];
int d[MAXN][1 << MAXN];
int allMask;
int bfs(){
    queue<pair<int,int>> q;
    
    for(int i = 0; i < N; i++){
        int mask = (1 << i);
        q.push({i,mask});
        d[i][mask] = 0;
    }
    while(!q.empty()){
        int u = q.front().first;
        int mask = q.front().second;
        q.pop();
        if(mask == allMask){
            return d[u][mask];
        }
        for(auto v : a[u]){
            int nextMask = mask | ( 1 << v);
            if(d[v][nextMask] != -1){
                continue;
            }
            d[v][nextMask] = d[u][mask] + 1;
            q.push({v,nextMask});
            
        }
    }
    
    return -1;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T; cin >> T;
    for(int t = 1; t <= T; t++){
        cin >> N >> M;
        for (int i = 0; i < N; i++) {
            a[i].clear();
        }
        for(int i = 1; i <= M; i++){
            
            int u, v;
            cin >> u >> v;
            a[u].push_back(v);
            a[v].push_back(u);
            
        }
        memset(d, -1, sizeof(d));
        // cout << "sr:" << sr << " sc " << sc << "\n";
        allMask = (1 << N) - 1;
        cout << "Dvxcv: " << allMask << "\n";
        cout << "#" << t << " " << bfs() << "\n";

    }
}
/*
1
4 3
0 1
0 2
0 3

#1 4


*/