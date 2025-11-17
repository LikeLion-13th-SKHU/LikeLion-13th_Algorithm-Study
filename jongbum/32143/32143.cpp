#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    priority_queue<int, vector<int>, greater<>> pqG;
    priority_queue<int> pqL;

    long long int h;
    int n, q, input;
    cin >> h >> n >> q;
    while (n--) {
        cin >> input;
        pqL.push(input);
    }

    int cnt = 1;
    while (!pqL.empty()) {
        h -= pqL.top();
        if (h > 0) cnt++;
        pqG.push(pqL.top());
        pqL.pop();
    }

    if (h <= 0) cout << cnt << '\n';
    else cout << "-1\n";

    while (q--) {
        cin >> input;
        h -= input;
        if (h > 0) cnt++;
        pqG.push(input);

        while (true) {
            if (pqG.top() + h > 0) break;
            h += pqG.top();
            pqG.pop();
        }

        if (h <= 0) cout << min(cnt, (int) pqG.size()) << '\n';
        else cout << "-1\n";
    }

    return 0;
}
