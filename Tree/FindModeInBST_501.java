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
    public int[] findMode(TreeNode root) {

        // creating HashMap as Elementry Data Structure
        HashMap<Integer, Integer> mp = new HashMap<>();

        dfs(root, mp);
        int maxFreq = 0;

        // Calculating Max Frequency
        for (var entry : mp.keySet()) {

            maxFreq = Math.max(maxFreq, mp.get(entry));
        }

        List<Integer> list = new ArrayList<>();

        // storing all the maxFreq Entry in a ArrayList
        for (var entry : mp.keySet()) {

            if (mp.get(entry) == maxFreq)
                list.add(entry);
        }

        // converting ArrayList into form of Array for suitable return type

        int[] ans = new int[list.size()];
        int idx = 0;
        for (int x : list) {

            ans[idx++] = x;
        }

        return ans;
    }

    // fun() for traverse the tree as well as store all the nodes with freq

    private void dfs(TreeNode root, Map<Integer, Integer> mp) {

        if (root == null)
            return;

        mp.put(root.val, mp.getOrDefault(root.val, 0) + 1);

        dfs(root.left, mp);
        dfs(root.right, mp);
    }
}
