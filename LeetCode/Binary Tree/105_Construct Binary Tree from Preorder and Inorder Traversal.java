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
