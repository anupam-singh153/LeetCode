class Solution {
    public void moveZeroes(int[] nums) {

        int n = nums.length;
        int zp = 0;
        for (int i = 0; i < n; ++i) {

            if (nums[i] != 0)
                nums[zp++] = nums[i];
        }

        while (zp < n)
            nums[zp++] = 0;
    }
}
