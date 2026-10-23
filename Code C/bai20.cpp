#include <stdio.h>
#include <conio.h>
#include <math.h>
main(){
	int x,n;
	scanf("%d%d",&x,&n);
	double b =10;
	for( int i=2 ; i<=n;i++){
		b += 1.0*i/x;
	}
	printf("B la: %f", b);
	getch();
}
