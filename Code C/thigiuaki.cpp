#include <stdio.h>
#include <math.h>
int main(){
	int n; float T= 0;
	printf("Nhap vao so nguyen n :");
	scanf("%d",&n);
	while(n<0){
		printf("Vui long nhap lai so nguyen n :");
		scanf("%d",&n);
	}
	for( int i = 0; i <=n;i++){
		T=T+(float)1/(2*i+1);
	}
	printf("%f",T);
}
