#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

int main() {
    int n, a, b;
    cin >> n;
    vector<pair<int, int>> v(n);
    for (int i = 0; i < n; i++) {
        cin >> a >> b;
        v[i] = {a, b};
    }

    sort(v.begin(), v.end());

    priority_queue<int, vector<int>, greater<>> pq;

    int sum = 0;

    for (int i = 0; i < n; i++) {
        pq.push(v[i].second);
        sum += v[i].second;

        if (pq.size() > v[i].first) {
            sum -= pq.top();
            pq.pop();
        }
    }

    cout << sum << '\n';

    return 0;
}
