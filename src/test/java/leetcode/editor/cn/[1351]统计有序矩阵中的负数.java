package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1351 {
//给你一个 m * n 的矩阵 grid，矩阵中的元素无论是按行还是按列，都以非递增顺序排列。
//
// 请你统计并返回 grid 中 负数 的数目。 
// >=
// 
//
// 示例 1： 
//
// 
//输入：grid = [[4,3,2,-1],
//             [3,2,1,-1],
//             [1,1,-1,-2],
//             [-1,-1,-2,-3]]
//输出：8
//解释：矩阵中共有 8 个负数。
// 
//
// 示例 2： 
//
// 
//输入：grid = [[3,2],[1,0]]
//输出：0
// 
//
// 示例 3： 
//
// 
//输入：grid = [[1,-1],[-1,-1]]
//输出：3
// 
//
// 示例 4： 
//
// 
//输入：grid = [[-1]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// m == grid.length 
// n == grid[i].length 
// 1 <= m, n <= 100 
// -100 <= grid[i][j] <= 100 
// 
//
// 
//
// 进阶：你可以设计一个时间复杂度为 O(n + m) 的解决方案吗？ 
//
// 
// Related Topics 数组 二分查找 
// 👍 59 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int countNegatives(int[][] grid) {
            int m = grid.length;
            int n = grid[0].length;
            int y = 0;
            int ans = 0;
            for (int x = m - 1; x >= 0; x--) {
                while (y < n && grid[x][y] >= 0) {
                    y++;
                }
                if (y == n) {
                    return ans;
                }
                ans += n - y;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(8, solution.countNegatives(new int[][]{
                    {4, 3, 2, -1},
                    {3, 2, 1, -1},
                    {1, 1, -1, -2},
                    {-1, -1, -2, -3}
            }));
            Assert.assertEquals(0, solution.countNegatives(new int[][]{
                    {3, 2},
                    {1, 0},
            }));
        }
    }
}