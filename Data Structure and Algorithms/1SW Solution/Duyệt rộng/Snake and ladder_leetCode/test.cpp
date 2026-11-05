#include <iostream>
#include <queue>
using namespace std;
int N;
int a[101][101];
int d[101];
bool visited[101];

void chuyen(int x , int& r, int& c){
    int hang = (x - 1)/N + 1;
    int offset = (x - 1)%N;
    if(hang % 2 == 0){
        c = N - offset;
    }
    else{
        c = offset + 1;
    }
    r = N - hang + 1;
}

int bfs(){
    queue<int> q;
    q.push(1);
    d[1] = 0;
    visited[1] = true;
    while(!q.empty()){
        int x = q.front();
        q.pop();
        if(x == N*N){
            return d[x];
        }
        for(int step = 1; step <= 6; step++){
            int v = x + step;
            if(v > N * N){
                continue;
            }
            int r, c;
            chuyen(v,r,c);
            if(a[r][c]!= -1){
                v=a[r][c];
            }
            if(!visited[v]){
                visited[v] =true;
                d[v]=d[x] + 1;
                q.push({v});
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
        cout << "#" << t << " " << bfs() << "\n";
    }
}