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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if(root != null){
            Queue<TreeNode> queue = new LinkedList<TreeNode>();
            queue.offer(root);
            TreeNode p = root;
            int n = 1, nextN = 0;
            while(queue.peek() != null){
                p = queue.poll();
                n--;
                if(p.left != null){
                    nextN++;
                    queue.offer(p.left);
                }
                if(p.right != null){
                    nextN++;
                    queue.offer(p.right);
                }
                if(n == 0){
                    result.add(p.val);
                    n = nextN;
                    nextN = 0;
                }
            }
        }
        return result;
    }
}
