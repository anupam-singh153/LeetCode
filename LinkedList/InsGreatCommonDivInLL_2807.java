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

    private int getGCD(int a, int b) {

        if (a % b == 0)
            return b;

        return getGCD(b, a % b);
    }

    public ListNode insertGreatestCommonDivisors(ListNode head) {

        ListNode dummy = new ListNode(-1);
        ListNode temp = dummy;

        while (head != null && head.next != null) {

            temp.next = head;
            int gcd = getGCD(head.val, head.next.val);
            head = head.next;

            temp.next.next = new ListNode(gcd);
            temp = temp.next.next;
        }

        temp.next = head;

        return dummy.next;
    }
}