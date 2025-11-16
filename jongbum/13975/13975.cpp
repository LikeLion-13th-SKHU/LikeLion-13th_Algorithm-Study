#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int t, n, input;
    cin >> t;

    while (t--) {
        cin >> n;
        priority_queue<long long int, vector<long long int>, greater<>> pq;
        while (n--) {
            cin >> input;
            pq.push(input);
        }

        long long int sum = 0;

        while (pq.size() > 1) {
            long long int cur = 0;
            cur += pq.top();
            pq.pop();
            cur += pq.top();
            sum += cur;
            pq.push(cur);
            pq.pop();
        }

        cout << sum << '\n';
    }

    return 0;
}
