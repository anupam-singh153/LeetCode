class Trie {
    static class Node {
        Node[] children;
        boolean eow;

        public Node() {
            this.children = new Node[26];
            this.eow = false;
        }
    }

    private Node root;

    public Trie() {
        this.root = new Node();
    }

    public void insert(String key) {
        Node curr = root;
        for (char c : key.toCharArray()) {
            int idx = c - 'a';

            if (curr.children[idx] == null)
                curr.children[idx] = new Node();

            curr = curr.children[idx];
        }
        curr.eow = true;
    }

    private boolean search(String key, int j, Node curr, int k) {
        if (curr == null) return false;
        
        if (j == key.length()) {
            return curr.eow && (k == 0);
        }

        int idx = key.charAt(j) - 'a';

        if (curr.children[idx] != null && search(key, j + 1, curr.children[idx], k)) {
            return true;
        }

        if (k > 0) {
            for (int i = 0; i < 26; i++) {
                if (i != idx && curr.children[i] != null) {
                    if (search(key, j + 1, curr.children[i], k - 1))
                        return true;
                }
            }
        }

        return false;
    }

    public boolean search(String key) {
        return search(key, 0, root, 1);
    }
}

class MagicDictionary {
    Trie t;

    public MagicDictionary() {
        this.t = new Trie();
    }
    
    public void buildDict(String[] dictionary) {
        for (String s : dictionary)
            t.insert(s);
    }

    public boolean search(String searchWord) {
        return t.search(searchWord);
    }
}
