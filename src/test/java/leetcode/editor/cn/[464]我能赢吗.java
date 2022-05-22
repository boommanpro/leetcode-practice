package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest464 {
//在 "100 game" 这个游戏中，两名玩家轮流选择从 1 到 10 的任意整数，累计整数和，先使得累计整数和达到 100 的玩家，即为胜者。 
//
// 如果我们将游戏规则改为 “玩家不能重复使用整数” 呢？ 
//
// 例如，两个玩家可以轮流从公共整数池中抽取从 1 到 15 的整数（不放回），直到累计整数和 >= 100。 
//
// 给定一个整数 maxChoosableInteger （整数池中可选择的最大数）和另一个整数 desiredTotal（累计和），判断先出手的玩家是否能稳
//赢（假设两位玩家游戏时都表现最佳）？ 
//
// 你可以假设 maxChoosableInteger 不会大于 20， desiredTotal 不会大于 300。 
//
// 示例： 
//
// 输入：
//maxChoosableInteger = 10
//desiredTotal = 11
//
//输出：
//false
//
//解释：
//无论第一个玩家选择哪个整数，他都会失败。
//第一个玩家可以选择从 1 到 10 的整数。
//如果第一个玩家选择 1，那么第二个玩家只能选择从 2 到 10 的整数。
//第二个玩家可以通过选择整数 10（那么累积和为 11 >= desiredTotal），从而取得胜利.
//同样地，第一个玩家选择任意其他整数，第二个玩家都会赢。
// 
// Related Topics 极小化极大 动态规划 
// 👍 158 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean canIWin(int n, int x) {
            int max = n * (n + 1) / 2;
            if (max < x) {
                return false;
            }
            return backTracking(n, x, new Boolean[1 << n], 0);
        }

        private boolean backTracking(int n, int x, Boolean[] state, int curr) {
            if (state[curr] != null) {
                return state[curr];
            }
            for (int i = 1; i <= n; i++) {
                int temp = 1 << (i - 1);
                if ((temp & curr) != 0) {
                    continue;
                }
                if (x - i <= 0 || backTracking(n, x - i, state, curr | temp)) {
                    return state[curr] = true;
                }
            }
            return state[curr] = false;
        }


        //是否胜利
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertFalse(solution.canIWin(10, 11));
            Assert.assertFalse(solution.canIWin(10, 40));
            Assert.assertFalse(solution.canIWin(20, 210));
            Assert.assertTrue(solution.canIWin(18, 79));
            Assert.assertTrue(solution.canIWin(6, 16));
        }
    }
}