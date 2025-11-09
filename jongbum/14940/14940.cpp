#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, m, y, x;
    cin >> n >> m;
    vector<vector<int>> v(n, vector<int>(m));
    vector<vector<bool>> visted(n, vector<bool>(m, false));
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> v[i][j];
            if (v[i][j] == 2) {
                x = j;
                y = i;
            }
        }
    }

    queue<pair<int,int>> q;
    q.push({y,x});
    v[y][x] = 0;
    while (!q.empty()) {

        int f = q.front().first;
        int s = q.front().second;
        q.pop();

        // 상
        if(f > 0 && v[f-1][s] && !visted[f-1][s]) {
            v[f-1][s] += v[f][s];
            q.push({f-1,s});
            visted[f-1][s] = true;
        }

        // 하
        if(f < n-1 && v[f+1][s] && !visted[f+1][s]) {
            v[f+1][s] += v[f][s];
            q.push({f+1,s});
            visted[f+1][s] = true;
        }

        // 좌
        if(s > 0 && v[f][s-1] && !visted[f][s-1]) {
            v[f][s-1] += v[f][s];
            q.push({f,s-1});
            visted[f][s-1] = true;
        }

        // 우
        if(s != m-1 && v[f][s+1] && !visted[f][s+1]) {
            v[f][s+1] += v[f][s];
            q.push({f,s+1});
            visted[f][s+1] = true;
        }
    }

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if (!visted[i][j] && v[i][j]) cout << "-1 ";
            else cout <<  v[i][j] << ' ';
        }
        cout << '\n';
    }

    return 0;
}
