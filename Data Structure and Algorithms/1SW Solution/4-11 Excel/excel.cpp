#include <iostream>
#include <queue>
#include <vector>
#include <cstring>
using namespace std;

int N, M, C;
bool visited[1001];
vector<vector<int>> a(1001);
int c[101];
int dem = 0;
void bfs(int x){
    queue<int> q;
    q.push(x);
    visited[x] = true;
    dem++;
    while(!q.empty()){
        int u = q.front();
        q.pop();
        for(auto v : a[u]){
            if(visited[v]){
                continue;
            }
            visited[v] = true;
            dem++;
            q.push(v);

        }
    }
    
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    for (int t = 1; t <= T; t++) {
        cin >> N >> M >> C;
        memset(visited, false, sizeof(visited));
        for(int i = 1; i <= M; i++){
            int u, v;
            cin >> u >> v;
            a[u].push_back(v);
        }
        for(int i =1; i <= C; i++){
            cin >> c[i];
            bfs(c[i]);
            
        }
        cout << "#" << t << " " << dem << "\n";
        dem = 0;
        a.clear();
        
    }

    return 0;
}

/*
1  
13 12 2
1 6
1 9
7 1
5 10
7 5
11 8
7 11
4 7
3 4
2 12
13 2
4 13 
1
13 

*/