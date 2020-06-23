package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest485 {
//给定一个二进制数组， 计算其中最大连续1的个数。 
//
// 示例 1: 
//
// 
//输入: [1,1,0,1,1,1]
//输出: 3
//解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
// 
//
// 注意： 
//
// 
// 输入的数组只包含 0 和1。 
// 输入数组的长度是正整数，且不超过 10,000。 
// 
// Related Topics 数组

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int findMaxConsecutiveOnes(int[] nums) {
            int p = -1;
            int result = 0;
            int n = nums.length;
            for (int i = 0; i < n; i++) {
                if (p == -1 && nums[i] == 1) {
                    p = i;
                    continue;
                }
                if (p != -1 && nums[i] != 1) {
                    result = Math.max(result, i - p);
                    p = -1;
                }
            }
            if (p != -1) {
                result = Math.max(result, n - p);
            }
            return result;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.findMaxConsecutiveOnes(new int[]{1, 1, 0, 1, 1, 1}));
        }
    }
}