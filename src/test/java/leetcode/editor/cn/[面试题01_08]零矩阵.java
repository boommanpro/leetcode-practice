package leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

import leetcode.editor.cn.utils.ArrayUtils;
import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题01_08 {
//编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。 
//
// 
//
// 示例 1： 
//
// 输入：
//[
//  [1,1,1],
//  [1,0,1],
//  [1,1,1]
//]
//输出：
//[
//  [1,0,1],
//  [0,0,0],
//  [1,0,1]
//]
// 
//
// 示例 2： 
//
// 输入：
//[
//  [0,1,2,0],
//  [3,4,5,2],
//  [1,3,1,5]
//]
//输出：
//[
//  [0,0,0,0],
//  [0,4,5,0],
//  [0,3,1,0]
//]
// 
// Related Topics 数组

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void setZeroes(int[][] matrix) {
            int m = matrix.length;
            int n = matrix[0].length;
            List<Integer> zeroRow = new ArrayList<>();
            List<Integer> zeroCol = new ArrayList<>();
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (matrix[i][j] == 0) {
                        zeroRow.add(i);
                        zeroCol.add(j);
                    }
                }
            }
            for (int i = 0; i < m; i++) {
                for (Integer j : zeroCol) {
                    matrix[i][j] = 0;
                }
            }
            for (int j = 0; j < n; j++) {
                for (Integer i : zeroRow) {
                    matrix[i][j] = 0;
                }
            }

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            int[][] matrix0 = new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
            int[][] matrix1 = new int[][]{{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
            solution.setZeroes(matrix0);
            solution.setZeroes(matrix1);
            Assert.assertEquals("[[1, 0, 1],[0, 0, 0],[1, 0, 1]]", ArrayUtils.twoDimension2String(matrix0));
            Assert.assertEquals("[[0, 0, 0, 0],[0, 4, 5, 0],[0, 3, 1, 0]]", ArrayUtils.twoDimension2String(matrix1));
        }
    }
}