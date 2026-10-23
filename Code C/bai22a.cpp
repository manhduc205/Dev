#include <stdio.h>
#include <math.h>
int main(){
	int n;
	int sum =0;
	int du;
	int base =1;
	scanf("%d",&n);
	while(n >0){
		du = n %10 ;
		n /= 10;
		sum = sum + du*base;
		base *=2;
	}
	printf("%d",sum);
}
