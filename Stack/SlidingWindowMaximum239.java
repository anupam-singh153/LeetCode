class Solution {

    private void findNextGreaterEle(int[] nums, int[] nge) {

        Stack<Integer> st = new Stack<>();
        int N = nums.length;

        for (int i = N - 1; i >= 0; --i) {

            while (!st.isEmpty() && nums[st.peek()] <= nums[i])
                st.pop();

            nge[i] = st.isEmpty() ? N : st.peek();
            st.push(i);
        }
    }

    public int[] maxSlidingWindow(int[] nums, int k) {

        int N = nums.length;
        int[] nge = new int[N];

        findNextGreaterEle(nums, nge);

        int[] result = new int[N - k + 1];

        int max, j = 0;
        for (int i = 0; i <= N - k; ++i) {

            if (j >= i + k)
                j = i;

            max = nums[j];
            while (j < i + k) {
                max = nums[j];
                j = nge[j];
            }

            result[i] = max;
        }

        return result;
    }
}
