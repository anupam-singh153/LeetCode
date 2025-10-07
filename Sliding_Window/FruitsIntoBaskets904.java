class Solution {
    public int totalFruit(int[] fruits) {

        HashMap<Integer, Integer> map = new HashMap<>();

        int result = 0, l = 0;
        int N = fruits.length;

        for (int r = 0; r < N; ++r) {

            map.put(fruits[r], map.getOrDefault(fruits[r], 0) + 1);

            while (l < r && map.size() > 2) {
                map.put(fruits[l], map.get(fruits[l]) - 1);

                if (map.get(fruits[l]) == 0)
                    map.remove(fruits[l]);

                l++;
            }

            result = Math.max(result, r - l + 1);
        }

        return result;
    }
}
