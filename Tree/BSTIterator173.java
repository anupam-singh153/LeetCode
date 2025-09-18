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
class BSTIterator {

    List<Integer> inorderResult;
    private int idx = 0;

    private void inorder(TreeNode root) {

        if (root == null)
            return;

        inorder(root.left);
        inorderResult.add(root.val);
        inorder(root.right);
    }

    public BSTIterator(TreeNode root) {

        this.inorderResult = new ArrayList<>();
        this.idx = 0;
        inorder(root);
    }

    public int next() {

        return inorderResult.get(idx++);
    }

    public boolean hasNext() {

        return idx < inorderResult.size();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
