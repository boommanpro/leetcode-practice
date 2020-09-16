package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest576 {
//给定一个 m × n 的网格和一个球。球的起始坐标为 (i,j) ，你可以将球移到相邻的单元格内，或者往上、下、左、右四个方向上移动使球穿过网格边界。但是，
//你最多可以移动 N 次。找出可以将球移出边界的路径数量。答案可能非常大，返回 结果 mod 109 + 7 的值。 
//
// 
//
// 示例 1： 
//
// 输入: m = 2, n = 2, N = 2, i = 0, j = 0
//输出: 6
//解释:
//
// 
//
// 示例 2： 
//
// 输入: m = 1, n = 3, N = 3, i = 0, j = 1
//输出: 12
//解释:
//
// 
//
// 
//
// 说明: 
//
// 
// 球一旦出界，就不能再被移动回网格内。 
// 网格的长度和高度在 [1,50] 的范围内。 
// N 在 [0,50] 的范围内。 
// Related Topics 深度优先搜索 动态规划 
// 👍 80 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        private static final int MOD = 1000000007;

        public int findPaths(int m, int n, int N, int i, int j) {
            return 0;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(6, solution.findPaths(2, 2, 2, 0, 0));
            Assert.assertEquals(12, solution.findPaths(1, 3, 3, 0, 1));
        }
    }
}