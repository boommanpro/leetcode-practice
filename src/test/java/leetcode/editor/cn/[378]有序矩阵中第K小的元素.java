package leetcode.editor.cn;

import java.util.*;
import java.util.stream.Collectors;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest378 {
//给定一个 n x n 矩阵，其中每行和每列元素均按升序排序，找到矩阵中第 k 小的元素。 
//请注意，它是排序后的第 k 小元素，而不是第 k 个不同的元素。 
//
// 
//
// 示例： 
//
// matrix = [
//   [ 1,  5,  9],
//   [10, 11, 13],
//   [12, 13, 15]
//],
//k = 8,
//
//返回 13。
// 
//
// 
//
// 提示： 
//你可以假设 k 的值永远是有效的，1 ≤ k ≤ n2 。 
// Related Topics 堆 二分查找

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int kthSmallest(int[][] matrix, int k) {
            int n = matrix.length;
            int size = n * n;
            List<Integer> list = new ArrayList<>(size);
            for (int i = 0; i < n; i++) {
                list.addAll(Arrays.stream(matrix[i]).boxed().collect(Collectors.toList()));
            }
            list.sort(Comparator.comparingInt(Integer::intValue));
            return list.get(k - 1);
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(13, solution.kthSmallest(new int[][]{{1, 5, 9}, {10, 11, 13}, {12, 13, 15}}, 8));
        }
    }
}