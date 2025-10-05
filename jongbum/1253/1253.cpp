#include <algorithm>
#include <iostream>
#include <vector>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;
    if (n < 3) {
        cout << "0\n";
        return 0;
    }

    vector<int> v(n,0);
    for (int i = 0; i < n; i++) cin >> v[i];

    sort(v.begin(), v.end());

    int cnt = 0;

    // 좋은 수 판별
    for (int cur = 0; cur < n; cur++) {
        int start = 0;
        int end = upper_bound(v.begin(), v.end(), v[cur] - v[start]) - v.begin();
        if (end == n) end--;

        while (start < end) {
            // start와 end는 커서와 같은 위치이면 안 되기 때문에
            if (start == cur) {
                start++;
                continue;
            }
            if (end == cur) {
                end--;
                continue;
            }

            // 커서가 가리키는 수를 기준이라고 할 때
            // 두 수의 합이 기준보다 작다면
            if (v[start] + v[end] < v[cur]) start++;
            // 두 수의 합이 기준보다 크다면
            else if (v[start] + v[end] > v[cur]) end--;
            // 두 수의 합이 기준과 같다면 반복문 종료
            else {
                cnt++;
                break;
            }
        }
    }
    cout << cnt << '\n';

    return 0;
}
