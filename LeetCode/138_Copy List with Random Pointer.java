/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        Node result = head == null ? null : new Node(head.val, null, null), p = result, q = head;
        HashMap<Node, Node> hashmap = new HashMap<Node, Node>();
        while(q != null){
            if(hashmap.get(q) == null){
                hashmap.put(q, p);
            }
            if(q.next != null){
                if(hashmap.get(q.next) == null){
                    p.next = new Node(q.next.val, null, null);
                    hashmap.put(q.next, p.next);
                }
                else{
                    p.next = hashmap.get(q.next);
                }
            }
            if(q.random != null){
                if(hashmap.get(q.random) == null){
                    p.random = new Node(q.random.val, null, null);
                    hashmap.put(q.random, p.random);
                }
                else{
                    p.random = hashmap.get(q.random);
                }
            }
            p = p.next;
            q = q.next;
        }
        return result;    
    }
}
