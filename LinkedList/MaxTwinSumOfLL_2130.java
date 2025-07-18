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

    private ListNode reverse(ListNode head) {

        if (head == null || head.next == null)
            return head;

        ListNode newHead = reverse(head.next);
        head.next.next = head;

        return newHead;
    }

    public int pairSum(ListNode head) {

        ListNode slow = head;
        ListNode fast = head.next;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        fast = slow.next;
        slow.next = null;
        fast = reverse(fast);

        ListNode temp1 = head;
        ListNode temp2 = fast;

        int result = 0;
        while (temp1 != null && temp2 != null) {

            result = Math.max(result, temp1.val + temp2.val);
            temp1 = temp1.next;
            temp2 = temp2.next;
        }

        return result;
    }
}
