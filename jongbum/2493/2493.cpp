#include <iostream>
#include <stack>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    // (길이, 순번)
    stack<pair<int, int>> left;
    stack<pair<int, int>> right;

    for (int i = 1; i <= n; i++) {
        int input;
        cin >> input;
        left.push({input, i});
    }

    // left에 다 넣으면 비교해야하는 순서의 역순이 되기 때문에 다시 right에 넣음으로써 뒤집기
    while (!left.empty()) {
        right.push(left.top());
        left.pop();
    }

    /* 기초 세팅 끝 */

    /* 로직 시작 */

    while (!right.empty()) {
        if (left.empty()) {
            cout << 0 << ' ';
            left.push(right.top());
            right.pop();
        }
        else if (left.top().first >= right.top().first) {
            cout << left.top().second << ' ';
            left.push(right.top());
            right.pop();
        }
        else if (left.top().first < right.top().first) left.pop();
    }

    return 0;
}