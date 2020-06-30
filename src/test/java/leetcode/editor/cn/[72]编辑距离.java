package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest72 {
//给你两个单词 word1 和 word2，请你计算出将 word1 转换成 word2 所使用的最少操作数 。 
//
// 你可以对一个单词进行如下三种操作： 
//
// 
// 插入一个字符 
// 删除一个字符 
// 替换一个字符 
// 
//
// 
//
// 示例 1： 
//
// 输入：word1 = "horse", word2 = "ros"
//输出：3
//解释：
//horse -> rorse (将 'h' 替换为 'r')
//rorse -> rose (删除 'r')
//rose -> ros (删除 'e')
// 
//
// 示例 2： 
//
// 输入：word1 = "intention", word2 = "execution"
//输出：5
//解释：
//intention -> inention (删除 't')
//inention -> enention (将 'i' 替换为 'e')
//enention -> exention (将 'n' 替换为 'x')
//exention -> exection (将 'n' 替换为 'c')
//exection -> execution (插入 'u')
// 
// Related Topics 字符串 动态规划

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            if (m * n == 0) {
                return n + m;
            }
            int[][] dp = new int[m + 1][n + 1];
            for (int i = 0; i <= m; i++) dp[i][0] = i;//初始化第一列
            for (int j = 0; j <= n; j++) dp[0][j] = j;//初始化第一行

            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    } else {
                        //长度不相等的删除操作
                        int mid = Math.min(dp[i][j - 1], dp[i - 1][j]);
                        //长度相等的删除操作
                        int min = Math.min(mid, dp[i - 1][j - 1]);
                        //操作做数+1
                        dp[i][j] = 1 + min;
                    }
                }
            }
            return dp[m][n];
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(3, solution.minDistance("horse", "ros"));
//            Assert.assertEquals(5, solution.minDistance("intention", "execution"));

        }
    }
}