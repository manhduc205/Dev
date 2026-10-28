#include <vector>
#include <iostream>
#include <cstring>
using namespace std;
vector<pair<int, int>> a[30];
int X;
int N, M, K;
bool visited[30];

void dfs(int u, int distance){
    // visited[u] = true;
    
    for(pair<int, int> x : a[u]){
        int v = x.first;
        int w = x.second;
        if(visited[v] == true){
            continue;
        }
        if(distance + w > K){
            continue;
        }
        X++;
        visited[v]=true;
        dfs(v,distance + w);
        // backtrack
        visited[v] = false;
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T; cin >> T;
    for(int t= 1; t<= T; t++){
        
        cin >> N >> M >> K;
        
        for(int i = 1; i <= N; i++){
            a[i].clear();
            visited[i]=false;
        }

        for(int i = 1; i <= M; i++){
            int u, v, w;
            cin >> u >> v >> w;
            a[u].push_back({v, w});
            a[v].push_back({u, w});
        }
        X = 0;
        visited[1] = true;
        dfs(1,0);
        cout << "#" << t << " " << X << "\n";
    }
    

    return 0;
}

/*

3
4 5 6
1 2 2
1 3 3
2 3 2
2 4 4
3 4 3

7 6 6
1 2 1
1 3 2
2 4 2
2 5 5
3 6 3
6 7 2

5 4 3
1 2 5
1 3 4
2 4 1
3 5 2

output:

*/
