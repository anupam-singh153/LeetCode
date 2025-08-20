/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {

        List<List<Integer>> ans = new ArrayList<>();

        if (root == null)
            return ans;

        Queue<Node> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> row = new ArrayList<>();
            int levelSize = queue.size();

            for (int i = 0; i < levelSize; ++i) {
                root = queue.poll();
                row.add(root.val);

                for (Node child : root.children) {
                    queue.add(child);
                }
            }
            ans.add(row);
        }
        return ans;
    }
}
