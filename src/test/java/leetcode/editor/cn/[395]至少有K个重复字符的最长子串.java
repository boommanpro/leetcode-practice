package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest395 {
//找到给定字符串（由小写字符组成）中的最长子串 T ， 要求 T 中的每一字符出现次数都不少于 k 。输出 T 的长度。 
//
// 示例 1: 
//
// 
//输入:
//s = "aaabb", k = 3
//
//输出:
//3
//
//最长子串为 "aaa" ，其中 'a' 重复了 3 次。
// 
//
// 示例 2: 
//
// 
//输入:
//s = "ababbc", k = 2
//
//输出:
//5
//
//最长子串为 "ababb" ，其中 'a' 重复了 2 次， 'b' 重复了 3 次。
// 
// Related Topics 递归 分治算法 Sliding Window 
// 👍 281 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        Map<Character, List<Integer>> cache;

        public int longestSubstring(String s, int k) {
            int[] cnt = new int[26];
            for (int i = 0; i < s.length(); i++) {
                cnt[s.charAt(i) - 'a']++;
            }
            if (checkSuccess(cnt, k)) {
                return s.length();
            }
            List<String> sub = new ArrayList<>();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < s.length(); i++) {
                if (cnt[s.charAt(i) - 'a'] < k) {
                    if (sb.length() > 0) {
                        sub.add(sb.toString());
                        sb = new StringBuilder();
                    }
                    continue;
                }
                sb.append(s.charAt(i));
            }
            if (sb.length() > 0) {
                sub.add(sb.toString());
            }
            int max = 0;
            for (String temp : sub) {
                if (max < temp.length()) {
                    max = Math.max(max, longestSubstring(temp,k));
                }
            }
            return max;
        }


        private boolean checkSuccess(int[] cnt, int k) {
            for (int i = 0; i < cnt.length; i++) {
                if (cnt[i] == 0) {
                    continue;
                }
                if (cnt[i] < k) {
                    return false;
                }
            }
            return true;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.longestSubstring("aaabb", 3));
            Assert.assertEquals(5, solution.longestSubstring("ababbc", 2));
        }
    }
}