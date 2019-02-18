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
    ListNode* removeElements(ListNode* head, int val) {
        if(head == NULL){
            return NULL;
        }
        ListNode *a, *b;
        a = head;
        while(a != NULL){
            if(a -> val == val){
                if(a == head){
                    head = head -> next;
                }
                else{
                    b -> next = a -> next;
                }
            }
            else{
                b = a; 
            }
            a = a -> next;           
        }
        return head;
    }
};