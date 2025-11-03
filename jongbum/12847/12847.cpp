#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<int> v(n);
    long long int sum = 0;

    for (int i = 0; i < n; i++) {
        cin >> v[i];
        if (i < m) sum += v[i];
    }

    long long int result = sum;

    for (int i = m; i < n; i++) {
        sum += v[i];
        sum -= v[i-m];
        result = max(result, sum);
    }

    cout << result << '\n';

    return 0;
}
