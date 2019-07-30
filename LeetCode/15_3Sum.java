/**
 * 15.3Sum
 *    Medium
 * Description:
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? 
 * Find all unique triplets in the array which gives the sum of zero.
 *
 * Note:
 * The solution set must not contain duplicate triplets.
 *
 * Example:
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 *  [
 *    [-1, 0, 1],
 *    [-1, -1, 2]
 *  ]
 */
 
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length < 3){
            return result;
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] > 0){
                break;
            }
            if(i > 0 && nums[i] == nums[i-1]){
                continue;
            }
            int begin = i + 1, end = nums.length - 1;
            while(begin < end){
                int sum = nums[i] + nums[begin] + nums[end];
                if(sum == 0){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(nums[i]);
                    temp.add(nums[begin++]);
                    temp.add(nums[end--]);
                    result.add(temp);
                    while(begin < end && nums[begin] == nums[begin-1]){
                        begin++;
                    }
                    while(begin < end && nums[end] == nums[end+1]){
                        end--;
                    }
                }
                else if(sum > 0){
                    end--;
                }
                else{
                    begin++;
                }
            }
            
        }
        return result;
    }
}
