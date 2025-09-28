class Solution {
    public String majorityFrequencyGroup(String s) {

        int[] freq = new int[26];

        for (char c : s.toCharArray())
            freq[c - 'a']++;

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < 26; ++i) {

            if (freq[i] > 0)
                map.put(freq[i], map.getOrDefault(freq[i], 0) + 1);
        }

        int groupSize = 0, frequency = -1;
        for (int key : map.keySet()) {

            if (map.get(key) > groupSize) {
                groupSize = map.get(key);
                frequency = key;
            } else if (map.get(key) == groupSize) {
                frequency = Math.max(frequency, key);
            }
        }

        if (groupSize == 0)
            return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 26; ++i) {

            if (freq[i] == frequency)
                sb.append((char) (i + 'a'));
        }

        return sb.toString();
    }
}
