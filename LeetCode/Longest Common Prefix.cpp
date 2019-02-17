#include <iostream>
#include <string>
#include <vector>

using namespace std;
string longestCommonPrefix(vector<string>& strs);

int main()
{
    string str[] = {"flower", "flow", "flight"};
    vector<string> strs(str, str + 3);
    string answer;
    answer = longestCommonPrefix(strs);
    cout << answer << endl;
    return 0;
}

string longestCommonPrefix(vector<string>& strs) {
    if(strs.empty()){
        return "";
    }
    string answer = "";
    vector<string>::iterator it;
    char temp = strs[0][0];
    int minlen = 1000000;
    for(it = strs.begin(); it != strs.end(); it++){
        if((int)(*it).length() < minlen){
            minlen = (int)(*it).length();
        }
    }
    for(int i = 0; i < minlen; i++){
        temp = strs[0][i];
        for(it = strs.begin(); it != strs.end(); it++){
            if(temp != (*it)[i]){
                break;
            }
        }
        if(it == strs.end()){
            answer += temp;
        }
        else{
            break;
        }
    }
    return answer;
}
