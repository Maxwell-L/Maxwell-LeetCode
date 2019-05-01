class Solution {
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        for(int i = 1; i < nums.length; i++){
            nums[i] = nums[i-1] > 0 ? nums[i] + nums[i-1] : nums[i];
            result = result > nums[i] ? result : nums[i];
        }
        return result;
    }
}
