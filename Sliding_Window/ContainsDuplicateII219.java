class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {

        int n = nums.length;
        int l = 0;

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int r = 0; r < n; ++r) {

            map.put(nums[r], map.getOrDefault(nums[r], 0) + 1);

            while ((r - l) > k) {
                map.put(nums[l], map.getOrDefault(nums[l], 0) - 1);

                if (map.get(nums[l]) == 0)
                    map.remove(nums[l]);

                System.out.println(l + " " + r);
                l++;
            }

            if (map.size() < (r - l + 1))
                return true;
        }

        return false;
    }
}
