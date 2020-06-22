package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest498 {
//给定一个含有 M x N 个元素的矩阵（M 行，N 列），请以对角线遍历的顺序返回这个矩阵中的所有元素，对角线遍历如下图所示。 
//
// 
//
// 示例: 
//
// 输入:
//[
// [ 1, 2, 3 ],
// [ 4, 5, 6 ],
// [ 7, 8, 9 ]
//]
//
//输出:  [1,2,4,7,5,3,6,8,9]
//
//解释:
//
// 
//
// 
//
// 说明: 
//
// 
// 给定矩阵中的元素总数不会超过 100000 。 
// 
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        /**
         * logic:
         * 对角线是 -1,+1  || +1,-1
         * 如果遇到不可达的地方需要  +1,0或者 0,+1
         */
        public int[] findDiagonalOrder(int[][] matrix) {
            if (matrix == null || matrix.length == 0) {
                return new int[]{};
            }
            int m = matrix.length;
            int n = matrix[0].length;
            int[] ans = new int[m * n];
            int K = m + n - 1;
            int index = 0;
            int x, y;
            for (int k = 0; k < K; k++) {
                boolean up = k % 2 == 0;
                if (up) {
                    //如果是向上的话
                    if (k < m) {
                        x = k;
                        y = 0;
                    } else {
                        x = m - 1;
                        y = k - x;
                    }
                    while (x >= 0 && y < n) {
                        ans[index++] = matrix[x][y];
                        x--;
                        y++;
                    }
                } else {
                    if (k < n) {
                        y = k;
                        x = 0;
                    } else {
                        y = n - 1;
                        x = k - y;
                    }
                    while (y >= 0 && x < m) {
                        ans[index++] = matrix[x][y];
                        y--;
                        x++;
                    }
                }
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
            Assert.assertArrayEquals(new int[]{3,2}, solution.findDiagonalOrder(new int[][]{{3}, {2}}));
            Assert.assertArrayEquals(new int[]{1, 2, 4, 7, 5, 3, 6, 8, 9}, solution.findDiagonalOrder(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}));
            Assert.assertArrayEquals(new int[]{1, 2, 5, 9, 6, 3, 4, 7, 10, 13, 14, 11, 8, 12, 15, 16}, solution.findDiagonalOrder(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}, {9, 10, 11, 12}, {13, 14, 15, 16}}));
        }
    }
}