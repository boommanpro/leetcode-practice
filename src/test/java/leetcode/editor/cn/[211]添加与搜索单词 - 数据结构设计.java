package leetcode.editor.cn;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest211 {
//设计一个支持以下两种操作的数据结构： 
//
// void addWord(word)
//bool search(word)
// 
//
// search(word) 可以搜索文字或正则表达式字符串，字符串只包含字母 . 或 a-z 。 . 可以表示任何一个字母。 
//
// 示例: 
//
// addWord("bad")
//addWord("dad")
//addWord("mad")
//search("pad") -> false
//search("bad") -> true
//search(".ad") -> true
//search("b..") -> true
// 
//
// 说明: 
//
// 你可以假设所有单词都是由小写字母 a-z 组成的。 
// Related Topics 设计 字典树 回溯算法

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class WordDictionary {

        TrieNode dict;

        /**
         * Initialize your data structure here.
         */
        public WordDictionary() {
            dict = new TrieNode();
        }

        /**
         * Adds a word into the data structure.
         */
        public void addWord(String word) {
            dict.insert(word);
        }

        /**
         * Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter.
         */
        public boolean search(String word) {
            return dict.search(word);
        }

        public static class TrieNode {

            public Map<Character, TrieNode> links;

            public boolean end;

            public TrieNode() {
                links = new HashMap<>();
            }

            public void insert(String word) {
                int n = word.length();
                TrieNode node = this;

                for (int i = 0; i < n; i++) {
                    char ch = word.charAt(i);
                    TrieNode next = node.get(ch);
                    if (next == null) {
                        next = new TrieNode();
                        node.put(ch, next);
                    }
                    node = next;
                }
                node.setEnd();
            }

            public boolean search(String key) {
                int n = key.length();
                List<TrieNode> originList = Collections.singletonList(this);
                List<TrieNode> nextList;
                for (int i = 0; i < n; i++) {
                    char ch = key.charAt(i);
                    nextList = findByChar(originList, ch);
                    if (nextList.isEmpty()) {
                        return false;
                    }
                    originList = nextList;
                }
                return originList.stream().map(TrieNode::isEnd).filter(Boolean::booleanValue).findAny().orElse(false);
            }

            public List<TrieNode> findByChar(List<TrieNode> originList, char ch) {
                List<TrieNode> result = new ArrayList<>();
                if (ch == '.') {
                    for (TrieNode trieNode : originList) {
                        result.addAll(trieNode.getAllChildren());
                    }
                } else {
                    for (TrieNode trieNode : originList) {
                        TrieNode next = trieNode.get(ch);
                        if (next != null) {
                            result.add(next);
                        }
                    }
                }
                return result;
            }

            public List<TrieNode> getAllChildren() {
                return new ArrayList<>(links.values());
            }

            public boolean isEnd() {
                return end;
            }

            public void put(char ch, TrieNode node) {
                links.put(ch, node);
            }

            public TrieNode get(char ch) {
                return links.get(ch);
            }

            public void setEnd() {
                this.end = true;
            }
        }

    }

    /**
     * Your WordDictionary object will be instantiated and called as such:
     * WordDictionary obj = new WordDictionary();
     * obj.addWord(word);
     * boolean param_2 = obj.search(word);
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            WordDictionary wordDictionary = new WordDictionary();
            wordDictionary.addWord("bad");
            wordDictionary.addWord("dad");
            wordDictionary.addWord("mad");
            Assert.assertFalse(wordDictionary.search("pad"));
            Assert.assertTrue(wordDictionary.search("bad"));
            Assert.assertTrue(wordDictionary.search(".ad"));
            Assert.assertTrue(wordDictionary.search("b.."));
        }
    }
}