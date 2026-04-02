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
    public ListNode mergeKLists(ListNode[] lists) {
        int n=lists.length;
        if (lists == null || n == 0) return null;
        if (n == 1) return lists[0];

        for(int i=1;i<n;i++){
            lists[i]=mergeTwo(lists[i-1],lists[i]);
        }
        return lists[n-1];
    }      

        private ListNode mergeTwo(ListNode l1, ListNode l2) {
            ListNode res=new ListNode();
            ListNode curr=res;
            while(l1!=null && l2!=null){
                if(l1.val<l2.val){
                    res.next=l1;
                    l1=l1.next;
                }else{
                    res.next=l2;
                    l2=l2.next;
                }
                res=res.next;
            }
            if(l1==null){
                res.next=l2;
            }
            if(l2==null){
                res.next=l1;
            }
            return curr.next;
        }
}
