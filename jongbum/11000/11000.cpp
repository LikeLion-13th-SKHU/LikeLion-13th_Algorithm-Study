#include <algorithm>
#include <iostream>
#include <queue>

using namespace std;

struct cmp {
    bool operator()(pair<int, int> &a, pair<int, int> &b) {
        return a.second > b.second;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n;
    cin >> n;
    vector<pair<int, int>> v(n);
    while (n--) cin >> v[n].first >> v[n].second;
    sort(v.begin(), v.end());
    
    priority_queue<pair<int, int>, vector<pair<int, int>>, cmp> pq;

    for (int i = 0; i < v.size(); i++) {
        if (!pq.empty() && pq.top().second <= v[i].first) pq.pop();
        pq.push(v[i]);
    }

    cout << pq.size() << '\n';

    return 0;
}
