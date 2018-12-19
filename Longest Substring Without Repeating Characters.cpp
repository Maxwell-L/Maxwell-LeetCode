#include <iostream>
#include <string>

using namespace std;
int check(string s, char c);
int lengthOfLongestSubstring(string s);

int main()
{
    string s;
    while(s != "QUIT"){
        cin >> s;
        cout << lengthOfLongestSubstring(s) << endl;
    }
    return 0;
}

int check(string s, char c) {
    for(int i = 0; i < (int)s.length(); i++){
        if(c == s[i]){
            return i;
        }
    }
    return -1;
}
int lengthOfLongestSubstring(string s) {
    if(s == ""){
        return 0;
    }
    string ans;
    int maxlen = 0;
    for(int i = 0; i < (int)s.length(); i++){
        int judge = check(ans, s[i]);
        if(s == "" || judge == -1){
            ans += s[i];
            if((int)ans.length() > maxlen){
                maxlen++;
            }
        }
        else if(judge + 1 >= (int)ans.length()){
            ans = s[i];
        }
        else{
            ans = ans.substr(judge+1) + s[i];
        }
    }
    return maxlen;
}
