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
    public boolean hasCycle(ListNode head) {
        if(head==null || head.next==null )return false;

        ListNode slow =head;
        ListNode fast =head.next;
        while(slow!=fast){
            if(slow.next!=null)
                slow=slow.next;
            else
                return false;
            if(fast.next!=null && fast.next.next!=null)
                fast=fast.next.next;
            else
                return false;
        }
        return true;
    }
}
