#include <iostream>
#include <queue>
#include <algorithm>

using namespace std;

int main() {
    int n, k;
    cin >> n >> k;
    vector<int> v(n);
    for (int i = 0; i < n; i++) cin >> v[i];
    sort(v.begin(), v.end());

    int cnt = 0;
    int start = 0;
    int end = n-1;

    while (start < end) {
        if (v[start] + v[end] > k) end--;
        else {
            start++;
            end--;
            cnt++;
        }
    }

    cout << cnt << '\n';

    return 0;
}
