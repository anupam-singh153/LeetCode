/*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/

class Solution {
    public Node flatten(Node head) {

        if (head == null)
            return head;
        Node temp = head;

        while (temp != null) {

            if (temp.child == null)
                temp = temp.next;

            else {
                Node nextNode = temp.next;
                Node childHead = flatten(temp.child);

                childHead.prev = temp;
                temp.next = childHead;
                temp.child = null;

                while (temp.next != null)
                    temp = temp.next;

                if (nextNode != null) {
                    temp.next = nextNode;
                    nextNode.prev = temp;
                }
            }
        }

        return head;
    }
}
