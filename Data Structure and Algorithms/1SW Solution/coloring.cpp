#include <iostream>
#include <vector>
using namespace std;
int b[4];
int N,M;
vector<vector<int>> a;

bool check(int i, int j){
    int cnt = 0;
    //tren
    if(i>0){
        b[cnt++] = a[i-1][j];
    }
    if(i < N -1){
        b[cnt++] = a[i+1][j];
    }
    if(j >0){
        b[cnt++] = a[i][j-1];
    }
    if(j < M -1){
        b[cnt++] = a[i][j +1];
    }
    for(int x = -1; x <= 1; x += 2){
        for(int y = -1; y<= 1; y+= 2){
            for(int z = -1; z <=1; z += 2){
                for(int w = -1; w <= 1; w +=2){
                    int sum = 0;
                    if(cnt > 0){
                        sum += x * b[0];
                    }
                    if(cnt > 1){
                        sum += y * b[1];
                    }
                    if(cnt > 2){
                        sum += z * b[2];
                    }
                    if(cnt > 3){
                        sum += w * b[3];
                    }
                    if(sum == a[i][j]){
                        return true;
                    }
                }
            }
        }
    
    } 
    return false;
}

int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T; cin >> T;
    for(int t = 1; t<= T; t++){
        cin >> N >> M;
        a.assign(N, vector<int>(M));
        for(int i = 0; i < N; i++){
            for(int j =0; j < M; j++){
                cin >> a[i][j];
            }
        }

        int dem = 0;
        for(int i = 0; i < N; i++){
            for(int j =0; j < M; j++){
                if(check(i,j) == true){
                    dem++;
                }
            }
        }
        cout << "#" << t << " ";
        cout << dem << "\n";
    }
    
    return 0;

}
/*
(Input)
5
5 6
3 4 0 -1 9 -2
-1 1 3 8 10 13
5 5 2 0 6 -4
-5 7 4 -1 8 -9
3 -7 -3 5 -3 12
9 5
-6 5 9 6 2
-7 -2 -5 0 7
2 6 10 -1 -1
6 -8 1 2 2
-6 -4 8 -10 8
9 -6 3 10 1
10 0 3 -2 5
-6 4 4 3 2
-6 10 8 -8 -5
7 12
-1 -4 3 1 -4 -6 4 -10 5 -8 -2 -3
5 1 10 -8 4 0 6 4 4 -5 -5 -10
-7 4 -7 9 10 -3 -10 -8 3 0 -5 1
-4 -8 -5 -6 -10 8 2 -1 -7 0 -9 -3
3 8 -5 5 -7 -5 8 -6 2 9 -3 4
10 -4 -6 2 8 -8 -9 6 6 -4 -10 9
0 -2 1 9 -8 -7 5 10 -6 -1 -8 -3
6 8
9 -7 0 0 9 4 2 -3
-6 0 -2 3 -1 -6 7 -5
-9 0 -4 6 3 -4 -2 -8
3 -8 5 -9 0 -1 9 8
-8 -10 -2 -6 1 -8 8 1
-4 -8 -1 7 -2 -7 6 10
5 9
-10 -10 -2 -3 10 9 -9 -8 0
9 -8 9 7 8 -3 -10 5 5
9 8 -5 10 -5 -7 -1 1 10
3 -4 -3 -3 -7 9 10 -5 2
9 10 -1 -9 7 5 3 -4 -2

(Output)
#1 18
#2 9
#3 22
#4 15
#5 19

*/