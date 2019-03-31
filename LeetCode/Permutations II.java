class Solution {
    public void dfs(List<List<Integer>> result, List<Integer> left, int[] nums, boolean[] index){
        if(left.size() == nums.length){
            if(!result.contains(left))
                result.add(left);
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(!index[i]){
                List<Integer> newLeft = new ArrayList<>(left);
                newLeft.add(nums[i]);
                index[i] = true;
                dfs(result, newLeft, nums, index);
                index[i] = false;
            } 
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        boolean[] index = new boolean[nums.length];
        dfs(result, new ArrayList<>(), nums, index);
        return result;
    }
}
