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

        int sum = 0;
        int carry = 0;

        ListNode head = new ListNode(-1);
        ListNode temp = head;

        while (l1 != null || l2 != null || carry > 0) {

            sum += carry;
            carry = 0;

            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }
            if (l2 != null) {
                sum += l2.val;s
                l2 = l2.next;
            }

            temp.next = new ListNode(sum % 10);
            temp = temp.next;
            carry = sum / 10;
            sum = 0;
        }

        return head.next;
    }
}
