package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest2457 {
//给你两个正整数 n 和 target 。 
//
// 如果某个整数每一位上的数字相加小于或等于 target ，则认为这个整数是一个 美丽整数 。 
//
// 找出并返回满足 n + x 是 美丽整数 的最小非负整数 x 。生成的输入保证总可以使 n 变成一个美丽整数。 
//
// 
//
// 示例 1： 
//
// 输入：n = 16, target = 6
//输出：4
//解释：最初，n 是 16 ，且其每一位数字的和是 1 + 6 = 7 。在加 4 之后，n 变为 20 且每一位数字的和变成 2 + 0 = 2 。可以证明
//无法加上一个小于 4 的非负整数使 n 变成一个美丽整数。
// 
//
// 示例 2： 
//
// 输入：n = 467, target = 6
//输出：33
//解释：最初，n 是 467 ，且其每一位数字的和是 4 + 6 + 7 = 17 。在加 33 之后，n 变为 500 且每一位数字的和变成 5 + 0 +
// 0 = 5 。可以证明无法加上一个小于 33 的非负整数使 n 变成一个美丽整数。 
//
// 示例 3： 
//
// 输入：n = 1, target = 1
//输出：0
//解释：最初，n 是 1 ，且其每一位数字的和是 1 ，已经小于等于 target 。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 10¹² 
// 1 <= target <= 150 
// 生成的输入保证总可以使 n 变成一个美丽整数。 
// 
//
// 👍 14 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long makeIntegerBeautiful(long n, int target) {
            char[] cs = String.valueOf(n).toCharArray();
            int len = cs.length;
            long ans = 0, sum = 0;
            for (int i = 0; i < len; i++) {
                sum += cs[i] - '0';
            }
            if (sum <= target) return 0; // 不做修改已经满足题意，直接返回0
            sum = 0;
            for (int i = 0; i < len; i++) {
                sum += cs[i] - '0';
                if (sum >= target) { // 只要大于等于说明这一位数我们不能加入
                    ans = (ans + 1) * (long) Math.pow(10, len - i); // 之前数字组成的数加1，之后的位数补零
                    break;
                } else {
                    ans *= 10;
                    ans += cs[i] - '0'; // 满足要求，则可以加入这一位数
                }
            }
            return ans - n;
        }
    }

//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(89, solution.makeIntegerBeautiful(11, 1));
            Assert.assertEquals(699997, solution.makeIntegerBeautiful(2300003, 3));
            Assert.assertEquals(6699997, solution.makeIntegerBeautiful(3300003, 3));
        }

    }
}