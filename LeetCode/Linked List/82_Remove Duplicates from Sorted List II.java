/**
 * 82.Remove Duplicates from Sorted List II
 *    Medium
 * Description:
 * Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.
 * 
 * Example 1:
 * Input: 1->2->3->3->4->4->5
 * Output: 1->2->5
 *
 * Example 2:
 * Input: 1->1->1->2->3
 * Output: 2->3
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
        ListNode result = new ListNode(0);
        ListNode p = result, a = head, b = head.next;
        p.next = head;
        Integer record = null;
        while(a != null){
            if((b != null && a.val == b.val) || (record != null && a.val == record)){
                p.next = b;    
            }
            else{
                p = p.next;    
            }
            record = a.val;
            a = b;
            b =  b == null ? null : b.next;
        }
        return result.next;
    }
}
