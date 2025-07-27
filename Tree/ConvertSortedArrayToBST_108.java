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

    private TreeNode buildTree(int[] nums, int l, int r) {

        if (l > r)
            return null;

        int m = l + (r - l) / 2;
        TreeNode root = new TreeNode(nums[m]);

        root.left = buildTree(nums, l, m - 1);
        root.right = buildTree(nums, m + 1, r);

        return root;
    }

    public TreeNode sortedArrayToBST(int[] nums) {

        return buildTree(nums, 0, nums.length - 1);
    }
}
