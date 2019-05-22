/**
 * 19.Remove Nth Node From End of List
 *    Medium
 * Description:
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 * Given linked list: 1->2->3->4->5, and n = 2.
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null){
            return null;
        }
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode slow = p, fast = p;
        int indexSlow = 0, indexFast = 0;
        while(fast != null){
            indexSlow++;
            slow = slow.next;
            if(fast.next == null){
                break;
            }
            fast = fast.next.next;
            indexFast = fast == null ? indexFast+1 : indexFast+2;
        }
        int sub = indexFast - indexSlow;
        if(sub - n > 0){
            while(sub - n > 0){
                slow = slow.next;
                sub--;
            }
        }
        else{
            slow = p;
            while(indexFast - n > 0){
                slow = slow.next;
                indexFast--;
            }
        }
        slow.next = slow.next.next;
        return p.next;
    }
}
