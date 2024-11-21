package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

class SolutionTest3248 {
//大小为 n x n 的矩阵 grid 中有一条蛇。蛇可以朝 四个可能的方向 移动。矩阵中的每个单元格都使用位置进行标识： grid[i][j] = (i *
// n) + j。
//
// 蛇从单元格 0 开始，并遵循一系列命令移动。
//
// 给你一个整数 n 表示 grid 的大小，另给你一个字符串数组 commands，其中包括 "UP"、"RIGHT"、"DOWN" 和 "LEFT"。题目
//测评数据保证蛇在整个移动过程中将始终位于 grid 边界内。
//
// 返回执行 commands 后蛇所停留的最终单元格的位置。
//
//
//
// 示例 1：
//
//
// 输入：n = 2, commands = ["RIGHT","DOWN"]
//
//
// 输出：3
//
// 解释：
//
//
//
//
//
// 0
// 1
//
//
// 2
// 3
//
//
//
//
//
//
//
//
// 0
// 1
//
//
// 2
// 3
//
//
//
//
//
//
//
// 0
// 1
//
//
// 2
// 3
//
//
//
//
// 示例 2：
//
//
// 输入：n = 3, commands = ["DOWN","RIGHT","UP"]
//
//
// 输出：1
//
// 解释：
//
//
//
//
//
// 0
// 1
// 2
//
//
// 3
// 4
// 5
//
//
// 6
// 7
// 8
//
//
//
//
//
//
//
//
// 0
// 1
// 2
//
//
// 3
// 4
// 5
//
//
// 6
// 7
// 8
//
//
//
//
//
//
//
// 0
// 1
// 2
//
//
// 3
// 4
// 5
//
//
// 6
// 7
// 8
//
//
//
//
//
//
//
// 0
// 1
// 2
//
//
// 3
// 4
// 5
//
//
// 6
// 7
// 8
//
//
//
//
//
//
// 提示：
//
//
// 2 <= n <= 10
// 1 <= commands.length <= 100
// commands 仅由 "UP"、"RIGHT"、"DOWN" 和 "LEFT" 组成。
// 生成的测评数据确保蛇不会移动到矩阵的边界外。
//
//
// Related Topics数组 | 字符串 | 模拟
//
// 👍 24, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int finalPositionOfSnake(int n, List<String> commands) {
            int x = 0;
            int y = 0;
            for (String command : commands) {
                switch (command) {
                    case "UP":
                        y--;
                        break;
                    case "RIGHT":
                        x++;
                        break;
                    case "DOWN":
                        y++;
                        break;
                    case "LEFT":
                        x--;
                        break;
                }

            }
            return (x + y * n);
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
        public void testBasicMovement() {
            int n = 2;
            List<String> commands = Arrays.asList("RIGHT", "DOWN");
            int expected = 3;
            int result = solution.finalPositionOfSnake(n, commands);
            assertEquals(expected, result);
        }

        @Test
        public void testBoundaryMovement() {
            int n = 3;
            List<String> commands = Arrays.asList("DOWN", "RIGHT", "UP", "LEFT");
            int expected = 0;
            int result = solution.finalPositionOfSnake(n, commands);
            assertEquals(expected, result);
        }
    }
}
