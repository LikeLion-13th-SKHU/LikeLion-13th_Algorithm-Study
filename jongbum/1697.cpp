#include <iostream>
#include <queue>
#include <map>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    queue<pair<int,int>> q;
    map<int, int> m;

    int n, k;
    cin >> n >> k;
    if (n >= k) {
        cout << n-k << '\n';
        return 0;
    }

    q.push({n,0});
    m[n] = 0;

    while (!q.empty()) {
        int cur = q.front().first;
        int cnt = q.front().second;
        q.pop();

        // 현재 내 좌표가 가야할 좌표보다 클 때
        if (cur >= k) {
            if (!m.count(k)) m[k] = cnt+cur-k;
            else m[k] = min(m[k], cnt+cur-k);
            continue;
        }

        // 2 곱하기
        if (!m.count(cur*2) || m[cur*2] > cnt+1) {
            q.push({cur*2, cnt+1});
            m[cur*2] = cnt+1;
        }

        // 1 더하기
        if (!m.count(cur+1) || m[cur+1] > cnt+1) {
            q.push({cur+1, cnt+1});
            m[cur+1] = cnt+1;
        }

        // 1 빼기
        if (cur > 0 && !m.count(cur-1) || m[cur-1] > cnt+1) {
            q.push({cur-1, cnt+1});
            m[cur-1] = cnt+1;
        }
    }

    cout << m[k] << '\n';

    return 0;
}
