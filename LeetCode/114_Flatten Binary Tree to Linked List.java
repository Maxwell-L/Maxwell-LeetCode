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
    public void flatten(TreeNode root) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(p != null || !stack.empty()){
            if(p == null){
                p = stack.pop();
            }
            if(p.right != null){
                stack.push(p.right);
            }
            if(p.left != null){
                p.right = p.left;
                p.left = null;
            }
            else{
                p.right = stack.empty() ? null : stack.pop();
            }
            p = p.right;
        }
    }
}
