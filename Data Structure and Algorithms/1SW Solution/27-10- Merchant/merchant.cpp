#include <vector>
#include <iostream>
#include <cstring>
#include <algorithm>
using namespace std;
int P[21][21];
int S[21][21];
int moveX[] = {-1,1,0,0};
int moveY[] = {0,0, -1, 1};
long long ans;
int R, C, sr, sc, D, I;
void dfs(int r, int c, int day, int goods, long long profit){
    if(day == D){
        if(ans < profit){
            ans = profit;
        }
        return;
    }
    for(int i = 0; i< 4; i++){
        int x = r + moveX[i];
        int y = c + moveY[i];
        if(x < 1 || x > R){
            continue;
        }
        if(y < 1 || y > C){
            continue;
        }
        dfs(x,y,day+1, goods, profit);
    }
    int temp = P[r][c];

    if (temp > 0) {
        goods += temp;
        P[r][c] = temp / 2;

        dfs(r, c, day + 1, goods, profit);

        goods -= temp;
        P[r][c] = temp;
    }
    if(goods > 0 && S[r][c] > 0){
        
        long long newP = profit +goods* S[r][c] ;
        S[r][c]--;

        dfs(r, c, day + 1, 0, newP);

        S[r][c]++;
    }

}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T; cin >> T;
    for(int t= 1; t<= T; t++){
        cin >> R >> C >> sr >> sc >> D >> I;
        for(int i = 1; i<= R; i++){
            for(int j = 1; j <= C; j++){
                cin >> P[i][j];
            }
        }
        for(int i = 1; i<= R; i++){
            for(int j = 1; j <= C; j++){
                cin >> S[i][j];
            }
        }
        ans = 0;
        dfs(sr, sc, 0, I, 0);

        cout << "#" << t << " " << ans << '\n';
    }
    

    return 0;
}
/*
2
5 4 2 4 6 5
5 7 8 2
7 22 6 7
5 5 3 10
3 1 9 8
32 2 5 5
1 2 2 2
2 5 1 13
5 5 1 3
2 5 4 3
10 5 1 3
5 4 5 1 4 5
5 7 8 2
7 22 6 7
5 5 3 10
3 1 9 8
32 2 5 5
1 2 2 2
2 5 1 13
5 5 1 3
2 5 4 3
10 5 1 3

OUTPUT
#1 351
#2 610
*/
