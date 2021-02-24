package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest1499 {
//给你一个数组 points 和一个整数 k 。数组中每个元素都表示二维平面上的点的坐标，并按照横坐标 x 的值从小到大排序。也就是说 points[i] =
// [xi, yi] ，并且在 1 <= i < j <= points.length 的前提下， xi < xj 总成立。 
//
// 请你找出 yi + yj + |xi - xj| 的 最大值，其中 |xi - xj| <= k 且 1 <= i < j <= points.lengt
//h。 
//
// 题目测试数据保证至少存在一对能够满足 |xi - xj| <= k 的点。 
//
// 
//
// 示例 1： 
//
// 输入：points = [[1,3],[2,0],[5,10],[6,-10]], k = 1
//输出：4
//解释：前两个点满足 |xi - xj| <= 1 ，代入方程计算，则得到值 3 + 0 + |1 - 2| = 4 。第三个和第四个点也满足条件，得到值 1
//0 + -10 + |5 - 6| = 1 。
//没有其他满足条件的点，所以返回 4 和 1 中最大的那个。 
//
// 示例 2： 
//
// 输入：points = [[0,0],[3,0],[9,2]], k = 3
//输出：3
//解释：只有前两个点满足 |xi - xj| <= 3 ，代入方程后得到值 0 + 0 + |0 - 3| = 3 。
// 
//
// 
//
// 提示： 
//
// 
// 2 <= points.length <= 10^5 
// points[i].length == 2 
// -10^8 <= points[i][0], points[i][1] <= 10^8 
// 0 <= k <= 2 * 10^8 
// 对于所有的1 <= i < j <= points.length ，points[i][0] < points[j][0] 都成立。也就是说，xi 是严格
//递增的。 
// 
// Related Topics 数组 Sliding Window 
// 👍 23 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findMaxValueOfEquation(int[][] points, int k) {
            int max = Integer.MIN_VALUE;
            int left = 0, right = 1;
            while (right < points.length) {
                //判断公式1
                if (left >= right) {
                    right++;
                    continue;
                }
                //判断公式2
                if (points[right][0] - points[left][0] > k) {
                    left++;
                    continue;
                }
                //判断公式3
                max = Math.max(max, points[left][1] + points[right][1] + points[right][0] - points[left][0]);
                //判断公式4
                if (points[right][1] - points[right][0] > points[left][1] - points[left][0]) {
                    left++;
                    continue;
                }
                right++;
            }
            right--;
            //判断公式1
            while (left < right) {
                left++;
                //判断公式2
                if (points[right][0] - points[left][0] > k) {
                    left++;
                    continue;
                }
                //判断公式3
                max = Math.max(max, points[left][1] + points[right][1] + points[right][0] - points[left][0]);
                //由于后面不存在另有的right，所以不用对公式4进行判断
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
            Assert.assertEquals(4, solution.findMaxValueOfEquation(new int[][]{{1, 3}, {2, 0}, {5, 10}, {6, -10}}, 1));
            Assert.assertEquals(3, solution.findMaxValueOfEquation(new int[][]{{0, 0}, {3, 0}, {9, 2}}, 3));
            Assert.assertEquals(-6, solution.findMaxValueOfEquation(new int[][]{{-19, 9}, {-15, -19}, {-5, -8}}, 10));
        }
    }
}