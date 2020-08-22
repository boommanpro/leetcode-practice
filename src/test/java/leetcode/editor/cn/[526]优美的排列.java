package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest526 {
//假设有从 1 到 N 的 N 个整数，如果从这 N 个数字中成功构造出一个数组，使得数组的第 i 位 (1 <= i <= N) 满足如下两个条件中的一个，
//我们就称这个数组为一个优美的排列。条件： 
//
// 
// 第 i 位的数字能被 i 整除 
// i 能被第 i 位上的数字整除 
// 
//
// 现在给定一个整数 N，请问可以构造多少个优美的排列？ 
//
// 示例1: 
//
// 
//输入: 2
//输出: 2
//解释: 
//
//第 1 个优美的排列是 [1, 2]:
//  第 1 个位置（i=1）上的数字是1，1能被 i（i=1）整除
//  第 2 个位置（i=2）上的数字是2，2能被 i（i=2）整除
//
//第 2 个优美的排列是 [2, 1]:
//  第 1 个位置（i=1）上的数字是2，2能被 i（i=1）整除
//  第 2 个位置（i=2）上的数字是1，i（i=2）能被 1 整除
// 
//
// 说明: 
//
// 
// N 是一个正整数，并且不会超过15。 
// 
// Related Topics 回溯算法 
// 👍 91 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        int count = 0;

        public int countArrangement(int N) {
            count = 0;
            int[] selectPath = new int[N];
            boolean[] visited = new boolean[N];
            for (int i = 1; i <= N; i++) {
                selectPath[i - 1] = i;
            }
            dfs(selectPath, visited, 0, N);
            return count;
        }

        private void dfs(int[] selectPath, boolean[] visited, int start, int n) {
            if (start == n) {
                count++;
                return;
            }
            for (int i = 0; i < n; i++) {
                int value = selectPath[i];
                if (visited[value - 1]) {
                    continue;
                }
                int len = start + 1;
                if (value % len == 0 || len % value == 0) {
                    visited[value - 1] = true;
                    dfs(selectPath, visited, start + 1, n);
                    visited[value - 1] = false;
                }

            }

        }


    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals(2, solution.countArrangement(2));
            Assert.assertEquals(3, solution.countArrangement(3));
            Assert.assertEquals(750, solution.countArrangement(11));
        }
    }
}