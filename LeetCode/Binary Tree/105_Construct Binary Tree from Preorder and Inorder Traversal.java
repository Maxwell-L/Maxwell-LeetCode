/**
 * 105.Construct Binary Tree from Preorder and Inorder Traversal
 *     Medium
 * Description:
 * Given preorder and inorder traversal of a tree, construct the binary tree.
 * Note:You may assume that duplicates do not exist in the tree.
 * For example,given
 * 		preorder = [3,9,20,15,7]
 * 		inorder = [9,3,15,20,7]
 * Return the following binary tree:
 *  	3
 *     / \
 *    9  20
 *      /  \
 *     15   7
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
    private TreeNode helper(int[] preorder, int preIndex, int[] inorder, int inIndex, int length){
        if(length == 0 || preIndex >= preorder.length){
            return null;
        }
        int newLength = 0;
        for(; newLength < preorder.length; newLength++){
            if(preorder[preIndex] == inorder[newLength]){
                break;
            }
        }
        newLength -= inIndex;
        TreeNode node = new TreeNode(preorder[preIndex]);
        node.left = helper(preorder, preIndex+1, inorder, inIndex, newLength);
        node.right = helper(preorder, preIndex+newLength+1, inorder, inIndex+newLength+1, length-newLength-1);
        return node;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(preorder, 0, inorder, 0, preorder.length);
    }
}
