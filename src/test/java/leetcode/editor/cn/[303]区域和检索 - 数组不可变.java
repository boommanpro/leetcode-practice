package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest303 {
//给定一个整数数组 nums，求出数组从索引 i 到 j (i ≤ j) 范围内元素的总和，包含 i, j 两点。 
//
// 示例： 
//
// 给定 nums = [-2, 0, 3, -5, 2, -1]，求和函数为 sumRange()
//
//sumRange(0, 2) -> 1
//sumRange(2, 5) -> -1
//sumRange(0, 5) -> -3 
//
// 说明: 
//
// 
// 你可以假设数组不可变。 
// 会多次调用 sumRange 方法。 
// 
// Related Topics 动态规划 
// 👍 174 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class NumArray {

        private final int[] f;

        private final int len;

        public NumArray(int[] nums) {
            if (nums == null || nums.length == 0) {
                len = 0;
                f = new int[0];
                return;
            }
            int n = nums.length;
            f = new int[n];
            len = n;
            f[0] = nums[0];
            for (int i = 1; i < nums.length; i++) {
                f[i] += f[i - 1] + nums[i];
            }
        }

        public int sumRange(int i, int j) {
            if (i < 0 || j >= len) {
                return 0;
            }
            if (i == 0) {
                return f[j];
            }
            return f[j] - f[i - 1];
        }
    }

    /**
     * Your NumArray object will be instantiated and called as such:
     * NumArray obj = new NumArray(nums);
     * int param_1 = obj.sumRange(i,j);
     */
//leetcode submit region end(Prohibit modification and deletion)

//Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
            Assert.assertEquals(1, numArray.sumRange(0, 2));
            Assert.assertEquals(-1, numArray.sumRange(2, 5));
            Assert.assertEquals(-3, numArray.sumRange(0, 5));
        }
    }
}