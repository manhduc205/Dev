#include <stdio.h>
#include <math.h>
int main(){
	int n; scanf("%d",&n);
	int a[n];
	for(int i =0;i <n; i++){
		scanf("%d", &a[i]);
	}	
	int sum =0;
	for (int i =0; i <n; i++){
		if(a[i] % 2 != 0){
			sum += a[i];
		}
	}
	printf("%d",sum);
	int sum =0;
	for(int i =0; i<n; i++){
		if(a[i] % 3 ==0 && a[i] >=0){
			sum += a[i];
		}
	}
}
