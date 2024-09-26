package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest2516 {
//给你一个由字符 'a'、'b'、'c' 组成的字符串 s 和一个非负整数 k 。每分钟，你可以选择取走 s 最左侧 还是 最右侧 的那个字符。
//
// 你必须取走每种字符 至少 k 个，返回需要的 最少 分钟数；如果无法取到，则返回 -1 。
//
//
//
// 示例 1：
//
//
//输入：s = "aabaaaacaabc", k = 2
//输出：8
//解释：
//从 s 的左侧取三个字符，现在共取到两个字符 'a' 、一个字符 'b' 。
//从 s 的右侧取五个字符，现在共取到四个字符 'a' 、两个字符 'b' 和两个字符 'c' 。
//共需要 3 + 5 = 8 分钟。
//可以证明需要的最少分钟数是 8 。
//
//
// 示例 2：
//
//
//输入：s = "a", k = 1
//输出：-1
//解释：无法取到一个字符 'b' 或者 'c'，所以返回 -1 。
//
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁵
// s 仅由字母 'a'、'b'、'c' 组成
// 0 <= k <= s.length
//
//
// Related Topics哈希表 | 字符串 | 滑动窗口
//
// 👍 47, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int takeCharacters(String S, int k) {
            char[] s = S.toCharArray();
            int n = s.length;
            int[] cnt = new int[3];
            for (char c : s) {
                cnt[c - 'a']++;
            }
            for (int i = 0; i < 3; i++) {
                if (cnt[i] < k) {
                    return -1;
                }
            }
            int mx = 0;
            for (int l = 0, r = 0; r < n; r++) {
                char c = s[r];
                int i = c - 'a';
                cnt[i]--;
                while (cnt[i] < k) {
                    cnt[s[l]-'a']++;
                    l++;
                }
                mx = Math.max(mx, r - l + 1);
            }
            return n - mx;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }

        @Test
        public void testExampleOne() {
            // 测试题目中的第一个例子
            String s = "aabaaaacaabc";
            int k = 2;
            assertEquals(8, solution.takeCharacters(s, k));
        }

        @Test
        public void testExampleTwo() {
            // 测试题目中的第二个例子
            String s = "a";
            int k = 1;
            assertEquals(-1, solution.takeCharacters(s, k));
        }
    }
}
