#include <iostream>
using namespace std;
typedef struct tagNode
{
    int info;
    struct tagNode * Next;
} NODE;
void insertAfter()