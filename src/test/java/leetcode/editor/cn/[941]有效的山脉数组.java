package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest941 {
//给定一个整数数组 A，如果它是有效的山脉数组就返回 true，否则返回 false。 
//
// 让我们回顾一下，如果 A 满足下述条件，那么它是一个山脉数组： 
//
// 
// A.length >= 3 
// 在 0 < i < A.length - 1 条件下，存在 i 使得：
// 
// A[0] < A[1] < ... A[i-1] < A[i] 
// A[i] > A[i+1] > ... > A[A.length - 1] 
// 
// 
// 
//
// 
//
// 
//
// 
//
// 示例 1： 
//
// 输入：[2,1]
//输出：false
// 
//
// 示例 2： 
//
// 输入：[3,5,5]
//输出：false
// 
//
// 示例 3： 
//
// 输入：[0,3,2,1]
//输出：true 
//
// 
//
// 提示： 
//
// 
// 0 <= A.length <= 10000 
// 0 <= A[i] <= 10000 
// 
//
// 
//
// 
// Related Topics 数组 
// 👍 75 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public boolean validMountainArray(int[] A) {
            int len = A.length;
            int i = 0;
            while (i < len - 1 && A[i] < A[i + 1]) {
                i++;
            }
            if (i == 0 || i == len - 1) {
                return false;
            }
            while (i < len - 1 && A[i] > A[i + 1]) {
                i++;
            }
            return i == len - 1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertFalse(solution.validMountainArray(new int[]{1, 2}));
            Assert.assertFalse(solution.validMountainArray(new int[]{3, 5, 5}));
            Assert.assertTrue(solution.validMountainArray(new int[]{0, 3, 2, 1}));
            Assert.assertTrue(solution.validMountainArray(new int[]{1, 3, 2}));
            Assert.assertFalse(solution.validMountainArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
            Assert.assertFalse(solution.validMountainArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9}));
        }
    }
}