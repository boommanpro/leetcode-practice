package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest474 {
//在计算机界中，我们总是追求用有限的资源获取最大的收益。 
//
// 现在，假设你分别支配着 m 个 0 和 n 个 1。另外，还有一个仅包含 0 和 1 字符串的数组。 
//
// 你的任务是使用给定的 m 个 0 和 n 个 1 ，找到能拼出存在于数组中的字符串的最大数量。每个 0 和 1 至多被使用一次。 
//
// 注意: 
//
// 
// 给定 0 和 1 的数量都不会超过 100。 
// 给定字符串数组的长度不会超过 600。 
// 
//
// 示例 1: 
//
// 
//输入: Array = {"10", "0001", "111001", "1", "0"}, m = 5, n = 3
//输出: 4
//
//解释: 总共 4 个字符串可以通过 5 个 0 和 3 个 1 拼出，即 "10","0001","1","0" 。
// 
//
// 示例 2: 
//
// 
//输入: Array = {"10", "0", "1"}, m = 1, n = 1
//输出: 2
//
//解释: 你可以拼出 "10"，但之后就没有剩余数字了。更好的选择是拼出 "0" 和 "1" 。
// 
// Related Topics 动态规划 
// 👍 198 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        @SuppressWarnings("all")
        public int findMaxForm(String[] strs, int m, int n) {
            int[][] f = new int[m + 1][n + 1];
            for (String str : strs) {
                int[] count = counting(str);
                for (int i = m; i >= count[0]; i--) {
                    for (int j = n; j >= count[1]; j--) {
                        f[i][j] = Math.max(f[i - count[0]][j - count[1]] + 1, f[i][j]);
                    }
                }
            }
            return f[m][n];
        }

        private int[] counting(String str) {
            int[] count = new int[2];
            for (int i = 0; i < str.length(); i++) {
                count[str.charAt(i) - '0']++;
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
            Assert.assertEquals(4, solution.findMaxForm(new String[]{"10", "0001", "111001", "1", "0"}, 5, 3));
            Assert.assertEquals(2, solution.findMaxForm(new String[]{"10", "0", "1"}, 1, 1));
        }
    }
}