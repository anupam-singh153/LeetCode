class Trie {

    private static class Node {
        Node[] children;
        String word;

        public Node() {
            this.children = new Node[26];
            this.word = null;
        }
    }

    Node root;

    public Trie() {
        this.root = new Node();
    }

    private static int[][] directions = { { -1, 0 }, { 0, 1 }, { 1, 0 }, { 0, -1 } };

    public void insert(String key) {
        Node node = root;

        for (char c : key.toCharArray()) {
            int idx = c - 'a';

            if (node.children[idx] == null)
                node.children[idx] = new Node();

            node = node.children[idx];
        }

        node.word = key;
    }

    public void search(char[][] board, int r, int c, Node node, List<String> result) {

        char ch = board[r][c];

        if (ch == '#' || node.children[ch - 'a'] == null)
            return;

        node = node.children[ch - 'a'];

        if (node.word != null) {
            result.add(node.word);
            node.word = null;
        }

        board[r][c] = '#';
        int M = board.length, N = board[0].length;

        for (int[] d : directions) {
            int nr = r + d[0];
            int nc = c + d[1];

            if (nr >= 0 && nr < M && nc >= 0 && nc < N)
                search(board, nr, nc, node, result);
        }

        board[r][c] = ch;
    }
}

class Solution {
    public List<String> findWords(char[][] board, String[] words) {

        Trie trie = new Trie();

        for (String word : words)
            trie.insert(word);

        List<String> result = new ArrayList<>();
        int M = board.length;
        int N = board[0].length;

        for (int r = 0; r < M; ++r) {
            for (int c = 0; c < N; ++c) {

                trie.search(board, r, c, trie.root, result);
            }
        }
        return result;
    }
}
