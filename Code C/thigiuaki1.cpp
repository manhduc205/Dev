#include <stdio.h>
#include <string.h>
struct NhanVien {
    char manv[10];
    char hoten[30];
    char phongban[30];
    char chucvu[30];
};

int main() {
    struct NhanVien nhanvien[50];
    int n;
    printf("Nhap so nhan vien: ");
    scanf("%d", &n);
    getchar();
	fflush(stdin);
    for (int i = 0; i < n; i++) {
        printf("Nhap thong tin cho nhan vien thu %d:\n", i + 1);
        printf("Nhap ma nhan vien: ");
        fflush(stdin);
        gets(nhanvien[i].manv);
          
		fflush(stdin);
        printf("Nhap ho ten: ");
        gets(nhanvien[i].hoten);
		fflush(stdin);
        printf("Nhap phong ban: ");
        gets(nhanvien[i].phongban);
		fflush(stdin);
        printf("Nhap chuc vu: ");
        gets(nhanvien[i].chucvu);
    }

    printf("Cac nhan vien co chuc vu truong phong:\n");
    for (int i = 0; i < n; i++) {
        if (strcmp(nhanvien[i].chucvu, "TP") == 0) {
            printf("Ma nhan vien: %s Ho ten: %s\n", nhanvien[i].manv, nhanvien[i].hoten);
        }
    }
    return 0;
}


