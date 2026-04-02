/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head.next==null && n==1 )return null;
        int num=0;
        ListNode curr=head;
        while(curr!=null){
            num++;
            curr=curr.next;
            
        }
        if(num==n)return head.next;

        int targetIndex = num-n-1;
        
        ListNode tmp=head;
        for(int i=0;i<targetIndex;i++){
            tmp=tmp.next;
        }

        tmp.next=tmp.next.next;
        return head;
    }
}
