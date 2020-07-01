package leetcode.editor.cn;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题10_01 {
//给定两个排序后的数组 A 和 B，其中 A 的末端有足够的缓冲空间容纳 B。 编写一个方法，将 B 合并入 A 并排序。 
//
// 初始化 A 和 B 的元素数量分别为 m 和 n。 
//
// 示例: 
//
// 输入:
//A = [1,2,3,0,0,0], m = 3
//B = [2,5,6],       n = 3
//
//输出: [1,2,2,3,5,6] 
//
// 说明: 
//
// 
// A.length == n + m 
// 
// Related Topics 数组 双指针

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public void merge(int[] A, int m, int[] B, int n) {
            int r = A.length - 1;
            while (m > 0 || n > 0) {
                if (m > 0 && n > 0) {
                    if (A[m - 1] > B[n - 1]) {
                        A[r] = A[m - 1];
                        m--;
                    } else {
                        A[r] = B[n - 1];
                        n--;
                    }
                    r--;
                    continue;
                }
                if (m > 0) {
                    A[r] = A[m - 1];
                    m--;
                }
                if (n > 0) {
                    A[r] = B[n - 1];
                    n--;
                }
                r--;
            }
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            int[] A1 = new int[]{1, 2, 3, 0, 0, 0};
            solution.merge(A1, 3, new int[]{2, 5, 6}, 3);
            Assert.assertEquals("[1, 2, 2, 3, 5, 6]", Arrays.toString(A1));

            int[] A2 = new int[]{4, 5, 6, 0, 0, 0};
            solution.merge(A2, 3, new int[]{1, 2, 3}, 3);
            Assert.assertEquals("[1, 2, 3, 4, 5, 6]", Arrays.toString(A2));
        }
    }
}