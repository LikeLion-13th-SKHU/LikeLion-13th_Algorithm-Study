#include <iostream>
#include <queue>
#include <map>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int cnt = 0;
    int size = 0;
    int n,d,k,c;
    cin >> n >> d >> k >> c;
    vector<int> v(n);
    for (int i = 0; i < n; i++) cin >> v[i];

    vector<int> cur(d+1,0);

    // window init
    for (int j = 0; j < k; j++)
        if (!cur[v[j]]++) ++size;

    for (int i = 0; i < n; i++) {
        // find max_cnt
        if (!cur[c]) cnt = max(cnt, size+1);
        else cnt = max(cnt, size);

        // move one step
        if (!--cur[v[i]]) size--;
        if (!cur[v[(i+k)%n]]++) ++size;
    }

    cout << cnt << '\n';

    return 0;
}
