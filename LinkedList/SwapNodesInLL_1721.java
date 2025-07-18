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
    public ListNode swapNodes(ListNode head, int k) {

        ListNode last = head;
        ListNode fast = head;

        while (k > 1) {
            k--;
            fast = fast.next;
        }

        ListNode first = fast;

        while (fast.next != null) {
            last = last.next;
            fast = fast.next;
        }

        int temp = first.val;
        first.val = last.val;
        last.val = temp;

        return head;
    }
}
