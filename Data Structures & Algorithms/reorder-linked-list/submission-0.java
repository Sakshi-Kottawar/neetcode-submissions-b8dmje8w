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
    public void reorderList(ListNode head) {
        ListNode slow=head,fast=head,temp=head;
        while(fast.next!=null && fast.next.next!=null )
        {
            slow=slow.next;
            fast=fast.next.next;
        }
        ListNode secondHalf=reverse(slow.next);
        slow.next=null;
        
        ListNode first=head;
        while(secondHalf!=null){
            ListNode nextFirst=first.next;
            ListNode nextSecond=secondHalf.next;

            first.next=secondHalf;
            secondHalf.next=nextFirst;

            first=nextFirst;
            secondHalf=nextSecond;

        }

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
