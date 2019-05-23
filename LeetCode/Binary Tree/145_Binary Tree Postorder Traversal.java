/**
 * 145.Binary Tree Postorder Traversal
 *     Hard
 * Description:
 * Given a binary tree, return the postorder traversal of its nodes' values.
 * 
 * Example:
 * Input: [1,null,2,3]
 *		  1
 *		   \
 *		    2
 *		   /
 *		  3
 * Output: [3,2,1]
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
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        if(root == null){
            return result;
        }
        TreeNode last = root;
        stack.push(root);
        while(!stack.empty()){
            TreeNode temp = stack.peek();
            if((temp.left == null && temp.right == null) || (temp.right == null && temp.left == last) || temp.right == last){
                result.add(stack.pop().val);
                last = temp;
            }
            else{
                if(temp.right != null){
                    stack.push(temp.right);
                }
                if(temp.left != null){
                    stack.push(temp.left);
                }
            }
        }
        return result;
    }
}
