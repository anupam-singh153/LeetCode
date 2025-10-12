class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int M = nums1.length;
        int N = nums2.length;
        int L = M + N;
        int[] nums = new int[L];

        int i = 0, j = 0, k = 0;

        while (i < M && j < N) {

            if (nums1[i] < nums2[j])
                nums[k++] = nums1[i++];
            else
                nums[k++] = nums2[j++];
        }

        while (i < M)
            nums[k++] = nums1[i++];

        while (j < N)
            nums[k++] = nums2[j++];

        if (L % 2 == 1)
            return nums[L / 2];

        return 1.0 * (nums[L / 2] + nums[L / 2 - 1]) / 2;
    }
}
