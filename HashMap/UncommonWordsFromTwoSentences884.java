class Solution {
    public String[] uncommonFromSentences(String s1, String s2) {

        HashMap<String, Integer> map = new HashMap<>();

        for (String s : s1.split(" "))
            map.put(s, map.getOrDefault(s, 0) + 1);

        for (String s : s2.split(" "))
            map.put(s, map.getOrDefault(s, 0) + 1);

        List<String> list = new ArrayList<>();

        for (String s : map.keySet()) {

            if (map.get(s) == 1)
                list.add(s);
        }

        String[] ans = new String[list.size()];

        for (int i = 0; i < ans.length; ++i) {
            ans[i] = list.get(i);
        }

        return ans;
    }
}
