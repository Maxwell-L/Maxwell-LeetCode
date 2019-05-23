/**
 * 91.Decode Ways
 *    Medium
 * Description:
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 *
 * Example 1:
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * Example 2:
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 */

class Solution {
    public int numDecodings(String s) {
        int pre = (int)(s.charAt(0) - '0'), cur = pre;
        int[] f = new int[s.length()];
        if(pre == 0){
            return 0;
        }
        f[0] = 1;
        for(int i = 1; i < s.length(); i++){
            cur = (int)(s.charAt(i) - '0');
            int isValue = pre * 10 + cur;
            if(isValue == 0 || (isValue > 26 && cur == 0)){
                return 0;
            }
            if(isValue > 26 || pre == 0){
                f[i] = f[i-1];
            }
            else if(cur == 0){
                f[i] = i > 1 ? f[i-2] : f[i-1];
            }
            else{
                f[i] = i == 1 ? 1 + f[i-1] : f[i-1] + f[i-2];
            }
            pre = cur;
        }
        return f[s.length() - 1];
    }
}
