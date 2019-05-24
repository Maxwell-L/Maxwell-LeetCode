/** 
 * 86.Partition List
 *    Medium
 * Description:
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 * 
 * Example:
 * Input: head = 1->4->3->2->5->2, x = 3
 * Output: 1->2->2->4->3->5
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
    public ListNode partition(ListNode head, int x) {
        ListNode less = new ListNode(0), greatOrEq = new ListNode(0);
        ListNode p = less, q = greatOrEq, iter = head;
        while(iter != null){
            if(iter.val < x){
                p.next = iter;
                p = p.next;
            }
            else{
                q.next = iter;
                q = q.next;
            }
            ListNode temp = iter.next;
            iter.next = null;
            iter = temp;
        }
        p.next = greatOrEq.next;
        return less.next;
    }
}
