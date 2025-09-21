#include <iostream>
#include <stack>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string str;
    cin >> str;

    stack<char> s;


    for (int i = 0; i <= str.size(); i++) {
        // cur : 현재 문자열에서 커서가 가리키고 있는 문자
        char cur = str[i];

        if (cur == 'A') {
            /*
            A가 들어오면 안 되는 경우
             1. size가 2 미만일 때
             2. 스택의 top이 A일 때
            */
            if (s.size() < 2 || s.top() == 'A') {
                cout << "NP\n";
                return 0;
            }
            else s.push(cur);
        }
        // 커서가 P를 가리킬 때
        else if (cur == 'P') {
            if (s.empty()) s.push(cur);
            // TOP이 A일 때
            // P를 삽입한다면 현재 스택에는 PPAP를 만족함
            // 그렇기 때문에 P를 삽입하기 전 POP을 3번하고 P 삽입
            else if (s.top() == 'A') {
                int T = 3;
                while (T--) s.pop();
                s.push(cur);
            }
            // TOP이 P일 때는 따로 따질 것 없이 P 삽입
            else if (s.top() == 'P') s.push(cur);
        }
    }

    /*
    결국 스택에 P만 남아있다면 PPAP를 출력
    그렇지 않다면 NP 출력
    */
    if (s.size() == 1 && s.top() == 'P') cout << "PPAP\n";
    else cout << "NP\n";

    return 0;
}