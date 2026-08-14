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
        PriorityQueue<ListNode> pq=new PriorityQueue<>((a,b)->{
                return a.val-b.val;
        });
        for(int i=0;i<lists.length;i++){
            pq.add(lists[i]);
        }
        ListNode ll=new ListNode(0);
        ListNode res=ll;
        while(!pq.isEmpty()){
            ListNode tmp=pq.poll();
            ll.next=tmp;
            ll=ll.next;
            if(tmp.next!=null)
                pq.add(tmp.next);
        }
        return res.next;
    }
}
