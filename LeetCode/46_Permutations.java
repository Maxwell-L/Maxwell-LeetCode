class Solution {
    public void dfs(List<List<Integer>> result, List<Integer> left, int[] nums){
        if(left.size() == nums.length){
            result.add(left);
            return;
        }
        for(int num : nums){
            if(!left.contains(num)){
                List<Integer> newLeft = new ArrayList<>(left);
                newLeft.add(num);
                dfs(result, newLeft, nums);
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        dfs(result, new ArrayList<>(), nums);
        return result;
    }
}
