/**
 * 92.Reverse Linked List II
 *    Medium
 * Description:
 * Reverse a linked list from position m to n. Do it in one-pass.
 * Note: 1 ≤ m ≤ n ≤ length of list.
 * 
 * Example:
 * Input: 1->2->3->4->5->NULL, m = 2, n = 4
 * Output: 1->4->3->2->5->NULL
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
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode result = new ListNode(0);
        int count = 0;
        ListNode p = result, pre = null;
        result.next = head;
        while(count < m){
            pre = p;
            p = p.next;
            count++;
        }
        ListNode b = p.next, c = null;
        while(count < n){
            c = b.next;
            b.next = p;
            p = b;
            b = c;
            count++;
        }
        pre.next.next = b;
        pre.next = p;
        return result.next;
    }
}
