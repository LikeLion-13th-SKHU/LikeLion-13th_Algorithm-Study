#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    /* 소수 찾기 */
    vector<bool> isPrime(1000000, true);
    vector<int> prime(0);

    isPrime[0] = isPrime[1] = false;

    for (int i = 4; i <= 1000000; i+=2) isPrime[i] = false;

    for (int i = 3; i <= 1000; i+=2) {
        if (isPrime[i]) {
            for (int j = i*i; j <= 1000000; j += 2*i) isPrime[j] = false;
        }
    }

    for (int i = 2; i <= 1000000; i++) {
        if (isPrime[i]) prime.push_back(i);
    }


    int n;
    cin >> n;
    vector<int> sum(n+1, 0);
    for (int i = 1; i < sum.size(); i++) {
        int input;
        cin >> input;
        sum[i] = input + sum[i-1];
    }


    int end = upper_bound(prime.begin(), prime.end(), n) - prime.begin();

    int cnt = 0;

    for (int i = 0; i < end; i++) {
        int len = prime[i];

        for (int j = n; j >= len; j--) {
            if (binary_search(prime.begin(), prime.end(), sum[j] - sum[j-len])) cnt++;
        }
    }

    cout << cnt << '\n';

    return 0;
}