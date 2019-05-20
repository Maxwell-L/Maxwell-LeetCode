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
    public int kthSmallest(TreeNode root, int k) {
        TreeNode p = root;
        int count = 0;
        Stack<TreeNode> stack = new Stack<TreeNode>();
        while(p != null || !stack.empty()){
            while(p != null){
                stack.push(p);
                p = p.left;
            }
            if(!stack.empty()){
                p = stack.pop();
                if(++count == k){
                    return p.val;
                }
                p = p.right;
            }
        }
        return 0;
    }
}
