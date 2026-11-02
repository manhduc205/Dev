#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
int N, M, sr, sc;
const int MAXN = 31;
char a[MAXN][MAXN];
int d[MAXN][MAXN][2][2];
int moveX[]= {-1,1,0,0};
int moveY[] = {0,0,-1,1};

// bài này sai 
// vì có thể có nhiều key trong ma trận chứ không phải chỉ có 2 key A và B


int bfs(int sr, int sc){

    queue<tuple<int, int, int, int>> q;
    int keyA = 0, keyB = 0;
    q.push({sr,sc,keyA, keyB});
    d[sr][sc][keyA][keyB] = 0;
    while(!q.empty()){
        int r = get<0>(q.front());
        int c = get<1>(q.front());
        int keyA = get<2>(q.front());
        int keyB = get<3>(q.front());
        q.pop();
        if(keyA == 1 && keyB == 1){
            return d[r][c][keyA][keyB];
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
            if(a[u][v] == 'A' && keyA == 0){
                continue;
            }
            if(a[u][v] == 'B' && keyB == 0){
                continue;
            }
            int nextKeyA = keyA;
            int nextKeyB = keyB;
            if(a[u][v] == 'a'){
                nextKeyA = 1;
            }
            if(a[u][v] == 'b'){
                nextKeyB = 1;
            }
            if(d[u][v][nextKeyA][nextKeyB] != -1){
                continue;
            }
            d[u][v][nextKeyA][nextKeyB] = d[r][c][keyA][keyB] + 1;
            q.push({u,v,nextKeyA,nextKeyB});
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