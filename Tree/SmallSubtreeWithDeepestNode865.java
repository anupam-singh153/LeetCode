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

    private int height(TreeNode root) {

        if (root == null)
            return 0;

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public TreeNode subtreeWithAllDeepest(TreeNode root) {

        while (true) {

            int leftHeight = height(root.left);
            int rightHeight = height(root.right);

            if (leftHeight == rightHeight)
                return root;

            else if (leftHeight < rightHeight) {

                return subtreeWithAllDeepest(root.right);
            } else {
                return subtreeWithAllDeepest(root.left);
            }
        }
    }
}
