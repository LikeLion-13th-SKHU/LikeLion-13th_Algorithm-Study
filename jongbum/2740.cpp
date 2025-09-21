#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    vector<vector<int>> a(n, vector<int>(m,0));

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            int input;
            cin >> input;
            a[i][j] = input;
        }
    }

    int k;
    cin >> m >> k;

    vector<vector<int>> b(m, vector<int>(k,0));

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < k; j++) {
            int input;
            cin >> input;
            b[i][j] = input;
        }
    }

    vector<vector<int>> result(n, vector<int>(k,0));

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < k; j++) {
            for (int l = 0; l < m; l++) {
                result[i][j] += a[i][l] * b[l][j];
            }
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < k; j++) {
            cout << result[i][j] << ' ';
        }
        cout << '\n';
    }

    return 0;
}