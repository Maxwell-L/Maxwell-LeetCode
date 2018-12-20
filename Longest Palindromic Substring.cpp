#include <iostream>
#include <string>

using namespace std;
bool check(string s);
string longestPalindrome(string s);

int main()
{
    string s;
    cin >> s;
    cout << "Answer : " << longestPalindrome(s) << endl;
    return 0;
}

bool check(string s){
    int i = 0, j = s.length() - 1;
    while(i < j){
        if(s[i] != s[j]){
            break;
        }
        i++;
        j--;
    }
    return i >= j ? true : false;
}
string longestPalindrome(string s) {
    if(s == "" ||  s.length() == 1){
        return s;
    }
    for(int i = s.length(); i > 0; i--){
        for(int j = 0; j <= (int)s.length() - i; j++){
            string sub = s.substr(j, i);
            if(check(sub)){
                return sub;
            }
        }
    }
    return "";
}
