#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, k;
    cin >> n >> k;
    if (k == n) k--;

    vector<int> v(n);       // 입력받은 글자의 길이를 저장하는 벡터
    vector<int> num(21, 0); // 글자 수가 현재 몇 개 있는 지 저장하는 벡터
    for (int i = 0; i < n; i++) {
        string name;
        cin >> name;
        v[i] = name.size();
    }
    queue<int> q;

    long long int cnt = 0;

    int cur = k;

    for (int i = 0; i < n; i++) {
        int std = v[i];
        if (!i) {
            for (int j = 1; j <= k; j++) num[v[j]]++;
            cnt += num[std];
            num[v[1]]--;
            if (cur < n-1) num[v[++cur]]++;
            continue;
        }

        if (cur == n-1) {
            cnt += num[std];
            if (i < n-1) num[v[i+1]]--;
            // 커서는 변동 x
        }
        else {
            cnt += num[std];
            if (i < n-1) num[v[i+1]]--;
            num[v[++cur]]++;
        }
    }

    cout << cnt << '\n';

    return 0;
}