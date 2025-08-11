class Solution {

    private boolean isVowel(char c) {

        if (c >= 'A' && c <= 'Z')
            c = (char) (c + 32);

        return c == 'a' || c == 'e' || c == 'i'
                || c == 'o' || c == 'u';
    }

    public String reverseVowels(String s) {

        List<Character> ls = new ArrayList<>();

        for (char c : s.toCharArray()) {

            if (isVowel(c))
                ls.add(c);
        }

        int i = ls.size() - 1;

        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {

            if (isVowel(c))
                sb.append(ls.get(i--));
            else
                sb.append(c);
        }

        return sb.toString();
    }
}
