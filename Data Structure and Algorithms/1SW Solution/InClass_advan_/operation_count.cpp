
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

    return 2 + F((n + 1) / 2);
}

ll S(ll n) {
    if (n <= 1) {
        return 0;
    }

    ll m = n / 2;

    if (n % 2 == 0) {
        return 2 * S(m) + 3 * m - 2;
    }

    return 2 * S(m) + 3 * m + F(m + 1);
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T; cin >> T;
    for(int t= 1; t<= T; t++){
        ll A, B;
        cin >> A >> B;
        cout << S(B) - S(A - 1) << '\n';
    }
    

    return 0;
}
