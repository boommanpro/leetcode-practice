package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest74 {
//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,50]], target = 13
//输出：false
// 
//
// 示例 3： 
//
// 
//输入：matrix = [], target = 0
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 0 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 
// 👍 283 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean searchMatrix(int[][] matrix, int target) {
            if (matrix == null || matrix.length == 0) {
                return false;
            }
            //从左下角开始搜索
            //大于当前数字 col++
            //小于当前数字 row--
            int row = matrix.length;
            int col = matrix[0].length;
            int i = row - 1;
            int j = 0;
            while (i >= 0 && j < col) {
                if (matrix[i][j] > target) {
                    i--;
                } else if (matrix[i][j] < target) {
                    j++;
                } else {
                    return true;
                }
            }
            return false;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertTrue(solution.searchMatrix(new int[][]{
                    {1, 3, 5, 7},
                    {10, 11, 16, 20},
                    {23, 30, 34, 50}
            }, 3));
            Assert.assertFalse(solution.searchMatrix(new int[][]{
                    {1, 3, 5, 7},
                    {10, 11, 16, 20},
                    {23, 30, 34, 50}
            }, 13));
            Assert.assertFalse(solution.searchMatrix(new int[][]{

            }, 0));
        }
    }
}