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
    bool isPalindrome(ListNode* head) {
        if(head == NULL || head -> next == NULL){
            return true;
        }
        int len = 0;
        ListNode *a = head, *b = head -> next, *c;
        while(a != NULL){
            len++;
            a = a -> next;
        }
        a = head;
        a -> next = NULL;
        for(int i = 0; i < len / 2 - 1; i++){
            c = b -> next;
            b -> next = a;
            a = b;
            b = c;
        }
        b = len % 2 == 0 ? b : b -> next;
        while(a != NULL){
            if(a -> val != b -> val){
                return false;
            }
            a = a -> next;
            b = b -> next;
        }
        return true;
    }
};