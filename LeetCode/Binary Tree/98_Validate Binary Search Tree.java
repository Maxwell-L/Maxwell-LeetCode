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
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        Integer pre = null;
        while(p != null || !stack.empty()){
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            if(!stack.empty()){
                TreeNode temp = stack.pop();
                if(pre == null || pre < temp.val){
                    pre = temp.val;
                    p = temp.right;
                }
                else{
                    return false;
                }
            }
        }
        return true;
    }
}
