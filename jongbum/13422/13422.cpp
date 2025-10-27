#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;
    while (T--) {
        int n, m, k;
        cin >> n >> m >> k;

        vector<int> v(n);
        for (int i = 0; i < n; i++) cin >> v[i];
        long long int sum = 0;
        int cnt = 0;
        if (n == m) {
            for (int i = 0; i < n; i++) sum += v[i];
            if (sum < k) cnt++;
        }
        else {
            for (int i = 0; i < n+m; i++) {
                sum += v[i%n];
                if (i < m) continue;
                sum -= v[(i-m)%n];
                if (sum < k) cnt++;
            }
        }
        cout << cnt << '\n';
    }

    return 0;
}
