class Node {
    Node[] children;
    int count;

    public Node() {
        this.children = new Node[26];
        this.count = 0;
    }
}

class Trie {

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
            curr.count += 1;
        }
    }

    public String commonPrefix(int N) {

        Node curr = root;
        StringBuilder sb = new StringBuilder();

        while (true) {

            boolean found = false;

            for (int i = 0; i < 26; ++i) {

                Node child = curr.children[i];

                if (child != null && child.count == N) {
                    sb.append((char) ('a' + i));
                    curr = curr.children[i];
                    found = true;
                    break;
                } else if (child != null)
                    return sb.toString();
            }

            if (!found)
                break;
        }
        return sb.toString();
    }
}

class Solution {
    public String longestCommonPrefix(String[] strs) {

        Trie trie = new Trie();

        for (String key : strs) {

            if (key.equals(""))
                return "";

            trie.insert(key);
        }
        return trie.commonPrefix(strs.length);
    }
}
