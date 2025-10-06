#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, x;
    cin >> n >> x;

    vector<int> v(n+1,0);

    int M = -1;
    int cnt = 0;

    for (int i = 1; i <= n; i++) {
        int input;
        cin >> input;
        v[i] += input + v[i-1];

        if (i < x) continue;

        if (M == v[i] - v[i-x]) cnt++;
        else if (M < v[i] - v[i-x]) {
            M = v[i] - v[i-x];
            cnt = 1;
        }
    }

    if (!M) cout << "SAD\n";
    else cout << M << '\n' << cnt << '\n';

    return 0;
}
