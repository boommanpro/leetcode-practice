package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest3200 {
//给你两个整数 red 和 blue，分别表示红色球和蓝色球的数量。你需要使用这些球来组成一个三角形，满足第 1 行有 1 个球，第 2 行有 2 个球，第
//3 行有 3 个球，依此类推。
//
// 每一行的球必须是 相同 颜色，且相邻行的颜色必须 不同。
//
// 返回可以实现的三角形的 最大 高度。
//
//
//
// 示例 1：
//
//
// 输入： red = 2, blue = 4
//
//
// 输出： 3
//
// 解释：
//
//
//
// 上图显示了唯一可能的排列方式。
//
// 示例 2：
//
//
// 输入： red = 2, blue = 1
//
//
// 输出： 2
//
// 解释：
//
// 上图显示了唯一可能的排列方式。
//
// 示例 3：
//
//
// 输入： red = 1, blue = 1
//
//
// 输出： 1
//
// 示例 4：
//
//
// 输入： red = 10, blue = 1
//
//
// 输出： 2
//
// 解释：
//
// 上图显示了唯一可能的排列方式。
//
//
//
// 提示：
//
//
// 1 <= red, blue <= 100
//
//
// Related Topics数组 | 枚举
//
// 👍 26, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int maxHeightOfTriangle(int red, int blue) {
            return Math.max(height(red, blue), height(blue, red));
        }

        private int height(int red, int blue) {
            int[] data = new int[]{red, blue};
            for (int i = 1; i <= 100; i++) {
                if (data[i % 2] >= i) {
                    data[i % 2] -= i;
                } else {
                    return i - 1;
                }
            }
            return -1;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        private final Solution solution = new Solution();

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
        }

        @Test
        public void testMaxHeightOfTriangle_1() {
            // 给定输入
            int red = 2, blue = 4;
            // 预期输出
            int expected = 3;
            // 实际输出
            int result = solution.maxHeightOfTriangle(red, blue);
            // 断言
            Assert.assertEquals(expected, result);
        }

        @Test
        public void testMaxHeightOfTriangle_2() {
            int red = 2, blue = 1;
            int expected = 2;
            int result = solution.maxHeightOfTriangle(red, blue);
            Assert.assertEquals(expected, result);
        }

        @Test
        public void testMaxHeightOfTriangle_3() {
            int red = 1, blue = 1;
            int expected = 1;
            int result = solution.maxHeightOfTriangle(red, blue);
            Assert.assertEquals(expected, result);
        }

        @Test
        public void testMaxHeightOfTriangle_4() {
            int red = 10, blue = 1;
            int expected = 2;
            int result = solution.maxHeightOfTriangle(red, blue);
            Assert.assertEquals(expected, result);
        }
    }
}
