/** 
 * 160.Intersection of Two Linked Lists
 *     Easy
 * Description:
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 *  A:		 a1 -> a2
 *					 \
 *					  c1 -> c2 -> c3
 *					 /
 *  B: b1 -> b2 -> b3
 * begin to intersect at node c1.
 * 
 * Example 1:
 *  A: 		 4 -> 1
 *  			   \
 *					8 -> 4 -> 5
 *				   /
 *  B:	5 -> 0 -> 1
 * Input: intersectVal = 8, listA = [4,1,8,4,5], listB = [5,0,1,8,4,5], skipA = 2, skipB = 3
 * Output: Reference of the node with value = 8
 * Input Explanation: The intersected node's value is 8 (note that this must not be 0 if the two lists intersect). 
 * From the head of A, it reads as [4,1,8,4,5]. From the head of B, it reads as [5,0,1,8,4,5]. 
 * There are 2 nodes before the intersected node in A; There are 3 nodes before the intersected node in B.
 *
 * Example 2:
 *  A:	0 -> 9 -> 1
 *				   \
 *					2 -> 4
 *				   /
 *	B:			  3
 * Input: intersectVal = 2, listA = [0,9,1,2,4], listB = [3,2,4], skipA = 3, skipB = 1
 * Output: Reference of the node with value = 2
 * Input Explanation: The intersected node's value is 2 (note that this must not be 0 if the two lists intersect). 
 * From the head of A, it reads as [0,9,1,2,4]. From the head of B, it reads as [3,2,4]. 
 * There are 3 nodes before the intersected node in A; There are 1 node before the intersected node in B.
 *
 * Example 3:
 * 	A:	2 -> 6 -> 4
 *
 *	B:		 1 -> 5
 * Input: intersectVal = 0, listA = [2,6,4], listB = [1,5], skipA = 3, skipB = 2
 * Output: null
 * Input Explanation: From the head of A, it reads as [2,6,4]. 
 * From the head of B, it reads as [1,5]. Since the two lists do not intersect, 
 * intersectVal must be 0, while skipA and skipB can be arbitrary values.
 * Explanation: The two lists do not intersect, so return null.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = 0, lenB = 0;
        ListNode nodeA = new ListNode(0), nodeB = new ListNode(0);
        nodeA.next = headA;
        nodeB.next = headB;
        ListNode p = nodeA, q = nodeB;
        while(p != null && p.next != null){
            lenA = p.next.next != null ? lenA + 2 : lenA + 1;
            p = p.next.next;
        }
        while(q != null && q.next != null){
            lenB = q.next.next != null ? lenB + 2 : lenB + 1;
            q = q.next.next;
        }
        if(lenA > lenB){
            return getIntersectionNode(headB, headA);
        }
        p = nodeA;
        q = nodeB;
        while(lenB > lenA){
            q = q.next;
            lenB--;
        }
        while(p != q){
            p = p.next;
            q = q.next;
        }
        return p;
    }
}
