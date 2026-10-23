#include <stdio.h>
#include <math.h>
int main() {
    float a, b, c, p, s;
    while (1) { 
        printf("Nhap vao 3 canh: ");
        scanf("%f %f %f", &a, &b, &c);
        if (a + b > c && a + c > b && b + c > a) {
            p = (a + b + c) / 2;
            s = sqrt(p * (p - a) * (p - b) * (p - c));
            printf("Nua chu vi: %f\n", p);
            printf("Dien tich: %f\n", s);
            break; 
        } else {
            printf("Ba canh khong tao thanh tam giac, vui long nhap lai.\n");
        }
    }
    return 0;
}

