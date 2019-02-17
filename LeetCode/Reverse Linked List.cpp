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
    ListNode* reverseList(ListNode* head) {
        if(head == NULL){
            return NULL;
        }
        ListNode *a, *b, *c;
        a = head;
        b = a -> next;
        a -> next = NULL;
        while(b != NULL){
            c = b -> next;
            b -> next = a;
            a = b;
            b = c;
        }
        head = a;
        return head;
    }
};
