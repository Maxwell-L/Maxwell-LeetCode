/**
 * 1.Two Sum
 *   Easy
 * Description:
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 * 
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
 
class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
        int[] result = new int[2];
        int temp = 0;
        for(int i = 0; i < nums.length; i++){
            temp = target - nums[i];
            if(hashmap.get(temp) == null){
                hashmap.put(nums[i], i);
            }
            else{
                result[0] = (hashmap.get(temp));
                result[1] = i;
                break;
            }
        }
        return result;
    }
}
