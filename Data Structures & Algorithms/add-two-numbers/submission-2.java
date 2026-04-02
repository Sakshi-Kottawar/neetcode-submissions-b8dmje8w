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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
         l1=reverse(l1);
         l2=reverse(l2);
         int n1=0;
         while(l1!=null){
            n1=n1*10+l1.val;
            l1=l1.next;
         }
         int n2=0;
         while(l2!=null){
            n2=n2*10+l2.val;
            l2=l2.next;
         }
         int n=n1+n2;
         if(n==0)return new ListNode(0);
         ListNode res=new ListNode();
         ListNode head=res;
         while(n>0){
            res.next=new ListNode(n%10);
            res=res.next;
            n=n/10;
         }
        return head.next;
        // return new ListNode(;
    }
    public ListNode reverse(ListNode head){
        ListNode curr=head;
        ListNode prev=null,next=null;

        while(curr!=null){
            next=curr.next;
            curr.next=prev;
            prev=curr;
            curr=next;
        }
        return prev;
    }
}
