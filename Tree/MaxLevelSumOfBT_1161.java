class Solution {
    public int maxLevelSum(TreeNode root) {

        int maxSum = Integer.MIN_VALUE;
        int result = -1;

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            int sum = 0;
            for (int i = 1; i <= levelSize; ++i) {
                TreeNode node = queue.poll();

                sum += node.val;

                if (node.left != null)
                    queue.offer(node.left);

                if (node.right != null)
                    queue.offer(node.right);
            }

            ++level;

            if (sum > maxSum) {
                result = level;
                maxSum = sum;
            }
        }

        return result;
    }
}
