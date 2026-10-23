#include <iostream>
#include <stack>
using namespace std;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(0);

    int n;

    while (cin >> n && n != 0) {
        stack<int> side;
        int need = 1;

        for (int i = 0; i < n; i++) {
            int x;
            cin >> x;

            while (!side.empty() && side.top() == need) {
                side.pop();
                need++;
            }

            if (x == need) {
                need++;
            } else {
                side.push(x);
            }
        }

        while (!side.empty() && side.top() == need) {
            side.pop();
            need++;
        }

        if (need == n + 1) {
            cout << "yes\n";
        } else {
            cout << "no\n";
        }
    }

    return 0;
}
