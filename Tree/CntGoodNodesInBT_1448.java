class Solution {

    private int result = 0;

    private void dfs(TreeNode root, int prevMax) {

        if (root == null)
            return;

        if (prevMax <= root.val)
            result++;

        prevMax = Math.max(prevMax, root.val);

        dfs(root.left, prevMax);
        dfs(root.right, prevMax);
    }

    public int goodNodes(TreeNode root) {

        dfs(root, -1000001);
        return result;
    }
}
