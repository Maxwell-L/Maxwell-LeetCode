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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int count = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(queue.peek() != null){
            TreeNode p = queue.poll();
            count++;
            if(p.left != null){
                queue.offer(p.left);
            }
            if(p.right != null){
                queue.offer(p.right);
            }
        }
        return count;
    }
}
