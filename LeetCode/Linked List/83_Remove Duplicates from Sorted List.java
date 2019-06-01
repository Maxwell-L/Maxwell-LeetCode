/**
 * 83.Remove Duplicates from Sorted List
 *    Easy
 * Description:
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 *
 * Example 1:
 * Input: 1->1->2
 * Output: 1->2
 *
 * Example 2:
 * Input: 1->1->2->3->3
 * Output: 1->2->3
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }   
        int num = head.val;
        ListNode p = head, q = head.next;
        while(q != null){
            if(q.val == num){
                p.next = q.next;
            }
            else{
                num = q.val;
                p = q;
            }
            q = p.next;
        }
        return head;
    }
}
