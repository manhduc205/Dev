#include <stdio.h>
#include <math.h>

int main() {
    float a, b, c, dental, nghiem1, nghiem2;

    printf("Nhap a (khac 0): ");
    scanf("%f", &a);
    while (a == 0) {
        printf("He so a phai khac 0. Vui long nhap lai.\n");
        printf("Nhap a (khac 0): ");
        scanf("%f", &a);
    }

    printf("Nhap b: ");
    scanf("%f", &b);
    printf("Nhap c: ");
    scanf("%f", &c);

    dental = pow(b, 2) - 4 * a * c;
    if(dental > 0) {
        nghiem1 = (-b + sqrt(dental)) / (2 * a);
        nghiem2 = (-b - sqrt(dental)) / (2 * a);
        printf("Phuong trinh co hai nghiem phan biet: %.2f va %.2f\n", nghiem1, nghiem2);
    } else if(dental == 0) {
        nghiem1 = -b / (2 * a);
        printf("Phuong trinh co mot nghiem kep: %.2f\n", nghiem1);
    } else {
        printf("Phuong trinh vo nghiem!\n");
    }

    return 0;
}

