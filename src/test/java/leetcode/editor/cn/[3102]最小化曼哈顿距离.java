package leetcode.editor.cn;

import org.junit.Test;

import java.util.TreeMap;

import static org.junit.Assert.assertEquals;

class SolutionTest3102 {
//给你一个下标从 0 开始的数组 points ，它表示二维平面上一些点的整数坐标，其中 points[i] = [xi, yi] 。
//
// 两点之间的距离定义为它们的曼哈顿距离。
//
// 请你恰好移除一个点，返回移除后任意两点之间的 最大 距离可能的 最小 值。
//
//
//
// 示例 1：
//
//
//输入：points = [[3,10],[5,15],[10,2],[4,4]]
//输出：12
//解释：移除每个点后的最大距离如下所示：
//- 移除第 0 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间，为 |5 - 10| + |15 - 2| = 18 。
//- 移除第 1 个点后，最大距离在点 (3, 10) 和 (10, 2) 之间，为 |3 - 10| + |10 - 2| = 15 。
//- 移除第 2 个点后，最大距离在点 (5, 15) 和 (4, 4) 之间，为 |5 - 4| + |15 - 4| = 12 。
//- 移除第 3 个点后，最大距离在点 (5, 15) 和 (10, 2) 之间的，为 |5 - 10| + |15 - 2| = 18 。
//在恰好移除一个点后，任意两点之间的最大距离可能的最小值是 12 。
//
//
// 示例 2：
//
//
//输入：points = [[1,1],[1,1],[1,1]]
//输出：0
//解释：移除任一点后，任意两点之间的最大距离都是 0 。
//
//
//
//
// 提示：
//
//
// 3 <= points.length <= 10⁵
// points[i].length == 2
// 1 <= points[i][0], points[i][1] <= 10⁸
//
//
// Related Topics几何 | 数组 | 数学 | 有序集合 | 排序
//
// 👍 17, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minimumDistance(int[][] points) {
            TreeMap<Integer, Integer> xTree = new TreeMap<>();
            TreeMap<Integer, Integer> yTree = new TreeMap<>();
            for (int[] point : points) {
                int x = point[0] + point[1];
                int y = point[1] - point[0];
                xTree.merge(x, 1, Integer::sum);
                yTree.merge(y, 1, Integer::sum);
            }
            int ans = Integer.MAX_VALUE;
            for (int[] point : points) {
                int x = point[0] + point[1];
                int y = point[1] - point[0];
                if (xTree.get(x) == 1) {
                    xTree.remove(x);
                } else {
                    xTree.merge(x, -1, Integer::sum);
                }
                if (yTree.get(y) == 1) {
                    yTree.remove(y);
                } else {
                    yTree.merge(y, -1, Integer::sum);
                }
                int xV = xTree.lastKey() - xTree.firstKey();
                int yV = yTree.lastKey() - yTree.firstKey();
                ans = Math.min(ans, Math.max(xV, yV));
                xTree.merge(x, 1, Integer::sum);
                yTree.merge(y, 1, Integer::sum);
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
        }

        @Test
        public void testMinimumDistanceExample1() {
            Solution solution = new Solution();
            int[][] pointsExample1 = {{3, 10}, {5, 15}, {10, 2}, {4, 4}};
            int expectedOutput1 = 12;
            int actualOutput1 = solution.minimumDistance(pointsExample1);
            assertEquals(expectedOutput1, actualOutput1);
        }

        @Test
        public void testMinimumDistanceExample2() {
            Solution solution = new Solution();
            int[][] pointsExample2 = {{1, 1}, {1, 1}, {1, 1}};
            int expectedOutput2 = 0;
            int actualOutput2 = solution.minimumDistance(pointsExample2);
            assertEquals(expectedOutput2, actualOutput2);
        }
    }
}
