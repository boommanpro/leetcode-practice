package leetcode.editor.cn;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

class SolutionTest3208 {
//给你一个整数数组 colors 和一个整数 k ，colors表示一个由红色和蓝色瓷砖组成的环，第 i 块瓷砖的颜色为 colors[i] ：
//
//
// colors[i] == 0 表示第 i 块瓷砖的颜色是 红色 。
// colors[i] == 1 表示第 i 块瓷砖的颜色是 蓝色 。
//
//
// 环中连续 k 块瓷砖的颜色如果是 交替 颜色（也就是说除了第一块和最后一块瓷砖以外，中间瓷砖的颜色与它 左边 和 右边 的颜色都不同），那么它被称为一个
//交替 组。
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
// 输入：colors = [0,1,0,1,0], k = 3
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
// 示例 2：
//
//
// 输入：colors = [0,1,0,0,1,0,1], k = 6
//
//
// 输出：2
//
// 解释：
//
//
//
// 交替组包括：
//
//
//
// 示例 3：
//
// 输入：colors = [1,1,0,1], k = 4
//
// 输出：0
//
// 解释：
//
//
//
//
//
// 提示：
//
//
// 3 <= colors.length <= 10⁵
// 0 <= colors[i] <= 1
// 3 <= k <= colors.length
//
//
// Related Topics数组 | 滑动窗口
//
// 👍 31, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfAlternatingGroups(int[] colors, int k) {
            int n = colors.length;
            int ans = 0;
            int curr = 0;
            for (int i = 0; i < n + k - 3; i++) {
                int mid = (i + n) % n;
                int left = (mid + n - 1) % n;
                int right = (mid + n + 1) % n;
                if (colors[mid] != colors[left] && colors[mid] != colors[right]) {
                    curr++;
                } else {
                    curr = 0;
                }
                if (curr >= k - 2) {
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
        public void testBasicCase1() {
            int[] colors = {0, 1, 0, 1, 0};
            int k = 3;
            assertEquals(3, solution.numberOfAlternatingGroups(colors, k));
        }

        @Test
        public void testBasicCase2() {
            int[] colors = {0, 1, 0, 0, 1, 0, 1};
            int k = 6;
            assertEquals(2, solution.numberOfAlternatingGroups(colors, k));
        }

        @Test
        public void testBasicCase3() {
            int[] colors = {1, 1, 0, 1};
            int k = 4;
            assertEquals(0, solution.numberOfAlternatingGroups(colors, k));
        }
    }
}
