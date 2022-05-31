package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class SolutionTest剑指OfferII_114 {
//现有一种使用英语字母的外星文语言，这门语言的字母顺序与英语顺序不同。 
//
// 给定一个字符串列表 words ，作为这门语言的词典，words 中的字符串已经 按这门新语言的字母顺序进行了排序 。 
//
// 请你根据该词典还原出此语言中已知的字母顺序，并 按字母递增顺序 排列。若不存在合法字母顺序，返回 "" 。若存在多种可能的合法字母顺序，返回其中 任意一种
// 顺序即可。 
//
// 字符串 s 字典顺序小于 字符串 t 有两种情况： 
//
// 
// 在第一个不同字母处，如果 s 中的字母在这门外星语言的字母顺序中位于 t 中字母之前，那么 s 的字典顺序小于 t 。 
// 如果前面 min(s.length, t.length) 字母都相同，那么 s.length < t.length 时，s 的字典顺序也小于 t 。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：words = ["wrt","wrf","er","ett","rftt"]
//输出："wertf"
// 
//
// 示例 2： 
//
// 
//输入：words = ["z","x"]
//输出："zx"
// 
//
// 示例 3： 
//
// 
//输入：words = ["z","x","z"]
//输出：""
//解释：不存在合法字母顺序，因此返回 "" 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= words.length <= 100 
// 1 <= words[i].length <= 100 
// words[i] 仅由小写英文字母组成 
// 
//
// 
//
// 注意：本题与主站 269 题相同： https://leetcode-cn.com/problems/alien-dictionary/ 
// Related Topics 深度优先搜索 广度优先搜索 图 拓扑排序 数组 字符串 👍 101 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String alienOrder(String[] words) {
            int len = words.length;
            Map<Character,List<Character>> edges = new HashMap<>();
            Map<Character, Integer> inDegrees = new HashMap<>();
            for (String word : words) {
                for (char c : word.toCharArray()) {
                    edges.putIfAbsent(c, new ArrayList<>());
                }
            }
            for (int i = 1; i < len; i++) {
                if (!addEdge(words[i - 1], words[i], edges,inDegrees)) {
                    return "";
                }
            }
            Queue<Character> queue = new LinkedList<>();
            Set<Character> dict = edges.keySet();
            for (Character c : dict) {
                if (!inDegrees.containsKey(c)) {
                    queue.offer(c);
                }
            }
            StringBuilder sb = new StringBuilder();
            while (!queue.isEmpty()) {
                char c = queue.poll();
                sb.append(c);
                List<Character> adjacent = edges.get(c);
                for (Character v : adjacent) {
                    inDegrees.put(v, inDegrees.get(v) - 1);
                    if (inDegrees.get(v) == 0) {
                        queue.offer(v);
                    }
                }
            }
            return sb.length() == edges.size() ? sb.toString() : "";
        }



        private boolean addEdge(String word1, String word2,Map<Character, List<Character>> edges, Map<Character, Integer> inDegrees) {
            int len1 = word1.length();
            int len2 = word2.length();
            int len = Math.min(len1, len2);
            int i = 0;
            for (; i < len; i++) {
                char a = word1.charAt(i);
                char b = word2.charAt(i);
                if (a != b) {
                    edges.get(a).add(b);
                    inDegrees.put(b, inDegrees.getOrDefault(b, 0) + 1);
                    break;
                }
            }
            return i != len || len1 <= len2;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("wertf", solution.alienOrder(new String[]{"wrt", "wrf", "er", "ett", "rftt"}));
        }

    }
}