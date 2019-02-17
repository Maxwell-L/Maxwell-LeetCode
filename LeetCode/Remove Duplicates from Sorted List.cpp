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
    ListNode* deleteDuplicates(ListNode* head) {
        ListNode *a, *b;
        a = head;
        int len = 0;
        while(a != NULL){
            a = a -> next;
            len++;
        }
        if(len == 0 || len == 1){
            return head;
        }
        a = head;
        b = a -> next;
        while(b != NULL){
            if(b -> val != a -> val){
                a = b;
                b = b -> next;
            }
            else{
                a -> next = b -> next;
                b = b -> next;
            }
        }
        return head;
    }
};