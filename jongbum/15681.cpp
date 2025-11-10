#include <iostream>
#include <queue>
#include <stack>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, r, q, u, v;
    cin >> n >> r >> q;
    vector<vector<int>> vec(n+1);
    vector<bool> visited(n+1, false);
    vector<int> dp(n+1, 1);

    while (--n) {
        cin >> u >> v;
        vec[u].push_back(v);
        vec[v].push_back(u);
    }

    stack<int> s;
    stack<int> parent;
    s.push(r);
    visited[r] = true;

    while (!s.empty()) {
        int cur = s.top();
        bool flag = false;

        for (int i = 0; i < vec[cur].size(); i++) {
            if (!visited[vec[cur][i]]) {
                flag = true;
                visited[vec[cur][i]] = true;
                s.push(vec[cur][i]);
            }
        }

        if (!flag) {
            s.pop();
            if (parent.top() == cur) parent.pop();
            if (!parent.empty()) dp[parent.top()] += dp[cur];
        }
        else parent.push(cur);
    }

    while (q--) {
        cin >> n;
        cout << dp[n] << '\n';
    }

    return 0;
}
