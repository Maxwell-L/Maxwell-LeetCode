/**
 * 61.Rotate List
 *    Medium
 * Description:
 * Given a linked list, rotate the list to the right by k places, where k is non-negative.
 *
 * Example1:
 * Input: 1->2->3->4->5->NULL, k = 2
 * Output: 4->5->1->2->3->NULL
 * Explanation:
 * rotate 1 steps to the right: 5->1->2->3->4->NULL
 * rotate 2 steps to the right: 4->5->1->2->3->NULL 
 *
 * Example 2:
 * Input: 0->1->2->NULL, k = 4
 * Output: 2->0->1->NULL
 * Explanation:
 * rotate 1 steps to the right: 2->0->1->NULL
 * rotate 2 steps to the right: 1->2->0->NULL
 * rotate 3 steps to the right: 0->1->2->NULL
 * rotate 4 steps to the right: 2->0->1->NULL
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode p = new ListNode(0);
        p.next = head;
        ListNode slow = p, fast = p;
        int lenSlow = 0, lenFast = 0;
        while(fast.next != null){
            lenSlow++;
            slow = slow.next;
            lenFast = fast.next.next == null ? lenFast+1 : lenFast+2;
            fast = fast.next.next == null ? fast.next : fast.next.next;
        }
        k = k % lenFast;
        if(k == 0){
            return head;
        }
        int sub = lenFast - lenSlow;
        if(sub > k){
            while(sub > k){
                slow = slow.next;
                sub--;
            }    
        }
        else{
            slow = p;
            while(lenFast > k){
                slow = slow.next;
                lenFast--;
            }
        }
        p.next = slow.next;
        slow.next = null;
        fast.next = head;
        return p.next;
    }
}