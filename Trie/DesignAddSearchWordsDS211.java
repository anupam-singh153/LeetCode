class Node {

    Node[] children;
    boolean eow;

    public Node() {
        this.children = new Node[26];
    }
}

class WordDictionary {

    private Node root;

    public WordDictionary() {
        this.root = new Node();
    }

    public void addWord(String word) {

        Node curr = root;
        word = word.toLowerCase();

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (curr.children[idx] == null)
                curr.children[idx] = new Node();

            curr = curr.children[idx];
        }

        curr.eow = true;
        return;
    }

    public boolean search(String word) {

        return searchHelper(word, 0, root);
    }

    private boolean searchHelper(String word, int index, Node curr) {
        if (curr == null)
            return false;

        if (index == word.length())
            return curr.eow;

        char c = word.charAt(index);

        if (c == '.') {
            for (int i = 0; i < 26; ++i) {
                if (curr.children[i] != null) {
                    if (searchHelper(word, index + 1, curr.children[i]))
                        return true;
                }
            }
            return false;
        } else {
            int idx = c - 'a';
            return searchHelper(word, index + 1, curr.children[idx]);
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
