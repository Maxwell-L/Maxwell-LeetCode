class Solution {
    public int[] reverse(int[] nums, int begin){
        int l = begin, r = nums.length - 1;
        while(l < r){
            int temp = nums[l];
            nums[l] = nums[r];
            nums[r] = temp;
            l++;
            r--;
        }
        return nums;
    }
    public void nextPermutation(int[] nums) {
        int flag = 0, begin = 0;
        for(int i = nums.length-1; i > 0; i--){
            if(nums[i] > nums[i-1]){
                int j = nums.length-1;
                while(nums[j] <= nums[i-1]){
                    j--;
                }
                int temp = nums[j];
                nums[j] = nums[i-1];
                nums[i-1] = temp;
                flag = 1;
                begin = i;
                nums = reverse(nums, begin);
                break;
            }
        }
        nums = flag == 1 ? nums : reverse(nums, 0);
    }
}
