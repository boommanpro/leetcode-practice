package leetcode.editor.cn;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest413 {
//如果一个数列至少有三个元素，并且任意两个相邻元素之差相同，则称该数列为等差数列。 
//
// 例如，以下数列为等差数列: 
//
// 
//1, 3, 5, 7, 9
//7, 7, 7, 7
//3, -1, -5, -9 
//
// 以下数列不是等差数列。 
//
// 
//1, 1, 2, 5, 7 
//
// 
//
// 数组 A 包含 N 个数，且索引从0开始。数组 A 的一个子数组划分为数组 (P, Q)，P 与 Q 是整数且满足 0<=P<Q<N 。 
//
// 如果满足以下条件，则称子数组(P, Q)为等差数组： 
//
// 元素 A[P], A[p + 1], ..., A[Q - 1], A[Q] 是等差的。并且 P + 1 < Q 。 
//
// 函数要返回数组 A 中所有为等差数组的子数组个数。 
//
// 
//
// 示例: 
//
// 
//A = [1, 2, 3, 4]
//
//返回: 3, A 中有三个子等差数组: [1, 2, 3], [2, 3, 4] 以及自身 [1, 2, 3, 4]。
// 
// Related Topics 数学 动态规划 
// 👍 164 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {
        public int numberOfArithmeticSlices(int[] A) {
            int ans = 0;

            //想像向 n 个字符中间插入两片木板bai，这两片木板之间的即为原串的一个du子串。
            //总共有 n + 1 个空位zhi可以插，第一个木板插入后，第二个还有 n 个空位。
            //连续是count*(count+1)/2
            //s的子串有 n*(n+1)/2  减去长度为0,1,2,3的子串为 => (n-2)*(n-1)/2

            int continuity = 0;
            for (int i = 2; i < A.length; i++) {
                if (A[i] - A[i - 1] == A[i - 1] - A[i - 2]) {
                    continuity++;
                } else {
                    ans += (continuity + 1) * continuity / 2;
                    continuity = 0;
                }
            }
            if (continuity != 0) {
                ans += (continuity + 1) * continuity / 2;
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
            Assert.assertEquals(3, solution.numberOfArithmeticSlices(new int[]{1, 2, 3, 4}));
            Assert.assertEquals(6, solution.numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5}));
            Assert.assertEquals(10, solution.numberOfArithmeticSlices(new int[]{1, 2, 3, 4, 5, 6}));
        }
    }
}