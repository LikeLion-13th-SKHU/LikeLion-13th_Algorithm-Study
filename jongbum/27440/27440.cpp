/*
시작시간 1525
종료시간 1706
1시간 41분
101분
*/
#include <iostream>
#include <map>
#include <queue>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    // {수, 깊이}
    map<long long int, int> m;
    long long int n;
    cin >> n;

    // {수, 깊이}
    queue<pair<long long int, int>> q;
    q.push({n, 0});
    m[n] = 0;

    while (q.front().first > 1) {
        long long int number = q.front().first;
        int depth = q.front().second;
        q.pop();

        // 수를 3으로 나눈 수에 방문한 적이 없고 3의 배수라면
        if (!m.count(number/3) && number % 3 == 0) {
            q.push({number/3, depth+1});
            m[number/3] = depth+1;
        }

        // 수를 2으로 나눈 수에 방문한 적이 없고 2의 배수라면
        if (!m.count(number/2) && !(number & 1)) {
            q.push({number/2, depth+1});
            m[number/2] = depth+1;
        }

        // 수에 1은 뺀 수에 방문한 적이 없다면
        if (!m.count(number-1)) {
            q.push({number-1, depth+1});
            m[number-1] = depth+1;
        }
    }

    // 출력
    cout << m[1] << '\n';

    return 0;
}