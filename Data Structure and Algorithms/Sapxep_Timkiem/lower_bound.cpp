#include <iostream>
using namespace std;
/*
Tương tự như hàm sort, lower_bound cũng trả
về iterator chứ không trả về giá trị.
|Nó trả về vị trí đầu tiên của phần tử lớn hơn
hoặc bằng X,| nếu trong mảng, vector bạn tìm
kiếm không có phần tử lớn hơn hoặc bằng X
(tất cả đều nhỏ hơn X) thì lower_bound trả về
last_iter*/
int main(){
int a[7] = {1, 2, 3, 3, 3, 4, 6};
auto it = lower_bound(a, a + 7, 3);
cout << *it << endl;
cout << (it - a) << endl; 
}
/*Phép trừ it - a trả về số nguyên, 
biểu thị số lượng phần tử từ a đến it (chỉ số của phần tử được trỏ tới bởi it).*/