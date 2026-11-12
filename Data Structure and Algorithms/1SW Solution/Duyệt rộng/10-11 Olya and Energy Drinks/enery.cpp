#include <iostream>
#include <cstring>
#include <queue>

using namespace std;
int N, M, K;
int x1,y1,x2,y2;
char a[1001][1001];
int d[1001][1001];
int moveX[] = {-1,1,0,0};
int moveY[] = {0,0,-1,1};
int bfs(){
    queue<pair<int,int>> q;
    q.push({x1,y1});
    d[x1][y1] = 0;
    while(!q.empty()){
        int r = q.front().first;
        int c = q.front().second;
        q.pop();
        if(r == x2 && c == y2){
            return d[r][c];
        }
        for(int i = 0; i< 4; i++){
            int u, v;
            for(int con = 1; con <= K; con++){
                u = r + moveX[i]* con;
                v = c + moveY[i]* con;
                if(u < 1 || u > N || v < 1 || v > M){
                    continue;
                }
                if(a[u][v] == '#'){
                    break;
                }
                if (d[u][v] != -1) {
                    if (d[u][v] < d[r][c] + 1) {
                        break;
                    }
                    continue;
                }

                d[u][v] = d[r][c] + 1;
                q.push({u, v});
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
        memset(d, -1, sizeof(d));
        cin >> N >> M >> K;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                cin >> a[i][j];
            }
        }
        cin >> x1 >> y1 >> x2 >> y2;

    
        cout << "#" << t << " " << bfs() << endl;
    }
}

/*
10 14 3
#.#......#....
.A......#.#...
............#.
.#.........##.
.#..#...#.....
#.##.......#..
..##..#....#..
......#.......
.##.#..#....B.
##.....#.#....
2 2 9 13
*/