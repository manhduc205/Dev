#include <stdio.h>
#include <string.h>
int main(){
	int n;
	float tbc=0;
	int count=0;
	int mang[10][10];
	int matrancv[10][10];	
	scanf("%d",&n);
	for(int i =0; i<n;i++){
		for(int j=0;j<n;j++){
			scanf("%d",&mang[i][j]);
		}
	}
	for(int i=0;i<n;i++){
		for(int j =0; j<n; j++){
			if(j>=i){
				printf("%d ",mang[i][j]);
			}
			else printf("  ");
		}
		printf("\n");
	}
	for(int i=0;i<n;i++){
		for(int j =0; j<n; j++){
			if(j==i||i+j==n-1){
				printf("%d ",mang[i][j]);
				tbc = tbc+mang[i][j];
				count++;
			}
			else printf("  ");
		}
		printf("\n");		
	}	
	printf("trung binh cong: %f\n",tbc/count);
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            matrancv[j][i] = mang[i][j];
        }
    }
    printf("Ma tran chuyen vi:\n");
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < n; j++) {
            printf("%d ", matrancv[i][j]);
        }
        printf("\n");
    }
    return 0;
}
