/*
1. 두 수를 입력받기
2. 두 수를 reverse()로 뒤집기
3. 두 수를 stoi()를 이용해 정수로 만들기
4. 뒤집힌 두 수를 더하기
5. to_string을 이용해 문자열로 저장
6. 그 문자열을 정수형으로 변환하고 출력
*/

#include <iostream>
#include <algorithm>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string a, b;
    cin >> a >> b;

    reverse(a.begin(), a.end());
    reverse(b.begin(), b.end());

    string result = to_string(stoi(a) + stoi(b));
    reverse(result.begin(), result.end());

    cout << stoi(result) << '\n';

    return 0;
}