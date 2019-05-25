/**
 * 78.Subsets
 * Medium
 * Description:
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *   [3],
 *   [1],
 *   [2],
 *   [1,2,3],
 *   [1,3],
 *   [2,3],
 *   [1,2],
 *   []
 * ]
 */
 
class Solution {
    private void helper(List<List<Integer>> result, List<Integer> set, int[] nums, int index){
        if(index == nums.length){
            return;
        }
        for(int i = index; i < nums.length; i++){
            List<Integer> newSet = new ArrayList<>(set);
            newSet.add(nums[i]);
            result.add(newSet);
            helper(result, newSet, nums, i+1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), nums, 0);
        result.add(new ArrayList<Integer>());
        return result;
    }
}
