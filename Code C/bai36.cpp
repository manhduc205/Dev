#include <stdio.h>
#include <string.h>
struct SINHVIEN{
	char hoten[30];
	int namsinh;
	float diemtb;
};
int main(){
	SINHVIEN sinhvien[50];
	int n;
	printf("Nhap so sinh vien: ");
	scanf("%d", &n);
	fflush(stdin);
	for(int i =0 ; i < n ; i++){
		printf("Nhap thong tin cho sinh vien thu: %d\n", i+1);
		printf("Nhap ho va ten:");
		gets(sinhvien[i].hoten);
		fflush(stdin);
		
		printf("Nhap nam sinh: ");
		scanf("%d", &sinhvien[i].namsinh);
		
		fflush(stdin);
		printf("Nhap diem tb: ");
		scanf("%f", &sinhvien[i].diemtb);
		fflush(stdin);
	}
	printf("Danh sach sinh vien xep loai kha tro len:\n");
	for(int i =0 ;i <n ;i++){
		if(sinhvien[i].diemtb >= 6.5){
			printf("%s %d\n",sinhvien[i].hoten,sinhvien[i].namsinh);
		}
	}
	printf("Danh sach sinh vien co nam sinh < 1997 \n");
		for(int i =0;i <n ;i++){
		if(sinhvien[i].namsinh < 1997){
			printf("%s\n",sinhvien[i].hoten);
		}
	}
    for(int i =0; i<n-1;i++){
    	for(int j=i+1; j<n;j++){
    		if(sinhvien[i].diemtb < sinhvien[j].diemtb){
    			SINHVIEN temp = sinhvien[i];
    			sinhvien[i] = sinhvien[j];
    			sinhvien[j]= temp;
			}
		}
	}
    printf("Danh sach sinh vien theo thu tu giam dan cua diem tb:\n");
    for(int i = 0; i < n; i++) {
        printf("%s %d %.2f\n", sinhvien[i].hoten, sinhvien[i].namsinh, sinhvien[i].diemtb);
    }
}
