package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest375 {
//我们正在玩一个猜数游戏，游戏规则如下： 
//
// 我从 1 到 n 之间选择一个数字，你来猜我选了哪个数字。 
//
// 每次你猜错了，我都会告诉你，我选的数字比你的大了或者小了。 
//
// 然而，当你猜了数字 x 并且猜错了的时候，你需要支付金额为 x 的现金。直到你猜到我选的数字，你才算赢得了这个游戏。 
//
// 示例: 
//
// n = 10, 我选择了8.
//
//第一轮: 你猜我选择的数字是5，我会告诉你，我的数字更大一些，然后你需要支付5块。
//第二轮: 你猜是7，我告诉你，我的数字更大一些，你支付7块。
//第三轮: 你猜是9，我告诉你，我的数字更小一些，你支付9块。
//
//游戏结束。8 就是我选的数字。
//
//你最终要支付 5 + 7 + 9 = 21 块钱。
// 
//
// 给定 n ≥ 1，计算你至少需要拥有多少现金才能确保你能赢得这个游戏。 
// Related Topics 极小化极大 动态规划 
// 👍 178 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int getMoneyAmount(int n) {
            int[][] memo = new int[n + 1][n + 1];
            for (int[] temp : memo) {
                Arrays.fill(temp, -1);
            }
            return dfs(1, n, memo);
        }

        private int dfs(int low, int high, int[][] memo) {
            if (low >= high) {
                return 0;
            }
            int res = memo[low][high];
            if (res != -1) {
                return res;
            }
            res = Integer.MAX_VALUE;
            for (int i = (low + high) / 2; i <= high; i++) {
                int temp = i + Math.max(dfs(i + 1, high, memo), dfs(low, i - 1, memo));
                res = Math.min(res, temp);
            }
            memo[low][high] = res;
            return res;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(16, solution.getMoneyAmount(10));
            Assert.assertEquals(49, solution.getMoneyAmount(20));
            Assert.assertEquals(79, solution.getMoneyAmount(30));
            Assert.assertEquals(400, solution.getMoneyAmount(100));

        }
    }
}