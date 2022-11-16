package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

class SolutionTest792 {
//给定字符串 s 和字符串数组 words, 返回 words[i] 中是s的子序列的单词个数 。 
//
// 字符串的 子序列 是从原始字符串中生成的新字符串，可以从中删去一些字符(可以是none)，而不改变其余字符的相对顺序。 
//
// 
// 例如， “ace” 是 “abcde” 的子序列。 
// 
//
// 
//
// 示例 1: 
//
// 
//输入: s = "abcde", words = ["a","bb","acd","ace"]
//输出: 3
//解释: 有三个是 s 的子序列的单词: "a", "acd", "ace"。
// 
//
// Example 2: 
//
// 
//输入: s = "dsahjpjauf", words = ["ahjpjau","ja","ahbwzgqnuk","tnmlanowax"]
//输出: 2
// 
//
// 
//
// 提示: 
//
// 
// 1 <= s.length <= 5 * 10⁴ 
// 1 <= words.length <= 5000 
// 1 <= words[i].length <= 50 
// words[i]和 s 都只由小写字母组成。 
// 
//
//
// Related Topics 字典树 哈希表 字符串 排序 👍 239 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numMatchingSubseq(String s, String[] words) {
            int n = s.length();
            Map<Character, TreeSet<Integer>> dict = new HashMap<>();
            for (int i = 0; i < n; i++) {
                char c = s.charAt(i);
                TreeSet<Integer> treeSet = dict.getOrDefault(c, new TreeSet<>());
                treeSet.add(i);
                dict.put(c, treeSet);
            }
            int ans = 0;
            for (String word : words) {
                int prev = -1;
                boolean isSubSequence = true;
                for (char c : word.toCharArray()) {
                    prev = getOder(dict, c, prev);
                    if (prev == -1) {
                        isSubSequence = false;
                        break;
                    }
                }
                if (isSubSequence) {
                    ans++;
                }
            }
            return ans;
        }

        public int getFirstOrder(Map<Character, TreeSet<Integer>> map, char c) {
            return getOder(map, c, -1);
        }

        public int getOder(Map<Character, TreeSet<Integer>> map, char c, int i) {
            TreeSet<Integer> treeSet = map.get(c);
            if (treeSet == null) {
                return -1;
            }
            Integer higher = treeSet.higher(i);
            if (higher == null) {
                return -1;
            }
            return higher;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }

    }
}