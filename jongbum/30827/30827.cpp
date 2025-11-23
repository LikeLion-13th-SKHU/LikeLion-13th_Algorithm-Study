#include <iostream>
#include <algorithm>
#include <queue>

using namespace std;

bool cmp(const pair<int, int> &a, const pair<int, int> &b) {
    if (a.second == b.second) return a.first < b.first;
    return a.second < b.second;
}

int main() {
    int n, k;
    cin >> n >> k;
    vector<pair<int, int>> v(n);
    for (int i = 0; i < n; i++) cin >> v[i].first >> v[i].second;
    sort(v.begin(), v.end(), cmp);

    int cnt = 0;
    vector<int> room(k,0);

    for (int i = 0; i < n; i++) {
        // k개 중 최적 방 찾기
        int tmp = 1e9+1;
        int tmp_idx = -1;
        for (int j = 0; j < k; j++) {
            if (v[i].first > room[j] && tmp > v[i].first - room[j]) {
                tmp = v[i].first - room[j];
                tmp_idx = j;
            }
        }
        if (tmp_idx != -1) {
            cnt++;
            room[tmp_idx] = v[i].second;
        }
    }

    cout << cnt << '\n';

    return 0;
}
