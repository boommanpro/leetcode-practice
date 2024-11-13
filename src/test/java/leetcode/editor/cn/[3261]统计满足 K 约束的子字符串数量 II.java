package leetcode.editor.cn;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

class SolutionTest3261 {
//给你一个 二进制 字符串 s 和一个整数 k。
//
// 另给你一个二维整数数组 queries ，其中 queries[i] = [li, ri] 。
//
// 如果一个 二进制字符串 满足以下任一条件，则认为该字符串满足 k 约束：
//
//
// 字符串中 0 的数量最多为 k。
// 字符串中 1 的数量最多为 k。
//
//
// 返回一个整数数组 answer ，其中 answer[i] 表示 s[li..ri] 中满足 k 约束 的 子字符串 的数量。
//
//
//
// 示例 1：
//
//
// 输入：s = "0001111", k = 2, queries = [[0,6]]
//
//
// 输出：[26]
//
// 解释：
//
// 对于查询 [0, 6]， s[0..6] = "0001111" 的所有子字符串中，除 s[0..5] = "000111" 和 s[0..6] = "0
//001111" 外，其余子字符串都满足 k 约束。
//
// 示例 2：
//
//
// 输入：s = "010101", k = 1, queries = [[0,5],[1,4],[2,3]]
//
//
// 输出：[15,9,3]
//
// 解释：
//
// s 的所有子字符串中，长度大于 3 的子字符串都不满足 k 约束。
//
//
//
// 提示：
//
//
// 1 <= s.length <= 10⁵
// s[i] 是 '0' 或 '1'
// 1 <= k <= s.length
// 1 <= queries.length <= 10⁵
// queries[i] == [li, ri]
// 0 <= li <= ri < s.length
// 所有查询互不相同
//
//
// Related Topics数组 | 字符串 | 二分查找 | 前缀和 | 滑动窗口
//
// 👍 23, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //1. 先写中文思路  2. 写出模糊的点，或者觉得用那种技术可以搞定 3.定义变量 4.写伪代码 5.coding
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public long[] countKConstraintSubstrings(String S, int k, int[][] queries) {
            int n = S.length();
            char[] s = S.toCharArray();
            long[] ans = new long[queries.length];
            long[] prefix = new long[n + 1];
            int[] sum = new int[2];
            int[] right = new int[n];
            int r, l = 0;
            for (r = 0; r < n; r++) {
                sum[s[r] - '0']++;
                while (sum[0] > k && sum[1] > k) {
                    sum[s[l] - '0']--;
                    l++;
                    right[l] = r;
                }
                prefix[r + 1] = r - l + 1 + prefix[r];
            }
            Arrays.fill(right, l, n, n);
            for (int i = 0; i < queries.length; i++) {
                l = queries[i][0];
                r = queries[i][1];
                int j = Math.min(r + 1, right[l]);
                ans[i] = prefix[r + 1] - prefix[j] + (long) (j - l) * (j - l + 1) / 2;
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
            String s1 = "0001111";
            int k1 = 2;
            int[][] queries1 = {{0, 6}};
            long[] expected1 = {26};
            assertArrayEquals(expected1, solution.countKConstraintSubstrings(s1, k1, queries1));

            String s2 = "010101";
            int k2 = 1;
            int[][] queries2 = {{0, 5}, {1, 4}, {2, 3}};
            long[] expected2 = {15, 9, 3};
            assertArrayEquals(expected2, solution.countKConstraintSubstrings(s2, k2, queries2));
        }


    }
}
