/**
 * 106.Construct Binary Tree from Inorder and Postorder Traversal
 *     Medium
 * Description:
 * Given inorder and postorder traversal of a tree, construct the binary tree.
 * Note:You may assume that duplicates do not exist in the tree.
 * For example, given
 *		inorder = [9,3,15,20,7]
 *		postorder = [9,15,7,20,3]
 * Return the following binary tree:
 *	   3
 *    / \
 *   9  20
 *     /  \
 *    15   7
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
    private TreeNode helper(int[] inorder, int[] postorder, int inL, int inR, int pL, int pR){
        if(inL >= inR || pL >= pR){
            return null;
        }
        TreeNode node = new TreeNode(postorder[pR-1]);
        int k = inL;
        for(; k < inR; k++){
            if(inorder[k] == postorder[pR-1]){
                break;
            }
        }
        node.left = helper(inorder, postorder, inL, k, pL, pL + k - inL);
        node.right = helper(inorder, postorder, k + 1, inR, pL + k - inL, pR - 1);
        return node;
    }
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        return helper(inorder, postorder, 0, inorder.length, 0, inorder.length);
    }
}
