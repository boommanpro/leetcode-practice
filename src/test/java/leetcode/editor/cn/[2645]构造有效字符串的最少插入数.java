package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest2645 {
//给你一个字符串 word ，你可以向其中任何位置插入 "a"、"b" 或 "c" 任意次，返回使 word 有效 需要插入的最少字母数。
//
// 如果字符串可以由 "abc" 串联多次得到，则认为该字符串 有效 。
//
//
//
// 示例 1：
//
// 输入：word = "b"
//输出：2
//解释：在 "b" 之前插入 "a" ，在 "b" 之后插入 "c" 可以得到有效字符串 "abc" 。
//
//
// 示例 2：
//
// 输入：word = "aaa"
//输出：6
//解释：在每个 "a" 之后依次插入 "b" 和 "c" 可以得到有效字符串 "abcabcabc" 。
//
//
// 示例 3：
//
// 输入：word = "abc"
//输出：0
//解释：word 已经是有效字符串，不需要进行修改。
//
//
//
//
// 提示：
//
//
// 1 <= word.length <= 50
// word 仅由字母 "a"、"b" 和 "c" 组成。
//
//
// Related Topics栈 | 贪心 | 字符串 | 动态规划
//
// 👍 29, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int addMinimum(String word) {
            int n = word.length();
            int[] d = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                d[i] = d[i - 1] + 2;
                if (i > 1 && word.charAt(i - 1) > word.charAt(i - 2)) {
                    d[i] = d[i - 1] - 1;
                }
            }
            return d[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.addMinimum("b"));
            Assert.assertEquals(6, solution.addMinimum("aaa"));
            Assert.assertEquals(0, solution.addMinimum("abc"));
        }

    }
}
