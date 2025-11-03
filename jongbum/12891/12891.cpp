#include <iostream>
#include <map>

using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
  
    int cnt = 0;
    int s,p,a,c,g,t;
    string str;
    cin>>s>>p>>str>>a>>c>>g>>t;
    s-=p;

    map<char,int> m;

    for (int i = 0; i < p; i++) m[str[i]]++;
    if (m['A'] >= a && m['C'] >= c && m['G'] >= g && m['T'] >= t) cnt++;
    m[str[0]]--;
    m[str[p]]++;

    for (int i = 1; i <= s; i++) {
        if (m['A'] >= a && m['C'] >= c && m['G'] >= g && m['T'] >= t) cnt++;
        m[str[i]]--;
        m[str[i+p]]++;
    }
    
    cout << cnt << '\n';

    return 0;
}
