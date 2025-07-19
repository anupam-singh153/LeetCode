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

    private final int MIN = Integer.MIN_VALUE;
    private final int MAX = Integer.MAX_VALUE;

    public boolean isEvenOddTree(TreeNode root) {

        boolean isEven = true;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int prev;

            if (isEven)
                prev = MIN;

            else
                prev = MAX;

            for (int i = 1; i <= levelSize; ++i) {
                TreeNode node = queue.poll();

                if (isEven && (node.val <= prev || node.val % 2 == 0))
                    return false;

                if (!isEven && (node.val >= prev || node.val % 2 == 1))
                    return false;

                prev = node.val;

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }

            isEven = !isEven;
        }

        return true;
    }
}
