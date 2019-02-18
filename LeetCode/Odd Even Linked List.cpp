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
    ListNode* oddEvenList(ListNode* head) {
        if(head == NULL || head -> next == NULL){
            return head;
        }
        ListNode *evenHead, *a, *b;
        a = head;
        evenHead = head -> next;
        b = evenHead;
        while(a != NULL && b != NULL){
            if(a -> next -> next != NULL){
                a -> next = a -> next -> next;
                a = a -> next;
            }    
            b -> next = b -> next == NULL ? NULL : b -> next -> next;
            b = b -> next;
        }
        a -> next = evenHead;
        return head;
    }
};