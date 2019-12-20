package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest268 {

    //给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
//
// 示例 1: 
//
// 输入: [3,0,1]
//输出: 2
// 
//
// 示例 2: 
//
// 输入: [9,6,4,2,3,5,7,0,1]
//输出: 8
// 
//
// 说明: 
//你的算法应具有线性时间复杂度。你能否仅使用额外常数空间来实现? 
// Related Topics 位运算 数组 数学
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int missingNumber(int[] nums) {
            int n = nums.length;
            int sum = n * (n + 1) / 2;
            for (int num : nums) {
                sum -= num;
            }
            return sum;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.missingNumber(new int[]{3, 0, 1}));
            Assert.assertEquals(8, solution.missingNumber(new int[]{9, 6, 4, 2, 3, 5, 7, 0, 1}));
        }
    }
}