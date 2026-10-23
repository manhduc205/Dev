#include <stdio.h>
#include <cstring>
int main(){
	char s[100];
	gets(s);
	int count = 0;
	for(int i = 0; i < strlen(s); i ++){
		if(s[i] == ' '){
			count++;
		}
	}
	printf("%d", count);
}


