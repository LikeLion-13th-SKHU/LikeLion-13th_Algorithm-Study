#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string str;
    cin >> str;

    vector<int> atoz(26, 0);
    for (char ch : str) atoz[ch - 'A']++;

    bool isOdd = false;
    char odd = '\0';
    for (int i = 0; i < 26; i++) {
        // 이미 홀수 개수가 있는데 또 홀수 개수가 나오면 종료
        if (isOdd && atoz[i] % 2 == 1) {
            cout << "I'm Sorry Hansoo\n";
            return 0;
        }

        if (atoz[i] % 2 == 1) {
            isOdd = true;
            odd = i + 'A';
        }
    }

    string result = "";

    for (int i = 0; i < 26; i++) {
        for (int j = atoz[i]; j > 1; j-=2) result += i + 'A';
    }

    cout << result;

    if (odd != '\0') cout << odd;

    reverse(result.begin(), result.end());

    cout << result << '\n';

    return 0;
}