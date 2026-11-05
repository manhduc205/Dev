#include <iostream>
#include <queue>
using namespace std;

int a[6001][51];
int M[6001];

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T;
    cin >> T;

    for (int t = 1; t <= T; t++) {
        int N; cin >> N;

        for (int i = 1; i <=N; i++) {

            cin >> M[i];

            for (int j = 1; j <=M[i]; j++) {
                cin >> a[i][j];
            }
        }


        priority_queue<int> q;
        long long sum = 0;

        for (int i = N; i >=1; i--) {
            for (int j = 1; j <=M[i]; j++) {

                q.push(a[i][j]);
            }

            sum += q.top();
            q.pop();
        }

        cout << "#" << t << " " << sum << "\n";
    }

    return 0;
}
