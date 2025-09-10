class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {

        HashSet<String> bannedWords = new HashSet<>();

        for (String s : banned)
            bannedWords.add(s);

        HashMap<String, Integer> map = new HashMap<>();

        char[] arr = paragraph.toLowerCase().toCharArray();

        for (int i = 0; i < arr.length; ++i) {
            char c = arr[i];

            if (c != ' ' && (c < 'a' || c > 'z')) {
                arr[i] = ' ';
            }
        }

        String sb = new String(arr);
        System.out.println(sb);

        for (String s : sb.split("\\s+")) {

            if (!bannedWords.contains(s))
                map.put(s, map.getOrDefault(s, 0) + 1);
        }

        String result = "";
        int freq = 0;

        for (String s : map.keySet()) {

            if (map.get(s) > freq) {
                result = s;
                freq = map.get(s);
            }
        }

        return result;
    }
}
