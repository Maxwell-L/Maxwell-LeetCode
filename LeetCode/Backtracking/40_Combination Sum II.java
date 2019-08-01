/** 
 * 40.Combination Sum II
 *    Medium
 * Description:
 * Given a collection of candidate numbers (candidates) and a target number (target), 
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *   [1, 7],
 *   [1, 2, 5],
 *   [2, 6],
 *   [1, 1, 6]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *   [1,2,2],
 *   [5]
 * ]
 */
 
class Solution {
    private void helper(int[] candidates, int index, int sum, int target, List<Integer> temp, List<List<Integer>> result){
        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1]){
                continue;
            }
            if(sum + candidates[i] > target){
                return;
            }
            if(sum + candidates[i] == target){
                List<Integer> newTemp = new ArrayList<>(temp);
                newTemp.add(candidates[i]);
                result.add(newTemp);
                return;
            }
            List<Integer> newTemp = new ArrayList<>(temp);
            newTemp.add(candidates[i]);
            if(i + 1 < candidates.length){
                helper(candidates, i+1, sum + candidates[i], target, newTemp, result);
            }   
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(candidates, 0, 0, target, new ArrayList<Integer>(), result);
        return result;
    }
}
