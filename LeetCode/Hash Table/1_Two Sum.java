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
