#include <stdio.h>

void nhapMang(int arr[], int n, int m) {
    printf("Nhap cac phan tu cua mang:\n");
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            scanf("%d", &arr[i * m + j]);
        }
    }
}

void xuatMang(int arr[], int n, int m) {
    printf("Mang sau khi sap xep:\n");
    for(int i = 0; i < n; i++) {
        for(int j = 0; j < m; j++) {
            printf("%d ", arr[i * m + j]);
        }
        printf("\n");
    }
}

void sapXepMangGiamDan(int arr[], int size) {
    for(int i = 0; i < size - 1; i++) {
        for(int j = i + 1; j < size; j++) {
            if(arr[i] < arr[j]) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
}

int main() {
    int n, m;

    printf("Nhap so dong n: ");
    scanf("%d", &n);
    printf("Nhap so cot m: ");
    scanf("%d", &m);

    int arr[n * m];

    nhapMang(arr, n, m);
    sapXepMangGiamDan(arr, n * m);
    xuatMang(arr, n, m);

    return 0;
}
