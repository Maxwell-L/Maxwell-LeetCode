/**
 * 147.Insertion Sort List
 *     Medium
 * Description:
 * Sort a linked list using insertion sort.
 * Algorithm of Insertion Sort:
 * 1.Insertion sort iterates, consuming one input element each repetition, and growing a sorted output list.
 * 2.At each iteration, insertion sort removes one element from the input data, finds the location it belongs within the sorted list, and inserts it there.
 * 3.It repeats until no input elements remain.
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
    public ListNode insertionSortList(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode pre = head, cur = head.next;
        while(cur != null){
            ListNode p = null, q = head;
            while(q != cur && q.val < cur.val){
                p = q;
                q = q.next;
            }
            if(q == cur){
                pre = cur;
                cur = cur.next;
            }
            else{
                pre.next = cur.next;
                cur.next = q;
                if(p != null){    
                    p.next = cur;
                }
                else{
                    head = cur;    
                }
                cur = pre.next;
            }
        }
        return head;   
    }
}
