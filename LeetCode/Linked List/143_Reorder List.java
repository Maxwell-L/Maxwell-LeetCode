/**
 * 143.Reorder List
 *     Medium
 * Description:
 * Given a singly linked list L: L0→L1→…→Ln-1→Ln,
 * reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 * 
 * Example 1:
 * Given 1->2->3->4, reorder it to 1->4->2->3.
 * 
 * Example 2:
 * Given 1->2->3->4->5, reorder it to 1->5->2->4->3.
 */
 
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null || head.next.next == null){
            return;
        }
        ListNode slow = head, fast = head;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next.next == null ? fast.next : fast.next.next;
        }
        ListNode a = slow.next, b = a.next, c = b;
        slow.next = null;
        a.next = null;
        while(b != null){
            c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        b = head;
        ListNode result = new ListNode(0);
        while(a != null || b != null){
            if(b != null){
                result.next = b;
                b = b.next;
                result = result.next;
            }
            if(a != null){
                result.next = a;
                a = a.next;
                result = result.next;
            }
        }    
    }
}
