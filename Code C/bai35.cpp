#include <stdio.h>
#include <string.h>
struct PHANSO{
	int tuso;
	int mauso;
};
int main(){
	PHANSO phanso[2];
	for(int i =0; i < 2; i++){
		printf("Nhap vao tu so:");
		scanf("%d",&phanso[i].tuso);
		printf("Nhap vao mau so:");
		scanf("%d",&phanso[i].mauso);
	}	
	float phanso1 ,phanso2;
	phanso1 = (float)phanso[0].tuso/phanso[0].mauso;
	phanso2 = (float)phanso[1].tuso/phanso[1].mauso;
	printf("Tong 2 phan so: %.2f\n",phanso1+phanso2);
	printf("Hieu 2 phan so: %.2f\n",phanso1-phanso2);
	printf("Tich 2 phan so: %.2f\n",phanso1*phanso2);
	printf("Thuong 2 phan so: %.2f\n",phanso1/phanso2);
}
