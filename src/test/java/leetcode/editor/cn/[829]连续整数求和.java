package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest829 {
//给定一个正整数 n，返回 连续正整数满足所有数字之和为 n 的组数 。 
//
// 
//
// 示例 1: 
//
// 
//输入: n = 5
//输出: 2
//解释: 5 = 2 + 3，共有两组连续整数([5],[2,3])求和后为 5。 
//
// 示例 2: 
//
// 
//输入: n = 9
//输出: 3
//解释: 9 = 4 + 5 = 2 + 3 + 4 
//
// 示例 3: 
//
// 
//输入: n = 15
//输出: 4
//解释: 15 = 8 + 7 = 4 + 5 + 6 = 1 + 2 + 3 + 4 + 5 
//
// 
//
// 提示: 
//
// 
// 1 <= n <= 10⁹ 
// 
// Related Topics 数学 枚举 👍 205 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int consecutiveNumbersSum(int n) {
            int ans = 1;
            int sum = 0;
            for (int l = 1, r = 1; r < n ; r++) {
                sum += r;
                while (sum >= n) {
                    if (sum == n) {
                        ans++;
                    }
                    sum -= l;
                    l++;
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
            Assert.assertEquals(2, solution.consecutiveNumbersSum(5));
            Assert.assertEquals(4, solution.consecutiveNumbersSum(15));
            Assert.assertEquals(4, solution.consecutiveNumbersSum(472330709));
            Assert.assertEquals(4, solution.consecutiveNumbersSum(807859109));
            Assert.assertEquals(16, solution.consecutiveNumbersSum(933320757));
        }

    }
}