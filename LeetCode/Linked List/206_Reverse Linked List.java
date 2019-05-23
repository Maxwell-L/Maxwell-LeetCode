/**
 * 206.Reverse Linked List
 *     Easy
 * Description:
 * Reverse a singly linked list.
 *
 * Example:
 * Input: 1->2->3->4->5->NULL
 * Output: 5->4->3->2->1->NULL
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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode a = null, b = head, c = head;
        while(b != null){
            c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        return a;
    }
}