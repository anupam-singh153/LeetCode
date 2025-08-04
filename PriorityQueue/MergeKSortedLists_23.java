class Solution {
    public ListNode mergeKLists(ListNode[] lists) {

        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.val, b.val));

        for (ListNode list : lists) {
            ListNode node = list;
            while (node != null) {

                ListNode temp = node;
                node = node.next;
                temp.next = null;

                pq.add(temp);
            }
        }

        ListNode head = new ListNode(-1);
        ListNode temp = head;

        while (!pq.isEmpty()) {
            temp.next = pq.poll();
            temp = temp.next;
        }

        return head.next;
    }
}
