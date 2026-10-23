#include <stdio.h>
#include <conio.h>
#include <math.h>

main(){
	int a,b;
	char ch;
	printf("Nhap a, b:");
	scanf("%d%d",&a,&b);
	fflush(stdin);
	ch = getchar();
	switch(ch){
		case '+': printf("Tong la:%d", a+b); break;
		case '-': printf("Hieu la:%d", a-b);break;
		case '/': printf("Thuong la:%f",float(a)/b);break;
		case '*': printf("Tich la: %d", a*b); break;
		default : printf("Khong phai la phep toan");
	}
	getch();
}
