#include <stdio.h>
#include <string.h>
#include <ctype.h>
// cho biet do dai cua xau
void length(char xau[]){	
	int dodai = strlen(xau);
	printf("Do dai cua xau: %d\n",dodai);
}
//doi xau thanh chu hoa
void upper(char xau[]){
	char inhoa[1000];
	for(int i =0; i< strlen(xau); i++){
		inhoa[i] = toupper(xau[i]);
	}
	printf("Xau in hoa: %s\n",inhoa);
}
void xuly(char xau[], char c){
	printf("Nhap vao 1 ki tu: ");
	c = getchar();
	int count = 0;
	for(int i =0; i < strlen(xau);i++){
		if(xau[i]==c){
			count++;
		}
	}
	printf("Co %d ki tu trung voi xau vua nhap\n",count);
}
void daonguoc(char xau[]){
	char v[1000];
	int dem = 0;
	for(int i = strlen(xau)-1; i >=0 ; i--){
		v[dem] = xau[i];
		dem++;
	}
	printf("Xau theo thu tu nguoc lai: %s",v);
}
int main(){
	char xau[1000];
	char c;
	printf("Nhap vao mot xau: ");
	fflush(stdin);
	gets(xau);
	length(xau);
	upper(xau);
	xuly(xau,c);
	daonguoc(xau);
}
