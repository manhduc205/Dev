#include <iostream>
#include <vector>
using namespace std;

// Hàm đếm số cặp có tổng bằng K
int countPairs(const vector<int>& arr, int n, int k) {
    int count = 0;
    for (int i = 0; i < n; i++) {
        for (int j = i + 1; j < n; j++) { // Xét cặp (i, j) với i < j
            if (arr[i] + arr[j] == k) {
                count++;
            }
        }
    }
    return count;
}

int main() {
    int t; // Số lượng bộ test
    cin >> t;
    while (t--) {
        int n, k;
        cin >> n >> k; // Đọc N và K
        vector<int> arr(n);
        for (int i = 0; i < n; i++) {
            cin >> arr[i]; // Đọc mảng A
        }
        cout << countPairs(arr, n, k) << endl; // Gọi hàm và in kết quả
    }
    return 0;
}
