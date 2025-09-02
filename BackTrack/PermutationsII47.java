class Solution {

    private void fuck(int[] nums, List<Integer> tuple, List<List<Integer>> result) {

        if (tuple.size() == nums.length) {
            List<Integer> sample = new ArrayList<>();
            sample.addAll(tuple);

            if (!result.contains(sample))
                result.add(sample);
            return;
        }

        for (int i = 0; i < nums.length; ++i) {

            if (nums[i] == -11)
                continue;

            tuple.add(nums[i]);
            int val = nums[i];
            nums[i] = -11;
            fuck(nums, tuple, result);
            nums[i] = val;
            tuple.remove(tuple.size() - 1);
        }

        return;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {

        List<List<Integer>> result = new ArrayList<>();
        fuck(nums, new ArrayList<>(), result);
        return result;
    }
}
