package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest3206 {
//给你一个整数数组 colors ，它表示一个由红色和蓝色瓷砖组成的环，第 i 块瓷砖的颜色为 colors[i] ：
//
//
// colors[i] == 0 表示第 i 块瓷砖的颜色是 红色 。
// colors[i] == 1 表示第 i 块瓷砖的颜色是 蓝色 。
//
//
// 环中连续 3 块瓷砖的颜色如果是 交替 颜色（也就是说中间瓷砖的颜色与它 左边 和 右边 的颜色都不同），那么它被称为一个 交替 组。
//
// 请你返回 交替 组的数目。
//
// 注意 ，由于 colors 表示一个 环 ，第一块 瓷砖和 最后一块 瓷砖是相邻的。
//
//
//
// 示例 1：
//
//
// 输入：colors = [1,1,1]
//
//
// 输出：0
//
// 解释：
//
//
//
// 示例 2：
//
//
// 输入：colors = [0,1,0,0,1]
//
//
// 输出：3
//
// 解释：
//
//
//
// 交替组包括：
//
//
//
//
//
// 提示：
//
//
// 3 <= colors.length <= 100
// 0 <= colors[i] <= 1
//
//
// Related Topics数组 | 滑动窗口
//
// 👍 18, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfAlternatingGroups(int[] colors) {
            int n = colors.length;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                int left = (i - 1 + n) % n;
                int right = (i + 1 + n) % n;
                if (colors[i] != colors[left] && colors[i] != colors[right]) {
                    ans++;
                }
            }
            return ans;
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
        public void testDefault() {
            int[] colors = {1, 1, 1};
            assertEquals(0, solution.numberOfAlternatingGroups(colors));
        }

        @Test
        public void testSingleGroup() {
            int[] colors = {0, 1, 0};
            assertEquals(1, solution.numberOfAlternatingGroups(colors));
        }

        @Test
        public void testMultipleGroups() {
            int[] colors = {0, 1, 0, 0, 1};
            assertEquals(3, solution.numberOfAlternatingGroups(colors));
        }

    }
}
