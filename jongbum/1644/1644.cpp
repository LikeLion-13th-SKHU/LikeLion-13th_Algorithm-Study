#include <cmath>
#include <iostream>
#include <vector>

using namespace std;

/* 에라토스테네스의 체 */
vector<int> eratosthenes(int n) {
    vector<bool> isPrime(n+1, true);

    for (int i = 3; i <= sqrt(n); i+=2) {
        if (isPrime[i]) {
            for (int j = i*i; j <= n; j+=i) isPrime[j] = false;
        }
    }

    vector<int> prime = {2};

    for (int i = 3; i <= n; i+=2) {
        if (isPrime[i]) prime.push_back(i);
    }

    return prime;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    if (n == 1) {
        cout << "0\n";
        return 0;
    }

    vector<int> prime = eratosthenes(n);

    int start = 0;
    int end = 0;
    int cur = prime[0]; // 2
    int cnt = 0;

    while (end != prime.size() - 1) {
        if (cur == n) {
            cnt++;
            cur += prime[++end];
        }
        else if (cur > n) cur -= prime[start++];
        else cur += prime[++end];
    }

    while (cur >= n) {
        if (cur == n) cnt++;
        cur -= prime[start++];
    }

    cout << cnt << '\n';

    return 0;
}