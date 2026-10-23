#include <stdio.h>
#include <math.h>
int main(){
	int a ,b,c;
	printf("nhap so to tien 1000 2000 3000:\n");
	for(int a =1 ;a <= 20 ; a++){
		for(int b=1; b <= 10;b++){
			for(int c =1; c <= 4;c++){
				if(a*1000 + b*2000 +c*5000==20000){
					printf("Co %d to 1000, %d to 2000, %d to 5000\n", a,b,c);
				}
			}
		}
	}
}
