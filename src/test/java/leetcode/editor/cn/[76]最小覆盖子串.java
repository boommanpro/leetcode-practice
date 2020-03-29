package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

class SolutionTest76 {

    //给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
//
// 示例： 
//
// 输入: S = "ADOBECODEBANC", T = "ABC"
//输出: "BANC" 
//
// 说明： 
//
// 
// 如果 S 中不存这样的子串，则返回空字符串 ""。 
// 如果 S 中存在这样的子串，我们保证它是唯一的答案。 
// 
// Related Topics 哈希表 双指针 字符串 Sliding Window
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public String minWindow(String s, String t) {
            if (s == null || s.isEmpty()) {
                return "";
            }

            int l = 0, r = 0;
            int[] ans = new int[]{Integer.MAX_VALUE, 0, 0};
            Map<Character, Integer> dict = new HashMap<>();
            for (char c : t.toCharArray()) {
                dict.put(c, dict.getOrDefault(c, 0) + 1);
            }

            int required = dict.size();
            int currentSize = 0;

            Map<Character, Integer> window = new HashMap<>();
            //滑动窗口
            //ADOBECODEBANC
            //ABC
            for (; r < s.length(); r++) {

                //获取当前字符
                char curr = s.charAt(r);

                //curr -> window
                window.put(curr, window.getOrDefault(curr, 0) + 1);

                //当某个char在dict和window中同时满足条件 currentSize++
                if (dict.containsKey(curr) && dict.get(curr).equals(window.get(curr))) {
                    currentSize++;
                }
                while (currentSize == required) {
                    //先做记录
                    if (r - l < ans[0]) {
                        ans[0] = r - l;
                        ans[1] = l;
                        ans[2] = r;
                    }
                    //进行滑动
                    //从最左边向右滑动
                    //不满足条件后currentSize --
                    char remove = s.charAt(l);
                    window.put(remove, window.get(remove) - 1);
                    l++;
                    if (dict.containsKey(remove) && window.get(remove).compareTo(dict.get(remove)) < 0) {
                        currentSize--;
                    }

                }
            }

            return ans[0] == Integer.MAX_VALUE ? "" : s.substring(ans[1], ans[2] + 1);
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("BANC", solution.minWindow("ADOBECODEBANC", "ABC"));
        }
    }
}