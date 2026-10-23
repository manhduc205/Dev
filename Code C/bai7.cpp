#include <stdio.h>
#define PI 3.14
int main(){
	int r;
	printf("Nhap vao ban kinh hinh cau: ");
	scanf("%d",&r);
	int s = 4 * PI * r*r;
	float v = 1.0*4/3 * PI * r*r*r;
	printf("Dien tich hinh cau la %d\n", s);
	printf("The tich hinh cau la %f\n",v);
}
