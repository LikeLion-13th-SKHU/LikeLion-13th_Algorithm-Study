#include <iostream>
#include <queue>
#include <stack>

using namespace std;

// {startVertex에서 가장 멀리 있는 정점, startVertex와 그 정점의 거리} 를 반환하는 함수
vector<int> dfs(int startVertex, vector<vector<pair<int,int>>> &vec) {
    vector<bool> visited(vec.size(), false);
    stack<pair<int, int>> s;

    visited[startVertex] = true;
    s.push({startVertex, 0});

    // {루트 노드에서 가장 멀리 있는 정점, 루트 노드와 그 정점의 길이}
    vector<int> res = {0,0};

    while (!s.empty()) {
        int cur = s.top().first;
        int len = s.top().second;
        if (len > res[1]) {
            res[1] = len;
            res[0] = cur;
        }

        bool flag = false;

        for (int i = 0; i < vec[cur].size(); i++) {
            if (!visited[vec[cur][i].first]) {
                flag = true;
                visited[vec[cur][i].first] = true;
                s.push({vec[cur][i].first, len + vec[cur][i].second});
            }
        }

        if (!flag) s.pop();
    }

    return res;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int n, u, v, w;
    cin >> n;
    vector<vector<pair<int,int>>> vec(n+1);

    while (--n) {
        cin >> u >> v >> w;
        vec[u].push_back({v,w});
        vec[v].push_back({u,w});
    }

    cout << dfs(dfs(1, vec)[0],vec)[1] << '\n';

    return 0;
}