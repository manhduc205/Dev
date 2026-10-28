
#include <iostream>
using namespace std;

using ll = long long;

ll F(ll n) {
    if (n == 1) {
        return 0;
    }

    if (n % 2 == 0) {
        return 1 + F(n / 2);
    }

    return 1 + F(n + 1);
}

ll S(ll n) {
    if (n <= 1) {
        return 0;
    }

    if (n % 2 == 1) {
        return S(n - 1) + F(n);
    }

    return 2 * S(n / 2) + 3 * (n / 2) - 2;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);

    int T;
    cin >> T;

    while (T--) {
        ll A, B;
        cin >> A >> B;

        cout << S(B) - S(A - 1) << '\n';
    }

    return 0;
}


/*

3
188 369
1077 8083
1 1000000000000000
*/
