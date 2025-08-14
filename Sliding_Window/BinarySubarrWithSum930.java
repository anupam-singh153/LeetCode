class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        Map<Integer, Integer> freq = new HashMap<>();
        freq.put(0, 1);

        int sum = 0, result = 0;
        for (int num : nums) {
            sum += num;
            result += freq.getOrDefault(sum - goal, 0);
            freq.put(sum, freq.getOrDefault(sum, 0) + 1);
        }

        return result;
    }
}
