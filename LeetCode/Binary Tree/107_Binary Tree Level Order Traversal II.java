/**
 * 107.Binary Tree Level Order Traversal II
 *     Easy
 * Description:
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values. 
 * (ie, from left to right, level by level from leaf to root).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 * return its bottom-up level order traversal as:
 * [
 *   [15,7],
 *   [9,20],
 *   [3]
 * ]
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
