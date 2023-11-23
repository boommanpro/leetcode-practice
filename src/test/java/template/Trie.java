package template;

public class Trie {
    private final TrieNode root;

    /**
     * Initialize your data structure here.
     */
    public Trie() {
        root = new TrieNode();
    }

    /**
     * Inserts a word into the trie.
     */
    public void insert(String word) {
        TrieNode node = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            TrieNode next = node.get(ch);
            if (next == null) {
                next = new TrieNode();
                node.put(ch, next);
            }
            node = next;
        }
        node.setIsEnd();
    }

    public boolean search(String word) {
        TrieNode node = root;
        int n = word.length();
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            TrieNode next = node.get(ch);
            if (next == null) {
                return false;
            }
            node = next;
        }
        return node.isEnd;
    }


    public int contains(String word) {
        int n = word.length();
        TrieNode node = root;
        for (int i = 0; i < n; i++) {
            char ch = word.charAt(i);
            TrieNode next = node.get(ch);
            if (next == null) {
                return -1;
            }
            if (next.isEnd) {
                return i + 1;
            }
            node = next;
        }
        return -1;
    }

    public static class TrieNode {
        private TrieNode[] links;

        private final int R = 26;

        private boolean isEnd;

        public TrieNode() {
            links = new TrieNode[R];
        }

        public boolean containsKey(char ch) {
            return links[ch - 'a'] != null;
        }

        public TrieNode get(char ch) {
            return links[ch - 'a'];
        }

        public void put(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public boolean isEnd() {
            return isEnd;
        }

        public void setIsEnd() {
            this.isEnd = true;
        }
    }
}
