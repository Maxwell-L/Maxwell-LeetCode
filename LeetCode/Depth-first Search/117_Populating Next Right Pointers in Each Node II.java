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
        int n = 1, nextN = 0;
        Queue<Node> queue = new LinkedList<Node>();
        queue.offer(root);
        Node p = root;
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
                n = nextN;
                nextN = 0;
            }
            else{
                p.next = queue.peek();
            }
        }
        return root;
    }
}
