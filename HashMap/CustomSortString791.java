class Solution {
    public String customSortString(String order, String s) {

        // storing Characters in HashMap of String s

        HashMap<Character, Integer> map = new HashMap<>();

        for (char ch : s.toCharArray()) {

            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }

        StringBuilder sb = new StringBuilder();

        // append character orderwise
        for (char ch : order.toCharArray()) {

            if (map.containsKey(ch)) {

                for (int i = 0; i < map.get(ch); ++i) {
                    sb.append(ch);
                }
                map.remove(ch);
            }
        }

        // append charcter without order
        for (var c : map.keySet()) {

            for (int i = 0; i < map.get(c); ++i) {
                sb.append(c);
            }
        }

        // return the sb as string
        return sb.toString();
    }
}
