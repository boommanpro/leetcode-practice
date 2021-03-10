package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest剑指Offer_56_eII {
//在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。 
//
// 
//
// 示例 1： 
//
// 输入：nums = [3,4,3,3]
//输出：4
// 
//
// 示例 2： 
//
// 输入：nums = [9,1,7,9,7,9,7]
//输出：1 
//
// 
//
// 限制： 
//
// 
// 1 <= nums.length <= 10000 
// 1 <= nums[i] < 2^31 
// 
//
// 
// 👍 140 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int singleNumber(int[] nums) {
            int t = 0;
            int o = 0;
            // 00
            // 01
            // 10
            for (int num : nums) {
                o = o ^ num & ~t;
                t = t ^ num & ~o;
            }
            return o;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(1, solution.singleNumber(new int[]{9, 1, 7, 9, 7, 9, 7}));
            Assert.assertEquals(4, solution.singleNumber(new int[]{3, 4, 3, 3}));
            Assert.assertEquals(6, solution.singleNumber(new int[]{6, 1, 1, 1}));
        }
    }
}