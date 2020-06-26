package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

class SolutionTest677 {
//实现一个 MapSum 类里的两个方法，insert 和 sum。 
//
// 对于方法 insert，你将得到一对（字符串，整数）的键值对。字符串表示键，整数表示值。如果键已经存在，那么原来的键值对将被替代成新的键值对。 
//
// 对于方法 sum，你将得到一个表示前缀的字符串，你需要返回所有以该前缀开头的键的值的总和。 
//
// 示例 1: 
//
// 输入: insert("apple", 3), 输出: Null
//输入: sum("ap"), 输出: 3
//输入: insert("app", 2), 输出: Null
//输入: sum("ap"), 输出: 5
// 
// Related Topics 字典树

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class MapSum {

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public MapSum() {
            root = new TrieNode();
        }

        public void insert(String key, int val) {
            root.insert(key, val);
        }

        /**
         * sum is prefix sum
         */
        public int sum(String prefix) {
            return root.searchPrefix(prefix).stream().map(TrieNode::getValue).mapToInt(Integer::intValue).sum();
        }

        static class TrieNode{
            private TrieNode[] links;

            private boolean isEnd;

            private int value;

            private static final int R = 26;

            public TrieNode(int value) {
                links = new TrieNode[R];
                this.value = value;
            }


            public TrieNode() {
                links = new TrieNode[R];
            }

            public List<TrieNode> searchPrefix(String key) {
                int n = key.length();
                TrieNode node = this;
                List<TrieNode> ans = new ArrayList<>();
                for (int i = 0; i < n; i++) {
                    char ch = key.charAt(i);
                    TrieNode next = node.get(ch);
                    if (next == null) {
                        return ans;
                    }
                    node = next;
                }
                if (node.isEnd) {
                    ans.add(node);
                }
                for (TrieNode link : node.getAll()) {
                    if (link.isEnd) {
                        ans.add(link);
                    }
                }
                return ans;
            }

            public List<TrieNode> getAll() {
                List<TrieNode> ans = new ArrayList<>();
                for (int i = 0; i < R; i++) {
                    TrieNode node = links[i];
                    if (node != null) {
                        ans.add(node);
                        ans.addAll(node.getAll());
                    }
                }
                return ans;
            }

            public void insert(String key, int val) {
                int n = key.length();
                TrieNode node = this;
                for (int i = 0; i < n; i++) {
                    char ch = key.charAt(i);
                    TrieNode next = node.get(ch);
                    if (next == null) {
                        next = new TrieNode();
                        node.put(ch, next);
                    }
                    node = next;
                }
                node.setEnd(true);
                node.setValue(val);
            }

            public int getValue() {
                return value;
            }

            public void setValue(int value) {
                this.value = value;
            }

            public void put(char ch, TrieNode node) {
                links[ch - 'a'] = node;
            }

            public boolean containsKey(char ch) {
                return get(ch) != null;
            }

            public TrieNode get(char ch) {
                return links[ch - 'a'];
            }

            public boolean isEnd() {
                return isEnd;
            }

            public void setEnd(boolean end) {
                isEnd = end;
            }
        }
    }

    /**
     * Your MapSum object will be instantiated and called as such:
     * MapSum obj = new MapSum();
     * obj.insert(key,val);
     * int param_2 = obj.sum(prefix);
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            MapSum mapSum = new MapSum();
            mapSum.insert("apple", 3);
            Assert.assertEquals(3, mapSum.sum("ap"));
            mapSum.insert("app", 2);
            Assert.assertEquals(5, mapSum.sum("ap"));
        }
    }
}