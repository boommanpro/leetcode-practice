package leetcode.editor.cn;

import java.util.*;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest212 {
//给定一个二维网格 board 和一个字典中的单词列表 words，找出所有同时在二维网格和字典中出现的单词。 
//
// 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
// 
//
// 示例: 
//
// 输入: 
//words = ["oath","pea","eat","rain"] and board =
//[
//  ['o','a','a','n'],
//  ['e','t','a','e'],
//  ['i','h','k','r'],
//  ['i','f','l','v']
//]
//
//输出: ["eat","oath"] 
//
// 说明: 
//你可以假设所有输入都由小写字母 a-z 组成。 
//
// 提示: 
//
// 
// 你需要优化回溯算法以通过更大数据量的测试。你能否早点停止回溯？ 
// 如果当前单词不存在于所有单词的前缀中，则可以立即停止回溯。什么样的数据结构可以有效地执行这样的操作？散列表是否可行？为什么？ 前缀树如何？如果你想学习如何
//实现一个基本的前缀树，请先查看这个问题： 实现Trie（前缀树）。 
// 
// Related Topics 字典树 回溯算法

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Set<String> allWord;

        public List<String> findWords(char[][] board, String[] words) {
            allWord = new HashSet<>();
            List<String> ans = new ArrayList<>();
            int m = board.length;
            int n = board[0].length;
            Trie dict = new Trie();
            //1.根据单元格通过回溯法构建所有的单词

            //2.将这些单词插入trie树中
            for (String word : allWord) {
                dict.insert(word);
            }
            //3.通过前缀进行搜索是否存在
            for (String word : words) {
                if (dict.existByPrefix(word)) {
                    ans.add(word);
                }
            }
            //返回存在的结果
            return ans;
        }

        public static class Trie {

            TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            public boolean existByPrefix(String key) {
                return root.existByPrefix(key);
            }

            public void insert(String word) {
                root.insert(word);
            }
        }

        public static class TrieNode {

            Map<Character, TrieNode> children;

            public TrieNode() {
                children = new HashMap<>();
            }

            public void put(char ch, TrieNode node) {
                children.put(ch, node);
            }

            public TrieNode get(char ch) {
                return children.get(ch);
            }

            public boolean existByPrefix(String key) {
                int n = key.length();
                TrieNode node = this;
                for (int i = 0; i < n; i++) {
                    char ch = key.charAt(i);
                    if (node.get(ch) == null) {
                        return false;
                    }
                }
                return true;
            }

            public void insert(String word) {
                TrieNode node = this;
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
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        /**
         * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母在一个单词中不允许被重复使用。
         */
        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertArrayEquals(new String[]{"eat", "oath"}, solution.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"}).toArray(new String[]{}));

        }
    }
}