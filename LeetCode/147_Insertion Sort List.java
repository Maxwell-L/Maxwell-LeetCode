/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head, cur = head.next;
        while(cur != null){
            ListNode p = null, q = head;
            while(q != cur && q.val < cur.val){
                p = q;
                q = q.next;
            }
            if(q == cur){
                pre = cur;
                cur = cur.next;
            }
            else{
                pre.next = cur.next;
                cur.next = q;
                if(p != null){    
                    p.next = cur;
                }
                else{
                    head = cur;    
                }
                cur = pre.next;
            }
        }
        return head;   
    }
}
