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

    private int k = 0;
    private int ans = 0;

    private void inorder(TreeNode root){

        if(root == null)
            return;

        inorder(root.left);
        k--;
        
        if(k == 0)
            this.ans = root.val;

        inorder(root.right);
    }
    public int kthSmallest(TreeNode root, int k) {
        this.k = k;
       
        inorder(root);
        return ans;
    }
}
