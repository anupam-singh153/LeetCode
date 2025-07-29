class Solution {

    private ListNode reverse(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;

        return newHead;
    }

    public boolean isPalindrome(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        slow.next = null;
        ListNode head2 = reverse(fast);

        slow = head2;
        fast = head;

        while (slow != null && fast != null) {

            if (slow.val != fast.val)
                return false;

            slow = slow.next;
            fast = fast.next;
        }

        return true;
    }
}
