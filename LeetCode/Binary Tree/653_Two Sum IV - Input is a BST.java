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
    public boolean findTarget(TreeNode root, int k) {
        if(root != null){
            Stack<TreeNode> stack = new Stack<TreeNode>();
            HashMap<Integer, Integer> hashmap = new HashMap<Integer, Integer>();
            TreeNode p = root;
            int temp = 0;
            while(p != null || !stack.empty()){
                if(p == null){
                    p = stack.pop();
                }
                temp = k - p.val;
                if(hashmap.get(temp) != null){
                    return true;
                }
                hashmap.put(p.val, p.val);
                if(p.right != null){
                    stack.push(p.right);
                }
                p = p.left;
            }
        }
        return false;
    }
}
