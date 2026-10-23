#include <iostream>
#include <vector>
using namespace std;

int demNutLa(int N, vector<int>& demCon) {
    int dem = 0;
    for (int i =1; i <=N; i++) {
        if (demCon[i] == 0) {
            dem++;
        }
    }
    return dem;

}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T;
    cin >> T;

    for (int t =1; t <=T; t++) {
        int N;
        cin >> N;

        vector<int> demCon(N + 1, 0);
        for (int i = 0; i < N - 1; i++) {
            int u, v;
            cin >> u >> v;
            demCon[u]++;
        }

        cout << "#" << t << ": ";
        cout << demNutLa(N, demCon) << '\n';
    }

    return 0;
}
