#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
int N;
int a[21][21];
bool visited[21];
int d[21];

void chuyen(int x, int& r, int& c){
    int rowFromBottom = (x-1)/N +1;
    int offset = (x - 1) % N;
    
    if(rowFromBottom % 2 == 0){
        c = N - offset;
    }
    else{
        c = offset + 1;
    }
    r = N - rowFromBottom + 1;
}

int bfs(){
    queue<int> q;
    q.push(1);
    d[1] = 0;
    visited[1] = true;
    while(!q.empty()){
        int u = q.front();
        q.pop();
        if(u == N * N){
            return d[u];
        }
        for(int step = 1; step <= 6; step++){
            int v = u + step;
            if (v > N * N) {
                break;
            }
            int r, c;
            chuyen(v, r, c);
            // cout << "v: " << v << "r" << r << "c: " << c << "\n";
            if(a[r][c] != -1){
                v = a[r][c];
            }
            if(!visited[v]){
                visited[v] = true;
                d[v] = d[u] + 1;
                q.push(v);
            }

        }
    }
    return -1;
}
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T; cin >> T;
    for(int t = 1; t <= T; t++){
        cin >> N;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= N; j++){
                cin >> a[i][j];
            }
        }
        memset(visited, false, sizeof(visited));
        memset(d, 0, sizeof(d));
        cout << "#" << t << " " << bfs() << "\n"; 
    }

}