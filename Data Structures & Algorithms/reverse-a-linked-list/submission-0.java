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
    public ListNode reverseList(ListNode head) {
        if(head==null || head.next==null)return head;
        ListNode i=head.next;
        ListNode j=null;
        ListNode k=head;
        int h=0;
        while(i!=null){
            k.next=j;
            j=k;
            k=i;
            i=i.next;   
        }
        k.next=j;
        return k;
    }
}
