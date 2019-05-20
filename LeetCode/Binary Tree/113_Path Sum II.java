/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    private void helper(TreeNode root, List<List<Integer>> result, List<Integer> temp, int sum){
        if(root == null){
            return;
        }
        if(sum - root.val == 0 && root.left == null && root.right == null){
            List<Integer> newTemp = new ArrayList<>(temp);
            newTemp.add(root.val);
            result.add(newTemp);
            return;
        }
        List<Integer> newTemp = new ArrayList<>(temp);
        newTemp.add(root.val);
        helper(root.left, result, newTemp, sum - root.val);
        helper(root.right, result, newTemp, sum - root.val); 
    }
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(root != null){
            helper(root, result, new ArrayList<Integer>(), sum);
        }
        return result;    
    }
}
