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
    ListNode* rotateRight(ListNode* head, int k) {
        if(head == NULL || k == 0){
            return head;
        }
        ListNode *end, *pre, *a, *b, *c;
        int len = 0;
        a = head;
        while(a != NULL){
            a = a -> next;
            len++;
        }
        if(len == 1){
            return head;
        }
        if(k > len){
            return rotateRight(head, k % len);
        }
        a = head;
        b = a -> next;
        c = b == NULL ? NULL : b -> next;
        while(c != NULL){
            a = a -> next;
            b = a -> next;
            c = b -> next;
        }
        pre = a;
        end = b;
        pre -> next = NULL;
        end -> next = head;
        head = end;
        return rotateRight(head, k-1);
    }
};
