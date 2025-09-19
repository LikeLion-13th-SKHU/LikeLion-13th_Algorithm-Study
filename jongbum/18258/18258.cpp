#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;

    queue<int> q;

    while (T--) {
        string cmd;
        cin >> cmd;

        if (cmd == "push") {
            int input;
            cin >> input;
            q.push(input);
        }
        else if (cmd == "pop") {
            if (q.empty()) {
                cout << -1 << '\n';
                continue;
            }
            cout << q.front() << '\n';
            q.pop();
        }
        else if (cmd == "size") {
            cout << q.size() << '\n';
        }
        else if (cmd == "empty") {
            if (q.empty()) {
                cout << 1 << '\n';
                continue;
            }
            cout << 0 << '\n';
        }
        else if (cmd == "front") {
            if (q.empty()) {
                cout << -1 << '\n';
                continue;
            }
            cout << q.front() << '\n';
        }
        else if (cmd == "back") {
            if (q.empty()) {
                cout << -1 << '\n';
                continue;
            }
            cout << q.back() << '\n';
        }
    }

    return 0;
}
