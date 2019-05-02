class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> pre = triangle.get(0), cur = triangle.get(0);
        int level = triangle.size(), result = pre.get(0);
        for(int i = 1; i < level; i++){
            cur = triangle.get(i);
            int len = cur.size();
            for(int j = 0; j < len; j++){
                if(j == 0){
                    cur.set(j, cur.get(j) + pre.get(j));
                    result = cur.get(j);
                }
                else if(j == len - 1){
                    cur.set(j, cur.get(j) + pre.get(j-1));
                    result = Math.min(result, cur.get(j));
                }
                else{
                    cur.set(j, cur.get(j) + Math.min(pre.get(j-1), pre.get(j)));
                    result = Math.min(result, cur.get(j));
                }
            }
            pre = cur;
        }
        return result;
    }
}
