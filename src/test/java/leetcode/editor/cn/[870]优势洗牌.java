package leetcode.editor.cn;

import java.util.Arrays;
import java.util.Comparator;

import org.junit.Assert;
import org.junit.Test;

class SolutionTest870 {
//给定两个大小相等的数组 A 和 B，A 相对于 B 的优势可以用满足 A[i] > B[i] 的索引 i 的数目来描述。 
//
// 返回 A 的任意排列，使其相对于 B 的优势最大化。 
//
// 
//
// 示例 1： 
//
// 输入：A = [2,7,11,15], B = [1,10,4,11]
//输出：[2,11,7,15]
// 
//
// 示例 2： 
//
// 输入：A = [12,24,8,32], B = [13,25,32,11]
//输出：[24,32,8,12]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= A.length = B.length <= 10000 
// 0 <= A[i] <= 10^9 
// 0 <= B[i] <= 10^9 
// 
// Related Topics 贪心算法 数组 
// 👍 103 👎 0

    public static
            //leetcode submit region begin(Prohibit modification and deletion)
    class Solution {

        public int[] advantageCount(int[] A, int[] B) {
            int[][] azip = zip(A);
            int[][] bzip = zip(B);
            Comparator<int[]> compare = (o1, o2) -> {
                if (o1[1] == o2[1]) {
                    return o1[0] - o2[0];
                }
                return o1[1] - o2[1];
            };
            Arrays.sort(bzip, compare);
            Arrays.sort(azip, compare);
            int N = A.length;
            int[] ans = new int[N];
            int al = 0;
            int ar = N - 1;
            int right = N - 1;
            while (right >= 0) {
                if (azip[ar][1] > bzip[right][1]) {
                    ans[bzip[right][0]] = azip[ar][1];
                    ar--;
                } else {
                    ans[bzip[right][0]] = azip[al][1];
                    al++;
                }
                right--;
            }
            return ans;
        }

        private int[][] zip(int[] nums) {
            int[][] ziped = new int[nums.length][2];
            for (int i = 0; i < nums.length; i++) {
                ziped[i][0] = i;
                ziped[i][1] = nums[i];
            }
            return ziped;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

    //Do some Test
    public static class TestClass {

        @Test
        public void defaultSolutionTest() {
            Solution solution = new Solution();
            Assert.assertEquals("[2, 11, 7, 15]", Arrays.toString(solution.advantageCount(new int[]{2, 7, 11, 15}, new int[]{1, 10, 4, 11})));
            Assert.assertEquals("[24, 32, 8, 12]", Arrays.toString(solution.advantageCount(new int[]{12, 24, 8, 32}, new int[]{13, 25, 32, 11})));
        }
    }
}