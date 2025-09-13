#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

// 배열을 45도 돌리기
vector<vector<int>> turn45(vector<vector<int>> &v) {
    for (int i = 1; i <= v.size()/2; i++) {
        int start = v.size()/2-i;
        // 위쪽
        swap(v[start][start], v[start][start+i]);
        swap(v[start][start], v[start][start+i*2]);
        // 오른쪽
        swap(v[start][start], v[start+i][start+i*2]);
        swap(v[start][start], v[start+i*2][start+i*2]);
        // 아래쪽
        swap(v[start][start], v[start+i*2][start+i]);
        swap(v[start][start], v[start+i*2][start]);
        // 왼쪽
        swap(v[start][start], v[start+i][start]);
    }

    return v;
}

// 배열을 -45도 돌리기
vector<vector<int>> turnm45(vector<vector<int>> &v) {
    for (int i = 1; i <= v.size()/2; i++) {
        int start = v.size()/2-i;
        // 왼쪽
        swap(v[start][start], v[start+i][start]);
        swap(v[start][start], v[start+i*2][start]);
        // 아래쪽
        swap(v[start][start], v[start+i*2][start+i]);
        swap(v[start][start], v[start+i*2][start+i*2]);
        // 오른쪽
        swap(v[start][start], v[start+i][start+i*2]);
        swap(v[start][start], v[start][start+i*2]);
        // 위쪽
        swap(v[start][start], v[start][start+i]);
    }

    return v;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        int n, d;
        cin >> n >> d;

        vector<vector<int>> v(n, vector<int>(n,0));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cin >> v[i][j];
            }
        }

        d /= 45;
        d %= 8;
        if (d > 0) {
            // d > 0
            while (d--) v = turn45(v);
        }
        else {
            // d < 0
            while (d++) v = turnm45(v);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                cout << v[i][j] << ' ';
            }
            cout << '\n';
        }
    }

    return 0;
}
