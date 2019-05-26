/**
 * 23.Merge k Sorted Lists
 *    Hard
 * Description:
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 *
 * Example:
 * Input:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * Output: 1->1->2->3->4->4->5->6
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
    public ListNode mergeKLists(ListNode[] lists) {
        Queue<ListNode> queue = new PriorityQueue<ListNode>(new Comparator<ListNode>(){
            public int compare(ListNode l1, ListNode l2){
                return l1.val - l2.val;
            }
        });
        for(int i = 0; i < lists.length; i++){
            ListNode list = lists[i];
            while(list != null){
                queue.offer(list);
                list = list.next;
            }
        }
        ListNode result = queue.poll(), p = result;
        while(p != null){
            p.next = queue.poll();
            p = p.next;
        }
        return result;
    }
}
