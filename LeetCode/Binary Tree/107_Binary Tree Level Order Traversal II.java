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
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> list = new ArrayList<Integer>();
        if(root == null){
            return result;
        }
        int num = 1, nextNum = 0;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        while(num != 0){
            TreeNode temp = queue.poll();
            list.add(temp.val);
            num--;
            if(temp.left != null){
                queue.offer(temp.left);
                nextNum++;
            }
            if(temp.right != null){
                queue.offer(temp.right);
                nextNum++;
            }
            if(num == 0){
                num = nextNum;
                nextNum = 0;
                result.add(0, new ArrayList<>(list));
                list.clear();
            }
        }
        return result;
    }
}
