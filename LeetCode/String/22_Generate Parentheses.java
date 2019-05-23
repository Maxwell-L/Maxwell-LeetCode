/**
 * 22.Generate Parentheses
 *    Medium
 * Description:
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 * 
 * For example, given n = 3, a solution set is:
 * [
 *  "((()))",
 *  "(()())",
 *  "(())()",
 *  "()(())",
 *  "()()()"
 * ]
 */
 
class Solution {
    public void recursion(List<String> result, char[] parentheses, int n, int count, int index){
        if(count == n){
            for(int i = 0; i < 2 * n; i++){
                if(parentheses[i] != '('){
                    parentheses[i] = ')';
                }
            }
            String str = String.valueOf(parentheses);
            result.add(str);
            return;
        }
        for(int i = index; i < 2 * count + 1; i++){
            parentheses[i] = '(';
            recursion(result, parentheses, n, count+1, i+1);
            parentheses[i] = ' ';
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        recursion(result, new char[2*n], n, 0, 0);
        return result;
    }
}