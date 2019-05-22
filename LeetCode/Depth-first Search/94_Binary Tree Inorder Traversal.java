/**
 * 94.Binary Tree Inorder Traversal
 *    Medium
 * Description:
 * Given a binary tree, return the inorder traversal of its nodes' values.
 * 
 * Example:
 * Input: [1,null,2,3]
		1
		 \
		  2
		 /
		3
 * Output: [1,3,2]
 */
 
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
