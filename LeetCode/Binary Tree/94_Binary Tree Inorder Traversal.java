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
    private void inorder(TreeNode root, List<Integer> result){
        if(root != null){
            inorder(root.left, result);
            result.add(root.val);
            inorder(root.right, result);
        }
    }
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        inorder(root, result);
        return result;
    }
}
