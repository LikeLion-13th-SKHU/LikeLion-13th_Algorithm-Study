/*
T 입력받고 T번 수행하기 때문에 O(T)

뒤집기 대신 뒤집혔는지 체크하는 bool isReverse 선언
isReverse는 기본값으로 false

R을 만날 때마다 isReverse 스위치

pop의 방향이 자유로운 덱을 사용
D를 입력받을 때 덱이 비어있다면 error 출력 후 반복문 종료
D를 입력받을 때 isReverse false면 pop_front, 그렇지 않다면 pop_back

덱의 크기 N과 비례하기 떄문에 O(N)
-> O(T * N)
*/

#include <iostream>
#include <queue>
#include <string>
#include <sstream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int T;
    cin >> T;
    while (T--) {
        string cmd;
        cin >> cmd;

        int n;
        cin >> n;
        deque<int> dq;

        string input;
        cin >> input;

        // 대괄호 해체
        input = input.substr(1, input.size()-2);

        stringstream ss(input);
        string token;
        // 쉼표 기준으로 파싱
        while (getline(ss, token, ',')) {
            dq.push_back(stoi(token));
        }

        /* 로직 시작 */

        bool isReverse = false;
        bool error = false;
        for (int i = 0; i < cmd.size(); i++) {
            // D
            if (cmd[i] == 'D') {
                if (dq.empty()) {
                    error = true;
                    cout << "error" << '\n';
                    break;
                }
                // isReverse가 false면 맨 앞 원소 삭제
                else if (!isReverse) dq.pop_front();
                // isReverse가 true면 맨 뒤 원소 삭제
                else if (isReverse) dq.pop_back();
            }
            // R
            else if (cmd[i] == 'R') {
                // front 반대로 바꾸기
                isReverse = !isReverse;
            }
        }

        // 에러 출력했으면 다음으로 넘어가기
        if (error) continue;

        cout << '[';
        if (!isReverse) {
            for (int i = 0; i < dq.size(); i++) {
                cout << dq[i];
                // 마지막 쉼표는 건너뛰기
                if (i == dq.size()-1) break;
                cout << ',';
            }
        }
        else {
            for (int i = dq.size()-1; i >= 0; i--) {
                cout << dq[i];
                // 마지막 쉼표는 건너뛰기
                if (i == 0) break;
                cout << ',';
            }
        }
        cout << "]\n";
    }

    return 0;
}