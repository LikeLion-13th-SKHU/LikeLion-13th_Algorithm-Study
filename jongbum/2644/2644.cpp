#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, x, y, m, p, c;
    cin >> n >> x >> y >> m;
    vector<vector<int>> v(n+1);
    vector<bool> visited(n+1, false);

    while (m--) {
        cin >> p >> c;
        v[p].push_back(c);
        v[c].push_back(p);
    }

    queue<pair<int, int>> q;
    q.push({y, 0});
    visited[y] = 0;

    while (!q.empty()) {
        int num = q.front().first;
        int cnt = q.front().second;
        q.pop();

        if (num == x) {
            cout << cnt << '\n';
            return 0;
        }

        for (int i = 0; i < v[num].size(); i++) {
            if (!visited[v[num][i]]) {
                q.push({v[num][i], cnt+1});
                visited[num] = cnt+1;
            }
        }
    }

    cout << "-1\n";
    return 0;
}
