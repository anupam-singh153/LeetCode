class Solution {
    public boolean wordPattern(String pattern, String s) {

        String[] arr = s.split("\\s+");
        Map<Character, String> map = new HashMap<>();
        Map<String, Character> map2 = new HashMap<>();

        if (arr.length != pattern.length())
            return false;

        int i = 0;
        for (char c : pattern.toCharArray()) {

            if (map.containsKey(c)) {
                if (!map.get(c).equals(arr[i]))
                    return false;
            } else if (map2.containsKey(arr[i])) {
                if (map2.get(arr[i]) != c)
                    return false;
            } else {
                map.put(c, arr[i]);
                map2.put(arr[i], c);
            }

            i++;
        }

        return true;
    }
}
