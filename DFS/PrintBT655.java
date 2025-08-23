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
    public List<List<String>> printTree(TreeNode root) {

        int m = calMaxHeight(root);
        int n = (int) Math.pow(2, m) - 1;

        List<List<String>> ans = new ArrayList<>();
        List<String> row = new ArrayList<>();

        for (int i = 0; i < n; ++i) {

            row.add("");
        }

        for (int i = 0; i < m; ++i) {
            ans.add(new ArrayList<>(row));
        }

        dfs(ans, root, 0, 0, n - 1);
        return ans;
    }

    public void dfs(List<List<String>> ans, TreeNode root, int row, int left, int right) {

        if (root == null)
            return;

        int mid = (left + right) / 2;

        ans.get(row).set(mid, "" + root.val);

        dfs(ans, root.left, row + 1, left, mid - 1);
        dfs(ans, root.right, row + 1, mid + 1, right);
    }

    public int calMaxHeight(TreeNode root) {

        if (root == null)
            return 0;

        return 1 + Math.max(calMaxHeight(root.left),
                calMaxHeight(root.right));
    }
}
