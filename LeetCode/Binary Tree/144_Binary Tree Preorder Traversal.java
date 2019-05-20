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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root != null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            TreeNode p = root;
            while(p != null || !stack.empty()){
                if(p == null){
                    p = stack.pop();
                }
                result.add(p.val);
                if(p.right != null){
                    stack.push(p.right);
                }
                p = p.left;
            }
        }
        return result;
    }
}
