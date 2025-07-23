class Node {
    Node[] children;
    boolean eow;

    public Node() {
        this.children = new Node[26];
        this.eow = false;
    }
}

class Trie {

    private Node root;

    public Trie() {

        this.root = new Node();
    }

    public void insert(String word) {

        Node curr = root;

        for (char c : word.toCharArray()) {

            int idx = c - 'a';

            if (curr.children[idx] == null)
                curr.children[idx] = new Node();

            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    public boolean search(String word) {

        Node curr = root;

        for (char c : word.toCharArray()) {
            int idx = c - 'a';

            if (curr.children[idx] == null)
                return false;

            curr = curr.children[idx];
        }

        return curr.eow;
    }

    public boolean startsWith(String prefix) {

        Node curr = root;

        for (char c : prefix.toCharArray()) {
            int idx = c - 'a';

            if (curr.children[idx] == null)
                return false;

            curr = curr.children[idx];
        }

        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
