/**
 * 203.Remove Linked List Elements
 *     Easy
 * Description:
 * Remove all elements from a linked list of integers that have value val.
 *
 * Example:
 * Input:  1->2->6->3->4->5->6, val = 6
 * Output: 1->2->3->4->5
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
    public ListNode removeElements(ListNode head, int val) {
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode p = result, q = head;
        while(q != null){
            if(q.val != val){
                p.next = q;
                p = p.next;
            }
            q = q.next;
        }
        p.next = null;
        return result.next;
    }
}
