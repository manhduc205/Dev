#include<stdio.h>
#include<conio.h>
#include<math.h>
main(){
	char hoten[30];
	float tongdiem;
	printf("Nhap vao ho ten:");
	fflush(stdin);
	gets(hoten);
	printf("Nhap vao tong diem:");
	scanf("%f",&tongdiem);
	if(tongdiem >0 && tongdiem <=10){
		if(tongdiem<5){
			printf("XEP LOAI KEM");
		}
		else if(tongdiem>=5 && tongdiem <7){
			printf("XEP LOAI TRUNG BINH");
		}
		else if(tongdiem>=7 && tongdiem<8){
			printf("XEP LOAI KHA");
		}
		else printf("XEP LOAI GIOI");
								
	}
	else printf("Vui long nhap lai!");
	getch();
}
