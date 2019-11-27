package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest70 {

    //假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
//
// 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？ 
//
// 注意：给定 n 是一个正整数。 
//
// 示例 1： 
//
// 输入： 2
//输出： 2
//解释： 有两种方法可以爬到楼顶。
//1.  1 阶 + 1 阶
//2.  2 阶 
//
// 示例 2： 
//
// 输入： 3 [1]+[2]
//输出： 3
//解释： 有三种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶
//3.  2 阶 + 1 阶

    // 输入： 4  [3] [2]
//输出： 5
//解释： 有五种方法可以爬到楼顶。
//1.  1 阶 + 1 阶 + 1 阶 + 1 阶
//2.  1 阶 + 2 阶 + 1 阶
//3.  1 阶 + 1 阶 + 2 阶
//4.  2 阶 + 1 阶 + 1 阶
//5.  2 阶 + 2 阶
// Related Topics 动态规划
    public static

//leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int climbStairs(int n) {
            if (n == 0) {
                return 0;
            }
            if (n == 1) {
                return 1;
            }
            if (n == 2) {
                return 2;
            }

            int[] memo = new int[n + 1];
            memo[1] = 1;
            memo[2] = 2;
            for (int i = 3; i <= n; i++) {
                memo[i] = memo[i - 1] + memo[i - 2];
            }

            return memo[n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(1, solution.climbStairs(1));
            Assert.assertEquals(2, solution.climbStairs(2));
            Assert.assertEquals(3, solution.climbStairs(3));
            Assert.assertEquals(5, solution.climbStairs(4));
        }
    }
}