#include <iostream>
#include <string>

using namespace std;
string longestPalindrome(string s);

int main()
{
    string s;
    cin >> s;
    cout << "Answer : " << longestPalindrome(s) << endl;
    return 0;
}

string longestPalindrome(string s) {
    if(s == "" ||  s.length() == 1){
        return s;
    }
    for(int i = s.length(); i > 0; i--){
        for(int j = 0; j <= (int)s.length() - i; j++){
            string sub = s.substr(j, i);
            int u = 0, v = sub.length() - 1;
            while(u < v){
                if(sub[u] != sub[v]){
                    break;
                }
                u++;
                v--;
            }
            if(u >= v){
                return sub;
            }
        }
    }
    return "";
}
