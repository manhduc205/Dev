#include <iostream>
#include <vector>
using namespace std;
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T;
    cin >> T;                                                                                                                               
    
    for(int t = 1; t <= T; t++){
        int N, M;
        
        cin >> N >> M;
        vector<vector<int>> a(N, vector<int> (N));
        for(int i =0; i < N; i++){
            for(int j = 0; j < N; j++){
                cin >> a[i][j];
            }
        }

        int rong = N/M;
        int maxSum = -1e9;
        for(int i = 0; i < N; i++){
            for(int j = 0; j < rong; j++){
                int sum = 0;
                for(int k = 0; k < M; k++){
                    int col = 0;
                    if(k % 2 ==0){
                        col = k * rong + j;
                    }
                    else{
                        col = k * rong + (rong - 1 - j);
                    }
                    sum += a[i][col];
                }
                if(sum > maxSum){
                    maxSum = sum;
                }
                
            }
        }
        cout << "#" << t << ": ";
        cout << maxSum << "\n";
    }
    return 0;
}

/*
2
6 3
5 1 8 2 4 3
6 5 2 1 3 7
1 1 5 6 1 2
2 7 1 5 7 6
4 5 7 1 2 3
5 2 3 7 4 8
8 4
3 4 8 7 5 1 6 4
5 4 7 8 1 3 2 4
4 8 6 7 2 1 6 8
2 1 5 7 6 4 8 2
3 4 8 6 9 1 2 3
5 5 4 7 6 2 8 4
4 9 8 7 1 8 6 5
1 2 4 8 7 9 5 3
output: 16
*/