#include <stdio.h>
int main(){
	int abc;
	printf("Nhap vao so co 3 chu so: ");
	scanf("%d",&abc);
	while(abc<100 || abc >999){
		printf("Vui long nhap lai: ");
		scanf("%d",&abc);
	}
	int a, b, c;
	c = abc % 10;
	abc /=10;
	b = abc % 10;
	abc /=10;
	a = abc % 10;
	printf("Chu so hang tram: %d\n", a);
	printf("Chu so hang chuc: %d\n", b);
	printf("Chu so hang don vi: %d\n",c);
}
