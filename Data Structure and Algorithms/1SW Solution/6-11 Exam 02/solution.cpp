#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
int V, E, K, S;
int sumRoll;
vector<int> a[20001];
int visited[20001][26];
int bfs(){
    queue<pair<int,int>> q;
    q.push({S, 0});
    visited[S][0] = true;
    while(!q.empty()){
        int u = q.front().first;
        int d = q.front().second;
        q.pop();
        if(d == sumRoll){
            continue;
        }
        for(auto v : a[u]){
            if(!visited[v][d+1]){
                visited[v][d+1] = true;
                q.push({v,d+1});
            }
        }

    }
    int ans = 0;
    for(int i = 1; i <= V; i++){
        if(visited[i][sumRoll]){
            ans++;
        }
    }
    return ans;
}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T; cin >> T;
    for(int t = 1; t<= T; t++){
        cin >> V >> E >> K >> S;
        memset(visited, false, sizeof(visited));
        for(int i = 1; i <= E; i++){
            int u, v;
            cin >> u >> v;
            a[u].push_back(v);
            a[v].push_back(u);
        }
        sumRoll = 0;
        for(int i = 1; i <=K ; i++){
            int roll ; cin >> roll;
            sumRoll += roll;
        }
        cout << "#" << t << " " << bfs()  << endl;

    }
    return 0;
}