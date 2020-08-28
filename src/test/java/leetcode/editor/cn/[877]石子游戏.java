package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest877 {
//亚历克斯和李用几堆石子在做游戏。偶数堆石子排成一行，每堆都有正整数颗石子 piles[i] 。 
//
// 游戏以谁手中的石子最多来决出胜负。石子的总数是奇数，所以没有平局。 
//
// 亚历克斯和李轮流进行，亚历克斯先开始。 每回合，玩家从行的开始或结束处取走整堆石头。 这种情况一直持续到没有更多的石子堆为止，此时手中石子最多的玩家获胜。
// 
//
// 假设亚历克斯和李都发挥出最佳水平，当亚历克斯赢得比赛时返回 true ，当李赢得比赛时返回 false 。 
//
// 
//
// 示例： 
//
// 输入：[5,3,4,5]
//输出：true
//解释：
//亚历克斯先开始，只能拿前 5 颗或后 5 颗石子 。
//假设他取了前 5 颗，这一行就变成了 [3,4,5] 。
//如果李拿走前 3 颗，那么剩下的是 [4,5]，亚历克斯拿走后 5 颗赢得 10 分。
//如果李拿走后 5 颗，那么剩下的是 [3,4]，亚历克斯拿走后 4 颗赢得 9 分。
//这表明，取前 5 颗石子对亚历克斯来说是一个胜利的举动，所以我们返回 true 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= piles.length <= 500 
// piles.length 是偶数。 
// 1 <= piles[i] <= 500 
// sum(piles) 是奇数。 
// 
// Related Topics 极小化极大 数学 动态规划 
// 👍 173 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public boolean stoneGame(int[] piles) {
            int n = piles.length;
            int[][] f = new int[n][n];
            for (int i = 0; i < n; i++) {
                f[i][i] = piles[i];
            }
            for (int i = n - 2; i >= 0; i--) {
                for (int j = i + 1; j < n; j++) {
                    f[i][j] = Math.max(piles[i] - f[i + 1][j], piles[j] - f[i][j - 1]);
                }
            }
            return f[0][n - 1] > 0;
        }

    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.stoneGame(new int[]{5, 3, 4, 5}));
            Assert.assertTrue(solution.stoneGame(new int[]{7, 7, 12, 16, 41, 48, 41, 48, 11, 9, 34, 2, 44, 30, 27, 12, 11, 39, 31, 8, 23, 11, 47, 25, 15, 23, 4, 17, 11, 50, 16, 50, 38, 34, 48, 27, 16, 24, 22, 48, 50, 10, 26, 27, 9, 43, 13, 42, 46, 24}));
        }
    }
}