#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
int N, M, sr, sc;
const int MAXN = 31;
char a[MAXN][MAXN];
int d[MAXN][MAXN][64];
int moveX[]= {-1,1,0,0};
int moveY[] = {0,0,-1,1};
int allKeysMask = 0;
// bài này phải sử dụng bitmask


int bfs(int sr, int sc){

    queue<tuple<int, int, int>> q;
    int mask = 0;
    
    q.push({sr,sc,mask});
    d[sr][sc][mask] = 0;
    while(!q.empty()){
        int r = get<0>(q.front());
        int c = get<1>(q.front());
        int mask = get<2>(q.front());
        
        q.pop();
        if (mask == allKeysMask) {
            return d[r][c][mask];   
        }
        for(int i  = 0; i < 4; i++){
            int u = r + moveX[i];
            int v = c + moveY[i];
            if(u < 1 || u > N || v < 1 || v > M){
                continue;
            }
            if(a[u][v] == '#'){
                continue;
            }
            if(a[u][v] >= 'A' && a[u][v] <= 'F'){
                int bit = a[u][v] - 'A';
                if((mask & (1 << bit)) == 0){
                    continue;
                }
            }
            int nextMask = mask;

            if (a[u][v] >= 'a' && a[u][v] <= 'f') {
                int bit = a[u][v] - 'a';
                
                nextMask |= (1 << bit);
            }
            if(d[u][v][nextMask] != -1){
                continue;
            }
            d[u][v][nextMask]= d[r][c][mask] + 1;
            q.push({u,v,nextMask});
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
        allKeysMask = 0;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                cin >> a[i][j];
            }
        }
        memset(d, -1, sizeof(d));
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(a[i][j] == '@'){
                    sr = i;
                    sc = j;

                }
                if (a[i][j] >= 'a' && a[i][j] <= 'f') {
                    int bit = a[i][j] - 'a';
                    allKeysMask |= (1 << bit);
                }
            }
        }
        // cout << "sr:" << sr << " sc " << sc << "\n";
        cout << "#" << t << " " << bfs(sr,sc) << "\n";

    }
}
/*
1
3 5
@.a..
###.#
b.A.B


*/