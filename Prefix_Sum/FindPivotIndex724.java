class Solution {
    public int pivotIndex(int[] nums) {

        int leftSum = 0;
        int rightSum = 0;

        int n = nums.length;

        int leftArr[] = new int[n];

        for (int i = 0; i < n; ++i) {

            leftArr[i] = leftSum;
            leftSum += nums[i];
        }

        int[] rightArr = new int[n];

        for (int i = n - 1; i >= 0; --i) {

            rightArr[i] = rightSum;
            rightSum += nums[i];
        }

        for (int i = 0; i < n; ++i) {

            if (leftArr[i] == rightArr[i])
                return i;
        }

        return -1;
    }
}
