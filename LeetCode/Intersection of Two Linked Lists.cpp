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
    ListNode *getIntersectionNode(ListNode *headA, ListNode *headB) {
        ListNode *a = headA, *b = headB;
        int lenA = 0, lenB = 0;
        while(a != NULL || b != NULL){
            if(a){
                lenA++;
                a = a -> next;
            }
            if(b){
                lenB++;
                b = b -> next;
            }
        }
        ListNode *longHead = lenA > lenB ? headA : headB;
        ListNode *shortHead = lenA > lenB ? headB : headA;
        for(int i = 0; i < abs(lenA - lenB); i++){
            longHead = longHead -> next;
        }
        while(longHead != NULL){
            if(longHead == shortHead){
                return longHead;
            }
            longHead = longHead -> next;
            shortHead = shortHead -> next;
        }
        return NULL;
    }
};