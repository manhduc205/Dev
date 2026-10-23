#include <iostream>
using namespace std;
int main(){
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T;
    cin >> T;
    for(int t = 1; t<=T; t++){
        int N, M, K;
        cin >> N >> M >> K;
        int a[101][101];
        int h[101];
        for(int i = 0; i < K; i++){
            cin >> h[i];
        }
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                cin >> a[i][j];
            }
        }
        for(int i = 0; i < K; i++){
            if(h[i]==4){
                for(int j = 1; j <= M; j++){
                    for(int i = 1; i < N; i++){
                        if(a[i][j] > 0){
                            a[i+1][j] = a[i][j] + a[i +1][j];
                            a[i][j] = 0;
                            break;
                        }
                    }    
                    
                }
            }
            if(h[i]==3){
                for(int j = 1; j <= M; j++){
                    for(int i = N; i >= 1; i--){
                        if(i > 1 && a[i][j] > 0){
                            a[i-1][j] = a[i][j] + a[i - 1][j];
                            a[i][j] = 0;
                            break;
                        }
                    }    
                    
                }
            }
            if(h[i]==2){
                for(int i = 1; i <= N; i++){
                    for(int j = 1; j <= M; j++){
                        if(j < M && a[i][j] > 0){
                            a[i][j+1] = a[i][j] + a[i][j+1];
                            a[i][j] = 0;
                            break;
                        }
                    }    
                    
                }
            }
            if(h[i]==1){
                for(int i = 1; i <= N; i++){
                    for(int j = M; j >= 1; j--){
                        if(j > 1 && a[i][j] > 0){
                            a[i][j-1] = a[i][j] + a[i][j-1];
                            a[i][j] = 0;
                            break;
                        }
                    }    
                    
                }
            }
        }
        cout << "#" << t << " ";
        int maxpp = 0;
        int col = 1;
        int row = 1;
        for(int i = 1; i <= N; i++){
            for(int j = 1; j <= M; j++){
                if (a[i][j] > maxpp) {
                    maxpp = a[i][j];
                    row = i;
                    col = j;
                }
            }
        }
        cout << maxpp << " " << row << " " << col << "\n";
        
    }
    return 0;
}