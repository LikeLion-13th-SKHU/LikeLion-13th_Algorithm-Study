#include <iostream>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int k, T; cin >> T;
    string str;

    while (T--) {
        cin >> str >> k;
        if (k == 1) {
            cout << "1 1\n";
            continue;
        }

        vector<pair<int, queue<int>>> atoz(26);
        int small = 1e4+1;
        int big = -1;

        for (int i = 0; i < str.size(); i++) {
            if (++atoz[str[i] - 'a'].first == k) {
                small = min(small, i - atoz[str[i] - 'a'].second.front() + 1);
                big = max(big, i - atoz[str[i] - 'a'].second.front() + 1);
                --atoz[str[i] - 'a'].first;
                atoz[str[i] - 'a'].second.pop();
            }
            atoz[str[i] - 'a'].second.push(i);
        }

        if (big == -1) cout << "-1\n";
        else cout << small << ' ' << big << '\n';
    }

    return 0;
}
