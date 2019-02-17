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
    ListNode* swapPairs(ListNode* head) {
        if(head == NULL || head -> next == NULL){
            return head;
        }
        ListNode *a, *b, *c, *d;
        a = head -> next;
        head -> next = head -> next -> next;
        a -> next = head;
        head = a;
        a = head -> next;
        b = a -> next;
        c = b == NULL ? NULL : b -> next;
        while(b != NULL && c != NULL){
            d = c -> next;
            c -> next = b;
            b -> next = d;
            a -> next = c;
            a = b;
            b = d;
            c = d == NULL ? NULL : d -> next;
        }
        return head;
    }
};
