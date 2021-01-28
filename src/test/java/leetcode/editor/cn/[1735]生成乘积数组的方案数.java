package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class SolutionTest1735 {
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
// 👍 8 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        int MOD = (int) 1e9 + 7;

        public int[] waysToFillArray(int[][] queries) {
            Map<Integer, Integer> map = new HashMap<>();
            //预处理10000以下的素数，使得prime[i] = K（K为i的任一素数因子，例如prime[12] = 3或者prime[12] = 2）
            int[] prime = new int[10001];
            for (int i = 2; i <= 10000; i++) {
                if (prime[i] > 0) {
                    continue;
                } else {
                    prime[i] = i;
                    for (int k = 2; k * prime[i] <= 10000; k++) {
                        prime[k * prime[i]] = i;
                    }
                }
            }
            //结果集
            int[] ans = new int[queries.length];
            int index = 0;
            for (int[] q : queries) {
                int n = q[0];
                int k = q[1];
                map.clear();
                //通过prime数组快速获得k的所有素数因子
                while (k > 1) {
                    map.put(prime[k], map.getOrDefault(prime[k], 0) + 1);
                    k /= prime[k];
                }
                //tmp表示单次询问的结果
                int tmp = 1;
                //分别求每个素数因子的去重后的全排列数（即组合数）
                for (int key : map.keySet()) {
                    int t = map.get(key);
                    tmp = (int) (((long) tmp * C(n + t - 1, t)) % MOD);
                }
                ans[index++] = tmp;
            }
            return ans;
        }

        private int C(int n, int k) {
            if (k == 0) return 1;
            int ans = 1;
            for (int i = n; i >= n - k + 1; i--) {
                ans = (int) (((long) ans * i) % MOD);
            }
            int t = 1;
            for (int i = 2; i <= k; i++) {
                t = (int) (((long) t * i) % MOD);
            }
            //快速幂求乘法逆元
            t = power(t, MOD - 2);
            return (int) (((long) ans * t) % MOD);
        }

        //快速幂
        private int power(int n, int k) {
            if (k == 0) return 1;
            if (n == 1) return 1;
            int ans = 1;
            while (k > 0) {
                if (k % 2 == 1) ans = (int) (((long) ans * n) % MOD);
                n = (int) (((long) n * n) % MOD);
                k >>= 1;
            }
            return ans;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[4]", Arrays.toString(solution.waysToFillArray(new int[][]{{2, 6}})));
            Assert.assertEquals("[4, 1, 50734910]", Arrays.toString(solution.waysToFillArray(new int[][]{{2, 6}, {5, 1}, {73, 660}})));
            Assert.assertEquals("[50734910]", Arrays.toString(solution.waysToFillArray(new int[][]{{73, 660}})));
            Assert.assertEquals("[2701]", Arrays.toString(solution.waysToFillArray(new int[][]{{73, 4}})));

        }
    }
}