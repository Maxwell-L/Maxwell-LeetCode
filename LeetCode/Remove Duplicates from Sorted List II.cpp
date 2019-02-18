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
        if(!head || !head -> next){
            return head;
        }
        ListNode myHead = ListNode(-1);
        ListNode *temp = &myHead, *a = head, *b = head -> next;
        int flag = 1;
        while(b != NULL){
            if(flag == 1 && a -> val != b -> val){
                temp -> next = a;
                temp = temp -> next;   
            }
            else{
                flag = flag == 0 && a -> val == b -> val ? flag : 1 - flag;
            }
            a = a -> next;
            b = b -> next;
        }
        temp -> next = flag == 1 ? a : NULL;
        return myHead.next;
    }
};
