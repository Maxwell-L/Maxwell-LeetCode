/**
 * 148.Sort List
 *     Medium
 * Description:
 * Sort a linked list in O(n log n) time using constant space complexity.
 * 
 * Example 1:
 * Input: 4->2->1->3
 * Output: 1->2->3->4
 * 
 * Example 2:
 * Input: -1->5->3->4->0
 * Output: -1->0->3->4->5
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
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode slow = temp, fast = temp;
        while(fast.next != null){
            slow = slow.next;
            fast = fast.next.next != null ? fast.next.next : fast.next;
        }
        fast = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(fast);
        ListNode result = new ListNode(0), p = result;
        while(left != null && right != null){
            if(left.val <= right.val){
                p.next = left;
                left = left.next;
            }
            else{
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        p.next = left == null ? right : left;
        return result.next;
    }
}
