package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.LinkedList;
import java.util.Queue;

class SolutionTest2684 {
//给你一个下标从 0 开始、大小为 m x n 的矩阵 grid ，矩阵由若干 正 整数组成。
//
// 你可以从矩阵第一列中的 任一 单元格出发，按以下方式遍历 grid ：
//
//
// 从单元格 (row, col) 可以移动到 (row - 1, col + 1)、(row, col + 1) 和 (row + 1, col + 1)
//三个单元格中任一满足值 严格 大于当前单元格的单元格。
//
//
// 返回你在矩阵中能够 移动 的 最大 次数。
//
//
//
// 示例 1：
// 输入：grid = [[2,4,3,5],[5,4,9,3],[3,4,2,11],[10,9,13,15]]
//输出：3
//解释：可以从单元格 (0, 0) 开始并且按下面的路径移动：
//- (0, 0) -> (0, 1).
//- (0, 1) -> (1, 2).
//- (1, 2) -> (2, 3).
//可以证明这是能够移动的最大次数。
//
// 示例 2：
//
//
//输入：grid = [[3,2,4],[2,1,9],[1,1,7]]
//输出：0
//解释：从第一列的任一单元格开始都无法移动。
//
//
//
//
// 提示：
//
//
// m == grid.length
// n == grid[i].length
// 2 <= m, n <= 1000
// 4 <= m * n <= 10⁵
// 1 <= grid[i][j] <= 10⁶
//
//
// Related Topics数组 | 动态规划 | 矩阵
//
// 👍 28, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        private static final int[][] DIRECTIONS = {{-1, 1}, {0, 1}, {1, 1}};

        public int maxMoves(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[m][n];
            for (int i = 0; i < m; i++) {
                queue.add(new int[]{i, 0});
                visited[i][0] = true;
            }
            return bfs(queue, grid,visited);
        }

        private int bfs(Queue<int[]> queue, int[][] grid, boolean[][] visited) {
            int m = grid.length;
            int n = grid[0].length;
            int depth = -1;
            while (!queue.isEmpty()) {
                int size = queue.size();
                while (size > 0) {
                    int[] curr = queue.poll();
                    for (int[] direction : DIRECTIONS) {
                        int x = curr[0] + direction[0];
                        int y = curr[1] + direction[1];
                        if (x >= 0 && y >= 0 && x < m && y < n && grid[curr[0]][curr[1]] < grid[x][y] && !visited[x][y]) {
                            visited[x][y] = true;
                            queue.add(new int[]{x, y});
                        }
                    }
                    size--;
                }
                depth++;
            }
            return depth;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.maxMoves(new int[][]{{2, 4, 3, 5}, {5, 4, 9, 3}, {3, 4, 2, 11}, {10, 9, 13, 15}}));
            Assert.assertEquals(0, solution.maxMoves(new int[][]{{3, 2, 4}, {2, 1, 9}, {1, 1, 7}}));
            Assert.assertEquals(49, solution.maxMoves(new int[][]
                    {
                            {1000000, 92910, 1021, 1022, 1023, 1024, 1025, 1026, 1027, 1028, 1029, 1030, 1031, 1032, 1033, 1034, 1035, 1036, 1037, 1038, 1039, 1040, 1041, 1042, 1043, 1044, 1045, 1046, 1047, 1048, 1049, 1050, 1051, 1052, 1053, 1054, 1055, 1056, 1057, 1058, 1059, 1060, 1061, 1062, 1063, 1064, 1065, 1066, 1067, 1068},
                            {1069, 1070, 1071, 1072, 1073, 1074, 1075, 1076, 1077, 1078, 1079, 1080, 1081, 1082, 1083, 1084, 1085, 1086, 1087, 1088, 1089, 1090, 1091, 1092, 1093, 1094, 1095, 1096, 1097, 1098, 1099, 1100, 1101, 1102, 1103, 1104, 1105, 1106, 1107, 1108, 1109, 1110, 1111, 1112, 1113, 1114, 1115, 1116, 1117, 1118}
                    }));
            Assert.assertEquals(5, solution.maxMoves(new int[][]
                    {{149, 262, 51, 287, 181, 16, 105, 185, 113},
                            {294, 34, 239, 26, 152, 173, 255, 125, 33},
                            {121, 88, 103, 202, 39, 10, 252, 108, 92},
                            {133, 61, 16, 113, 195, 198, 255, 141, 143},
                            {207, 57, 224, 75, 289, 258, 225, 154, 178},
                            {108, 131, 242, 119, 281, 149, 246, 209, 209},
                            {194, 237, 135, 132, 204, 78, 207, 80, 157},
                            {67, 17, 150, 37, 267, 155, 87, 182, 2},
                            {263, 17, 81, 41, 176, 8, 106, 62, 207},
                            {75, 151, 205, 87, 229, 207, 170, 235, 262},
                            {231, 9, 199, 57, 186, 299, 266, 82, 20},
                            {104, 65, 285, 114, 269, 15, 33, 266, 61},
                            {9, 200, 38, 225, 3, 80, 173, 193, 142},
                            {48, 136, 119, 252, 207, 69, 15, 63, 35},
                            {151, 51, 106, 51, 277, 110, 201, 127, 141}}));
        }

    }
}
