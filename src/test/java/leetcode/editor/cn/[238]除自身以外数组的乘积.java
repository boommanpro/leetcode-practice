package leetcode.editor.cn;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest238 {
//给你一个长度为 n 的整数数组 nums，其中 n > 1，返回输出数组 output ，其中 output[i] 等于 nums 中除 nums[i] 之
//外其余各元素的乘积。 
//
// 
//
// 示例: 
//
// 输入: [1,2,3,4]
//输出: [24,12,8,6] 
//
// 
//
// 提示：题目数据保证数组之中任意元素的全部前缀元素和后缀（甚至是整个数组）的乘积都在 32 位整数范围内。 
//
// 说明: 请不要使用除法，且在 O(n) 时间复杂度内完成此题。 
//
// 进阶： 
//你可以在常数空间复杂度内完成这个题目吗？（ 出于对空间复杂度分析的目的，输出数组不被视为额外空间。） 
// Related Topics 数组 
// 👍 680 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] productExceptSelf(int[] nums) {
            int len = nums.length;
            if (len == 0) {
                return nums;
            }
            int[] prefix = new int[nums.length];
            int[] suffix = new int[nums.length];
            prefix[0] = nums[0];
            suffix[len - 1] = nums[len - 1];
            for (int i = 1; i < len; i++) {
                prefix[i] = nums[i] * prefix[i - 1];
            }
            for (int i = len - 2; i >= 0; i--) {
                suffix[i] = nums[i] * suffix[i + 1];
            }
            for (int i = 0; i < len; i++) {
                nums[i] = (i - 1 >= 0 ? prefix[i - 1] : 1) * (i + 1 < len ? suffix[i + 1] : 1);
            }
            return nums;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[24, 12, 8, 6]", Arrays.toString(solution.productExceptSelf(new int[]{1, 2, 3, 4})));
            Assert.assertEquals("[0, 0]", Arrays.toString(solution.productExceptSelf(new int[]{0, 0})));
        }
    }
}