#include <stdio.h>
#include <string.h>

void nenxau(char str[]){
    int len = strlen(str);
    char nstr;
    for( int i =0 ; i <len; i++){
        int count =1;
        nstr = str[i];
        while(i+1<len && str[i]==str[i+1]){
            count++;
            i++;
        }
        printf("%d%c",count,nstr);
    }
}
int main ()
{
    char str[100];
    printf ("nhap ki tu: ");
    scanf ("%s", &str);
    printf ("so lan xuat hien ki tu tren la: ");
    nenxau(str);
    return 0;
}
