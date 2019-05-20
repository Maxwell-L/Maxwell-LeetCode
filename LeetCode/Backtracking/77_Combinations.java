class Solution {
    private void helper(List<List<Integer>> result, List<Integer> temp, int c, int n, int k){
        if(k == 0){
            result.add(new ArrayList<>(temp));
            return;
        }
        for(int i = c; i <= n; i++){
            temp.add(i);
            helper(result, temp, i+1, n, k-1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        helper(result, new ArrayList<Integer>(), 1, n, k);
        return result;
    }
}