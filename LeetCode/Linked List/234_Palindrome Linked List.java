/**
 * 234.Palindrome Linked List
 *     Easy
 * Description:
 * Given a singly linked list, determine if it is a palindrome.
 *
 * Example 1:
 * Input: 1->2
 * Output: false
 *
 * Example 2:
 * Input: 1->2->2->1
 * Output: true
 *
 * Follow up:
 * Could you do it in O(n) time and O(1) space?
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
    public boolean isPalindrome(ListNode head) {
        if(head == null || head.next == null){
            return true;
        }
        ListNode node = new ListNode(0);
        node.next = head;
        ListNode slow = node, fast = node, temp = null;
        int len = 0;
        while(fast != null && fast.next != null){
            temp = slow;
            slow = slow.next;
            len = fast.next.next == null ? len + 1 : len + 2;
            fast = fast.next.next;
        }
        fast = slow.next;
        if(len % 2 == 1){
            temp.next = null;
        }
        else{    
            slow.next = null;
        }
        ListNode a = head, b = head.next, c = null;
        a.next = null;
        while(b != null){
            c = b.next;
            b.next = a;
            a = b;
            b = c;
        }
        slow = a;
        while(slow != null){
            if(slow.val != fast.val){
                return false;
            }
            slow = slow.next;
            fast = fast.next;
        }
        return true;
    }
}
