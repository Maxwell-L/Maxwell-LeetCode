/**
 * 43.Multiply Strings
 *    Medium
 * Description:
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 *
 * Example 1:
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 *
 * Example 2:
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 *
 * Note:
 *    The length of both num1 and num2 is < 110.
 *    Both num1 and num2 contain only digits 0-9.
 *    Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 *    You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
 
class Solution {
    public String multiply(String num1, String num2) {
        if(num1.equals("0") || num2.equals("0")){
            return "0";
        }
        if(num1.length() < num2.length()){
            return multiply(num2, num1);
        }
        int carry = 0, index = 0, start = 0;
        StringBuilder res = new StringBuilder("");
        for(int i = num2.length() - 1; i >= 0; i--){
            int n2 = num2.charAt(i) -'0';
            index = start;
            for(int j = num1.length() - 1; j >= 0; j--){
                int n1 = num1.charAt(j) - '0';
                if(index >= res.length()){
                    int low = (n1 * n2 + carry) % 10;
                    carry = (n1 * n2 + carry) / 10;
                    res.append(low);
                }
                else{
                    int n3 = res.charAt(index) - '0';
                    int low = (n1 * n2 + carry + n3) % 10;
                    carry = (n1 * n2 + carry + n3) / 10;
                    res.replace(index, index+1, String.valueOf(low));
                }
                index++;
            }
            if(carry != 0){
                res.append(carry);
                carry = 0;
            }
            start++;
        }
        return res.reverse().toString();
    }
}
