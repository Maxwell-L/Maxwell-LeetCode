/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        ListNode *slow = head;
        ListNode *fast = head;
        while(fast != NULL){
            slow = slow -> next;
            fast = fast -> next == NULL ? NULL : fast -> next -> next;
            if(fast == NULL){
                return NULL;
            }
            if(slow == fast){
                ListNode *slow2 = head;
                while(slow2 != slow){
                    slow2 = slow2 -> next;
                    slow = slow -> next;
                }
                return slow;
            }
        }
        return NULL;
        
    }
};