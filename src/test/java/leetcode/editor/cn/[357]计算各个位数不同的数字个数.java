package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest357 {
//给定一个非负整数 n，计算各位数字都不同的数字 x 的个数，其中 0 ≤ x < 10n 。 
//
// 示例: 
//
// 输入: 2
//输出: 91 
//解释: 答案应为除去 11,22,33,44,55,66,77,88,99 外，在 [0,100) 区间内的所有数字。
// 
// Related Topics 数学 动态规划 回溯算法 
// 👍 82 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int countNumbersWithUniqueDigits(int n) {
            if (n == 0) return 1;
            return dfs(Math.min(10, n), 0, new boolean[10]);
        }

        private int dfs(int n, int idx, boolean[] used) {
            int count = 0;
            if (idx != n) {
                for (int i = 0; i < 10; i++) {
                    //多位数时，第一个数字不能为0
                    if (i == 0 && n > 1 && idx == 1) {
                        continue;
                    }
                    //不能使用用过的数字
                    if (used[i]) {
                        continue;
                    }
                    used[i] = true;
                    count += dfs(n, idx + 1, used) + 1;
                    used[i] = false;
                }
            }
            return count;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(91, solution.countNumbersWithUniqueDigits(2));
        }
    }
}