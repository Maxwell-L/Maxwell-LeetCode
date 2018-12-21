#include <iostream>
#include <string>

using namespace std;
int lengthOfLastWord(string s);

int main()
{
    string s;
    cin >> s;
    cout << lengthOfLastWord(s) << endl;
    return 0;
}

int lengthOfLastWord(string s) {
    if(s.empty()){
        return 0;
    }
    int last = s.length() - 1;
    while(s[last] == ' '){
        last--;
    }
    int len = 0;
    while(s[last] != ' ' && last >= 0){
        len++;
        last--;
    }
    return len;
}
