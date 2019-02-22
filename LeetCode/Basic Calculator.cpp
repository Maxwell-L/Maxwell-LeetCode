class Solution {
public:
    int calculate(string s) {
        stack<int> stl;
        int len = s.length(), res = 0, sign = 1, num = 0;
        for(int i = 0; i < len; i++){
            if(s[i] >= '0'){
                num = 0;
                while(i < len && s[i] >= '0'){
                    num = num * 10 + (s[i++] - '0');
                }
                res += sign * num;
                i--;
            }
            else if(s[i] == '+'){
                sign = 1;
            }
            else if(s[i] == '-'){
                sign = -1;
            }
            else if(s[i] == '('){
                stl.push(res);
                stl.push(sign);
                res = 0;
                sign = 1;
            }
            else if(s[i] == ')'){
                res *= stl.top();
                stl.pop();
                res += stl.top();
                stl.pop();    
            }
        }
        return res;
    }
};