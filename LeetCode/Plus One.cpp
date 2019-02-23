class Solution {
public:
    vector<int> plusOne(vector<int>& digits) {
        int carry = 1, num = 0;
        for(int i = digits.size() - 1; i >= 0; i--){
            num = digits[i] + carry;
            digits[i] = num == 10 ? 0 : num;
            carry = num == 10 ? 1 : 0;
        }
        if(carry == 1){
            digits.insert(digits.begin(), carry);
        }
        return digits;
    }
};
