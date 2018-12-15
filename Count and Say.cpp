#include <iostream>
#include <stack>
#include <string>
#include <sstream>

using namespace std;
string countAndSay(int n);

int main()
{
    int n;
    cin >> n;
    while(n != 100){
        cout << countAndSay(n) << endl;
        cin >> n;
    }

    return 0;
}

string countAndSay(int n) {
        if(n == 1){
            return "1";
        }
        string last = countAndSay(n-1);
        string answer;
        stack<char> stk;
        stringstream numToStr;
        for(int i = 0; i < (int)last.length(); i++){
            if(stk.empty() || last[i] == stk.top()){
                stk.push(last[i]);
            }
            else{
                numToStr << stk.size();
                answer += numToStr.str();
                numToStr.str("");
                answer += stk.top();
                while(!stk.empty()){
                    stk.pop();
                }
                stk.push(last[i]);
            }
        }
        numToStr << stk.size();
        answer += numToStr.str();
        answer += stk.top();
        return answer;
    }
