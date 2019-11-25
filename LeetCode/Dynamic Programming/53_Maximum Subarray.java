/**
 * 53.Maximum Subarray
 *    Easy
 * Description:
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * 
 * Explanation: [4,-1,2,1] has the largest sum = 6.
 *
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
 */
class Solution {
    public int maxSubArray(int[] nums) {
        int[] f = new int[nums.length];
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++) {
            if(i == 0 || f[i-1] < 0){
                f[i] = nums[i];
            } else {
                f[i] = f[i-1] + nums[i];
            }
            max = f[i] > max ? f[i] : max;
        }
        return max;
    }
}
