#include <iostream>
#include <vector>
#include <string>
#include <sstream>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string str;
    cin >> str;

    // 문자열에서 단어가 시작하는 인덱스 저장
    vector<int> word_begin_idx(1, 0);

    int cnt_upper = 0;      // 대문자 수 저장
    int cnt_underbar = 0;   // _ 개수 저장

    // 문자열의 첫번째 문자는 소문자
    if (str[0] < 'a') {
        cout << "Error!" << '\n';
        return 0;
    }

    for (int i = 1; i < str.size(); i++) {
        if (str[i] <= 'Z') {
            cnt_upper++;
            word_begin_idx.push_back(i);
        }
        else if (str[i] == '_') {
            // _ 앞뒤로 소문자가 존재하지 않는 경우
            if (i == str.size()-1 || str[i-1] <= 95 || str[i+1] <= 95) {
                cout << "Error!" << '\n';
                return 0;
            }
            cnt_underbar++;
        }
    }

    // 마지막 단어의 길이를 계산할 수 있도록 마지막에 문자열의 크기 삽입
    word_begin_idx.push_back(str.size());

    // 대문자와 _가 동시에 존재할 때
    if (cnt_underbar && cnt_upper) {
        cout << "Error!" << '\n';
        return 0;
    }

    // 대문자만 존재할 때(java)
    if (cnt_upper > 0) {
        string result = "";
        // 4 long
        // 3 And
        // 8 mnemonic
        // 10 identifier
        for (int i = 0; i < word_begin_idx.size() - 1; i++) {
            string tmp = str.substr(word_begin_idx[i],(word_begin_idx[i+1] - word_begin_idx[i]));
            tmp[0] += 'a' - 'A';
            result += tmp;
            // 마지막에는 _ 붙이면 안 되므로 for문 탈출
            if (i == word_begin_idx.size() - 2) break;
            result += '_';
        }
        result[0] -= 'a' - 'A';
        cout << result << '\n';
    }
    // _만 존재할 때(cpp)
    else if (cnt_underbar > 0) {
        string result = "";
        stringstream ss(str);
        string token;
        while (getline(ss, token, '_')) {
            token[0] -= 'a' - 'A';
            result += token;
        }
        result[0] += 'a' - 'A';
        cout << result << '\n';
    }
    // 문자열 전부 소문자로 이루어져 있을 때(java, cpp 모두 가능)
    else {
        cout << str << '\n';
    }

    return 0;
}