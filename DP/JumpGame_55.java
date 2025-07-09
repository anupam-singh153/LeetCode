class JumpGame_55 {

    private Boolean[] dp;

    private boolean solve(int[] nums, int idx) {

        if (idx == nums.length)
            return true;

        if (dp[idx] != null)
            return dp[idx];

        boolean flag = false;

        for (int i = 1; i <= nums[idx - 1]; ++i) {
            flag |= solve(nums, idx + i);

            if (flag)
                return true;
        }

        return dp[idx] = flag;
    }

    public boolean canJump(int[] nums) {

        int n = nums.length;
        dp = new Boolean[n + 1];

        return solve(nums, 1);
    }
}
