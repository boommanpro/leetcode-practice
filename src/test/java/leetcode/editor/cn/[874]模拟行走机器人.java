package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest874 {
//机器人在一个无限大小的网格上行走，从点 (0, 0) 处开始出发，面向北方。该机器人可以接收以下三种类型的命令： 
//
// 
// -2：向左转 90 度 
// -1：向右转 90 度 
// 1 <= x <= 9：向前移动 x 个单位长度 
// 
//
// 在网格上有一些格子被视为障碍物。 
//
// 第 i 个障碍物位于网格点 (obstacles[i][0], obstacles[i][1]) 
//
// 机器人无法走到障碍物上，它将会停留在障碍物的前一个网格方块上，但仍然可以继续该路线的其余部分。 
//
// 返回从原点到机器人所有经过的路径点（坐标为整数）的最大欧式距离的平方。 
//
// 
//
// 示例 1： 
//
// 输入: commands = [4,-1,3], obstacles = []
//输出: 25
//解释: 机器人将会到达 (3, 4)
// 
//
// 示例 2： 
//
// 输入: commands = [4,-1,4,-2,4], obstacles = [[2,4]]
//输出: 65
//解释: 机器人在左转走到 (1, 8) 之前将被困在 (1, 4) 处
// 
//
// 
//
// 提示： 
//
// 
// 0 <= commands.length <= 10000 
// 0 <= obstacles.length <= 10000 
// -30000 <= obstacle[i][0] <= 30000 
// -30000 <= obstacle[i][1] <= 30000 
// 答案保证小于 2 ^ 31 
// 
// Related Topics 贪心算法 
// 👍 117 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        //顺时针
        private static final int[][] DIRECTION = new int[][]{
                {0, 1},
                {1, 0},
                {0, -1},
                {-1, 0}
        };

        public int robotSim(int[] commands, int[][] obstacles) {
            int max = 0;
            int direction = 0;
            Set<Long> blocking = Arrays.stream(obstacles).map(a -> {
                long x = (long) a[0] + 30000;
                long y = (long) a[1] + 30000;
                return (x << 16) + y;
            }).collect(Collectors.toSet());
            int x = 0;
            int y = 0;
            for (int command : commands) {
                switch (command) {
                    case -2:
                        direction = (direction + 3) % 4;
                        break;
                    case -1:
                        direction = (direction + 1) % 4;
                        break;
                    default:
                        for (int i = 0; i < command; i++) {
                            int nx = DIRECTION[direction][0] + x;
                            int ny = DIRECTION[direction][1] + y;
                            long code = (((long) nx + 30000) << 16) + ((long) ny + 30000);
                            if (!blocking.contains(code)) {
                                x = nx;
                                y = ny;
                                max = Math.max(max, x * x + y * y);
                            }
                        }
                }
            }
            return max;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
//            Assert.assertEquals(25, solution.robotSim(new int[]{4, -1, 3}, new int[][]{}));
            Assert.assertEquals(65, solution.robotSim(new int[]{4, -1, 4, -2, 4}, new int[][]{{2, 4}}));
        }
    }
}