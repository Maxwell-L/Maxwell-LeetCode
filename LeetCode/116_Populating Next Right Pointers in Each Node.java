/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root == null || (root.left == null && root.right == null)){
            return root;
        }
        int count = 1;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        Node p = null;
        while(queue.peek() != null){
            int i = count;
            while(i != 0){
                i--;
                p = queue.poll();
                p.next = i == 0 ? null : queue.peek();
                if(p.left != null){
                    queue.offer(p.left);
                    queue.offer(p.right);
                }
            }
            count *= 2;
        }
        return root;
    }
}
