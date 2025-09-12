class Solution {

    private Map<Integer, List<Integer>> database;

    public Solution(int[] nums) {
        this.database = new HashMap<>();

        for (int i = 0; i < nums.length; ++i) {

            database.putIfAbsent(nums[i], new ArrayList<>());
            database.get(nums[i]).add(i);
        }
    }

    public int pick(int target) {

        if (!database.containsKey(target))
            return -1;

        List<Integer> indices = database.get(target);
        int index = (int) (Math.random() * indices.size());

        return indices.get(index);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int param_1 = obj.pick(target);
 */
