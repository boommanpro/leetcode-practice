package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

        private static final char END = '#';

        public List<String> findWords(char[][] board, String[] words) {
            List<String> ans = new ArrayList<>();
            int m = board.length;
            if (m == 0) {
                return ans;
            }
            int n = board[0].length;
            Trie dict = new Trie();
            for (String word : words) {
                dict.insert(word);
            }
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    backTracking(board, i, j, ans, dict, m, n);
                }
            }
            return ans;
        }

        private void backTracking(char[][] board, int i, int j, List<String> ans, Trie node, int m, int n) {
            if (i < 0 || j < 0 || i >= m || j >= n) {
                return;
            }
            char curr = board[i][j];
            if (curr == END) {
                return;
            }
            Trie next = node.get(curr);
            if (next == null) {
                return;
            }
            if (next.getWord() != null) {
                ans.add(next.getWord());
                next.setWord(null);
            }
            board[i][j] = END;
            backTracking(board, i + 1, j, ans, next, m, n);
            backTracking(board, i - 1, j, ans, next, m, n);
            backTracking(board, i, j + 1, ans, next, m, n);
            backTracking(board, i, j - 1, ans, next, m, n);
            board[i][j] = curr;

        }


        public static class Trie {

            Map<Character, Trie> children;


            String word;

            public Trie() {
                children = new HashMap<>();
            }

            public void put(char ch, Trie node) {
                children.put(ch, node);
            }

            public Trie get(char ch) {
                return children.get(ch);
            }

            public void insert(String word) {
                Trie node = this;
                int n = word.length();
                for (int i = 0; i < n; i++) {
                    char ch = word.charAt(i);
                    Trie next = node.get(ch);
                    if (next == null) {
                        next = new Trie();
                        node.put(ch, next);
                    }
                    node = next;
                }
                node.setWord(word);
            }

            public void setWord(String word) {
                this.word = word;
            }

            public String getWord() {
                return word;
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
            Assert.assertArrayEquals(new String[]{"oath", "eat",}, solution.findWords(new char[][]{{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}}, new String[]{"oath", "pea", "eat", "rain"}).toArray(new String[]{}));
            Assert.assertArrayEquals(new String[]{"acdb",}, solution.findWords(new char[][]{{'a', 'b'}, {'c', 'd'}}, new String[]{"acdb"}).toArray(new String[]{}));

        }
    }
}