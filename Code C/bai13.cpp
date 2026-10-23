#include <stdio.h>
#include <conio.h>
#include <math.h>
main(){
	int thang, nam;
	printf("Nhap vao thang, nam:");
	scanf("%d%d",&thang,&nam);
	switch(thang){
		case 1 : case 3 : case 5: case 7 : case 8 : case 10 : case 12 : printf("So ngay 31"); break;
		case 2:
			if ((nam % 4 == 0 && nam % 100 != 0) || (nam % 400 == 0)){
				printf("So ngay 29");
			}
			else printf("So ngay 28");break;
		case 4: case 6 : case 9 : case 11: printf("So ngay 30");break;	
		default:
            printf("Thang khong hop le.\n");
            break;			
	}
	getch();
}
