package leetcode.editor.cn;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest454 {
//给定四个包含整数的数组列表 A , B , C , D ,计算有多少个元组 (i, j, k, l) ，使得 A[i] + B[j] + C[k] + D[
//l] = 0。 
//
// 为了使问题简单化，所有的 A, B, C, D 具有相同的长度 N，且 0 ≤ N ≤ 500 。所有整数的范围在 -228 到 228 - 1 之间，最
//终结果不会超过 231 - 1 。 
//
// 例如: 
//
// 
//输入:
//A = [ 1, 2]
//B = [-2,-1]
//C = [-1, 2]
//D = [ 0, 2]
//
//输出:
//2
//
//解释:
//两个元组如下:
//1. (0, 0, 0, 1) -> A[0] + B[0] + C[0] + D[1] = 1 + (-2) + (-1) + 2 = 0
//2. (1, 1, 0, 0) -> A[1] + B[1] + C[0] + D[0] = 2 + (-1) + (-1) + 0 = 0
// 
// Related Topics 哈希表 二分查找

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            //和值->数量
            int ans = 0;
            Map<Integer, Integer> abMap = new HashMap<>();
            for (int a : A) {
                for (int b : B) {
                    int tmp = a + b;
                    abMap.put(tmp, abMap.getOrDefault(tmp, 0) + 1);
                }
            }
            for (int c : C) {
                for (int d : D) {
                    int tmp = c + d;
                    Integer count = abMap.get(-tmp);
                    if (count != null) {
                        ans+=count;
                    }
                }
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
            Assert.assertEquals(2, solution.fourSumCount(
                    new int[]{1, 2},
                    new int[]{-2, -1},
                    new int[]{-1, 2},
                    new int[]{0, 2}
            ));
            Assert.assertEquals(6, solution.fourSumCount(
                    new int[]{-1, -1},
                    new int[]{-1, 1},
                    new int[]{-1, 1},
                    new int[]{1, -1}
            ));
        }
    }
}