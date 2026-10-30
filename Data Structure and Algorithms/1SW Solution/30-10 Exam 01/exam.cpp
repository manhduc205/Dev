#include <iostream>
#include <vector>
#include <queue>
#include <cstring>
using namespace std;

const int MAXN = 100005;

const int NONE = 0;
const int A_COUNTRY = 1;
const int B_COUNTRY = 2;
const int CONFLICT = 3;

int N, M, A, B;
vector<int> adj[MAXN];

int visited[MAXN];
int d[MAXN];

int conflictCount = 0;
int cntA = 0;

void bfs() {
    queue<int> q;

    visited[A] = A_COUNTRY;
    visited[B] = B_COUNTRY;

    d[A] = 0;
    d[B] = 0;

    q.push(A);
    q.push(B);

    while (!q.empty()) {
        int sz = q.size();

        for (int i = 0; i < sz; i++) {
            int u = q.front();
            q.pop();

            if (visited[u] == CONFLICT)
                continue;

            for (auto v : adj[u]) {

                if (visited[v] == NONE) { // nếu chưa được thăm
                    visited[v] = visited[u]; // đánh dấu visited là A và B
                    d[v] = d[u] + 1; // đánh dấu khoảng cách từ A hoặc B đến nút đang xét
                    q.push(v);
                }
                else if (visited[v] != CONFLICT && visited[v] != visited[u] && d[v] == d[u] + 1) {

                    visited[v] = CONFLICT;
                    conflictCount++;
                }
            }
        }
    }
}

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int T; cin >> T;
    for(int t = 1; t <= T; t++){
        cin >> N >> M;
        cin >> A >> B;

        for (int i = 1; i <= M; i++) {
            int u, v;
            cin >> u >> v;

            adj[u].push_back(v);
            adj[v].push_back(u);
        }

        bfs();

        for (int i = 1; i <= N; i++) {
            if (visited[i] == A_COUNTRY)
                cntA++;
        }

        int need = N / 2 + 1 - cntA;

        if (need < 0)
            need = 0;
        
        cout << "#" << t << " " << conflictCount << " " << need << "\n";
        for (int i = 1; i <= 100000; i++) {
            adj[i].clear();
            visited[i] = NONE;
            d[i] = 0;
        }

        conflictCount = 0;
        cntA = 0;
    }
    
    return 0;
}
/*
1
9 9
1 9
1 2
1 3
2 4
3 4
4 6
4 7
5 7
7 9
8 9

output: 1 2
*/