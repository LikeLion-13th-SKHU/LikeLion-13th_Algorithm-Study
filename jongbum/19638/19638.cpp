#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    priority_queue<int> pq;
    int n, h, t;
    cin >> n >> h >> t;
    for (int i = 0; i < n; i++) {
        int input;
        cin >> input;
        pq.push(input);
    }

    int i = t;
    while (i) {
        if (pq.top() < h) break;
        pq.push(max(1,pq.top()/2));
        pq.pop();
        i--;
    }

    if (pq.top() >= h) cout << "NO\n" << pq.top() << '\n';
    else cout << "YES\n" << t-i << '\n';

    return 0;
}
