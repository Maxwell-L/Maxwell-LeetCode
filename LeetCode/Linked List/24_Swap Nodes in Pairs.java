/**
 * 24.Swap Nodes in Pairs
 *    Medium
 * Description:
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 * Example:
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode p = result, temp = null;
        while(p.next != null && p.next.next != null){
            temp = p.next;
            p.next = temp.next;
            temp.next = p.next.next;
            p.next.next = temp;
            p = p.next.next;
        }
        return result.next;
    }
}
