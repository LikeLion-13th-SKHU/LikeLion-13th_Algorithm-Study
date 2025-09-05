#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

bool cmp(const pair<int, string> &a, const pair<int, string> &b) {
    if (a.first == b.first) {
        return a.second < b.second;
    }
    return a.first > b.first;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int N;
    cin >> N;

    vector<pair<int, string>> v;
    while (N--) {
        string str;
        cin >> str;

        // find_if로 찾기
        auto it = find_if(v.begin(), v.end(),
            [&str](const pair<int, string> &p) {
                return p.second == str;
            });

        // 없으면 {1, str} push_back
        if (it == v.end()) {
            v.push_back({1, str});
        }
        // 있으면 first++
        else {
            it->first++;
        }
    }

    sort(v.begin(), v.end(), cmp);

    cout << v[0].second << '\n';
  
    return 0;
}