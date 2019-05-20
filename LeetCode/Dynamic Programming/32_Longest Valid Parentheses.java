class Solution {
    public int longestValidParentheses(String s) {
        int left1 = 0, right1 = 0, left2 = 0, right2 =0, longest1 = 0, longest2 = 0;
        for(int i = 0, j = s.length()-1; i < s.length(); i++, j--){
            if(s.charAt(i) == '('){
                left1++;
            }
            else if(s.charAt(i) == ')' && left1 > right1){
                right1++;
                longest1 = left1 == right1 && 2 * left1 > longest1 ? 2 * left1 : longest1;
            }
            else{
                left1 = 0;
                right1 = 0;
            }
            if(s.charAt(j) == ')'){
                right2++;
            }
            else if(s.charAt(j) == '(' && left2 < right2){
                left2++;
                longest2 = left2 == right2 && 2 * left2 > longest2 ? 2 * left2 : longest2;
            }
            else{
                left2 = 0;
                right2 = 0;
            }
        }
        longest1 = left1 == right1 && longest1 < 2 * left1 ? 2 * left1 : longest1;
        longest2 = left2 == right2 && longest2 < 2 * left2 ? 2 * left2 : longest2;
        return longest1 > longest2 ? longest1 : longest2;
        
    }
}
