package leetcode.editor.cn;

import com.sun.org.apache.xpath.internal.operations.Or;
import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.*;
import java.util.function.Function;

class SolutionTest336 {
//给定一组唯一的单词， 找出所有不同 的索引对(i, j)，使得列表中的两个单词， words[i] + words[j] ，可拼接成回文串。 
//
// 示例 1: 
//
// 输入: ["abcd","dcba","lls","s","sssll"]
//输出: [[0,1],[1,0],[3,2],[2,4]] 
//解释: 可拼接成的回文串为 ["dcbaabcd","abcddcba","slls","llssssll"]
// 
//
// 示例 2: 
//
// 输入: ["bat","tab","cat"]
//输出: [[0,1],[1,0]] 
//解释: 可拼接成的回文串为 ["battab","tabbat"] 
// Related Topics 字典树 哈希表 字符串

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public List<List<Integer>> palindromePairs(String[] words) {
            List<List<Integer>> ans = new ArrayList<>();
            if (words == null) {
                return ans;
            }
            int n = words.length;
            if (n <= 1) {
                return ans;
            }
            TrieNode dict = new TrieNode();
            //将逆序后的words插入到dict中
            for (int i = 0; i < n; i++) {
                dict.insert(new StringBuilder(words[i]).reverse().toString(), i);
            }
            for (int i = 0; i < words.length; i++) {
                //查找匹配 3种匹配模式
                String word = words[i];
                int m = word.length();
                TrieNode node = dict;
                int j;
                for (j = 0; j < m; j++) {
                    //如果当前字符串是回文的
                    if (isPalindrome(word.substring(j))) {
                        for (Integer k : node.getWords()) {
                            if (k != i) {
                                ans.add(Arrays.asList(i, k));
                            }
                        }
                    }
                    char ch = word.charAt(j);
                    TrieNode next = node.get(ch);
                    if (next == null) {
                        break;
                    }
                    node = next;
                }
                if (j == m) {
                    for (Integer k : node.getWords()) {
                        if (k != i) {
                            ans.add(Arrays.asList(i, k));
                        }
                    }
                    for (Integer k : node.getSuffixList()) {
                        if (k != i) {
                            ans.add(Arrays.asList(i, k));
                        }
                    }
                }

            }
            return ans;
        }

        private boolean isPalindrome(String str) {
            int i = 0;
            int j = str.length() - 1;
            while (i < j) {
                if (str.charAt(i) != str.charAt(j)) {
                    return false;
                }
                i++;
                j--;
            }
            return true;
        }


        public static class TrieNode {
            /**
             * 前缀树的关键
             */
            private final Map<Character, TrieNode> children;

            /**
             * 如果当前节点的后序节点是回文串,则记录index
             */
            private final List<Integer> suffixList;

            /**
             * 当前节点是否是完成的串,如果是记录index
             */
            private final List<Integer> words;

            public TrieNode() {
                children = new HashMap<>();
                suffixList = new ArrayList<>();
                words = new ArrayList<>();
            }

            public TrieNode get(char ch) {
                return children.get(ch);
            }

            public List<Integer> getSuffixList() {
                return suffixList;
            }

            public List<Integer> getWords() {
                return words;
            }

            public void put(char ch, TrieNode node) {
                children.put(ch, node);
            }

            public void insert(String word, Integer index) {
                int n = word.length();
                TrieNode node = this;
                for (int i = 0; i < n; i++) {
                    if (isPalindrome(word.substring(i))) {
                        node.addSuffix(index);
                    }
                    char ch = word.charAt(i);
                    TrieNode next = node.get(ch);
                    if (next == null) {
                        next = new TrieNode();
                        node.put(ch, next);
                    }
                    node = next;
                }
                //处理 words
                node.addWords(index);
            }

            private void addSuffix(Integer index) {
                this.suffixList.add(index);
            }

            public void addWords(Integer index) {
                this.words.add(index);
            }

            private boolean isPalindrome(String str) {
                int i = 0;
                int j = str.length() - 1;
                while (i < j) {
                    if (str.charAt(i) != str.charAt(j)) {
                        return false;
                    }
                    i++;
                    j--;
                }
                return true;
            }
        }
    }


//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[[0, 1]]", solution.palindromePairs(new String[]{"aaab", "aaa"}).toString());
            Assert.assertEquals("[[0, 1], [1, 0]]", solution.palindromePairs(new String[]{"abcd", "dcba"}).toString());
            Assert.assertEquals("[[0, 1], [1, 0], [2, 4], [3, 2]]", solution.palindromePairs(new String[]{"abcd", "dcba", "lls", "s", "sssll"}).toString());
            Assert.assertEquals("[[0, 1], [1, 0]]", solution.palindromePairs(new String[]{"bat", "tab", "cat"}).toString());
        }
    }
}