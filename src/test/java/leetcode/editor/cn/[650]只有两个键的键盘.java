package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest650 {
//最初在一个记事本上只有一个字符 'A'。你每次可以对这个记事本进行两种操作： 
//
// 
// Copy All (复制全部) : 你可以复制这个记事本中的所有字符(部分的复制是不允许的)。 
// Paste (粘贴) : 你可以粘贴你上一次复制的字符。 
// 
//
// 给定一个数字 n 。你需要使用最少的操作次数，在记事本中打印出恰好 n 个 'A'。输出能够打印出 n 个 'A' 的最少操作次数。 
//
// 示例 1: 
//
// 
//输入: 3
//输出: 3
//解释:
//最初, 我们只有一个字符 'A'。
//第 1 步, 我们使用 Copy All 操作。
//第 2 步, 我们使用 Paste 操作来获得 'AA'。
//第 3 步, 我们使用 Paste 操作来获得 'AAA'。
// 
//
// 说明: 
//
// 
// n 的取值范围是 [1, 1000] 。 
// 
// Related Topics 动态规划 
// 👍 201 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int minSteps(int n) {
            if (n == 1) {
                return 0;
            }
            return dfs(1, 1, 1, n);
        }

        private int dfs(int curr, int paste, int operation, int n) {
            if (curr + paste >= n) {
                if (curr + paste == n) {
                    return operation + 1;
                }
                return Integer.MAX_VALUE;
            }
            //分两种操作
            // 1. copyAll and paste
            // 2. pasted
            int res = Integer.MAX_VALUE;
            res = Math.min(res, dfs(curr + paste, paste, operation + 1, n));
            if (curr == paste) {
                //如果curr == paste   -> 需要执行两个操作
                res = Math.min(res, dfs(curr + paste, curr + paste, operation + 2, n));
            } else {
                res = Math.min(res, dfs(curr, curr, operation + 1, n));
            }
            return res;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.minSteps(3));
            Assert.assertEquals(4, solution.minSteps(4));
            Assert.assertEquals(5, solution.minSteps(6));
            Assert.assertEquals(8, solution.minSteps(18));
            Assert.assertEquals(9, solution.minSteps(27));
        }
    }
}