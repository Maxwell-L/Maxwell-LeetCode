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
