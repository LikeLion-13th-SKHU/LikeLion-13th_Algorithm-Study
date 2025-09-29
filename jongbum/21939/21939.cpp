#include <iostream>
#include <map>
#include <set>

using namespace std;

struct cmp {
    // first가 문제 수, second가 난이도
    bool operator()(const pair<int, int>&a, const pair<int, int>&b) const {
        if (a.second == b.second) return a.first < b.first;
        return a.second < b.second;
    }
};

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    // {문제번호, 난이도}
    set<pair<int, int>, cmp> list;
    map<int, int> for_find;

    while (n--) {
        int number, level;
        cin >> number >> level;
        list.insert({number, level});
        for_find.insert({number, level});
    }

    int m;
    cin >> m;
    while (m--) {
        string cmd;
        cin >> cmd;
        if (cmd == "recommend") {
            int x;
            cin >> x;
            if (++x) cout << prev(list.end())->first << '\n';
            else cout << list.begin()->first << '\n';
        }

        else if (cmd == "add") {
            // 문제 번호, 난이도
            int number, level;
            cin >> number >> level;
            list.insert({number, level});
            for_find.insert({number, level});
        }
        else if (cmd == "solved"){
            // 문제 번호
            int number;
            cin >> number;
            int level = for_find[number];
            list.erase({number, level});
            for_find.erase(number);
        }
    }

    return 0;
}