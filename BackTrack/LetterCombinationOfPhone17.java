public class Solution {

    private static Map<Character, String> map;
    private static int M;

    static {
        map = new HashMap<>();

        map.put('0', "0");
        map.put('1', "1");
        map.put('2', "abc");
        map.put('6', "mno");
        map.put('3', "def");
        map.put('7', "pqrs");
        map.put('4', "ghi");
        map.put('8', "tuv");
        map.put('5', "jkl");
        map.put('9', "wxyz");
    }

    private void fuck(char[][] board, int r, StringBuilder sb, ArrayList<String> result) {

        if (r == M) {
            result.add(new String(sb));
            return;
        }

        for (int c = 0; c < board[r].length; ++c) {

            sb.append(board[r][c]);
            fuck(board, r + 1, sb, result);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public ArrayList<String> letterCombinations(String A) {

        ArrayList<String> result = new ArrayList<>();
        M = A.length();

        if (M == 0)
            return new ArrayList<String>();

        char[][] board = new char[M][];
        int i = 0;
        for (char c : A.toCharArray()) {
            board[i++] = map.get(c).toCharArray();
        }

        fuck(board, 0, new StringBuilder(), result);
        return result;
    }
}
