
#include <iostream>
using namespace std;

int main() {
    int N, test = 0;

    while (cin >> N && N != 0) {
        int balance[1000] = {0};
        int total = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                int x;
                cin >> x;

                total += x;
                balance[i] += x;
                balance[j] -= x;
            }
        }

        int answer = 0;

        for (int i = 0; i < N; i++) {
            if (balance[i] > 0) {
                answer += balance[i];
            }
        }

        test++;
        cout << test << ". " << total << " " << answer << "\n";
    }

    return 0;
}
