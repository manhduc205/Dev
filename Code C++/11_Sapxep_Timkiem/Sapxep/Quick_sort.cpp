#include <iostream>
#include <algorithm>

using namespace std;

int partition(int a[], int l, int r){ // phân hoạch lomuto
    int pilot = a[r];
    int i = l - 1;
    for(int j = l; j < r; j++){
        if(a[j] <= pilot){
            ++i;
            swap(a[i], a[j]);   
        }
    }
    
    // Đưa con trỏ về giữa
    ++i;
    swap(a[i], a[r]);
    return i;
}

int partition2(int a[], int l, int r){ // phân hoạch hoare
    int pivot = a[l];
    int i = l - 1, j = r + 1;
    while(1){
        do{
            ++i;
        }while (a[i] < pivot);
        do{
            --j;
        }while(a[j] > pivot);
        if( i < j ){
            swap(a[i], a[j]);
        }        
        else return j;
    }
}
void quickSort(int a[], int l, int r){
    if(l >= r) return;
    int p = partition(a, l, r);
    quickSort(a, l, p - 1);
    quickSort(a, p + 1, r);
}
int main(){
    int n; cin >> n;
    int a[50];
    for(int i = 0; i < n; i++){
        cin >> a[i];
    }
    quickSort(a, 0, n - 1);
    for(int i = 0; i < n; i++){
        cout << a[i] << " ";
    }
    return 0;
}
