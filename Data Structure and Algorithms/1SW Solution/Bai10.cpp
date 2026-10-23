#include <iostream>
#include <vector>
using namespace std;

int DoSau(int x, vector<int>& cha) {
    int dem = 0;
    while (x != 1) {
        x = cha[x];
        dem++;
    }

    return dem;
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T;
    cin >> T;
    for (int t =1; t <=T; t++) {
        int N, Q;
        cin >> N >> Q;

        vector<int> cha(N + 1, 0);
        for (int i = 0; i < N - 1; i++) {
            int u, v;
            cin >> u >> v;
            cha[v] = u;
        }
        cout << "#" << t << ":";
        for (int i = 0; i < Q; i++) {
            int x;
            cin >> x;
            cout << " " << DoSau(x, cha);
        }
        cout << '\n';
    }

    return 0;
}
