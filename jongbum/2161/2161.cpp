#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    queue<int> q;

    for (int i = 1; i <= n; i++) q.push(i);

    while (!q.empty()) {
        cout << q.front() << ' ';
        q.pop();

        if (q.empty()) break;

        q.push(q.front());
        q.pop();
    }
    return 0;
}