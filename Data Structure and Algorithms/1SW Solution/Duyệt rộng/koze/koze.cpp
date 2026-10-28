#include <iostream>
#include <queue>
#include <cstring>
using namespace std;
int N, M;
char a[251][251];
int d[251][251];
bool visited[251][251];
int moveX[] = {-1,1,0, 0};
int moveY[] = {0,0,-1,1};
int sumSheep = 0, sumWolf = 0;
void bfs(int sr, int sc){
    queue<pair<int,int>> q;
    q.push({sr,sc});
    visited[sr][sc] = true;
    d[sr][sc] = 0;
    int sheep =0, wolf = 0;
    if(a[sr][sc]=='k'){
        sheep++;
    }
    if(a[sr][sc]=='v'){
        wolf++;
    }
    bool escape = false;
    while(!q.empty()){
        int r = q.front().first;
        int c = q.front().second;
        q.pop();
        for(int i = 0; i < 4; i++){
            int u = r + moveX[i];
            int v = c + moveY[i];
            if(u < 1 || u > N || v < 1 || v > M){
                continue;
            }
            if(a[u][v] == '#'){
                continue;
            }
            if(visited[u][v]){
                continue;
            }
            if(u == 1 || u == N || v == 1 || v == M){
                escape = true;
            }
            
            if(a[u][v]=='k'){
                sheep++;
            }
            if(a[u][v]=='v'){
                wolf++;
            }
            
            visited[u][v] = true;
            d[u][v] = d[r][c] + 1;
            q.push({u,v});
            
        }
    }
    if(escape == true){
        sumSheep += sheep;
        sumWolf += wolf;
    }
    else{
        if(sheep > wolf ){
            sumSheep += sheep; 
        }
        else{
            sumWolf += wolf;
        }
    }
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
        memset(visited, false, sizeof(visited));
        memset(d, -1, sizeof(d));
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if(visited[i][j] != true && a[i][j] != '#'){
                    bfs(i, j);
                    
                }
            }
        }
        cout << "#" << t << " " << sumSheep << " " << sumWolf << "\n";
        sumSheep = 0;
        sumWolf = 0;
    }
    
}
/*
Input:
1
8 8  
.######.  
#..k...#  
#.####.#  
#.#v.#.#  
#.#.k#k#  
#k.##..#  
#.v..v.#  
.######.

Output:
3 1
*/