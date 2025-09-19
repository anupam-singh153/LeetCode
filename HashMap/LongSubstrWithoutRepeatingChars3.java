class Solution {
    public int lengthOfLongestSubstring(String s) {

        HashMap<Character, Integer> map = new HashMap<>();
        int l = 0, n = s.length();
        int maxLen = 0;

        for (int r = 0; r < n; ++r) {

            char c = s.charAt(r);
            map.put(c, map.getOrDefault(c, 0) + 1);

            while (map.size() < (r - l + 1)) {
                char rp = s.charAt(l++);
                map.put(rp, map.getOrDefault(rp, 0) - 1);

                if (map.get(rp) == 0)
                    map.remove(rp);
            }

            maxLen = Math.max(maxLen, r - l + 1);
        }

        return maxLen;
    }
}
