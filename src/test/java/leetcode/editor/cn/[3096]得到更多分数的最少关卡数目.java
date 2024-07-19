package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest3096 {
//给你一个长度为 n 的二进制数组 possible 。
//
// Alice 和 Bob 正在玩一个有 n 个关卡的游戏，游戏中有一些关卡是 困难 模式，其他的关卡是 简单 模式。如果 possible[i] == 0
//，那么第 i 个关卡是 困难 模式。一个玩家通过一个简单模式的关卡可以获得 1 分，通过困难模式的关卡将失去 1 分。
//
// 游戏的一开始，Alice 将从第 0 级开始 按顺序 完成一些关卡，然后 Bob 会完成剩下的所有关卡。
//
// 假设两名玩家都采取最优策略，目的是 最大化 自己的得分，Alice 想知道自己 最少 需要完成多少个关卡，才能获得比 Bob 更多的分数。
//
// 请你返回 Alice 获得比 Bob 更多的分数所需要完成的 最少 关卡数目，如果 无法 达成，那么返回 -1 。
//
// 注意，每个玩家都至少需要完成 1 个关卡。
//
//
//
// 示例 1：
//
//
// 输入：possible = [1,0,1,0]
//
//
// 输出：1
//
// 解释：
//
// 我们来看一下 Alice 可以完成的关卡数目：
//
//
// 如果 Alice 只完成关卡 0 ，Bob 完成剩下的所有关卡，那么 Alice 获得 1 分，Bob 获得 -1 + 1 - 1 = -1 分。
// 如果 Alice 完成到关卡 1 ，Bob 完成剩下的所有关卡，那么 Alice 获得 1 - 1 = 0 分，Bob 获得 1 - 1 = 0 分。
// 如果 Alice 完成到关卡 2 ，Bob 完成剩下的所有关卡，那么 Alice 获得 1 - 1 + 1 = 1 分，Bob 获得 -1 分。
//
//
// Alice 需要完成至少一个关卡获得更多的分数。
//
// 示例 2：
//
//
// 输入：possible = [1,1,1,1,1]
//
//
// 输出：3
//
// 解释：
//
// 我们来看一下 Alice 可以完成的关卡数目：
//
//
// 如果 Alice 只完成关卡 0 ，Bob 完成剩下的所有关卡，那么 Alice 获得 1 分，Bob 获得 4 分。
// 如果 Alice 完成到关卡 1 ，Bob 完成剩下的所有关卡，那么 Alice 获得 2 分，Bob 获得 3 分。
// 如果 Alice 完成到关卡 2 ，Bob 完成剩下的所有关卡，那么 Alice 获得 3 分，Bob 获得 2 分。
// 如果 Alice 完成到关卡 3 ，Bob 完成剩下的所有关卡，那么 Alice 获得 4 分，Bob 获得 1 分。
//
//
// Alice 需要完成至少三个关卡获得更多的分数。
//
// 示例 3：
//
//
// 输入：possible = [0,0]
//
//
// 输出：-1
//
// 解释：
//
// 两名玩家只能各完成 1 个关卡，Alice 完成关卡 0 得到 -1 分，Bob 完成关卡 1 得到 -1 分。两名玩家得分相同，所以 Alice 无法得
//到更多分数。
//
//
//
// 提示：
//
//
// 2 <= n == possible.length <= 10⁵
// possible[i] 要么是 0 要么是 1 。
//
//
// Related Topics数组 | 前缀和
//
// 👍 5, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumLevels(int[] possible) {
            int n = possible.length;
            for (int i = 0; i < n; i++) {
                if (possible[i] == 0) {
                    possible[i] = -1;
                }
            }
            int[] preSum = new int[n + 1];
            for (int i = 0; i < n; i++) {
                preSum[i + 1] = preSum[i] + possible[i];
            }
            for (int i = 0; i < n - 1; i++) {
                if (2 * preSum[i + 1] - preSum[n] > 0) {
                    //这里返回的是关卡数
                    return i + 1;
                }
            }
            return -1;
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
        public void testMinimumLevels_Example1() {
            // Given
            int[] possible = {1, 0, 1, 0};
            // When
            int result = solution.minimumLevels(possible);
            // Then
            assertEquals(1, result);
        }

        @Test
        public void testMinimumLevels_Example2() {
            // Given
            int[] possible = {1, 1, 1, 1, 1};
            // When
            int result = solution.minimumLevels(possible);
            // Then
            assertEquals(3, result);
        }

        @Test
        public void testMinimumLevels_Example3() {
            // Given
            int[] possible = {0, 0};
            // When
            int result = solution.minimumLevels(possible);
            // Then
            assertEquals(-1, result);
        }
    }
}
