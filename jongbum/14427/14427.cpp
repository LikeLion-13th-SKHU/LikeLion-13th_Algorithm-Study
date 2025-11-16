#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, Q, idx, v;
    cin >> n;
    vector<int> vec(n+1, 0);

    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
    for (int i = 1; i <= n; i++) {
        cin >> vec[i];
        pq.push({vec[i], i});
    }

    cin >> m;
    while (m--) {
        cin >> Q;
        if (--Q) {
            while (pq.top().first != vec[pq.top().second]) pq.pop();
            cout << pq.top().second << '\n';
        }
        else {
            cin >> idx >> v;
            vec[idx] = v;
            pq.push({v, idx});
        }
    }

    return 0;
}
