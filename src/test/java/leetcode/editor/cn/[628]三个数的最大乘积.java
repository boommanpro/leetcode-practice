package leetcode.editor.cn;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest628 {
//给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。 
//
// 示例 1: 
//
// 
//输入: [1,2,3]
//输出: 6
// 
//
// 示例 2: 
//
// 
//输入: [1,2,3,4]
//输出: 24
// 
//
// 注意: 
//
// 
// 给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。 
// 输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。 
// 
// Related Topics 数组 数学 
// 👍 224 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            return Math.max(getLeftMax(nums), getRightMax(nums));
        }

        private int getLeftMax(int[] nums) {
            return nums[0] * nums[1] * nums[nums.length - 1];
        }

        private int getRightMax(int[] nums) {
            return nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(6, solution.maximumProduct(new int[]{1, 2, 3}));
            Assert.assertEquals(24, solution.maximumProduct(new int[]{1, 2, 3, 4}));
            Assert.assertEquals(0, solution.maximumProduct(new int[]{-2, -1, 0}));
            Assert.assertEquals(2, solution.maximumProduct(new int[]{-2, -1, 0, 1}));
            Assert.assertEquals(2, solution.maximumProduct(new int[]{-2, -1, 0, 1, 1}));
        }
    }
}