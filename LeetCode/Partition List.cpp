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
    ListNode* partition(ListNode* head, int x) {
        if(head == NULL || head -> next == NULL){
            return head;
        }
        ListNode headS = ListNode(-1);
        ListNode headB = ListNode(-1);
        ListNode *tempS = &headS, *tempB = &headB, *a = head;
        while(a != NULL){
            if(a -> val < x){
                tempS -> next = a;
                tempS = tempS -> next;
            }
            else{
                tempB -> next = a;
                tempB = tempB -> next;
            }
            a = a -> next;
        }
        tempB -> next = NULL;
        tempS -> next = headB.next;
        return headS.next;   
    }
};