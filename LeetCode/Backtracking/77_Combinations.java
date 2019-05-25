/** 
 * 77.Combinations
 *    Medium
 * Description:
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 *
 * Example:
 * Input: n = 4, k = 2
 * Output:
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 */
 
class Solution {
    private void helper(List<List<Integer>> result, List<Integer> temp, int c, int n, int k){
        if(k == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = c; i <= n; i++){
            temp.add(i);
            helper(result, temp, i+1, n, k-1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), 1, n, k);
        return result;
    }
}