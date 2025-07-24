class Solution {
    public List<Integer> rightSideView(TreeNode root) {

        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        if (root == null)
            return result;

        queue.add(root);

        while (!queue.isEmpty()) {
            int levelSize = queue.size();

            for (int i = 1; i <= levelSize; ++i) {

                TreeNode node = queue.poll();

                if (i == levelSize)
                    result.add(node.val);

                if (node.left != null)
                    queue.add(node.left);

                if (node.right != null)
                    queue.add(node.right);
            }
        }

        return result;
    }
}
