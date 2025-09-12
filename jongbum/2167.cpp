#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;

    cin >> n >> m;

    vector<vector<int>> sum(n+1, vector<int>(m+1, 0));

    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= m; j++) {
            int input;
            cin >> input;
            sum[i][j] += input + sum[i][j-1];
        }
    }
    
    int T;
    cin >> T;
    while (T--) {
        int i, j, x, y;
        cin >> i >> j >> x >> y;

        int result = 0;

        for (int idx = i; idx <= x; idx++) {
            result += sum[idx][y] - sum[idx][j-1];
        }

        cout << result << '\n';
    }
    return 0;
}