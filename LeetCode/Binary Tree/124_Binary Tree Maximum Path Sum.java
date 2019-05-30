/** 
 * 124.Binary Tree Maximum Path Sum
 *     Hard
 * Description:
 * Given a non-empty binary tree, find the maximum path sum.
 * For this problem, a path is defined as any sequence of nodes from some starting node to 
 * any node in the tree along the parent-child connections. 
 * The path must contain at least one node and does not need to go through the root.
 * 
 * Example 1:
 * Input: [1,2,3]
 *        1
 *       / \
 *      2   3
 * Output: 6
 *
 * Example 2:
 * Input: [-10,9,20,null,null,15,7]
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * Output: 42
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
    private int helper(TreeNode root, int[] result){
        if(root == null){
            return 0;
        }
        int l = helper(root.left, result);
        int r = helper(root.right, result);
        int sum = root.val;
        sum = l > 0 ? sum + l : sum;
        sum = r > 0 ? sum + r : sum;
        result[0] = result[0] < sum ? sum : result[0];
        return Math.max(root.val, Math.max(root.val + l, root.val + r));
        
    }
    public int maxPathSum(TreeNode root) {
        int[] result = new int[]{root.val};
        helper(root, result);   
        return result[0];
    }
}
