/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {

    private static class Pair {
        TreeNode node;
        int sum = 0;

        public Pair(TreeNode node, int sum) {
            this.node = node;
            this.sum = sum;
        }
    }

    public boolean hasPathSum(TreeNode root, int targetSum) {

        Queue<Pair> queue = new LinkedList<>();

        if (root == null)
            return false;

        queue.add(new Pair(root, root.val));

        while (!queue.isEmpty()) {
            Pair p = queue.poll();

            if (p.node.left == null && p.node.right == null) {
                if (p.sum == targetSum)
                    return true;
            }

            if (p.node.left != null)
                queue.add(new Pair(p.node.left, p.sum + p.node.left.val));

            if (p.node.right != null)
                queue.add(new Pair(p.node.right, p.sum + p.node.right.val));
        }

        return false;
    }
}
