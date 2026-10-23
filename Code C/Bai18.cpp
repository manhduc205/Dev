#include <stdio.h>
#include <math.h>
int main(){
	int n;
	int sum =0;
	int du;
	printf("Nhap vao so co 3 chu so:");
	scanf("%d",&n);
	while(n > 0){
		du = n%10;
		n/=10;
		sum +=du;
	}
	if(sum==9) printf("YES");
	else printf("NO");
	
}
