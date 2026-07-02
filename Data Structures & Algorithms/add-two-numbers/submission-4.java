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
        ListNode head1 = l1;
        ListNode head2 = l2;

        if(head1==null)return head2;
        if(head2==null)return head1;

        ListNode resList=new ListNode();
        ListNode reshead=resList;
        int carry =0;
        while(head1!=null && head2!=null){
            int val1=head1.val;
            int val2=head2.val;

            int res=val1+val2;
            
            resList.next=new ListNode((res%10)+carry);
            res=res/10;
            if(res>0){
                carry=res;
            }else{
                carry=0;
            }
            resList=resList.next;
            head1=head1.next;
            head2=head2.next;
        }
        while(head1!=null){
            int res=head1.val+carry;
            resList.next=new ListNode((res%10));
            res=res/10;
            if(res>0){
                carry=res;
            }else{
                carry=0;
            }
            resList=resList.next;
            head1=head1.next;
        }

        while(head2!=null){
            int res=head2.val+carry;
            resList.next=new ListNode((res%10));
            res=res/10;
            if(res>0){
                carry=res;
            }else{
                carry=0;
            }
            resList=resList.next;
            head2=head2.next;
        }
        if(carry>0){
            resList.next=new ListNode(carry);
        }
        
        return reshead.next;

    }
    
}
