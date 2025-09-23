#include <iostream>
#include <stack>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    stack<int> result;
    result.push(-1);

    stack<int> fore;
    stack<int> back;

    int n;
    cin >> n;
    for (int i = 1; i <= n; i++) {
        int input;
        cin >> input;

        if (i == n) {
            back.push(input);
            break;
        }

        fore.push(input);
    }

    while (!fore.empty()) {
        if (back.empty()) {
            result.push(-1);
            back.push(fore.top());
            fore.pop();
        }
        else {
            if (fore.top() < back.top()) {
                result.push(back.top());
                back.push(fore.top());
                fore.pop();
            }
            else back.pop();
        }
    }

    while (!result.empty()) {
        cout << result.top() << ' ';
        result.pop();
    }

    return 0;
}