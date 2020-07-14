package leetcode.editor.cn;

import java.util.Arrays;
import java.util.List;

import leetcode.editor.cn.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

class SolutionTest120 {
//给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。 
//
// 相邻的结点 在这里指的是 下标 与 上一层结点下标 相同或者等于 上一层结点下标 + 1 的两个结点。 
//
// 
//
// 例如，给定三角形： 
//
// [
//     [2],
//    [3,4],
//   [6,5,7],
//  [4,1,8,3]
//]
// 
//
// 自顶向下的最小路径和为 11（即，2 + 3 + 5 + 1 = 11）。 
//
// 
//
// 说明： 
//
// 如果你可以只使用 O(n) 的额外空间（n 为三角形的总行数）来解决这个问题，那么你的算法会很加分。 
// Related Topics 数组 动态规划 
// 👍 441 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minimumTotal(List<List<Integer>> triangle) {
            if (triangle == null || triangle.isEmpty()) {
                return 0;
            }
            int n = triangle.size();
            Integer[] prev = triangle.get(n - 1).toArray(new Integer[]{});
            Integer[] res = new Integer[n];
            int count = 1;
            while (count < n) {
                List<Integer> curr = triangle.get(n - count - 1);
                for (int i = count; i < n; i++) {
                    res[i] = Math.min(prev[i - 1], prev[i]) + curr.get(i - count);
                }
                prev = Arrays.copyOf(res,n);
                count++;
            }
            return prev[n - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(11, solution.minimumTotal(ArrayUtils.twoDimension2List(new int[][]{{2}, {3, 4}, {6, 5, 7}, {4, 1, 8, 3}})));
            Assert.assertEquals(-10, solution.minimumTotal(ArrayUtils.twoDimension2List(new int[][]{{-10}})));
            Assert.assertEquals(1, solution.minimumTotal(ArrayUtils.twoDimension2List(new int[][]{{1}, {-2, -5}, {3, 6, 9}, {-1, 2, 4, -3}})));
        }
    }
}