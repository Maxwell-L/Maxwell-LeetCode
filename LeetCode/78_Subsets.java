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
