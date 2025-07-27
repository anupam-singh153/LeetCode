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
    public void flatten(TreeNode root) {

        if (root == null)
            return;

        TreeNode leftTree = root.left;
        TreeNode rightTree = root.right;

        flatten(root.left);
        flatten(root.right);

        root.left = null;
        root.right = leftTree;

        TreeNode node = root;

        while (node.right != null)
            node = node.right;

        node.right = rightTree;
    }
}
