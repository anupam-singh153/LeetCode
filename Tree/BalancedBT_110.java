class Solution {

    private boolean flag;

    private int depth(TreeNode root) {

        if (root == null)
            return 0;

        int leftHeight = depth(root.left);
        int rightHeight = depth(root.right);

        if (Math.abs(leftHeight - rightHeight) > 1) {
            flag = false;
            return 0;
        }

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public boolean isBalanced(TreeNode root) {

        this.flag = true;
        depth(root);

        return flag;
    }
}
