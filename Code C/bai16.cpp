#include <stdio.h>
#include <math.h>
#include <string.h>
#include <ctype.h>

int main ()
{
    char ch;
    printf ("nhap vao ch mot ki tu ");
    scanf (" %c", &ch);
    if (isalpha(ch)) {printf ("day la chu cai");}
    else if (isdigit(ch)) {printf ("day la chu so");}
    else {printf ("ki tu khac");}
    return 0;

}
