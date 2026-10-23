#include <stdio.h>
#include <math.h>
bool check(int a[], int n){
	for ( int i= 0; i <n; i++){
		if (a[i]%i ==0){
			return false;
		}
		return true;
	}
}
int main(){
	int n; scanf("%d",&n);
	int a[n];
	for(int i =0;i <n; i++){
		scanf("%d", &a[i]);
	}
	int count=0, sum =0;
	for (int i=0; i <n; i++){
		if(a[i]){
			count++;
			sum += a[i];
			printf("%d",a[i]);
		}
	}
	printf("%d",sum/count);
	return 0;
}
