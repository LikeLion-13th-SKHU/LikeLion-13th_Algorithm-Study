#include <iostream>
#include <map>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    map<string, int> cnt;

    int maxCnt = 0;
    string maxStr = "";

    int N;
    cin >> N;

    while (N--) {
        string str;
        cin >> str;

        cnt[str]++;

        if (cnt[str] > maxCnt) {
            maxCnt = cnt[str];
            maxStr = str;
        }
        else if (cnt[str] == maxCnt) maxStr = (str < maxStr) ? str : maxStr;
    }

    cout << maxStr << '\n';

    return 0;
}