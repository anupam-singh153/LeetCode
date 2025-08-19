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
    List<List<Integer>> seen = new ArrayList<>();
    Queue<TreeNode> q = new LinkedList<>();

    public List<List<Integer>> levelOrderBottom(TreeNode root) {

        if (root == null)
            return seen;

        q.add(root);

        while (!q.isEmpty()) {
            int levelsize = q.size();
            List<Integer> currList = new ArrayList<>();

            for (int I = 0; I < levelsize; ++I) {
                TreeNode visit = q.remove();

                if (visit.left != null)
                    q.add(visit.left);

                if (visit.right != null)
                    q.add(visit.right);

                currList.add(visit.val);

            }
            seen.add(0, currList);
        }
        return seen;
    }
}
