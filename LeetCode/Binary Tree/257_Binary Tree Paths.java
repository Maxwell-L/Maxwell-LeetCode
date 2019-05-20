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
    private void helper(TreeNode root, List<String> result, String temp){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            String p = new String(temp);
            p += String.valueOf(root.val);
            result.add(p);
            return;
        }
        String p = new String(temp);
        p += String.valueOf(root.val) + "->";
        helper(root.left, result, p);
        helper(root.right, result, p);
    }
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        helper(root, result, new String());
        return result;
    }
}
