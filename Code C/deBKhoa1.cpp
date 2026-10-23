#include <stdio.h>
double calculate_range(double a[], int size){
	double max_ele = a[0];
	for(int i=0; i < size ;i++){
		if(max_ele < a[i]){
			max_ele = a[i];
		}
	}
	double min_ele = a[0];
	for(int i=0; i < size ;i++){
		if(min_ele > a[i]){
			min_ele = a[i];
		}
	}
	return max_ele - min_ele;	
	
}
int main(){
	int size;
	scanf("%d",&size);
	double a[size];
	for(int i=0; i < size; i++){
		scanf("%f",&a[i]);
	}
	printf("%f", calculate_range(a,size));
}
