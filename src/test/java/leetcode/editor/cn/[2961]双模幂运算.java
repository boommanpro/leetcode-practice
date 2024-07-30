package leetcode.editor.cn;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

class SolutionTest2961 {
//给你一个下标从 0 开始的二维数组 variables ，其中 variables[i] = [ai, bi, ci, mi]，以及一个整数 target
//。
//
// 如果满足以下公式，则下标 i 是 好下标：
//
//
// 0 <= i < variables.length
// ((aibi % 10)ci) % mi == target
//
//
// 返回一个由 好下标 组成的数组，顺序不限 。
//
//
//
// 示例 1：
//
//
//输入：variables = [[2,3,3,10],[3,3,3,1],[6,1,1,4]], target = 2
//输出：[0,2]
//解释：对于 variables 数组中的每个下标 i ：
//1) 对于下标 0 ，variables[0] = [2,3,3,10] ，(2³ % 10)³ % 10 = 2 。
//2) 对于下标 1 ，variables[1] = [3,3,3,1] ，(3³ % 10)³ % 1 = 0 。
//3) 对于下标 2 ，variables[2] = [6,1,1,4] ，(6¹ % 10)¹ % 4 = 2 。
//因此，返回 [0,2] 作为答案。
//
//
// 示例 2：
//
//
//输入：variables = [[39,3,1000,1000]], target = 17
//输出：[]
//解释：对于 variables 数组中的每个下标 i ：
//1) 对于下标 0 ，variables[0] = [39,3,1000,1000] ，(39³ % 10)¹⁰⁰⁰ % 1000 = 1 。
//因此，返回 [] 作为答案。
//
//
//
//
// 提示：
//
//
// 1 <= variables.length <= 100
// variables[i] == [ai, bi, ci, mi]
// 1 <= ai, bi, ci, mi <= 10³
// 0 <= target <= 10³
//
//
// Related Topics数组 | 数学 | 模拟
//
// 👍 26, 👎 0bug 反馈 | 使用指南 | 更多配套插件
//
//
//
//

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public List<Integer> getGoodIndices(int[][] variables, int target) {
            List<Integer> ans = new ArrayList<>();
            int n = variables.length;
            for (int i = 0; i < n; i++) {
                if (goodIndices(variables[i], target)) {
                    ans.add(i);
                }
            }
            return ans;
        }

        private boolean goodIndices(int[] variable, int target) {
            int a = variable[0];
            int b = variable[1];
            int c = variable[2];
            int m = variable[3];

            return powMod(powMod(a, b, 10), c, m) == target;
        }


        public int powMod(int x, int y, int mod) {
            int res = 1;
            while (y != 0) {
                if ((y & 1) != 0) {
                    res = res * x % mod;
                }
                x = x * x % mod;
                y >>= 1;
            }
            return res;
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
        public void testGetGoodIndicesExample1() {
            int[][] variables = {{2, 3, 3, 10}, {3, 3, 3, 1}, {6, 1, 1, 4}};
            int target = 2;
            List<Integer> expected = Arrays.asList(0, 2);
            List<Integer> result = solution.getGoodIndices(variables, target);
            assertEquals(expected, result);
        }

        @Test
        public void testGetGoodIndicesExample2() {
            int[][] variables = {{39, 3, 1000, 1000}};
            int target = 17;
            List<Integer> expected = new ArrayList<>();
            List<Integer> result = solution.getGoodIndices(variables, target);
            assertEquals(expected, result);
        }

        @Test
        public void testGetGoodIndicesProvidedData() {
            int[][] variables = {
                    {30, 5, 43, 2},
                    {15, 50, 35, 41},
                    {45, 34, 41, 32},
                    {14, 37, 33, 13},
                    {6, 8, 1, 53},
                    {37, 1, 12, 52},
                    {42, 37, 2, 52},
                    {9, 2, 15, 3},
                    {31, 12, 21, 24},
                    {52, 24, 6, 12},
                    {51, 35, 21, 52},
                    {30, 18, 10, 2},
                    {27, 31, 50, 27},
                    {29, 25, 26, 32},
                    {15, 38, 43, 17},
                    {22, 12, 16, 43},
                    {48, 9, 15, 6},
                    {41, 26, 22, 21},
                    {41, 49, 52, 26},
                    {53, 38, 9, 33}
            };
            int target = 1;
            List<Integer> expected = Arrays.asList(5, 7, 8, 10, 17, 18);
            List<Integer> result = solution.getGoodIndices(variables, target);
            assertEquals(expected, result);
        }
    }
}
