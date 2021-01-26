package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;


import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.math.BigInteger;

class SolutionTest5648 {
//给你一个二维整数数组 queries ，其中 queries[i] = [ni, ki] 。第 i 个查询 queries[i] 要求构造长度为 ni 、每
//个元素都是正整数的数组，且满足所有元素的乘积为 ki ，请你找出有多少种可行的方案。由于答案可能会很大，方案数需要对 109 + 7 取余 。 
//
// 请你返回一个整数数组 answer，满足 answer.length == queries.length ，其中 answer[i]是第 i 个查询的结果
//。 
//
// 
//
// 示例 1： 
//
// 
//输入：queries = [[2,6],[5,1],[73,660]]
//输出：[4,1,50734910]
//解释：每个查询之间彼此独立。
//[2,6]：总共有 4 种方案得到长度为 2 且乘积为 6 的数组：[1,6]，[2,3]，[3,2]，[6,1]。
//[5,1]：总共有 1 种方案得到长度为 5 且乘积为 1 的数组：[1,1,1,1,1]。
//[73,660]：总共有 1050734917 种方案得到长度为 73 且乘积为 660 的数组。1050734917 对 109 + 7 取余得到 507
//34910 。
// 
//
// 示例 2 ： 
//
// 
//输入：queries = [[1,1],[2,2],[3,3],[4,4],[5,5]]
//输出：[1,2,3,10,5]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= queries.length <= 104 
// 1 <= ni, ki <= 104 
// 
// Related Topics 数学 
// 👍 4 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)

    class Solution {
        public int[] waysToFillArray(int[][] queries) {
            int[] ans = new int[queries.length];
            for (int i = 0; i < queries.length; i++) {
                int a = queries[i][0];
                int b = queries[i][1];
                Map<Integer, Integer> map = getFactorMap(b);
                BigInteger integer = new BigInteger("1");
                for (Integer value : map.keySet()) {
                    System.out.print(value);
                    System.out.println(": " + map.get(value));
                    integer = integer.multiply(repeatGroup(a, map.get(value)));
                }
                integer = integer.remainder(new BigInteger("" + 1000000007));
                ans[i] = integer.intValue();
            }
            return ans;
        }


        private Map<Integer, Integer> getFactorMap(int b) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int i = 2; i <= b; ++i) {
                while (b % i == 0) {
                    map.put(i, map.getOrDefault(i, 0) + 1);
                    b /= i;
                }
            }
            return map;
        }

        private BigInteger repeatGroup(int m, int n) {
            if (n == 0) {
                return new BigInteger("1");
            }
            BigInteger c = new BigInteger("0");
            for (int i = 0; i < n; ++i) {
                BigInteger b = new BigInteger("1");
                int z = n - i;
                for (int k = m - z + 1; k <= m; ++k) {
                    b = b.multiply(new BigInteger("" + k));
                }
                while (z > 1) {
                    b = b.divide(new BigInteger("" + z));
                    --z;
                }
                b = b.multiply(repeatGroup(n - i, i));
                c = c.add(b);
            }
            return c;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[4, 1, 50734910]", Arrays.toString(solution.waysToFillArray(new int[][]{{2, 6}, {5, 1}, {73, 660}})));
            Assert.assertEquals("[50734910]", Arrays.toString(solution.waysToFillArray(new int[][]{{73, 660}})));
            Assert.assertEquals("[2701]", Arrays.toString(solution.waysToFillArray(new int[][]{{73, 4}})));
        }
    }
}