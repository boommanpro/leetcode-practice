package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest812 {
//给定包含多个点的集合，从其中取三个点组成三角形，返回能组成的最大三角形的面积。 
//
// 
//示例:
//输入: points = [[0,0],[0,1],[1,0],[0,2],[2,0]]
//输出: 2
//解释: 
//这五个点如下图所示。组成的橙色三角形是最大的，面积为2。
// 
//
// 
//
// 注意: 
//
// 
// 3 <= points.length <= 50. 
// 不存在重复的点。 
// -50 <= points[i][j] <= 50. 
// 结果误差值在 10^-6 以内都认为是正确答案。 
// 
// Related Topics 几何 数组 数学 👍 124 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public double largestTriangleArea(int[][] points) {
            double ans = 0;
            for (int[] A : points) {
                for (int[] B : points) {
                    for (int[] C : points) {
                        ans = Math.max(ans, triangleArea(A[0], A[1], B[0], B[1], C[0], C[1]));
                    }
                }
            }
            return ans;
        }

        public double triangleArea(int x1, int y1, int x2, int y2, int x3, int y3) {
            return 0.5 * Math.abs(x1 * y2 + x2 * y3 + x3 * y1 - x1 * y3 - x2 * y1 - x3 * y2);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.largestTriangleArea(new int[][]{{0, 0}, {0, 1}, {1, 0}, {0, 2}, {2, 0}}));
        }

    }
}