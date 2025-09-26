#include <iostream>
#include <map>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    map<int, int> map;

    int n;
    cin >> n;

    while (n--) {
        int m;
        cin >> m;
        if (--m) {
            int w;
            cin >> w;
            cout << map[w] << '\n';
        }
        else {
            int x, w;
            cin >> x >> w;
            map[w] = x;
        }
    }

    return 0;
}