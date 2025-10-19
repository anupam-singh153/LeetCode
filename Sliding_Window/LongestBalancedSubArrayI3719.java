class Solution {

    public int longestBalanced(int[] nums, int l) {

        int N = nums.length;

        HashMap<Integer, Integer> map = new HashMap<>();
        int even = 0, odd = 0, result = 0;

        for (int r = l; r < N; ++r) {

            if (!map.containsKey(nums[r])) {
                map.put(nums[r], 1);

                if (nums[r] % 2 == 0)
                    even++;
                else
                    odd++;
            } else {
                map.put(nums[r], map.get(nums[r]) + 1);
            }

            if (even == odd)
                result = Math.max(result, r - l + 1);
        }

        while (l < N) {
            map.put(nums[l], map.get(nums[l]) - 1);

            if (map.get(nums[l]) == 0) {

                map.remove(map.get(nums[l]));

                if (nums[l] % 2 == 0)
                    even--;
                else
                    odd--;
            }

            if (even == odd)
                result = Math.max(result, N - l - 1);
            l++;
        }

        return result;
    }

    public int longestBalanced(int[] nums) {

        int N = nums.length;
        int result = 0;

        for (int i = 0; i < N; ++i) {

            result = Math.max(result, longestBalanced(nums, i));
        }

        return result;
    }
}
