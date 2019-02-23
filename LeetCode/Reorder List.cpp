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
    void reorderList(ListNode* head) {
        if(head == NULL || head -> next == NULL){
             return;
        }
        else{
            ListNode answer = ListNode(-1);
            ListNode *slow = head, *fast = head, *a, *b, *c, *ans = &answer;
            while(1){
                if(fast -> next == NULL){
                    break;
                }
                if(fast -> next -> next == NULL){
                    fast = fast -> next;
                    break;
                }
                slow = slow -> next;
                fast = fast -> next -> next;
            }
            a = slow -> next;
            slow -> next = NULL;
            b = a -> next;
            a -> next = NULL;
            while(b != NULL){
                c = b -> next;
                b -> next = a;
                a = b;
                b = c;
            }
            b = head;
            while(a != NULL || b != NULL){
                if(b != NULL){
                   ans -> next = b;
                   ans = ans -> next;
                   b = b -> next;
                }
                if(a != NULL){
                    ans -> next = a;
                    ans = ans -> next;
                    a = a -> next;
                }
            }
            head = answer.next;
        }    
    }
};
