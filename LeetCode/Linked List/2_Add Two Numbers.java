/**
 * 2.Add Two Numbers
 *   Medium
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode p = head, u = l1, v = l2;
        int sum = 0;
        while(u != null || v != null){
            sum /= 10;
            if(u != null){
                sum += u.val;
                u = u.next;
            }
            if(v != null){
                sum += v.val;
                v = v.next;
            }
            p.next = new ListNode(sum % 10);
            p = p.next;
        }
        if(sum / 10 == 1){
            p.next = new ListNode(1);
        }
        return head.next;
    }
}
