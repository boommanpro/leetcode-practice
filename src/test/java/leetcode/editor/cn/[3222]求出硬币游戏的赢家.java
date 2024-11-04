package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest3222 {
//给你两个 正 整数 x 和 y ，分别表示价值为 75 和 10 的硬币的数目。
//
// Alice 和 Bob 正在玩一个游戏。每一轮中，Alice 先进行操作，Bob 后操作。每次操作中，玩家需要拿出价值 总和 为 115 的硬币。如果一名
//玩家无法执行此操作，那么这名玩家 输掉 游戏。
//
// 两名玩家都采取 最优 策略，请你返回游戏的赢家。
//
//
//
// 示例 1：
//
//
// 输入：x = 2, y = 7
//
//
// 输出："Alice"
//
// 解释：
//
// 游戏一次操作后结束：
//
//
// Alice 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。
//
//
// 示例 2：
//
//
// 输入：x = 4, y = 11
//
//
// 输出："Bob"
//
// 解释：
//
// 游戏 2 次操作后结束：
//
//
// Alice 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。
// Bob 拿走 1 枚价值为 75 的硬币和 4 枚价值为 10 的硬币。
//
//
//
//
// 提示：
//
//
// 1 <= x, y <= 100
//
//
// Related Topics数学 | 博弈 | 模拟
//
// 👍 1, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public String losingPlayer(int x, int y) {
            int cnt = 0;
            while (x > 0 && y > 3) {
                x--;
                y -= 4;
                cnt++;
            }

            return cnt % 2 == 0 ? "Bob" : "Alice";
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();


        @Test
        public void defaultSolutionTest() {
            assertEquals("Alice", solution.losingPlayer(2, 7));
            assertEquals("Bob", solution.losingPlayer(4, 11));
            assertEquals("Alice", solution.losingPlayer(1, 4));
        }


    }
}
