package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest2575 {
//给你一个下标从 0 开始的字符串 word ，长度为 n ，由从 0 到 9 的数字组成。另给你一个正整数 m 。
//
// word 的 可整除数组 div 是一个长度为 n 的整数数组，并满足：
//
//
// 如果 word[0,...,i] 所表示的 数值 能被 m 整除，div[i] = 1
// 否则，div[i] = 0
//
//
// 返回 word 的可整除数组。
//
//
//
// 示例 1：
//
//
//输入：word = "998244353", m = 3
//输出：[1,1,0,0,0,1,1,0,0]
//解释：仅有 4 个前缀可以被 3 整除："9"、"99"、"998244" 和 "9982443" 。
//
//
// 示例 2：
//
//
//输入：word = "1010", m = 10
//输出：[0,1,0,1]
//解释：仅有 2 个前缀可以被 10 整除："10" 和 "1010" 。
//
//
//
//
// 提示：
//
//
// 1 <= n <= 10⁵
// word.length == n
// word 由数字 0 到 9 组成
// 1 <= m <= 10⁹
//
//
// Related Topics数组 | 数学 | 字符串
//
// 👍 52, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int[] divisibilityArray(String word, int m) {
            int[] res = new int[word.length()];
            long cur = 0;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                cur = (cur * 10 + (c - '0')) % m;
                res[i] = (cur == 0) ? 1 : 0;
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
//            Assert.assertEquals("[1, 1, 0, 0, 0, 1, 1, 0, 0]", Arrays.toString(solution.divisibilityArray("998244353", 3)));
//            Assert.assertEquals("[0, 1, 0, 1]", Arrays.toString(solution.divisibilityArray("1010", 10)));
            Assert.assertEquals("[0, 1, 1, 0, 1, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1]", Arrays.toString(solution.divisibilityArray("4868438856666666", 6)));
        }

    }
}
