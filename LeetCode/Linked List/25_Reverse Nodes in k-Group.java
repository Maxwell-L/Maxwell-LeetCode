/**
 * 25.Reverse Nodes in k-Group
 *    Hard
 * Description:
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * k is a positive integer and is less than or equal to the length of the linked list. 
 * If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.
 *
 * Example:
 * Given this linked list: 1->2->3->4->5
 * For k = 2, you should return: 2->1->4->3->5
 * For k = 3, you should return: 3->2->1->4->5
 * Note:
 * Only constant extra memory is allowed.
 * You may not alter the values in the list's nodes, only nodes itself may be changed.
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null || head.next == null || k < 2){
            return head;
        }
        ListNode result = new ListNode(0);
        result.next = head;
        ListNode p = result, a = head, b = a.next, c = null;
        int len = 0;
        while(p.next != null){
            len = p.next.next != null ? len + 2 : len + 1;
            p = p.next.next != null ? p.next.next : p.next;
        }
        int time = len / k;
        p = result;
        while(time-- > 0){
            int count = 1;
            while(count++ < k){
                c = b.next;
                b.next = a;
                a = b;
                b = c;
            }
            c = p.next;
            p.next.next = b;
            p.next = a;
            p = c;
            a = b;
            b = a != null ? a.next : null;
        }
        return result.next;
    }
}
