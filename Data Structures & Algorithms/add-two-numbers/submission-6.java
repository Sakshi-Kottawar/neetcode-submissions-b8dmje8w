class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head1 = l1;
        ListNode head2 = l2;

        ListNode resList = new ListNode();
        ListNode reshead = resList;
        int carry = 0;

        // Run as long as there is data in l1, data in l2, or a remaining carry
        while (head1 != null || head2 != null || carry > 0) {
            // Get values safely, using 0 if the list has ended
            int val1 = (head1 != null) ? head1.val : 0;
            int val2 = (head2 != null) ? head2.val : 0;

            int res = val1 + val2 + carry;
            
            resList.next = new ListNode(res % 10);
            carry = res / 10; // Automatically handles 0 or 1 without if-else

            resList = resList.next;

            // Move list pointers forward only if they are not null
            if (head1 != null) head1 = head1.next;
            if (head2 != null) head2 = head2.next;
        }
        
        return reshead.next;
    }
}
