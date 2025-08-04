class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        int[] result = new int[n];

        Arrays.fill(result, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() && nums2[i] > nums2[stack.peek()]) {

                int index = stack.pop();

                result[index] = nums2[i];
            }
            stack.push(i);
        }

        int[] ans = new int[m];

        for (int i = 0; i < m; ++i) {
            int idx = -1;

            for (int j = 0; j < n; ++j) {

                if (nums2[j] == nums1[i]) {

                    ans[i] = result[j];
                    break;
                }
            }
        }
        return ans;
    }
}
