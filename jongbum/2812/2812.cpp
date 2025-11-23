#include <iostream>
#include <vector>
#include <stack>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(nullptr);
    cout.tie(nullptr);
    
    int n, k;
    string str;
    cin >> n >> k >> str;
    
    stack<char> s;
    
    for(int i = 0; i < str.size(); i++) {
        while(k > 0 && !s.empty() && s.top() < str[i]) {
            s.pop();
            k--;
        }
        s.push(str[i]);
    }
    
    vector<char> res;
    
    while(!s.empty()) {
        res.push_back(s.top());
        s.pop();
    }
    
    for(int i = res.size()-1; i >= k; i--) cout << res[i];
    
    return 0;
}
