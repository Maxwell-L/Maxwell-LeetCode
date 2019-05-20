class Solution {
    private void helper(List<List<Integer>> result, List<Integer> list, int[] candidates, int target, int tempSum, int index){
        if(tempSum == target){
            result.add(list);
            return;
        }
        for(int i = index; i < candidates.length; i++){
            if(tempSum + candidates[i] <= target){
                List<Integer> newList = new ArrayList<>(list);
                newList.add(candidates[i]);
                helper(result, newList, candidates, target, tempSum+candidates[i], i);
            }
        }
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), candidates, target, 0, 0);
        return result;
    }
}
