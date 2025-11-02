#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n,k;
    cin >> n >> k;

    queue<int> q;
    int len = 1e6+1;

    for (int i = 0; i < n; i++) {
        int input;
        cin >> input;
        if (!--input) {
            q.push(i);
            if (q.size() == k) {
                len = min(len,q.back() - q.front() + 1);
                q.pop();
            }
        }
    }

    if (len == 1e6+1) cout << "-1\n";
    else cout << len << '\n';

    return 0;
}
