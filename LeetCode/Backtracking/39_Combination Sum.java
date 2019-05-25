/**
 * 39.Combination Sum
 *    Medium
 * Description:
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target), 
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *  [7],
 *  [2,2,3]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *  [2,2,2,2],
 *  [2,3,3],
 *  [3,5]
 * ]
 */

class Solution {
    private void helper(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int tempSum, int index){
        if(tempSum == target){
            result.add(list);
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(tempSum + candidates[i] <= target){
                List<Integer> newList = new ArrayList<>(list);
                newList.add(candidates[i]);
                helper(result, newList, candidates, target, tempSum+candidates[i], i);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), candidates, target, 0, 0);
        return result;
    }
}
