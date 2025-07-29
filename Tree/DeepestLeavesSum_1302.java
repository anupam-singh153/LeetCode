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

        int leftHt = height(root.left);
        int rightHt = height(root.right);

        return 1 + Math.max(leftHt, rightHt);
    }

    private int deepestLeavesSum(TreeNode root, int d, int l) {

        if (root == null)
            return 0;

        if (d == l && isLeaf(root))
            return root.val;

        return deepestLeavesSum(root.left, d, l + 1) + deepestLeavesSum(root.right, d, l + 1);
    }

    private boolean isLeaf(TreeNode root) {

        return root.left == null && root.right == null;
    }

    public int deepestLeavesSum(TreeNode root) {

        int ht = height(root);

        return deepestLeavesSum(root, ht, 1);
    }
}
