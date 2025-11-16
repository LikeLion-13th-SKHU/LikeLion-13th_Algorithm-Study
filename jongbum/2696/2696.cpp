#include <algorithm>
#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int T;
    cin >> T;

    while (T--) {
        int n, input;
        cin >> n;
        int cnt = 0;

        priority_queue<int> pqL;
        priority_queue<int, vector<int>, greater<>> pqG;


        cout << n/2+1 << '\n';
        for (int i = 1; i <= n; i++) {
            cin >> input;
            if (pqL.empty() || input < pqL.top()) pqL.push(input);
            else pqG.push(input);

            if (pqL.size() > pqG.size()+1) {
                pqG.push(pqL.top());
                pqL.pop();
            }
            else if (pqL.size() < pqG.size()) {
                pqL.push(pqG.top());
                pqG.pop();
            }

            if (i&1) {
                cout << pqL.top() << ' ';
                if (!(++cnt % 10)) cout << '\n';
            }
        }
        if (cnt % 10) cout << '\n';
    }

    return 0;
}
