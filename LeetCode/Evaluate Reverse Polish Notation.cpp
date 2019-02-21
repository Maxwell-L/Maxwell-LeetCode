class Solution {
public:
    int evalRPN(vector<string>& tokens) {
        stack<int> stl;
        int len = tokens.size();
        int num1 = 0, num2 = 0;
        for(int i = 0; i < len; i++){
            if(tokens[i] != "+" && tokens[i] != "-" && tokens[i] != "*" && tokens[i] != "/"){
                num1 = stol(tokens[i]);
                stl.push(num1);
            }
            else{
                num1 = stl.top();
                stl.pop();
                num2 = stl.top();
                stl.pop();
                if(tokens[i] == "+"){
                    stl.push(num1 + num2);
                }
                else if(tokens[i] == "-"){
                    stl.push(num2 - num1);
                }
                else if(tokens[i] == "*"){
                    stl.push(num1 * num2);
                }
                else{
                    stl.push(num2 / num1);
                }
            }    
        }
        return stl.top();
    }
};