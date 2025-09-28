#include <iostream>
#include <map>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, q;
    cin >> n >> q;

    map<int, bool> m;

    for (int i = 1; i <= n; i++) {
        bool input;
        cin >> input;
        if (input) m[i] = true;
    }

    int cur = 1;

    while (q--) {
        int cmd;
        cin >> cmd;

        switch (cmd) {
            case 1: {
                int i;
                cin >> i;
                if (m.count(i)) m.erase(i);
                else m[i] = true;
                break;
            }
            case 2: {
                int x;
                cin >> x;
                cur = (cur + x) % n;
                if (!cur) cur = n;
                break;
            }
            case 3: {
                if (m.empty()) {
                    cout << -1 << '\n';
                    break;
                }

                if (m.lower_bound(cur) == m.end()) cout << m.begin()->first - cur + n << '\n';
                else cout << m.lower_bound(cur)->first - cur << '\n';
                break;
            }
        }
    }
    return 0;
}