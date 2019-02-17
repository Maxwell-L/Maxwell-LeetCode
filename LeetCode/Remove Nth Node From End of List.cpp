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
    ListNode* removeNthFromEnd(ListNode* head, int n) {
        if(head == NULL){
            return NULL;
        }
        ListNode *p;
        int len = 0;
        p = head;
        while(p != NULL){
            p = p -> next;
            len++;
        }
        if(len == 1){
            return NULL;
        }
        p = head;
        int removePos = len - n;
        if(removePos == 0){
            return head -> next;
        }
        for(int i = 0; i < removePos - 1; i++){
            p = p->next;
        }
        p->next = p->next->next;
        return head;
    }
};
