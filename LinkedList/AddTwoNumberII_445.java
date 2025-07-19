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

        ListNode curr = head, prev = null, nextNode = null;

        while (curr != null) {

            nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }

        return prev;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head1 = l1 = reverse(l1);
        ListNode head2 = l2 = reverse(l2);

        int carry = 0;
        ListNode temp, dummy;
        temp = dummy = new ListNode(-1);

        while ((l1 != null && l2 != null) || carry > 0) {

            if (l1 != null) {
                carry += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                carry += l2.val;
                l2 = l2.next;
            }

            temp.next = new ListNode(carry % 10);
            carry /= 10;
            temp = temp.next;
        }

        if (l1 != null)
            temp.next = l1;

        if (l2 != null)
            temp.next = l2;

        return reverse(dummy.next);
    }
}
