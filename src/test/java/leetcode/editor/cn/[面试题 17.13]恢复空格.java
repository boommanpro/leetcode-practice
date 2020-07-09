package leetcode.editor.cn;

import java.util.Arrays;
import java.util.HashMap;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题17_13 {
//哦，不！你不小心把一个长篇文章中的空格、标点都删掉了，并且大写也弄成了小写。像句子"I reset the computer. It still didn’
//t boot!"已经变成了"iresetthecomputeritstilldidntboot"。在处理标点符号和大小写之前，你得先把它断成词语。当然了，你有一
//本厚厚的词典dictionary，不过，有些词没在词典里。假设文章用sentence表示，设计一个算法，把文章断开，要求未识别的字符最少，返回未识别的字符数。 
//
//
// 注意：本题相对原题稍作改动，只需返回未识别的字符数 
//
// 
//
// 示例： 
//
// 输入：
//dictionary = ["looked","just","like","her","brother"]
//sentence = "jesslookedjustliketimherbrother"
//输出： 7
//解释： 断句后为"jess looked just like tim her brother"，共7个未识别字符。
// 
//
// 提示： 
//
// 
// 0 <= len(sentence) <= 1000 
// dictionary中总字符数不超过 150000。 
// 你可以认为dictionary和sentence中只包含小写字母。 
// 
// Related Topics 记忆化 字符串 
// 👍 13 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int respace(String[] dictionary, String sentence) {
            //如果句子为空 -> 0
            if (sentence == null || sentence.length() == 0) {
                return 0;
            }
            //获取字典树
            TrieNode root = new TrieNode();
            for (String word : dictionary) {
                root.insertReverseWord(word);
            }
            //获取长度 n
            int n = sentence.length();
            //获取dp
            int[] dp = new int[n + 1];
            //初始化默认值为 max
            Arrays.fill(dp, Integer.MAX_VALUE);
            //sentence 为0时，长度为0
            dp[0] = 0;
            for (int i = 1; i <= n; ++i) {
                //默认递增1
                dp[i] = dp[i - 1] + 1;
                //current node
                TrieNode currentNode = root;
                for (int j = i; j >= 1; --j) {
                    char ch = sentence.charAt(j - 1);
                    TrieNode nextNode = currentNode.get(ch);
                    //如果不存在单词 则就是 dp[i-1]+1
                    if (nextNode == null) {
                        break;
                    } else if (nextNode.isWord()) {
                        dp[i] = Math.min(dp[i], dp[j - 1]);
                    }
                    if (dp[i] == 0) {
                        break;
                    }
                    currentNode = nextNode;
                }
            }
            return dp[n];
        }

        public static class TrieNode {

            private final HashMap<Character, TrieNode> links;

            private boolean isWord;

            public TrieNode() {
                this.links = new HashMap<>();
                this.isWord = false;
            }

            public void insertWord(String word) {
                int n = word.length();
                TrieNode node = this;
                for (int i = 0; i < n; i++) {
                    char ch = word.charAt(i);
                    TrieNode nextNode = node.get(ch);
                    if (nextNode == null) {
                        nextNode = new TrieNode();
                    }
                    node.put(ch, nextNode);
                    node = nextNode;
                }
                node.setWord();
            }

            private void setWord() {
                this.isWord = true;
            }

            public TrieNode get(char ch) {
                return links.get(ch);
            }

            public void put(char ch, TrieNode node) {
                links.put(ch, node);
            }

            public boolean isWord() {
                return isWord;
            }

            public void insertReverseWord(String word) {
                int n = word.length();
                TrieNode node = this;
                for (int i = n - 1; i >= 0; --i) {
                    char ch = word.charAt(i);
                    TrieNode nextNode = node.get(ch);
                    if (nextNode == null) {
                        nextNode = new TrieNode();
                    }
                    node.put(ch, nextNode);
                    node = nextNode;
                }
                node.setWord();
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(7, solution.respace(new String[]{"looked", "just", "like", "her", "brother"}, "jesslookedjustliketimherbrother"));
        }
    }
}