#include <iostream>
#include <vector>

using namespace std;

vector<vector<int>> turnLeft(vector<vector<int>> &v) {
    int row = v.size();
    int column = v[0].size();
    int start = 0;
    while (min(row, column)) {
        // 왼쪽
        for (int i = 1; i <= row - 1; i++) {
            swap(v[start][start], v[start+i][start]);
        }
        // 아래쪽
        for (int i = 1; i <= column - 1; i++) {
            swap(v[start][start], v[start+row-1][start+i]);
        }
        // 오른쪽
        for (int i = row-2; i >= 0; i--) {
            swap(v[start][start], v[start+i][start+column-1]);
        }
        // 위쪽
        for (int i = column-2; i >= 1; i--) {
            swap(v[start][start], v[start][start+i]);
        }

        row -= 2;
        column -= 2;
        start++;
    }

    return v;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m, r;
    cin >> n >> m >> r;

    // n행 m열 만큼의 벡터 선언
    vector<vector<int>> v(n, vector<int>(m, 0));

    // 벡터 입력
    for (int i = 0; i < n; i++) {
        for (int j = 0 ; j < m; j++) cin >> v[i][j];
    }

    // r번 돌리기
    for (int i = 0; i < r; i++) v = turnLeft(v);

    // 벡터 출력
    for (int i = 0; i < n; i++) {
        for (int j = 0 ; j < m; j++) cout << v[i][j] << ' ';
        cout << '\n';
    }

    return 0;
}