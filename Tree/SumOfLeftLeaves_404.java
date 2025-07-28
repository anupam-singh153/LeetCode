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

    private boolean isLeaf(TreeNode root) {

        if (root != null && root.left == null && root.right == null)
            return true;

        return false;
    }

    public int sumOfLeftLeaves(TreeNode root) {

        if (root == null)
            return 0;

        int sum = 0;

        if (isLeaf(root.left))
            sum += root.left.val;

        return sum + sumOfLeftLeaves(root.left) + sumOfLeftLeaves(root.right);
    }
}
