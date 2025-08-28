
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

    public void insert(String key) {

        Node curr = root;

        for (char c : key.toCharArray()) {
            int idx = c - 'a';

            if (curr.children[idx] == null)
                curr.children[idx] = new Node();

            curr = curr.children[idx];
        }
        curr.eow = true;
        return;
    }

    public boolean search(String key) {

        Node curr = root;

        for (char c : key.toCharArray()) {
            int idx = c - 'a';

            if (curr.children[idx] == null)
                return false;

            curr = curr.children[idx];
        }

        return curr.eow;
    }
}

class Solution {
    private Trie t = new Trie();

    private boolean wordBreak(String key, HashMap<String, Boolean> dp) {

        int n = key.length();

        if (n == 0)
            return true;

        if (dp.containsKey(key))
            return dp.get(key);

        for (int i = 1; i <= n; ++i) {

            String firstPart = key.substring(0, i);
            String secondPart = key.substring(i);

            if (t.search(firstPart) && wordBreak(secondPart, dp))
                return true;
        }

        dp.put(key, false);
        return false;
    }

    public boolean wordBreak(String s, List<String> wordDict) {

        HashMap<String, Boolean> dp = new HashMap<>();

        for (String word : wordDict)
            t.insert(word);

        return wordBreak(s, dp);
    }
}
