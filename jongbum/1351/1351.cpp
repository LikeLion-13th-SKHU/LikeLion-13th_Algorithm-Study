#include <iostream>
#include <map>

using namespace std;

map<long long int, long long int> m;

long long int dp(long long int n, int p, int q) {
    // 이미 있는 값이면 계산 하지 않기
    if(m.count(n)) return m[n];

    if (n == 0) return 1;
    if (n == 1) return 2;

    m[n] = dp(n/p, p, q) + dp(n/q, p, q);

    return m[n];
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    long long int n, p, q;
    cin >> n >> p >> q;

    cout << dp(n, p, q) << '\n';

    return 0;
}