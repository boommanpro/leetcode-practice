package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest面试题17_21 {
//给定一个直方图(也称柱状图)，假设有人从上面源源不断地倒水，最后直方图能存多少水量?直方图的宽度为 1。 
//
// 
//
// 上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的直方图，在这种情况下，可以接 6 个单位的水（蓝色部分表示水）。 感谢 Marco
//s 贡献此图。 
//
// 示例: 
//
// 输入: [0,1,0,2,1,0,1,3,2,1,2,1]
//输出: 6 
// Related Topics 栈 数组 双指针 
// 👍 128 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int trap(int[] height) {
            if (height == null || height.length == 0) {
                return 0;
            }
            int len = height.length;
            int[] leftMax = new int[len];
            leftMax[0] = height[0];
            int[] rightMax = new int[len];
            rightMax[len - 1] = height[len - 1];
            for (int i = 1; i < len; i++) {
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }
            for (int i = len - 2; i >= 0; i--) {
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }
            int ans = 0;
            for (int i = 0; i < len; i++) {
                ans += Math.min(leftMax[i], rightMax[i]) - height[i];
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(6, solution.trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
        }
    }
}