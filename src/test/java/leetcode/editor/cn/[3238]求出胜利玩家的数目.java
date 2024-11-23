package leetcode.editor.cn;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertEquals;

class SolutionTest3238 {
//给你一个整数 n ，表示在一个游戏中的玩家数目。同时给你一个二维整数数组 pick ，其中 pick[i] = [xi, yi] 表示玩家 xi 获得了一个
//颜色为 yi 的球。
//
// 如果玩家 i 获得的球中任何一种颜色球的数目 严格大于 i 个，那么我们说玩家 i 是胜利玩家。换句话说：
//
//
// 如果玩家 0 获得了任何的球，那么玩家 0 是胜利玩家。
// 如果玩家 1 获得了至少 2 个相同颜色的球，那么玩家 1 是胜利玩家。
// ...
// 如果玩家 i 获得了至少 i + 1 个相同颜色的球，那么玩家 i 是胜利玩家。
//
//
// 请你返回游戏中 胜利玩家 的数目。
//
// 注意，可能有多个玩家是胜利玩家。
//
//
//
// 示例 1：
//
//
// 输入：n = 4, pick = [[0,0],[1,0],[1,0],[2,1],[2,1],[2,0]]
//
//
// 输出：2
//
// 解释：
//
// 玩家 0 和玩家 1 是胜利玩家，玩家 2 和玩家 3 不是胜利玩家。
//
// 示例 2：
//
//
// 输入：n = 5, pick = [[1,1],[1,2],[1,3],[1,4]]
//
//
// 输出：0
//
// 解释：
//
// 没有胜利玩家。
//
// 示例 3：
//
//
// 输入：n = 5, pick = [[1,1],[2,4],[2,4],[2,4]]
//
//
// 输出：1
//
// 解释：
//
// 玩家 2 是胜利玩家，因为玩家 2 获得了 3 个颜色为 4 的球。
//
//
//
// 提示：
//
//
// 2 <= n <= 10
// 1 <= pick.length <= 100
// pick[i].length == 2
// 0 <= xi <= n - 1
// 0 <= yi <= 10
//
//
// Related Topics数组 | 哈希表 | 计数
//
// 👍 23, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int winningPlayerCount(int n, int[][] pick) {
            Map<Integer, Map<Integer, Integer>> colorCount = new HashMap<>();
            for (int[] op : pick) {
                Map<Integer, Integer> count = colorCount.computeIfAbsent(op[0], k -> new HashMap<>());
                count.put(op[1], count.getOrDefault(op[1], 0) + 1);
            }
            int ans = 0;
            for (Map.Entry<Integer, Map<Integer, Integer>> entry : colorCount.entrySet()) {
                for (Map.Entry<Integer, Integer> colorCnt : entry.getValue().entrySet()) {
                    if (colorCnt.getValue() > entry.getKey()) {
                        ans++;
                        break;
                    }
                }
            }
            return ans;
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
        public void testBasicCase() {
            int n = 4;
            int[][] pick = {{0, 0}, {1, 0}, {1, 0}, {2, 1}, {2, 1}, {2, 0}};
            assertEquals(2, solution.winningPlayerCount(n, pick));
        }

        @Test
        public void testNoWinners() {
            int n = 5;
            int[][] pick = {{1, 1}, {1, 2}, {1, 3}, {1, 4}};
            assertEquals(0, solution.winningPlayerCount(n, pick));
        }

        @Test
        public void testSingleWinner() {
            int n = 5;
            int[][] pick = {{1, 1}, {2, 4}, {2, 4}, {2, 4}};
            assertEquals(1, solution.winningPlayerCount(n, pick));
        }
    }
}
