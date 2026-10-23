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
    cout << dem;
    return 0;

}

/*
5 6
3 4 0 -1 9 -2
-1 1 3 8 10 13
5 5 2 0 6 -4
-5 7 4 -1 8 -9
3 -7 -3 5 -3 12

output : 18

you are given a grid of size N x M and each cell of the grid is filled with a number 

in the grid you want to color some of the cells by following the condition below

Condition by either adding or subtracting all of the numbers that are placed at the top, at the bottom, to the right and to the left of a given number, you can get the given number

see the grid below
*/