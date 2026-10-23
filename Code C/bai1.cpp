#include<stdio.h>
#include<conio.h>
main()
{
int a = 20 ; 
int b = 15;
float x = 25.678;
printf("\n1:%d %f\n",a,x);
printf("2:%4d %10f\n",b,x);
printf("3:%2d %3f\n",a,x);
printf("4:%10.3f %10d\n",x,b);
printf("5:%-5d %f\n",a,x);
printf("6:%*d\n",b,b);
printf("7:%*.*f\n",12,5,x);
printf("8:%x :%8x :\n",a,a); //14 la cach bieu dien so 20 trong he thap luc phân(hexadecimal)
printf("9:%o :%8o :\n",a,a); //24 la cach bieu dien so 20 trong he bat phan(octal)
getch();
}

