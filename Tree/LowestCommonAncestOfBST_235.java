/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

class Solution {

    private boolean contains(TreeNode root, TreeNode node) {

        if (root == null)
            return false;

        if (root.val == node.val)
            return true;

        else if (node.val < root.val)
            return contains(root.left, node);

        else
            return contains(root.right, node);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || p == root || q == root)
            return root;

        boolean pInLeft = contains(root.left, p);
        boolean qInRight = contains(root.right, q);

        if (pInLeft && !qInRight)
            return lowestCommonAncestor(root.left, p, q);

        if (!pInLeft && qInRight)
            return lowestCommonAncestor(root.right, p, q);

        return root;
    }
}
