package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.Assert.assertEquals;

class SolutionTest3111 {
//给你一个二维整数数组 point ，其中 points[i] = [xi, yi] 表示二维平面内的一个点。同时给你一个整数 w 。你需要用矩形 覆盖所有
//点。
//
// 每个矩形的左下角在某个点 (x1, 0) 处，且右上角在某个点 (x2, y2) 处，其中 x1 <= x2 且 y2 >= 0 ，同时对于每个矩形都 必
//须 满足 x2 - x1 <= w 。
//
// 如果一个点在矩形内或者在边上，我们说这个点被矩形覆盖了。
//
// 请你在确保每个点都 至少 被一个矩形覆盖的前提下，最少 需要多少个矩形。
//
// 注意：一个点可以被多个矩形覆盖。
//
//
//
// 示例 1：
//
//
//
//
// 输入：points = [[2,1],[1,0],[1,4],[1,8],[3,5],[4,6]], w = 1
//
//
// 输出：2
//
// 解释：
//
// 上图展示了一种可行的矩形放置方案：
//
//
// 一个矩形的左下角在 (1, 0) ，右上角在 (2, 8) 。
// 一个矩形的左下角在 (3, 0) ，右上角在 (4, 8) 。
//
//
// 示例 2：
//
//
//
//
// 输入：points = [[0,0],[1,1],[2,2],[3,3],[4,4],[5,5],[6,6]], w = 2
//
//
// 输出：3
//
// 解释：
//
// 上图展示了一种可行的矩形放置方案：
//
//
// 一个矩形的左下角在 (0, 0) ，右上角在 (2, 2) 。
// 一个矩形的左下角在 (3, 0) ，右上角在 (5, 5) 。
// 一个矩形的左下角在 (6, 0) ，右上角在 (6, 6) 。
//
//
// 示例 3：
//
//
//
//
// 输入：points = [[2,3],[1,2]], w = 0
//
//
// 输出：2
//
// 解释：
//
// 上图展示了一种可行的矩形放置方案：
//
//
// 一个矩形的左下角在 (1, 0) ，右上角在 (1, 2) 。
// 一个矩形的左下角在 (2, 0) ，右上角在 (2, 3) 。
//
//
//
//
// 提示：
//
//
// 1 <= points.length <= 10⁵
// points[i].length == 2
// 0 <= xi == points[i][0] <= 10⁹
// 0 <= yi == points[i][1] <= 10⁹
// 0 <= w <= 10⁹
// 所有点坐标 (xi, yi) 互不相同。
//
//
// Related Topics贪心 | 数组 | 排序
//
// 👍 19, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minRectanglesToCoverPoints(int[][] points, int w) {
            Arrays.sort(points, Comparator.comparingInt(a -> a[0]));
            int ans = 1;
            int n = points.length;
            int l = points[0][0];
            int r = l + w;
            for (int i = 1; i < n; i++) {
                if (points[i][0] > r) {
                    ans++;
                    l = points[i][0];
                    r = l + w;
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
        public void testMinRectanglesToCoverPointsExample1() {
            int[][] points = {{2, 1}, {1, 0}, {1, 4}, {1, 8}, {3, 5}, {4, 6}};
            int w = 1;
            int expected = 2;
            int result = solution.minRectanglesToCoverPoints(points, w);
            assertEquals(expected, result);
        }

        @Test
        public void testMinRectanglesToCoverPointsExample2() {
            int[][] points = {{0, 0}, {1, 1}, {2, 2}, {3, 3}, {4, 4}, {5, 5}, {6, 6}};
            int w = 2;
            int expected = 3;
            int result = solution.minRectanglesToCoverPoints(points, w);
            assertEquals(expected, result);
        }

        @Test
        public void testMinRectanglesToCoverPointsExample3() {
            int[][] points = {{2, 3}, {1, 2}};
            int w = 0;
            int expected = 2;
            int result = solution.minRectanglesToCoverPoints(points, w);
            assertEquals(expected, result);
        }

    }
}
