package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest96 {
//给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？ 
//
// 示例: 
//
// 输入: 3
//输出: 5
//解释:
//给定 n = 3, 一共有 5 种不同结构的二叉搜索树:
//
//   1         3     3      2      1
//    \       /     /      / \      \
//     3     2     1      1   3      2
//    /     /       \                 \
//   2     1         2                 3 
// Related Topics 树 动态规划 
// 👍 619 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int numTrees(int n) {
            if (n == 0 || n == 1) {
                return 1;
            }
            int[] f = new int[n + 1];
            f[0] = 1;
            f[1] = 1;
            for (int i = 2; i <= n; ++i) {
                for (int j = 1; j <= i; ++j) {
                    f[i] += f[j - 1] * f[i - j];
                }
            }
            return f[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.numTrees(2));
            Assert.assertEquals(5, solution.numTrees(3));
        }
    }
}