package leetcode.editor.cn;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest剑指Offer_56_I {
//一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [4,1,4,6]
//输出：[1,6] 或 [6,1]
// 
//
// 示例 2： 
//
// 输入：nums = [1,2,10,4,1,4,3,3]
//输出：[2,10] 或 [10,2] 
//
// 
//
// 限制： 
//
// 
// 2 <= nums.length <= 10000 
// 
//
// 
// 👍 325 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] singleNumbers(int[] nums) {
            int xor = 0;
            for (int num : nums) {
                xor ^= num;
            }
            int div = 1;
            while ((div & xor) == 0) {
                div <<= 1;
            }
            int a = 0;
            int b = 0;
            for (int num : nums) {
                if ((num & div) == 0) {
                    a ^= num;
                } else {
                    b ^= num;
                }
            }
            return new int[]{a, b};
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[2, 10]", Arrays.toString(solution.singleNumbers(new int[]{1, 2, 10, 4, 1, 4, 3, 3})));
        }
    }
}