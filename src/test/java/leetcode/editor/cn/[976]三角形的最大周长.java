package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

class SolutionTest976 {
//给定由一些正数（代表长度）组成的数组 A，返回由其中三个长度组成的、面积不为零的三角形的最大周长。 
//
// 如果不能形成任何面积不为零的三角形，返回 0。 
//
// 
//
// 
// 
//
// 示例 1： 
//
// 输入：[2,1,2]
//输出：5
// 
//
// 示例 2： 
//
// 输入：[1,2,1]
//输出：0
// 
//
// 示例 3： 
//
// 输入：[3,2,3,4]
//输出：10
// 
//
// 示例 4： 
//
// 输入：[3,6,2,3]
//输出：8
// 
//
// 
//
// 提示： 
//
// 
// 3 <= A.length <= 10000 
// 1 <= A[i] <= 10^6 
// 
// Related Topics 排序 数学 
// 👍 106 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int largestPerimeter(int[] A) {
            //a+b>c
            Arrays.sort(A);
            for (int i = A.length - 1; i >= 2; i--) {
                if (A[i-2]+A[i-1]>A[i]){
                    return A[i - 2] + A[i - 1] + A[i];
                }
            }
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(5, solution.largestPerimeter(new int[]{2, 1, 2}));
            Assert.assertEquals(0, solution.largestPerimeter(new int[]{1, 2, 1}));
            Assert.assertEquals(10, solution.largestPerimeter(new int[]{3, 2, 3, 4}));
            Assert.assertEquals(8, solution.largestPerimeter(new int[]{3, 6, 2, 3}));
        }
    }
}