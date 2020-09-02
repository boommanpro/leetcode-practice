package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1140 {
//亚历克斯和李继续他们的石子游戏。许多堆石子 排成一行，每堆都有正整数颗石子 piles[i]。游戏以谁手中的石子最多来决出胜负。 
//
// 亚历克斯和李轮流进行，亚历克斯先开始。最初，M = 1。 
//
// 在每个玩家的回合中，该玩家可以拿走剩下的 前 X 堆的所有石子，其中 1 <= X <= 2M。然后，令 M = max(M, X)。 
//
// 游戏一直持续到所有石子都被拿走。 
//
// 假设亚历克斯和李都发挥出最佳水平，返回亚历克斯可以得到的最大数量的石头。 
//
// 
//
// 示例： 
//
// 输入：piles = [2,7,9,4,4]
//输出：10
//解释：
//如果亚历克斯在开始时拿走一堆石子，李拿走两堆，接着亚历克斯也拿走两堆。在这种情况下，亚历克斯可以拿到 2 + 4 + 4 = 10 颗石子。 
//如果亚历克斯在开始时拿走两堆石子，那么李就可以拿走剩下全部三堆石子。在这种情况下，亚历克斯可以拿到 2 + 7 = 9 颗石子。
//所以我们返回更大的 10。 
// 
//
// 
//
// 提示： 
//
// 
// 1 <= piles.length <= 100 
// 1 <= piles[i] <= 10 ^ 4 
// 
// Related Topics 动态规划 
// 👍 65 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int stoneGameII(int[] piles) {
            int n = piles.length;
            int[][] dp = new int[n][n + 1];
            int sum = 0;
            for (int i = n - 1; i >= 0; i--) {
                sum += piles[i];
                for (int M = 1; M <= n; M++) {
                    if (i + 2 * M >= n) {
                        dp[i][M] = sum;
                    } else {
                        for (int x = 1; x <= 2 * M; x++) {
                            dp[i][M] = Math.max(dp[i][M], sum - dp[i + x][Math.max(x, M)]);
                        }
                    }
                }
            }
            return dp[0][1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(10, solution.stoneGameII(new int[]{2, 7, 9, 4, 4}));
            Assert.assertEquals(98008, solution.stoneGameII(new int[]{8270, 7145, 575, 5156, 5126, 2905, 8793, 7817, 5532, 5726, 7071, 7730, 5200, 5369, 5763, 7148, 8287, 9449, 7567, 4850, 1385, 2135, 1737, 9511, 8065, 7063, 8023, 7729, 7084, 8407}));
            Assert.assertEquals(155, solution.stoneGameII(new int[]{1, 2, 3, 4, 5, 7, 1, 2, 2, 1, 2, 3, 5, 6, 44, 55, 66, 77}));
        }
    }
}