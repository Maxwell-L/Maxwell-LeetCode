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
    ListNode* middleNode(ListNode* head) {
        int len = 0;
        ListNode *a = head;
        while(a != NULL){
            len++;
            a = a -> next;
        }
        for(int i = 0; i < len / 2; i++){
            head = head -> next;
        }
        return head;
    }
};