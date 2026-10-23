#include <iostream>
using namespace std;

int n;
int a[100];

void backtrack(int i) {
    // Đã chọn đủ n vị trí
    if (i == n) {
        for (int j = 0; j < n; j++) {
            cout << a[j];
        }
        cout << '\n';
        return;
    }

    // Thử các lựa chọn tại vị trí i
    for (int x = 0; x <= 1; x++) {
        a[i] = x;
        backtrack(i + 1);
    }
}

int main() {
    cin >> n;
    backtrack(0);
    return 0;
}
