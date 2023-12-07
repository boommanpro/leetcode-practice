package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest2953 {
//给你一个字符串 word 和一个整数 k 。
//
// 如果 word 的一个子字符串 s 满足以下条件，我们称它是 完全字符串：
//
//
// s 中每个字符 恰好 出现 k 次。
// 相邻字符在字母表中的顺序 至多 相差 2 。也就是说，s 中两个相邻字符 c1 和 c2 ，它们在字母表中的位置相差 至多 为 2 。
//
//
// 请你返回 word 中 完全 子字符串的数目。
//
// 子字符串 指的是一个字符串中一段连续 非空 的字符序列。
//
//
//
// 示例 1：
//
//
//输入：word = "igigee", k = 2
//输出：3
//解释：完全子字符串需要满足每个字符恰好出现 2 次，且相邻字符相差至多为 2 ：igigee, igigee, igigee 。
//
//
// 示例 2：
//
//
//输入：word = "aaabbbccc", k = 3
//输出：6
//解释：完全子字符串需要满足每个字符恰好出现 3 次，且相邻字符相差至多为 2 ：aaabbbccc, aaabbbccc, aaabbbccc,
//aaabbbccc, aaabbbccc, aaabbbccc 。
//
//
//
//
// 提示：
//
//
// 1 <= word.length <= 10⁵
// word 只包含小写英文字母。
// 1 <= k <= word.length
//
//
// Related Topics哈希表 | 字符串 | 滑动窗口
//
// 👍 24, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countCompleteSubstrings(String s, int k) {
            int ans = 0;
            int n = s.length();
            for (int i = 0; i < n; ) {
                int start = i;
                for (i++; i < n && Math.abs(s.charAt(i) - s.charAt(i - 1)) <= 2; i++) {}
                ans += f(s.substring(start, i), k);
            }
            return ans;
        }

        private int f(String s, int k) {
            int ans = 0;
            for (int m = 1; m <= 26 && m * k <= s.length(); m++) {
                int[] window = new int[26];
                int r = 0;
                while (r < s.length()) {
                    int l = r - m * k + 1;
                    window[s.charAt(r) - 'a']++;
                    if (l >= 0) {
                        boolean addFlag = true;
                        for (int i = 0; i < 26; i++) {
                            if (window[i] > 0 && window[i] != k) {
                                addFlag = false;
                                break;
                            }
                        }
                        if (addFlag) {
                            ans++;
                        }
                        window[s.charAt(l) - 'a']--;
                    }
                    r++;
                }

            }
            return ans;
        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.countCompleteSubstrings("igigee", 2));
            Assert.assertEquals(6, solution.countCompleteSubstrings("aaabbbccc", 3));
        }

    }
}
