package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class SolutionTest648 {
//在英语中，我们有一个叫做 词根(root)的概念，它可以跟着其他一些词组成另一个较长的单词——我们称这个词为 继承词(successor)。例如，词根an，
//跟随着单词 other(其他)，可以形成新的单词 another(另一个)。 
//
// 现在，给定一个由许多词根组成的词典和一个句子。你需要将句子中的所有继承词用词根替换掉。如果继承词有许多可以形成它的词根，则用最短的词根替换它。 
//
// 你需要输出替换之后的句子。 
//
// 
//
// 示例： 
//
// 输入：dict(词典) = ["cat", "bat", "rat"] sentence(句子) = "the cattle was rattled by
// the battery"
//输出："the cat was rat by the bat"
// 
//
// 
//
// 提示： 
//
// 
// 输入只包含小写字母。 
// 1 <= dict.length <= 1000 
// 1 <= dict[i].length <= 100 
// 1 <= 句中词语数 <= 1000 
// 1 <= 句中词语长度 <= 1000 
// 
// Related Topics 字典树 哈希表

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String replaceWords(List<String> dict, String sentence) {
            if (sentence == null || sentence.isEmpty()) {
                return sentence;
            }
            if (dict.isEmpty()) {
                return sentence;
            }
            //如果继承词有多个可以形成他的词根,则用最短的代替他
            Trie dictTree = new Trie();
            for (String word : dict) {
                dictTree.insert(word);
            }
            StringBuilder sb = new StringBuilder();
            String[] split = sentence.split("\\s");
            for (int i = 0; i < split.length; i++) {
                sb.append(dictTree.getRoot(split[i]));
                if (i != split.length - 1) {
                    sb.append(" ");
                }
            }
            return sb.toString();
        }

        static class Trie {
            TrieNode root;

            public Trie() {
                root = new TrieNode();
            }

            public void insert(String word) {
                root.insert(word);
            }

            public String getRoot(String word) {
                return root.searchRoot(word);
            }

            static class TrieNode {
                private final Map<Character, TrieNode> links;
                private boolean isEnd;

                public TrieNode() {
                    links = new HashMap<>();
                }

                public TrieNode get(char ch) {
                    return links.get(ch);
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
                    node.setEnd(true);
                }

                public void setEnd(boolean end) {
                    isEnd = end;
                }

                private void put(char ch, TrieNode next) {
                    this.links.put(ch, next);
                }

                public String searchRoot(String word) {
                    int n = word.length();
                    TrieNode node = this;
                    for (int i = 0; i < n; i++) {
                        char ch = word.charAt(i);
                        TrieNode next = node.get(ch);
                        if (next != null && next.isEnd) {
                            return word.substring(0, i + 1);
                        }
                        if (next == null) {
                            return word;
                        }
                        node = next;
                    }
                    return word;
                }
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("the cat was rat by the bat", solution.replaceWords(Arrays.asList("cat", "bat", "rat"), "the cattle was rattled by the battery"));
        }
    }
}