#include<stdio.h>
#include<conio.h>
main()
{
int m = 3,p = 5;
int a1,a2,a3,a4,a5;
float x1,x2,x3,x4;
printf("\n Tim gia tri gan cho cac bien ");
a1 = m<p;
a2 = m == p;
a3 = p%m + p>m;
a4 = m*(p>m ? m:p);
a5 = m*(p<m ? p:p);
x1 = p/m;
x2 = (float)p/m;
x3 = (p +0.5)/m;
x4 = (int)(p+0.5)/m;
printf("\n a1 = %d ",a1);
printf("\n a2 = %d ",a2);
printf("\n a3 = %d ",a3);
printf("\n a4 = %d ",a4);
printf("\n a5 = %d ",a5);
printf("\n x1 = %10.3f ",x1);
printf("\n x2 = %10.3f ",x2);
printf("\n x3 = %10.3f ",x3);
printf("\n x4 = %10.3f ",x4);
getch();
}
