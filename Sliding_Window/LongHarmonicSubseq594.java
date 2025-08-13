class Solution {
    public int findLHS(int[] nums) {

        Arrays.sort(nums);

        int l = 0, r = 0;
        int n = nums.length;
        int ans = 0;

        for (; r < n; ++r) {

            while (nums[r] - nums[l] > 1)
                l++;

            if (nums[l] + 1 == nums[r])
                ans = Math.max(ans, r - l + 1);
        }

        return ans;
    }
}
