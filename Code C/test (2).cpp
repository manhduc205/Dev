#include <stdio.h>
#include <string.h>

void nenxau(char xau[]){
	int dodai = strlen(xau);
	for(int i=0; i <dodai ; i++){
		char nstr = xau[i];
		int count = 1;
		while(i+1 < dodai && xau[i]==xau[i+1]){
			count++;
			i++;
		}
		printf("%d%c",count,nstr);
	}
	
}

int main() {
    char xau[100000];
    printf("Nhap vao xau:");
    scanf("%s",&xau);
    nenxau(xau);
    return 0;
}

